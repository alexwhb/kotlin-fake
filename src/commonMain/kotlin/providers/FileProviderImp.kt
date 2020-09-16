package providers

import Fake.Companion.fake
import providers.definition.FileProvider

class FileProviderImp : BaseProvider(), FileProvider {
    override val extension: String
        get() = getValue("extension") { fake!!.fetch("file.extension") }
    override val mimeType: String
        get() = getValue("mimeType") { fake!!.fetch("file.mime_type") }
}