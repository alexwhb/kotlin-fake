package providers.definition

interface BankProvider: Provider {
    val name: String
    val swiftBic: String
    val bankCountryCode: String
    val ibanLetterCode: String
    val ibanDigits: String
}