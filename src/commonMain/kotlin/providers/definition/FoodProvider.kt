package providers.definition

interface FoodProvider : Provider {
    val ingredient: String
    val spice: String
    val measurement: String
}