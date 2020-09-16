package providers

import Fake.Companion.fake
import providers.definition.CompanyProvider

class CompanyProviderImp : BaseProvider(), CompanyProvider {
    override val suffix: String
        get() = getValue("suffix") { fake!!.fetch("company.suffix") }
    override val buzzwords: String
        get() = getValue("buzzwords") { fake!!.fetch("company.buzzwords") }
    override val bs: String
        get() = getValue("bs") { fake!!.fetch("company.bs") }
    override val name: String
        get() = getValue("name") { fake!!.fetch("company.name") }
    override val industry: String
        get() = getValue("industry") { fake!!.fetch("company.industry") }
    override val profession: String
        get() = getValue("profession") { fake!!.fetch("company.profession") }
}