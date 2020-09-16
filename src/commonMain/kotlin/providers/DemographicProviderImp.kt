package providers

import Fake.Companion.fake
import providers.definition.DemographicProvider

class DemographicProviderImp: BaseProvider(), DemographicProvider {

    override fun race(): String {
        return getValue("race") { fake!!.fetch("demographic.race") }
    }

    override fun educationalAttainment(): String {
        return getValue("educationalAttainment") { fake!!.fetch("demographic.educational_attainment") }
    }

    override fun demonym(): String {
        return getValue("demonym") { fake!!.fetch("demographic.demonym") }
    }

    override fun maritalStatus(): String {
        return getValue("maritalStatus") { fake!!.fetch("demographic.marital_status") }
    }

    override fun sex(): String {
        return getValue("sex") { fake!!.fetch("demographic.sex") }
    }
}