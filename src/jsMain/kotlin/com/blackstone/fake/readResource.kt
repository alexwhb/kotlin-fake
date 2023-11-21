package com.blackstone.fake

import kotlin.reflect.KClass

actual fun <T : Any> readResource(klass: KClass<T>, path: String): String {
    throw Exception("not defined")
}

actual fun String.format(local: String, vararg args: Any?): String {
    throw Exception("not defined")
}