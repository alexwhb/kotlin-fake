package providers

import Fake.Companion.fake
import providers.definition.BookProvider

class BookProviderImp : BaseProvider(s), BookProvider {
    override fun title(): String {
        return getValue("title") { fake!!.fetch("book.title") }
    }

    override fun author(): String {
        return getValue("author") { fake!!.fetch("book.author") }
    }

    override fun publisher(): String {
        return getValue("publisher") { fake!!.fetch("book.publisher") }
    }

    override fun genre(): String {
        return getValue("genre") { fake!!.fetch("book.genre") }
    }
}