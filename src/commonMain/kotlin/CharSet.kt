import kotlin.random.Random

data class CharSet(val chars: String, val random: Random = Random.Default) {

    operator fun plus(value: CharSet): CharSet {
        return CharSet(chars + value.chars)
    }

    fun getRandomElement(): String {
        val index = random.nextInt(0, chars.length - 1)
        return chars[index].toString()
    }

    fun replace(strToBeReplaced: String, replacePattern: String = "#"):String {
        val pattern = Regex(replacePattern)

        return pattern.replace(strToBeReplaced) {
            this.getRandomElement()
        }
    }

    companion object {
        fun alnum(random: Random = Random.Default): CharSet {
            return alpha(random) + numeric(random)
        }
        fun alpha(random: Random = Random.Default): CharSet {
            return CharSet("abcdefghijklmnopqrstuvwxyz", random)
        }
        fun numeric(random: Random = Random.Default): CharSet {
            return CharSet("0123456789", random)
        }
    }
}