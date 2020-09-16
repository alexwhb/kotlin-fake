import kotlin.reflect.KClass


actual fun <T : Any> getResourcePath(klass: KClass<T>, path: String): String {
   return "" // TODO
}


actual fun String.format(local: String, vararg args: Any?): String {
    return "" // todo this needs to be implemented. 
}