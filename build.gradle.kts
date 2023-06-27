import java.util.*

buildscript {

    dependencies {
        classpath(libs.plugins.spring.boot.gradle.plugin.get().toString())
    }
}

plugins {
    java
    id(libs.plugins.dependency.management.get().pluginId) version "${libs.plugins.dependency.management.get().version}"
    id(libs.plugins.lombok.plugin.get().pluginId) version "${libs.plugins.lombok.plugin.get().version}"
}


allprojects{
    repositories {
        google()
        mavenCentral()
        gradlePluginPortal()
    }
    // 配置项目信息
    group = "com.rbtxm"
    version = "1.0"


    tasks.withType<JavaCompile> {
        // jdk版本
        sourceCompatibility = "17"
        targetCompatibility = "17"
        // utf-8编码
        options.encoding = "UTF-8"
    }

    // 测试
    tasks.withType<Test> {
        useJUnitPlatform()
    }

}

var springBootStarterTest: String = libs.spring.boot.starter.test.get().toString()
var springCloudDependencies: String = libs.spring.cloud.dependencies.get().toString()
var springCloudAlibabaDependencies: String = libs.spring.cloud.alibaba.dependencies.get().toString()


val gradleProperties: MutableMap<String, Any?> = project.rootProject.file("application.properties")
        .takeIf { it.exists() }
        ?.let { propertiesFile ->
            Properties().apply {
                propertiesFile.inputStream().use { load(it) }
            }
        }?.entries?.associate { (key, value) -> key.toString() to value }?.toMutableMap()
        ?: mutableMapOf()

subprojects {

    apply {
        plugin("java")
        plugin("application")
        plugin("java-library")
        plugin("io.freefair.lombok")
        plugin("org.springframework.boot")
        plugin("io.spring.dependency-management")
    }

    dependencyManagement {
        imports {
            mavenBom(springCloudDependencies)
            mavenBom(springCloudAlibabaDependencies)
        }
    }

    dependencies{
        testImplementation(springBootStarterTest)
    }
    tasks.named<Copy>("processResources") {
        val bootstrapYml = File("${projectDir}/src/main/resources/bootstrap.yml")
        if (bootstrapYml.exists()) {
            delete("${project.buildDir}")
            gradleProperties["projectName"] = project.name
            from(projectDir) {
                include("src/main/resources/bootstrap.yml")
            }
            into("${projectDir}/build/resources/main")
            doLast {
                val file = file("${destinationDir}/bootstrap.yml")
                val modifiedContent = StringBuilder()
                file.bufferedReader().use { reader ->
                    reader.forEachLine { line ->
                        val replacedLine = replaceProperties(line, gradleProperties)
                        modifiedContent.appendLine(replacedLine)
                    }
                }
                file.writeText(modifiedContent.toString())
            }

        }
    }
}



fun replaceProperties(line: String, properties: Map<String, *>): String {
    var replacedLine = line
    for ((key, value) in properties) {
        val placeholder = "\${$key}"
        val propertyValue = value.toString()
        replacedLine = replacedLine.replace(placeholder, propertyValue)
    }
    return replacedLine
}
