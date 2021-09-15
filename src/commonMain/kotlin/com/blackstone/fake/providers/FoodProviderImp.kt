package com.blackstone.fake.providers

import com.blackstone.fake.Fake.Companion.fake
import com.blackstone.fake.providers.definition.FoodProvider

class FoodProviderImp : BaseProvider(), FoodProvider {
    override val ingredient: String
        get() = getValue("ingredient") { fake.fetch("food.ingredients") }
    override val spice: String
        get() = getValue("spice") { fake.fetch("food.spices") }
    override val measurement: String
        get() = getValue("measurement") { fake.fetch("food.measurement_sizes") + " " + fake.fetch("food.measurements") }
}