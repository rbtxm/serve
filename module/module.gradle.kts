subprojects{
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
