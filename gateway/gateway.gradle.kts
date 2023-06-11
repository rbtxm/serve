plugins{
    id(libs.plugins.lombok.plugin.get().pluginId) version "${libs.plugins.lombok.plugin.get().version}"
}
dependencyManagement {
    imports {
        mavenBom(libs.spring.cloud.dependencies.get().toString())
        mavenBom(libs.spring.cloud.alibaba.dependencies.get().toString())
    }
}
dependencies {
    annotationProcessor(libs.spring.boot.configuration.processor.get().toString())
    implementation(libs.spring.boot.starter.data.redis.reactive.get().toString())
    implementation(libs.spring.boot.starter.actuator.get().toString())
    implementation(libs.spring.cloud.starter.gateway.get().toString())
    implementation(libs.spring.cloud.starter.bootstrap.get().toString())
    implementation(libs.spring.cloud.loadbalancer.get().toString())
    implementation(libs.spring.cloud.starter.alibaba.nacos.discovery.get().toString())
    implementation(libs.spring.cloud.starter.alibaba.nacos.config.get().toString())

    testImplementation(platform(libs.junit.bom.get().toString()))
    testImplementation(libs.junit.jupiter.get().toString())
}