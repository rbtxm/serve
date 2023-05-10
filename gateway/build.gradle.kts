dependencyManagement{
    imports{
        mavenBom( "org.springframework.cloud:spring-cloud-dependencies:${libs.versions.springcloud.get()}")
        mavenBom( "com.alibaba.cloud:spring-cloud-alibaba-dependencies:${libs.versions.springcloudalibaba.get()}")
    }
}
dependencies{
    compileOnly("org.projectlombok:lombok")
    annotationProcessor("org.projectlombok:lombok")
    annotationProcessor("org.springframework.boot:spring-boot-configuration-processor")
    implementation("org.springframework.boot:spring-boot-starter-data-redis-reactive")
    implementation("org.springframework.boot:spring-boot-starter-actuator")
    implementation("org.springframework.boot:spring-boot-starter-web"){
        exclude(group = "org.springframework.boot", module = "spring-boot-starter-tomcat")
    }
    implementation("org.springframework.boot:spring-boot-starter-undertow")
    implementation("org.springframework.cloud:spring-cloud-starter-gateway")
    implementation("org.springframework.cloud:spring-cloud-starter-bootstrap")
    implementation("org.springframework.cloud:spring-cloud-loadbalancer")
    implementation("com.alibaba.cloud:spring-cloud-starter-alibaba-nacos-discovery")
    implementation("com.alibaba.cloud:spring-cloud-starter-alibaba-nacos-config")
    implementation("com.alibaba.cloud:spring-cloud-alibaba-sentinel-gateway")
}
