package providers.definition

interface BankProvider {
    val name: String
    val swiftBic: String
    val bankCountryCode: String
    val ibanLetterCode: String
    val ibanDigits: String
}