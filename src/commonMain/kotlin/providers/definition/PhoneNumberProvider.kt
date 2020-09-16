package providers.definition

interface PhoneNumberProvider : Provider {
    fun formats(): String
}