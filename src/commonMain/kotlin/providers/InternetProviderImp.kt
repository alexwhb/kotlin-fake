package providers

import providers.definition.InternetProvider

class InternetProviderImp : BaseProvider(), InternetProvider {
    override val freeEmail: String
        get() = TODO("Not yet implemented")
    override val domainSuffix: String
        get() = TODO("Not yet implemented")
    override val companyEmail: String
        get() = TODO("Not yet implemented")
    override val userName: String
        get() = TODO("Not yet implemented")
    override val password: String
        get() = TODO("Not yet implemented")
    override val domainName: String
        get() = TODO("Not yet implemented")
    override val slug: String
        get() = TODO("Not yet implemented")
    override val ipv4: String // todo this is not techinally correct, so fix.
        get() = CharSet.numeric(Fake.fake!!.random).replace("10.#.#.###", )
    override val ipv6: String
        get() = TODO("Not yet implemented")
    override val macAddress: String
        get() = TODO("Not yet implemented")
}