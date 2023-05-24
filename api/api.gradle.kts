var springCloud: String = libs.versions.springcloud.get()
subprojects{

    dependencyManagement{
        imports{
            mavenBom( "org.springframework.cloud:spring-cloud-dependencies:${springCloud}")
        }
    }

    dependencies{
        implementation(project(":common:core"))
        compileOnly("org.projectlombok:lombok")
        annotationProcessor("org.projectlombok:lombok")
        implementation("org.springframework.cloud:spring-cloud-starter-openfeign")
    }
}
