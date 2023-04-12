dependencyManagement{
    imports{
        mavenBom( "org.springframework.cloud:spring-cloud-dependencies:${libs.versions.springcloud.get()}")
        mavenBom( "com.alibaba.cloud:spring-cloud-alibaba-dependencies:${libs.versions.springcloudalibaba.get()}")
    }
}

dependencies{
    implementation("org.springframework.cloud:spring-cloud-starter-bootstrap")
    implementation("org.springframework.boot:spring-boot-starter-web")
    implementation("com.alibaba.cloud:spring-cloud-starter-alibaba-nacos-discovery")
    implementation("com.alibaba.cloud:spring-cloud-starter-alibaba-nacos-config")
}
