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
//
//include("gateway")
//
//include("auth")
//
//include("common")
//include("common:core","common:datasource","common:redis","common:doc","common:security","common:log","common:datascope","common:seata","common:sentinel")
//
//include("module")
//include("module:system","module:file")
//
//include("api")
//include("api:system","api:file")

val projectDirs = listOf("gateway", "auth", "common", "module")

val commonProjectDirs = listOf("redis", "doc", "security", "log", "datascope", "seata", "sentinel")

projectDirs("", projectDirs)

projectDirs("common", commonProjectDirs)


fun projectDirs(path: String, projectDirs: List<String>) {
    val dir: File = if (path.isEmpty()) {
        rootDir
    } else {
        File(rootDir, path)
    }
    projectDirs.forEach { dirName ->
        val subdir = File(dir, dirName)
        subdir.walkTopDown().maxDepth(1).forEach { dir ->
            val buildFile = File(dir, "${dir.name}.gradle.kts")
            if (buildFile.exists()) {
                includeProject(path, dirName, dir.name)
            }
        }
    }
}

fun includeProject(path: String, projectDirName: String, projectName: String) {
    val baseDir = File(settingsDir, projectDirName)
    val projectDir: File = if (path.isEmpty()) {
        File(baseDir, projectName)
    } else {
        File(File(baseDir, path), projectName)
    }
    val buildFileName = "${projectName}.gradle.kts"
    assert(projectDir.isDirectory)
    assert(File(projectDir, buildFileName).isFile)

    include(projectName)

    project(":${projectName}").projectDir = projectDir
    project(":${projectName}").buildFileName = buildFileName
}
