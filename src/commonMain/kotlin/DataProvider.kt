//import com.suparnatural.core.fs.ContentEncoding
//import com.suparnatural.core.fs.FileSystem
//import kotlinx.serialization.Serializable
//import kotlinx.serialization.decodeFromString
//import kotlinx.serialization.json.Json
//import kotlin.random.Random

//val random by lazy { Random.Default }

//fun <T> Random.getRandomElement(elements: List<T>): T {
//    return elements[this.nextInt(0, elements.size - 1)]
//}
//
//class NameProvider() {
//    @Serializable
//    data class Names(val firstNames: List<String>, val lastNames: List<String>, val prefixes: List<String>)
//
//    private val path = "./src/commonTest/resources/names.json"
//
//    private val names by lazy {
//        val nameData = FileSystem.readFile(path, ContentEncoding.Utf8)
//        Json.decodeFromString<Names>(nameData!!)
//    }
//
//    fun getFirstName(): String {
//        return random.getRandomElement(names.firstNames)
//    }
//
//    fun getLastName(): String {
//        return random.getRandomElement(names.lastNames)
//    }
//
//    fun getPrefix(): String {
//        return random.getRandomElement(names.prefixes)
//    }
//
//    fun getFullName(): String {
//        return "${getFirstName()} ${getLastName()}"
//    }
//}
//
//data class CharSet(val chars: String) {
//
//    operator fun plus(value: CharSet): CharSet {
//        return CharSet(chars + value.chars)
//    }
//
//    companion object {
//        fun alnum(): CharSet {
//            return alpha() + numeric()
//        }
//        fun alpha(): CharSet {
//            return CharSet("abcdefghijklmnopqrstuvwxyz")
//        }
//        fun numeric(): CharSet {
//            return CharSet("0123456789")
//        }
//    }
//}
//
//fun CharSet.getRandomElement(): String {
//    val index = random.nextInt(0, chars.length - 1)
//    return chars[index].toString()
//}
//
//
//// this is a generator function that replaces a pattern with random values either
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

//fun createSessionId():String {
//    return replace("####-####-####-####-####", CharSet.alnum()).run {
//        replace("####:$this", CharSet.numeric()).toUpperCase()
//    }
//}
//
//fun createBookId():String {
//    return replace("####", CharSet.alnum())
//}
