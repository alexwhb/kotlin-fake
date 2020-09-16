package providers.definition

interface DemographicProvider : Provider {

    val race: String
    val educationalAttainment: String
    val demonym: String
    val maritalStatus: String
    val sex: String
}