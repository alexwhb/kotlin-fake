package com.blackstone.fake.providers.definition

interface LoremProvider : Provider {
    val word: String
    fun sentence(nbWords: Int = 7, variableNbWords: Boolean = true): String
    fun paragraph(nbSentences:Int = 3, variableNbSentences: Boolean = true, sentenceGenerator: (() -> String)? = null):String
}