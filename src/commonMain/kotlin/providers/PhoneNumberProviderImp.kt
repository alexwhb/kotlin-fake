package providers

import Fake.Companion.fake
import providers.definition.PhoneNumberProvider

class PhoneNumberProviderImp: BaseProvider(), PhoneNumberProvider {
    override fun formats(): String {
        return getValue("formats") { fake!!.fetch("phone_number.formats") }
    }
}