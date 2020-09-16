package providers.definition

interface MiscellaneousProvider {

    val boolean: Boolean
    fun boolean(chanceOfGettingTrue:Int = 50)

    val md5: String
    val sha1: String
    val sha256: String
    val locale: String
    val countryCode: String
    val languageCode: String
    val currencyCode: String
    val emoji: String
}