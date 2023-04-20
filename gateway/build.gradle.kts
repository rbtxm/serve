import org.springframework.boot.gradle.tasks.run.BootRun

dependencyManagement{
    imports{
        mavenBom( "org.springframework.cloud:spring-cloud-dependencies:${libs.versions.springcloud.get()}")
        mavenBom( "com.alibaba.cloud:spring-cloud-alibaba-dependencies:${libs.versions.springcloudalibaba.get()}")
    }
}

dependencies{
    implementation(project(":common:core"))
    implementation(project(":common:redis"))
    implementation(project(":common:doc"))
    implementation(project(":common:log"))
    compileOnly("org.projectlombok:lombok")
    annotationProcessor("org.projectlombok:lombok")
    annotationProcessor("org.springframework.boot:spring-boot-configuration-processor")
    implementation("org.springframework.boot:spring-boot-starter-data-redis-reactive")
    implementation("org.springframework.boot:spring-boot-starter-web")
    implementation("org.springframework.cloud:spring-cloud-starter-bootstrap")
    implementation("com.alibaba.cloud:spring-cloud-starter-alibaba-nacos-discovery")
    implementation("com.alibaba.cloud:spring-cloud-starter-alibaba-nacos-config")
    implementation("com.alibaba.cloud:spring-cloud-alibaba-sentinel")
    implementation("com.alibaba.cloud:spring-cloud-alibaba-sentinel-gateway")
}

