package com.blackstone.fake.providers

import com.blackstone.fake.Fake
import com.blackstone.fake.providers.definition.MiscellaneousProvider
import okio.ByteString.Companion.encodeUtf8

class MiscellaneousProviderImp : MiscellaneousProvider {
    override val boolean: Boolean
        get() = Fake.fake.random.nextBoolean()

    override fun boolean(chanceOfGettingTrue: Int):Boolean =
        Fake.fake.random.nextInt(1, 100) <= chanceOfGettingTrue

    override val md5: String
        get() = Fake.fake.random.nextInt().toString().encodeUtf8().md5().hex()
    override val sha1: String
        get() = Fake.fake.random.nextInt().toString().encodeUtf8().sha1().hex()
    override val sha256: String
        get() = Fake.fake.random.nextInt().toString().encodeUtf8().sha256().hex()
    override val locale: String
        get() = TODO("Not yet implemented")
    override val countryCode: String
        get() = TODO("Not yet implemented")
    override val languageCode: String
        get() = TODO("Not yet implemented")
    override val currencyCode: String
        get() = TODO("Not yet implemented")
    override val emoji: String
        get() = TODO("Not yet implemented")
}
