package com.blackstone.fake.providers

//import com.blackstone.fake.Fake.Companion.fake
import com.blackstone.fake.Fake.Companion.fake
import com.blackstone.fake.providers.definition.NameProvider

class NameProviderImp : BaseProvider(), NameProvider {
    override val name: String
        get() = getValue("name") { fake.fetch("name.name") }
    override val nameWithMiddle: String
        get() = getValue("nameWithMiddle") { fake.fetch("name.name_with_middle") }
    override val firstName: String
        get() = getValue("firstName") { fake.fetch("name.first_name") }
    override val lastName: String
        get() = getValue("lastName") { fake.fetch("name.last_name") }
    override val prefix: String
        get() = getValue("prefix") { fake.fetch("name.prefix") }
    override val suffix: String
        get() = getValue("suffix") { fake.fetch("name.suffix") }
    override val title: String
        get() = getValue("title") { fake.fetch("name.title.job") }
}