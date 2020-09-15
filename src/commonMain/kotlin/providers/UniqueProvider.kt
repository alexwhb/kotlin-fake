package providers

import assert
import getRandomElement
import kotlin.random.Random

class UniqueProvider(private val random: Random) {

    fun <T> uniqueElementsOf(values: List<T>, numberOfUniqueElements: Int = 1): List<T> {
        return values.toSet().shuffled(random).take(numberOfUniqueElements)
    }

}

