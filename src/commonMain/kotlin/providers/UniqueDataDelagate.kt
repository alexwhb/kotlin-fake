package providers

import assert
import kotlin.reflect.KProperty

class Holder<T> {
    private val seen = HashMap<String, MutableSet<T>>()

    operator fun get(key: String): MutableSet<T> {
        val set = seen[key]
        if (set == null) {
            seen[key] = mutableSetOf()
        }
        return seen[key]!!
    }
}

class UniqueDelegate<out T>(private val seen: MutableSet<T>, private val function: () -> T) {

    private val maxTries = 15

    val value : T
    get() {
        var count = 0
        var value = function()

        while (seen.contains(value) && count < maxTries) {
            count++
            value = function()
        }
        assert(count != maxTries, "max tries exceeded")
        seen.add(value)
        return value
    }

    operator fun getValue(provider: Any, property: KProperty<*>): T {
        return value
    }



}

