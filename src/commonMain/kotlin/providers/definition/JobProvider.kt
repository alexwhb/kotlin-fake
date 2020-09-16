package providers.definition

interface JobProvider : Provider {
    val field: String
    val seniority: String
    val position: String
    val title: String
    val keySkill: String
}