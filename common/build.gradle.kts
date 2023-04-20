var springCloud: String = libs.versions.springcloud.get()
var springCloudAlibaba: String = libs.versions.springcloudalibaba.get()

subprojects{
    apply{
        plugin("java-library")
    }
    dependencies{
        compileOnly("org.projectlombok:lombok")
        annotationProcessor("org.projectlombok:lombok")
    }
    dependencyManagement{
        imports{
            mavenBom( "org.springframework.cloud:spring-cloud-dependencies:${springCloud}")
            mavenBom( "com.alibaba.cloud:spring-cloud-alibaba-dependencies:${springCloudAlibaba}")
        }
    }
}