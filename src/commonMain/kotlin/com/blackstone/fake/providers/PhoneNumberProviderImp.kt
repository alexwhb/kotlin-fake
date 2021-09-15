package com.blackstone.fake.providers

import com.blackstone.fake.Fake.Companion.fake
import com.blackstone.fake.providers.definition.PhoneNumberProvider

class PhoneNumberProviderImp: BaseProvider(), PhoneNumberProvider {
    override fun formats(): String {
        return getValue("formats") { fake.fetch("phone_number.formats") }
    }
}