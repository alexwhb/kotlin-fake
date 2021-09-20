package com.blackstone.fake

import platform.Foundation.*
import kotlin.reflect.KClass


actual fun <T : Any> readResource(klass: KClass<T>, path: String): String {

    var manager = NSFileManager.defaultManager

    println(manager.currentDirectoryPath)
    // TODO fix this... but for now this is a hack that works.
    var path = "Input Absolut Path To resource"
    val data = manager.contentsAtPath(path) ?: throw IllegalArgumentException("Cannot open input file $path")

    return NSString.create(data, NSUTF8StringEncoding).toString()
}


actual fun String.format(local: String, vararg args: Any?): String {
    return "" // todo this needs to be implemented. 
}
