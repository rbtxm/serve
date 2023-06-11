var springCloud: String = libs.spring.cloud.dependencies.get().toString()
var springCloudAlibaba: String = libs.spring.cloud.alibaba.dependencies.get().toString()
var lombokPlugin:String = libs.plugins.lombok.plugin.get().pluginId

plugins{
    id(libs.plugins.lombok.plugin.get().pluginId) version "${libs.plugins.lombok.plugin.get().version}"
}
subprojects{
    apply{
        plugin(lombokPlugin)
    }
    dependencyManagement{
        imports{
            mavenBom(springCloud)
            mavenBom(springCloudAlibaba)
        }
    }

    dependencies{
        implementation("org.springframework.boot:spring-boot-starter-web"){
            exclude(group = "org.springframework.boot", module = "spring-boot-starter-tomcat")
        }
        implementation("org.springframework.cloud:spring-cloud-starter-bootstrap")
        implementation("org.springframework.boot:spring-boot-starter-undertow")
        implementation("com.alibaba.cloud:spring-cloud-starter-alibaba-nacos-discovery")
        implementation("com.alibaba.cloud:spring-cloud-starter-alibaba-nacos-config")
    }
}
