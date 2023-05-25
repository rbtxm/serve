var springCloud: String = libs.versions.springcloud.get()
subprojects{

    dependencyManagement{
        imports{
            mavenBom( "org.springframework.cloud:spring-cloud-dependencies:${springCloud}")
        }
    }

    dependencies{
        implementation(project(":common:core"))
        implementation("org.springframework.cloud:spring-cloud-starter-openfeign")
    }
}
