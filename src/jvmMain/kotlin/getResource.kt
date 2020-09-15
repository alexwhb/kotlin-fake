import kotlin.reflect.KClass


actual fun <T : Any> getResourcePath(klass: KClass<T>, path: String):String {
   return  klass.java.getResource(path).path ?: ""
}