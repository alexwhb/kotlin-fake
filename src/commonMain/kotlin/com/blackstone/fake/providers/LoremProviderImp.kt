package com.blackstone.fake.providers

import com.blackstone.fake.Fake.Companion.fake
import com.blackstone.fake.assert
import com.blackstone.fake.plus
import com.blackstone.fake.providers.definition.LoremProvider

class LoremProviderImp : BaseProvider(), LoremProvider {
    override val word: String
        get() = getValue("words") { fake.fetch("lorem.words") }

    override fun sentence(nbWords: Int, variableNbWords: Boolean): String {
        assert(nbWords > 3, "You must have more than 3 words to use sentence")
        var numberOfWords = nbWords
        if (variableNbWords) {
            numberOfWords = fake.random.nextInt(
                nbWords,
                nbWords * 2
            ) // todo I'd like to make this larger for small N and smaller for large N
        }
        val sb = StringBuilder()
        for (i in 0 until numberOfWords) {
            sb + word
            if (i < numberOfWords - 2) sb + " "
        }
        sb + "."
        return sb.toString()
    }

    override fun paragraph(nbSentences: Int, variableNbSentences: Boolean, sentenceGenerator: (() -> String)?): String {
        assert(nbSentences >= 2, "You must have at least 2 sentences to make a valid paragraph")
        var numberOfSentences = nbSentences
        if (variableNbSentences) {
            numberOfSentences = fake.random.nextInt(
                nbSentences,
                nbSentences * 2
            ) // todo I'd like to make this larger for small N and smaller for large N
        }

        val sb = StringBuilder()
        for (i in 0 until numberOfSentences) {
            if (sentenceGenerator == null) {
                sb + sentence()
            } else {
                sb + sentenceGenerator()
            }
            if (i < numberOfSentences - 2) sb + " "
        }
        return sb.toString()
    }

}