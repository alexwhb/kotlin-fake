package providers

import Fake.Companion.fake
import providers.definition.AddressProvider

class AddressProviderImp : BaseProvider(), AddressProvider {
    override val city: String
        get() = getValue("city") { fake!!.fetch("address.city") }
    override val streetAddress: String
        get() = getValue("streetAddress") { fake!!.fetch("address.street_address") }
    override val buildingNumber: String
        get() = getValue("buildingNumber") { fake!!.fetch("address.secondary_address") }
    override val zipCode: String
        get() = getValue("zipCode") { fake!!.fetch("address.zip_code") }
    override val state: String
        get() = getValue("state") { fake!!.fetch("address.state") }
    override val stateAbbreviation: String
        get() = getValue("stateAbbreviation") { fake!!.fetch("address.state_abbr") }
}