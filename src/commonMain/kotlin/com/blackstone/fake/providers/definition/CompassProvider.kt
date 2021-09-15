package com.blackstone.fake.providers.definition

interface CompassProvider : Provider {
    val cardinal: String
    val ordinal: String
    val halfWind: String
    val quarterWind: String
    val direction: String
    val abbreviation: String
    val azimuth: String
    val cardinalAbbreviation: String
    val ordinalAbbreviation: String
    val halfWindAbbreviation: String
    val quarterWindAbbreviation: String
    val cardinalAzimuth: String
    val ordinalAzimuth: String
    val halfWindAzimuth: String
    val quarterWindAzimuth: String
}