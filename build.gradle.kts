buildscript{

    repositories{
        gradlePluginPortal()
        mavenCentral()
    }

    dependencies{
        classpath(libs.plugins.spring.boot.gradle.plugin.get().toString())
    }

}

subprojects {
    apply {
        plugin("java")
        plugin("org.springframework.boot")
        plugin("io.spring.dependency-management")
    }
    repositories {
        google()
        mavenCentral()
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
