rootProject.name = "serve"

rootDir.walkTopDown().maxDepth(2).forEach { dir ->
    if (dir.isDirectory && dir != rootDir) {
        val buildFile = File(dir, "${dir.name}.gradle.kts")
        if (buildFile.exists()) {
            includeProject(dir)
        }
    }
}

fun includeProject(projectDir: File) {

    val buildFileName = "${projectDir.name}.gradle.kts"

    assert(projectDir.isDirectory)
    assert(File(projectDir, buildFileName).isFile)

    val projectName: String = if (projectDir.parentFile.name == rootDir.name) {
        projectDir.name
    } else {
        "${projectDir.parentFile.name}:${projectDir.name}"
    }

    include(projectName)
    project(":${projectName}").projectDir = projectDir
    project(":${projectName}").buildFileName = buildFileName
}
