package com.blackstone.fake.providers.definition

interface BiasedProvider:Provider {
    // get a random number between 10 and 20,
    // with more chances to be close to 20
    fun biasedNumberBetween(min: Int = 10, max: Int = 20, function: (x: Double) -> Double): Double
}