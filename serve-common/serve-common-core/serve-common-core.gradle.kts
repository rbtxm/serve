dependencies {
    implementation(libs.guava.get().toString())
    api(libs.hutool.core.get().toString())
    implementation(libs.commons.lang3.get().toString())
    implementation(libs.commons.io.get().toString())
    implementation(libs.commons.fileupload.get().toString())
    implementation(libs.transmittable.thread.local.get().toString())
    implementation(libs.spring.boot.starter.validation.get().toString())
    implementation(libs.spring.boot.starter.web.get().toString()){
        exclude(libs.spring.boot.starter.tomcat.get().toString())
    }
    implementation(libs.spring.boot.starter.undertow.get().toString())
}