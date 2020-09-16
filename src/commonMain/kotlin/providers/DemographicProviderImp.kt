package providers

import Fake.Companion.fake
import providers.definition.DemographicProvider

class DemographicProviderImp: BaseProvider(), DemographicProvider {

    override val race: String
        get() = getValue("race") { fake!!.fetch("demographic.race") }
    override val educationalAttainment: String
        get() = getValue("educationalAttainment") { fake!!.fetch("demographic.educational_attainment") }
    override val demonym: String
        get() = getValue("demonym") { fake!!.fetch("demographic.demonym") }
    override val maritalStatus: String
        get() = getValue("maritalStatus") { fake!!.fetch("demographic.marital_status") }
    override val sex: String
        get() = getValue("sex") { fake!!.fetch("demographic.sex") }
}