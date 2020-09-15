package providers

import com.suparnatural.core.fs.ContentEncoding
import com.suparnatural.core.fs.FileSystem
import getRandomElement
import getResourcePath
import kotlinx.serialization.Serializable

import kotlinx.serialization.decodeFromString
import kotlinx.serialization.json.Json
import kotlin.random.Random


class NameProvider(private val random: Random) {

//    private val path = "./src/commonMain/resources/names.json"

    @Serializable
    data class Names(val firstNames: List<String>, val lastNames: List<String>, val prefixes: List<String>)

    private val holder by lazy { Holder<String>() }

    private val names by lazy {
        val path = getResourcePath(NameProvider::class, "/names.json")
        val nameData = FileSystem.readFile(path, ContentEncoding.Utf8)
        Json.decodeFromString<Names>(nameData!!)
    }

    val lastName by UniqueDelegate(holder["lastName"]) {
        random.getRandomElement(names.lastNames)
    }
    val firstName by UniqueDelegate(holder["firstName"]) {
        random.getRandomElement(names.firstNames)
    }

    val prefix
        get() = random.getRandomElement(names.prefixes)

    val fullName by UniqueDelegate(holder["fullName"]) {
        "$firstName $lastName"
    }
}
