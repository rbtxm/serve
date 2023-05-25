@Suppress("DSL_SCOPE_VIOLATION")
plugins {
    alias(libs.plugins.profiles)
}

buildscript{

    repositories{
        gradlePluginPortal()
        mavenCentral()
    }

    dependencies{
        classpath("org.springframework.boot:spring-boot-gradle-plugin:${libs.versions.springboot.get()}")
    }
}

subprojects {
    apply {
        plugin("java")
        plugin("org.springframework.boot")
        plugin ( "org.kordamp.gradle.profiles")
        plugin("io.spring.dependency-management")
    }
    repositories {
        google()
        mavenCentral()
    }

    profiles{
// build.gradle.kts 或其他子模块的构建文件

        profile("development") {
            // 开发环境配置
            // ...
        }

        profile("production") {
            // 生产环境配置
            // ...
        }

    }

    // 配置项目信息
    group = "com.rbtxm"
    version = "1.0.0-SNAPSHOT"


    // jdk版本
    tasks.withType<JavaCompile> {
        sourceCompatibility = "17"
        targetCompatibility = "17"
    }

    // utf-8编码
    tasks.withType<JavaCompile> {
        options.encoding = "UTF-8"
    }

    // 测试
    tasks.withType<Test> {
        useJUnitPlatform()
    }
}
