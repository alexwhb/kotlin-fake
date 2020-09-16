import kotlin.random.Random
import kotlin.reflect.KClass


// todo this still will allow duplicates if we call this multiple times. We need
// to create some guarantee of uniqueness
//fun <T> Random.getRandomElement(elements: List<T>): T {
//    return elements[this.nextInt(0, elements.size - 1)]
//}

expect fun <T : Any> getResourcePath(klass:KClass<T>, path:String):String

expect fun String.format(local: String, vararg args: Any?): String

operator fun StringBuilder.plus(str: String) {
    this.append(str)
}

fun assert(b: Boolean, message: String = "") {
    if (!b) {
        throw Exception("assertion error: $message")
    }
}

// if you just cast a char to an int it will not get you the expected value...
// it will return the ASCII code so this is the way to get the real numeric value
// ref: https://stackoverflow.com/questions/47713611/how-do-i-convert-a-digit-char-0-9-to-its-numeric-value
fun Char.getNumericValue(): Int {
    if (this !in '0'..'9') {
        throw NumberFormatException()
    }
    return this.toInt() - '0'.toInt()
}

fun String.shuffle(): String {
    val str = this.toCharArray()
    str.shuffle()
    return str.concatToString()
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

