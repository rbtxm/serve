dependencies {
    annotationProcessor(libs.spring.boot.configuration.processor.get().toString())
    implementation(libs.spring.cloud.loadbalancer.get().toString())
    implementation(libs.spring.cloud.starter.gateway.get().toString())
    implementation(libs.bundles.nacos.config)
}