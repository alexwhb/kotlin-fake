import providers.BookProvider
import providers.NameProvider
import providers.UniqueProvider
import kotlin.random.Random


class Fake {

    val random by lazy { Random.Default }

    val name by lazy {
        NameProvider(random)
    }

    val book by lazy {
        BookProvider(random)
    }

    val unique by lazy { UniqueProvider(random) }

}