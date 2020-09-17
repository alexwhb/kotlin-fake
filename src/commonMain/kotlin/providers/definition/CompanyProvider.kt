package providers.definition

interface CompanyProvider: Provider {
    val suffix: String
    val buzzwords: String
    val bs: String
    val name: String
    val industry: String
    val profession: String
}