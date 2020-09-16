package providers

import Fake.Companion.fake
import providers.definition.CompassProvider

class CompassProviderImp : BaseProvider(), CompassProvider {
    override val cardinal: String
        get() = getValue("cardinal") { fake!!.fetch("compass.cardinal.word") }
    override val ordinal: String
        get() = getValue("ordinal") { fake!!.fetch("compass.ordinal.word") }
    override val halfWind: String
        get() = getValue("half_wind") { fake!!.fetch("compass.half-wind.word") }
    override val quarterWind: String
        get() = getValue("quarter_wind") { fake!!.fetch("compass.quarter-wind.word") }
    override val direction: String
        get() = getValue("direction") { fake!!.fetch("compass.direction") }
    override val abbreviation: String
        get() = getValue("abbreviation") { fake!!.fetch("compass.abbreviation") }
    override val azimuth: String
        get() = getValue("azimuth") { fake!!.fetch("compass.azimuth") }
    override val cardinalAbbreviation: String
        get() = getValue("cardinal_abbreviation") { fake!!.fetch("compass.cardinal.abbreviation") }
    override val ordinalAbbreviation: String
        get() = getValue("ordinal_abbreviation") { fake!!.fetch("compass.cardinal.abbreviation") }
    override val halfWindAbbreviation: String
        get() = getValue("half_wind_abbreviation") { fake!!.fetch("compass.half-wind.abbreviation") }
    override val quarterWindAbbreviation: String
        get() = getValue("quarter_wind_abbreviation") { fake!!.fetch("compass.quarter-wind.abbreviation") }
    override val cardinalAzimuth: String
        get() = getValue("cardinal_azimuth") { fake!!.fetch("compass.cardinal.azimuth") }
    override val ordinalAzimuth: String
        get() = getValue("ordinal_azimuth") { fake!!.fetch("compass.ordinal.azimuth") }
    override val halfWindAzimuth: String
        get() = getValue("half_wind_azimuth") { fake!!.fetch("compass.half-wind.azimuth") }
    override val quarterWindAzimuth: String
        get() = getValue("quarter_wind_azimuth") { fake!!.fetch("compass.quarter-wind.azimuth") }
}