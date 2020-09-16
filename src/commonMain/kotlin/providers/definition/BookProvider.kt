package providers.definition

interface BookProvider : Provider {
    val title: String
    val author: String
    val publisher: String
    val genre: String
}