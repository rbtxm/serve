rootProject.name = "serve"

fun includeProject(projectDirName: String, projectName: String) {
    val baseDir = File(settingsDir, projectDirName)
    val projectDir = File(baseDir, projectName)
    val buildFileName = "${projectName}.gradle.kts"

    assert(projectDir.isDirectory)
    assert(File(projectDir, buildFileName).isFile)

    include(projectName)
    project(":${projectName}").projectDir    = projectDir
    project(":${projectName}").buildFileName = buildFileName
}

listOf("docs", "subprojects").forEach { dirName ->
    val subdir = File(rootDir, dirName)
    subdir.walkTopDown().maxDepth(1).forEach { dir ->
        val buildFile = File(dir, "${dir.name}.gradle.kts")
        if (buildFile.exists()) {
            includeProject(dirName, dir.name)
        }
    }
}