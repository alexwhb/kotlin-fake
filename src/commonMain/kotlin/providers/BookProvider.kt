package providers

import com.suparnatural.core.fs.ContentEncoding
import com.suparnatural.core.fs.FileSystem
import getRandomElement
import getResourcePath
import kotlinx.serialization.Serializable
import kotlinx.serialization.decodeFromString
import kotlinx.serialization.json.Json
import kotlin.random.Random

class BookProvider(val random: Random) {

    private val holder by lazy { mutableSetOf<Book>() }

    @Serializable
    data class Book(val title: String, val authors: String, val isbn: String, val isbn13: String, val image_url: String)

    private val books by lazy {
        val path =  getResourcePath(BookProvider::class, "/books.json")
        val bookData = FileSystem.readFile(path, ContentEncoding.Utf8)
        Json {
            this.isLenient = true
        }.decodeFromString<List<Book>>(bookData!!)
    }

    private val uniqueBook: Book by UniqueDelegate(holder) {
        random.getRandomElement(books)
    }

    val title get() = uniqueBook.title
    val authors get() = uniqueBook.authors
    val isbn get() = uniqueBook.isbn
    val isbn13 get() = uniqueBook.isbn13
    val imageUrl get() = uniqueBook.image_url
    val bookId get() = CharSet.alnum(random).replace("####")

}