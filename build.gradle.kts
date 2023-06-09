import java.io.FileInputStream
import java.util.*

buildscript {
    repositories {
        gradlePluginPortal()
        mavenCentral()
    }

    dependencies {
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
    version = "1.0"

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
    tasks.named<Copy>("processResources") {
        val bootstrapYml = file("${projectDir}/src/main/resources/bootstrap.yml")
        if(bootstrapYml.exists()){
            from(projectDir)
            include("/src/main/resources/bootstrap.yml")
            into("${projectDir}/src/build/resources/main/bootstrap.yml")
            expand(project.properties)
        }
    }

}

