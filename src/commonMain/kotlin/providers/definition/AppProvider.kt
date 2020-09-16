package providers.definition

interface AppProvider : Provider {
    val name: String
    val swiftBic: String
    val bankCountryCode: String
    val ibanLetterCode: String
    val ibanDigits: String
}