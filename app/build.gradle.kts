plugins {
    id("com.android.application")
    id("com.google.gms.google-services") // Firebase 插件
}

android {
    namespace = "com.example.studentsystemapp"
    compileSdk = 34

    defaultConfig {
        applicationId = "com.example.studentsystemapp"
        minSdk = 21
        targetSdk = 34
        versionCode = 1
        versionName = "1.0"
    }

    buildTypes {
        release {
            isMinifyEnabled = false
            proguardFiles(getDefaultProguardFile("proguard-android-optimize.txt"), "proguard-rules.pro")
        }
    }

    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_17
        targetCompatibility = JavaVersion.VERSION_17
    }
}

dependencies {
    implementation("androidx.appcompat:appcompat:1.6.1")
    implementation("androidx.recyclerview:recyclerview:1.2.1")
    implementation("androidx.constraintlayout:constraintlayout:2.1.4")
    implementation("com.google.android.material:material:1.11.0")
    androidTestImplementation("androidx.test.ext:junit:1.1.5") // AndroidJUnit4 支持
    androidTestImplementation("androidx.test:runner:1.5.2")   // 测试运行器
    androidTestImplementation("androidx.test:rules:1.5.0")    // 测试规则
    testImplementation("junit:junit:4.13.2") // 单元测试支持
    implementation(platform("com.google.firebase:firebase-bom:32.0.0"))
    implementation("com.google.firebase:firebase-auth")
    implementation("com.google.firebase:firebase-firestore")
    implementation(libs.monitor)
    androidTestImplementation(libs.junit.junit)
}
