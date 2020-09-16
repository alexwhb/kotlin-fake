package providers.definition

interface FileProvider : Provider {
    val extension: String
    val mimeType: String
}