package com.blackstone.fake.providers

import com.blackstone.fake.CharSet
import com.blackstone.fake.Fake
import com.blackstone.fake.format
import com.blackstone.fake.providers.definition.InternetProvider

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
        get() = {
            val nbWords = Fake.random().nextInt(1, 6)
            (0 until nbWords).joinToString("-") { Fake.lorem().word }
        }.toString()
    override val ipv4: String // todo this is not techinally correct, so fix.
        get() = CharSet.numeric(Fake.fake.random).replace("10.#.#.###")
    override val ipv6: String
        get() = {
            val result = mutableListOf<String>()
            for (i in 0 until 8) {
                result.add(Fake.random().nextInt(0, 65535).toString(16))
            }
            result.joinToString(":")
        }.toString()
    override val macAddress: String
        get() = {
            val mac = mutableListOf<String>()
            for (i in 0 until 6) {
                mac.add("%02X".format("", Fake.random().nextInt(0, 0xff)))
            }
            mac.joinToString(":")
        }.toString()
}