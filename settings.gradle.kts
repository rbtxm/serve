rootProject.name = "serve"
include("gateway")
include("auth")
include("common")
include("common:config")
findProject(":common:config")?.name = "config"
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
include("common:seata")
findProject(":common:seata")?.name = "seata"
include("common:sentinel")
findProject(":common:sentinel")?.name = "sentinel"
include("module")
include("module:system")
findProject(":module:system")?.name = "system"
include("module:file")
findProject(":module:file")?.name = "file"
include("api")
include("api:system")
findProject(":api:system")?.name = "api-system"
include("api:file")
findProject(":api:file")?.name = "api-file"