rootProject.name = "backend"

val modules: MutableList<Module> = mutableListOf()

fun module(name: String, path: String) {
    modules.add(Module(name, "${rootDir}/${path}"))
}

data class Module(
    val name: String,
    val path: String,
)

module(name = ":server", path = "server")

modules.forEach {
    include(it.name)
    project(it.name).projectDir = file(it.path)
}

dependencyResolutionManagement {
    versionCatalogs {
        create("libs") {
            from(files("libs.versions.toml"))
        }
    }
}