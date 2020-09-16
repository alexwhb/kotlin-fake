package providers

import providers.definition.BiasedProvider
import kotlin.math.floor

class BiasedProviderImp : BiasedProvider {

    /**
     * Returns a biased integer between min and max (both inclusive).
     * The distribution depends on $unction.
     *
     * The algorithm creates two doubles, x ∈ [0, 1], y ∈ [0, 1) and checks whether the
     * return value of $function for x is greater than or equal to y. If this is
     * the case the number is accepted and x is mapped to the appropriate integer
     * between $min and $max. Otherwise two new doubles are created until the pair
     * is accepted.
     *
     * @param min Minimum value of the generated integers.
     * @param max Maximum value of the generated integers.
     * @param function A function mapping x ∈ [0, 1] onto a double ∈ [0, 1]
     * @return integer An integer between $min and $max.
     */
    override fun biasedNumberBetween(min: Int, max: Int, function: (x: Double) -> Double): Double {
        // ref: https://bookdown.org/rdpeng/advstatcomp/rejection-sampling.html
        // ref: https://github.com/fzaninotto/Faker/blob/37f93702ce51ca08112b40084b7c88f66a10eb62/src/Faker/Provider/Biased.php
        TODO("I need to spend more time figuring out how to do this right. This is called 'Rejection Sampling'")
//        var x: Double
//        var y: Double
//        val random = Fake.fake!!.random
//        do {
//            x = random.nextDouble() / (Double.MAX_VALUE - 1.0)
//            y = random.nextDouble() / Double.MAX_VALUE
//        } while (function(x) < y)
//
//        return floor((x * (max - min + 1) + min))
    }
}