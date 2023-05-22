import org.gradle.internal.classpath.Instrumented.systemProperty

lateinit var appName: String



@Suppress("DSL_SCOPE_VIOLATION")
buildscript{

    repositories{
        mavenCentral()
    }

    dependencies{
        classpath("org.springframework.boot:spring-boot-gradle-plugin:${libs.versions.springboot.get()}")
    }
}
val activeProfile: String = System.getProperty("activeProfile") ?: "dev"
//apply {
//    from("gradle.properties")
//}
tasks.register("dev") {
    group = "profile"
    doFirst {
        System.setProperty("activeProfile", "dev")
    }
    doLast{
        println("activeProfile: ${System.getProperty("activeProfile")}")
    }
}
tasks.register("prod") {
    group = "profile"
    doFirst {
        System.setProperty("activeProfile", "prod")
    }
    doLast{
        println("activeProfile: ${System.getProperty("activeProfile")}")
    }
}
// 切换环境, 根据切换的环境的，获取到对应的配置文件

subprojects{
    apply{
        plugin("java")
        plugin("org.springframework.boot")
        plugin("io.spring.dependency-management")
    }
    repositories {
        google()
        mavenCentral()
    }
    // 配置项目信息
    group = "com.rbtxm"
    version = "1.0.0-SNAPSHOT"

    // jdk版本
    tasks.withType<JavaCompile> {
        sourceCompatibility = "17"
        targetCompatibility = "17"
    }

    // utf-8编码
    tasks.withType<JavaCompile> {
        options.encoding = "UTF-8"
    }

    // 测试
    tasks.withType<Test> {
        useJUnitPlatform()
    }

}
