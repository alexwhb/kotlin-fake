package com.blackstone.fake

import platform.Foundation.*
import kotlin.reflect.KClass


actual fun <T : Any> readResource(klass: KClass<T>, path: String): String {
    val manager = NSFileManager.defaultManager

    println(manager.currentDirectoryPath)
    // TODO fix this... but for now this is a hack that works.
    val path = "/Users/iblackmac/Projects/Work/AndroidProjects/learning/Fake-MPP/src/commonTest/resources/en.yml"
    val data = manager.contentsAtPath(path) ?: throw IllegalArgumentException("Cannot open input file $path")

    return NSString.create(data, NSUTF8StringEncoding).toString()
}


actual fun String.format(local: String, vararg args: Any?): String {
    return "" // todo this needs to be implemented. 
}
