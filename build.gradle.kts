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

plugins {
    id(libs.plugins.dependency.management.get().pluginId) version "${libs.plugins.dependency.management.get().version}"
    id(libs.plugins.lombok.plugin.get().pluginId) version "${libs.plugins.lombok.plugin.get().version}"
}

var springCloudDependencies: String = libs.spring.cloud.dependencies.get().toString()
var springCloudAlibabaDependencies: String = libs.spring.cloud.alibaba.dependencies.get().toString()

val gradleProperties: MutableMap<String, Any?> = project.rootProject.file("gradle.properties")
        .takeIf { it.exists() }
        ?.let { propertiesFile ->
            Properties().apply {
                propertiesFile.inputStream().use { load(it) }
            }
        }?.entries?.associate { (key, value) -> key.toString() to value }?.toMutableMap()
        ?: mutableMapOf()

subprojects {
    repositories {
        google()
        mavenCentral()
    }
    apply {
        plugin("java")
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
        val bootstrapYml = File("${projectDir}/src/main/resources/bootstrap.yml")
        if (bootstrapYml.exists()) {
            delete("${project.buildDir}")
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
