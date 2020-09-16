package providers

import Fake.Companion.fake
import providers.definition.FileProvider

class FileProviderImp : BaseProvider(), FileProvider {
    override fun extension(): String {
        return getValue("extension") { fake!!.fetch("file.extension") }
    }

    override fun mimeType(): String {
        return getValue("mimeType") { fake!!.fetch("file.mime_type") }
    }
}