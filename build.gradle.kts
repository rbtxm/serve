import org.springframework.boot.gradle.tasks.run.BootRun

lateinit var myProperty: String



@Suppress("DSL_SCOPE_VIOLATION")
buildscript{

    repositories{
        mavenCentral()
    }

    dependencies{
        classpath("org.springframework.boot:spring-boot-gradle-plugin:${libs.versions.springboot.get()}")
    }
}

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

    // 定义属性
    // 在 Gradle 构建脚本中设置属性值
    ext {
        myProperty = "value"
    }

// 在 bootRun 任务中传递属性值
    tasks.named<BootRun>("bootRun") {
        systemProperty("myProperty", myProperty)
    }


}
