package providers.definition

interface ColorProvider : Provider{
    val hexColor: String
    val safeHexColor: String
    val rgbColor: String
    val rgbColorArray: List<Int>
    val cssRgbColor: String
    val rgbaCssColor: String
    val safeColorName: String
    val colorName: String
    val hslColor: String
    val hslColorArray: List<Int>
}