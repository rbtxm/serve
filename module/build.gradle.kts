var springCloud: String = libs.versions.springcloud.get()
var springCloudAlibaba: String = libs.versions.springcloudalibaba.get()
var lombok: String = libs.versions.lombok.get()
subprojects{

    dependencyManagement{
        imports{
            mavenBom( "org.springframework.cloud:spring-cloud-dependencies:${springCloud}")
            mavenBom( "com.alibaba.cloud:spring-cloud-alibaba-dependencies:${springCloudAlibaba}")
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

        compileOnly("org.projectlombok:lombok:${lombok}")
        annotationProcessor("org.projectlombok:lombok:${lombok}")
    }
}
