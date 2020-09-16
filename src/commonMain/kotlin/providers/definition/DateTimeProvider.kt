package providers.definition

interface DateTimeProvider : Provider {
    val dateFormatter: String
    val timeFormatter: String
    val dateTimeFormatter: String
}