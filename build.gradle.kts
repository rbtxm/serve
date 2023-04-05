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
    // 动态多数据源配置
    // 配置分布式事务（多表）
}
