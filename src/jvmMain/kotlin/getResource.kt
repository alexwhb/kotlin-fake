package com.blackstone.fake

import java.nio.charset.StandardCharsets
import java.util.*
import kotlin.reflect.KClass


actual fun <T : Any> readResource(klass: KClass<T>, path: String):String {
   return String(klass.java.getResourceAsStream(path).readAllBytes(), StandardCharsets.US_ASCII)
}


actual fun String.format(local: String, vararg args: Any?):String {
   // yes I know I'm not using the local... for now I'm just defaulting for simplicity sake.
   // if I remove that param it will confuse the correct method resolver.
   return this.format(*args)
}