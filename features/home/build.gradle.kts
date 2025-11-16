plugins {
    alias(libs.plugins.android.library)
    alias(libs.plugins.kotlin.android)
    alias(libs.plugins.kotlin.compose)
}

android {
    namespace = "ru.sumin.testtask.features.home"
    compileSdk = 35

    defaultConfig {
        minSdk = 24
    }

    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_17
        targetCompatibility = JavaVersion.VERSION_17
    }
    kotlinOptions {
        jvmTarget = "17"
    }
    buildFeatures {
        compose = true
    }
}

dependencies {
    implementation(libs.androidx.core.ktx)
    implementation(libs.androidx.lifecycle.runtime.ktx)

    // --- Compose UI ---
    implementation(platform(libs.androidx.compose.bom))
    implementation(libs.androidx.compose.ui)
    implementation(libs.androidx.compose.ui.graphics)
    implementation(libs.androidx.compose.ui.tooling.preview)
    implementation(libs.androidx.compose.material3)
    debugImplementation(libs.androidx.compose.ui.tooling)

    // --- Navigation & DI ---
    implementation(libs.androidx.navigation.compose)
    implementation(libs.koin.androidx.compose)

    // --- Async ---
    implementation(libs.kotlinx.coroutines.android)

    // --- Картинки (Coil) - ВАЖНО для списка курсов ---
    implementation(libs.coil.compose)

    // --- Модули ---
    implementation(project(":core:ui"))      // UI компоненты
    implementation(project(":core:network")) // Чтобы делать запросы к API
    implementation(project(":core:database")) // Чтобы сохранять в избранное
}