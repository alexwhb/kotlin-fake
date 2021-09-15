package com.blackstone.fake.providers

import com.blackstone.fake.Fake
import com.blackstone.fake.format
import com.blackstone.fake.providers.definition.ColorProvider

class ColorProviderImp : ColorProvider {

    private val random = Fake.fake.random

    override val hexColor: String
        get() = "#${
            random.nextInt(1, 16777215)
                .toString(16)
                .padStart(6, '0')
        }"

    override val safeHexColor: String
        get() {
            val color = random.nextInt(0, 255).toString(16).padStart(3, '0')
            return "#${color[0]}${color[0]}${color[1]}${color[1]}${color[2]}${color[2]}"
        }

    override val rgbColor: String
        get() = rgbColorArray.joinToString(",")

    override val rgbColorArray: List<Int>
        get() {
            return listOf(
                hexColor.substring(1..2).toInt(16),
                hexColor.substring(3..4).toInt(16),
                hexColor.substring(5..6).toInt(16)
            )
        }

    override val cssRgbColor: String
        get() = rgbColorArray.joinToString(",", "rgb(", ")")

    override val rgbaCssColor: String // todo we might need to round the double to something
        get() = "rgba(${rgbColor},${"%.2f".format("", random.nextDouble(0.0, 1.0))})"

    override val safeColorName: String
        get() = Fake.fake.fetch("color.safe_color_names")

    override val colorName: String
        get() = Fake.fake.fetch("color.all_color_names")

    override val hslColor: String
        get() = hslColorArray.joinToString(",")

    override val hslColorArray: List<Int>
        get() = listOf(
            random.nextInt(0, 360),
            random.nextInt(0, 100),
            random.nextInt(0, 100)
        );
}