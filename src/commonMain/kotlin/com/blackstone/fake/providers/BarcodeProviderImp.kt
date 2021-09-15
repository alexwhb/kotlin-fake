package com.blackstone.fake.providers

import com.blackstone.fake.CharSet
import com.blackstone.fake.Fake
import com.blackstone.fake.assert
import com.blackstone.fake.getNumericValue
import com.blackstone.fake.providers.definition.BarcodeProvider

class BarcodeProviderImp : BaseProvider(), BarcodeProvider {

    private fun ean(length: Int = 13): String {
        val code = CharSet.numeric().replace("#".repeat(length - 1))

        return "$code${eanChecksum(code)}"
    }

    /**
     * Utility function for computing EAN checksums
     *
     */
    private fun eanChecksum(input: String): Int {
        val sequence = if ((input.length + 1) == 8) {
            arrayOf(3, 1)
        } else {
            arrayOf(1, 3)
        }
        var sums = 0;
        for (i in input.indices) {
            sums += input[i].getNumericValue() * sequence[i % 2]
        }
        return (10 - sums % 10) % 10;
    }

    /**
     * ISBN-10 check digit
     * @link http://en.wikipedia.org/wiki/International_Standard_Book_Number#ISBN-10_check_digits
     *
     */
    private fun isbnChecksum(input: String): String {
        // We're calculating check digit for ISBN-10
        // so, the length of the input should be 9
        val length = 9;

        assert(input.length == length, "Input length should be equal to $length")

        val values = mutableListOf<Int>()
        for (i in input.indices) {
            values.add((10 - i) * input[i].getNumericValue())
        }
        val result = (11 - values.sum() % 11) % 11
        return if (result < 10) result.toString() else "X"
    }

    override val ean13: String
        get() = ean()
    override val ean8: String
        get() = ean(8)
    override val isbn10: String
        get() {
            val code = CharSet.numeric().replace("#".repeat(9))
            return "$code${isbnChecksum(code)}"
        }
    override val isbn13: String
        get() {
            val code = "97${Fake.fake.random.nextInt(8, 9)}${CharSet.numeric().replace("#".repeat(9))}"
            return "$code${eanChecksum(code)}"
        }
}