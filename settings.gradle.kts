rootProject.name = "spring-mvc-boilerplate"

fun includeModules(pathname: String) {
    File(pathname).listFiles()?.forEach {
        if (it.isDirectory && File(it, "build.gradle.kts").exists()) {
            include("$pathname:${it.name}")
        }
    }
}

pluginManagement {
    val kotlin_version: String by settings
    val klint_version: String by settings
    val spring_boot_version: String by settings
    val spring_dependency_management_version: String by settings

    plugins {
        id("org.springframework.boot") version spring_boot_version
        id("io.spring.dependency-management") version spring_dependency_management_version

        kotlin("jvm") version kotlin_version
        kotlin("plugin.spring") version kotlin_version
        kotlin("plugin.jpa") version kotlin_version

        id("org.jlleitschuh.gradle.ktlint") version klint_version
    }
}

includeModules("application")
includeModules("domain")
includeModules("common")
