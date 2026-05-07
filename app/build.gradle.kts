import com.google.firebase.crashlytics.buildtools.gradle.CrashlyticsExtension

plugins {
    alias(libs.plugins.android.application)
    alias(libs.plugins.kotlin.compose)
    alias(libs.plugins.hilt.android)
    alias(libs.plugins.ksp)
    alias(libs.plugins.google.services)
    alias(libs.plugins.firebase.crashlytics)
}

fun loadEnvFile(file: File): Map<String, String> {
    if (!file.exists()) return emptyMap()
    return file.readLines()
        .map { it.trim() }
        .filter { it.isNotEmpty() }
        .filterNot { it.startsWith("#") }
        .mapNotNull { line ->
            val idx = line.indexOf('=')
            if (idx <= 0) return@mapNotNull null
            val key = line.take(idx).trim()
            val rawValue = line.substring(idx + 1).trim()
            val value = rawValue
                .removePrefix("\"")
                .removeSuffix("\"")
                .removePrefix("'")
                .removeSuffix("'")
            if (key.isEmpty()) null else key to value
        }
        .toMap()
}

fun loadEnvFor(flavor: String): Map<String, String> {
    val base = loadEnvFile(rootProject.file(".env"))
    val override = loadEnvFile(rootProject.file(".env.$flavor"))
    return base + override
}

fun String.asBuildConfigString(): String = "\"" + replace("\\", "\\\\").replace("\"", "\\\"") + "\""

android {
    val sharedEnv = loadEnvFile(rootProject.file(".env"))
    namespace = sharedEnv["NAMESPACE"]!!
    compileSdk {
        version = release(36)
    }
    defaultConfig {
        minSdk = 24
        targetSdk = 36

        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
    }

    signingConfigs {
        getByName("debug") {
            storeFile = rootProject.file("keystores/debugkeystore")
            storePassword = "123456"
            keyAlias = "debugkeystore"
            keyPassword = "123456"
        }
        listOf("develop", "staging", "production").forEach { flavorName ->
            val env = loadEnvFor(flavorName)
            val keystoreFile = rootProject.file(env["KEYSTORE_FILE_PATH"]!!)
            if (keystoreFile.exists()) {
                create(flavorName) {
                    storeFile = keystoreFile
                    storePassword = env["KEYSTORE_PASSWORD"]!!
                    keyAlias = env["KEY_ALIAS"]!!
                    keyPassword = env["KEY_PASSWORD"]!!
                }
            }
        }
    }

    flavorDimensions += "env"
    productFlavors {
        create("develop") {
            val env = loadEnvFor("develop")
            dimension = "env"
            applicationId = env["APPLICATION_ID"]!!
            versionCode = env["APPLICATION_VERSION_CODE"]!!.toInt()
            versionName = env["APPLICATION_VERSION_NAME"]!!
            versionNameSuffix = "-develop"
            buildConfigField("String", "BASE_URL", env["SERVER_URL"]!!.asBuildConfigString())
            buildConfigField(
                "String",
                "APPLICATION_NAME",
                env["APPLICATION_NAME"]!!.asBuildConfigString()
            )
            manifestPlaceholders["applicationName"] = env["APPLICATION_NAME"]!!
            signingConfigs.findByName("develop")?.let { signingConfig = it }
        }
        create("staging") {
            val env = loadEnvFor("staging")
            dimension = "env"
            applicationId = env["APPLICATION_ID"]!!
            versionCode = env["APPLICATION_VERSION_CODE"]!!.toInt()
            versionName = env["APPLICATION_VERSION_NAME"]!!
            versionNameSuffix = "-staging"
            buildConfigField("String", "BASE_URL", env["SERVER_URL"]!!.asBuildConfigString())
            buildConfigField(
                "String",
                "APPLICATION_NAME",
                env["APPLICATION_NAME"]!!.asBuildConfigString()
            )
            manifestPlaceholders["applicationName"] = env["APPLICATION_NAME"]!!
            signingConfigs.findByName("staging")?.let { signingConfig = it }
        }
        create("production") {
            val env = loadEnvFor("production")
            dimension = "env"
            applicationId = env["APPLICATION_ID"]!!
            versionCode = env["APPLICATION_VERSION_CODE"]!!.toInt()
            versionName = env["APPLICATION_VERSION_NAME"]!!
            buildConfigField("String", "BASE_URL", env["SERVER_URL"]!!.asBuildConfigString())
            buildConfigField(
                "String",
                "APPLICATION_NAME",
                env["APPLICATION_NAME"]!!.asBuildConfigString()
            )
            manifestPlaceholders["applicationName"] = env["APPLICATION_NAME"]!!
            signingConfigs.findByName("production")?.let { signingConfig = it }
        }
    }
    buildTypes {
        release {
            configure<CrashlyticsExtension> { mappingFileUploadEnabled = false }
            isMinifyEnabled = true
            isShrinkResources = true
            proguardFiles(
                getDefaultProguardFile("proguard-android-optimize.txt"),
                "proguard-rules.pro"
            )
        }
    }
    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_11
        targetCompatibility = JavaVersion.VERSION_11
    }
    buildFeatures {
        compose = true
        buildConfig = true
    }
}

dependencies {
    implementation(platform(libs.firebase.bom))
    implementation(libs.firebase.analytics)
    implementation(libs.firebase.crashlytics)
    implementation(libs.androidx.core.ktx)
    implementation(libs.androidx.appcompat)
    implementation(libs.androidx.browser)
    implementation(libs.androidx.lifecycle.runtime.ktx)
    implementation(libs.androidx.activity.compose)
    implementation(platform(libs.androidx.compose.bom))
    implementation(libs.androidx.compose.ui)
    implementation(libs.androidx.compose.ui.graphics)
    implementation(libs.androidx.compose.ui.tooling.preview)
    implementation(libs.androidx.compose.material3)
    implementation(libs.androidx.navigation.compose)
    implementation(libs.coil.compose)
    implementation(libs.compose.shimmer)
    implementation(libs.spinkit)
    testImplementation(libs.junit)
    androidTestImplementation(libs.androidx.junit)
    androidTestImplementation(libs.androidx.espresso.core)
    androidTestImplementation(platform(libs.androidx.compose.bom))
    androidTestImplementation(libs.androidx.compose.ui.test.junit4)
    debugImplementation(libs.androidx.compose.ui.tooling)
    debugImplementation(libs.androidx.compose.ui.test.manifest)
    implementation(libs.hilt.android)
    ksp(libs.hilt.android.compiler)
    implementation(libs.androidx.hilt.navigation.compose)
    implementation(libs.retrofit)
    implementation(libs.retrofit.converter.moshi)
    implementation(libs.okhttp)
    implementation(libs.okhttp.logging.interceptor)
    implementation(libs.moshi)
    ksp(libs.moshi.kotlin.codegen)
    implementation(libs.androidx.datastore.preferences)
    implementation(libs.androidx.room.runtime)
    implementation(libs.androidx.room.ktx)
    ksp(libs.androidx.room.compiler)

    debugImplementation(libs.chucker.library)
    releaseImplementation(libs.chucker.library.no.op)
}
