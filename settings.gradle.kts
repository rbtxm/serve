pluginManagement {
    repositories {
        gradlePluginPortal()
    }
    resolutionStrategy {
        eachPlugin {
            if (requested.id.id == "org.kordamp.gradle.profiles") {
                useModule("org.kordamp.gradle.profiles:org.kordamp.gradle.profiles.gradle.plugin:${requested.version}")
            }
        }
    }
}
rootProject.name = "serve"

rootDir.walkTopDown().maxDepth(2).forEach { dir ->
    println(dir.name)
    val buildFile = File(dir, "${dir.name}.gradle.kts")
    if (buildFile.exists()) {
        includeProject(dir.name)
    }
}

fun includeProject(projectName: String) {
    val baseDir = File(settingsDir, projectName)
    val projectDir = File(baseDir, projectName)
    val buildFileName = "${projectName}.gradle.kts"
    assert(projectDir.isDirectory)
    assert(File(projectDir, buildFileName).isFile)
    include(projectName)
    project(":${projectName}").projectDir = projectDir
    project(":${projectName}").buildFileName = buildFileName
}
