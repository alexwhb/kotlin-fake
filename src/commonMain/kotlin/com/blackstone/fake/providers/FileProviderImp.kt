package com.blackstone.fake.providers

import com.blackstone.fake.Fake.Companion.fake
import com.blackstone.fake.providers.definition.FileProvider

class FileProviderImp : BaseProvider(), FileProvider {
    override val extension: String
        get() = getValue("extension") { fake.fetch("file.extension") }
    override val mimeType: String
        get() = getValue("mimeType") { fake.fetch("file.mime_type") }
}