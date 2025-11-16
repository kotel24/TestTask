plugins {
    alias(libs.plugins.android.library)
    alias(libs.plugins.kotlin.android)
    alias(libs.plugins.ksp)
}

android {
    namespace = "ru.sumin.testtask.core.database"
    compileSdk = 35

    defaultConfig {
        minSdk = 24
        consumerProguardFiles("consumer-rules.pro")
    }

    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_17
        targetCompatibility = JavaVersion.VERSION_17
    }
    kotlinOptions {
        jvmTarget = "17"
    }
}

dependencies {
    implementation(libs.androidx.core.ktx)

    // --- Room (Database) ---
    implementation(libs.androidx.room.runtime)
    implementation(libs.androidx.room.ktx) // Для поддержки Coroutines/Flow

    // Генератор кода (вместо kapt теперь ksp)
    ksp(libs.androidx.room.compiler)

    // --- DI (Koin) ---
    implementation(libs.koin.android)

    // --- Async ---
    implementation(libs.kotlinx.coroutines.android)
}