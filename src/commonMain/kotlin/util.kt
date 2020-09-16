import kotlinx.serialization.descriptors.StructureKind
import kotlin.random.Random
import kotlin.reflect.KClass


// todo this still will allow duplicates if we call this multiple times. We need
// to create some guarantee of uniqueness
//fun <T> Random.getRandomElement(elements: List<T>): T {
//    return elements[this.nextInt(0, elements.size - 1)]
//}

expect fun <T : Any> getResourcePath(klass:KClass<T>, path:String):String

operator fun StringBuilder.plus(str: String) {
    this.append(str)
}

fun assert(b: Boolean, message: String = "") {
    if (!b) {
        throw Exception("assertion error: $message")
    }
}

data class CharSet(val chars: String, val random: Random = Random.Default) {

    operator fun plus(value: CharSet): CharSet {
        return CharSet(chars + value.chars)
    }

    fun getRandomElement(): String {
        val index = random.nextInt(0, chars.length - 1)
        return chars[index].toString()
    }

    fun replace(strToBeReplaced: String, replacePattern: String = "#"):String {
        val pattern = Regex(replacePattern)

        return pattern.replace(strToBeReplaced) {
            this.getRandomElement()
        }
    }

    companion object {
        fun alnum(random: Random = Random.Default): CharSet {
            return alpha(random) + numeric(random)
        }
        fun alpha(random: Random = Random.Default): CharSet {
            return CharSet("abcdefghijklmnopqrstuvwxyz", random)
        }
        fun numeric(random: Random = Random.Default): CharSet {
            return CharSet("0123456789", random)
        }
    }
}


//
//fun replace(
//    strToBeReplaced: String,
//    replaceWith: CharSet,
//    replacePattern: String = "#"
//): String {
//    val pattern = Regex(replacePattern)
//
//    return pattern.replace(strToBeReplaced) {
//        replaceWith.getRandomElement()
//    }
//}

