package providers.definition

interface CompassProvider : Provider {
    val cardinal: String
    val ordinal: String
    val half_wind: String
    val quarter_wind: String
    val direction: String
    val abbreviation: String
    val azimuth: String
    val cardinal_abbreviation: String
    val ordinal_abbreviation: String
    val half_wind_abbreviation: String
    val quarter_wind_abbreviation: String
    val cardinal_azimuth: String
    val ordinal_azimuth: String
    val half_wind_azimuth: String
    val quarter_wind_azimuth: String
}