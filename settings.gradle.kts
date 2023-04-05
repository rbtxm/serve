pluginManagement {
    repositories {
        gradlePluginPortal()
        google()
        mavenCentral()
    }
}

dependencyResolutionManagement {
    repositories {
        google()
        mavenCentral()
    }
}
rootProject.name = "classroom-serve"
include("gateway")
include("auth")
include("common")
include("common:core")
findProject(":common:core")?.name = "core"
include("common:datasource")
findProject(":common:datasource")?.name = "datasource"
include("common:redis")
findProject(":common:redis")?.name = "redis"
include("common:doc")
findProject(":common:doc")?.name = "doc"
include("common:security")
findProject(":common:security")?.name = "security"
include("common:log")
findProject(":common:log")?.name = "log"
include("common:datascope")
findProject(":common:datascope")?.name = "datascope"
include("module")
include("module:system")
findProject(":module:system")?.name = "system"
include("module:file")
findProject(":module:file")?.name = "file"
include("api")