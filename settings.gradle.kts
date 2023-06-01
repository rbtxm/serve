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
    if (dir.isDirectory && dir != rootDir) {
        val buildFile = File(dir, "${dir.name}.gradle.kts")
        if (buildFile.exists()) {
            includeProject(dir)
        }
    }
}

fun includeProject(projectDir: File){
    val  projectName = projectDir.name

    val buildFileName = "${projectName}.gradle.kts"

    val baseDir = File(settingsDir, projectName)
    val subProjectDir = File(baseDir, projectName)
    assert(subProjectDir.isDirectory)
    assert(File(subProjectDir, buildFileName).isFile)

    val parentProjectName = projectDir.parentFile.name

    include(if (parentProjectName.equals(rootDir.name)) projectName else "${parentProjectName}:${projectName}")
    project(if (parentProjectName.equals(rootDir.name)) ":${projectName}" else ":${parentProjectName}:${projectName}").projectDir = subProjectDir
    project(if (parentProjectName.equals(rootDir.name)) ":${projectName}" else ":${parentProjectName}:${projectName}").buildFileName = buildFileName

}
