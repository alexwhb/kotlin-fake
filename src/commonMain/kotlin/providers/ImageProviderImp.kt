package providers

import assert
import providers.definition.ImageProvider

class ImageProviderImp : BaseProvider(), ImageProvider {

    private val categories = listOf(
        "abstract", "animals", "business", "cats", "city", "food", "nightlife",
        "fashion", "people", "nature", "sports", "technics", "transport"
    )

    override val imageUrl: String
        get() = imageUrl()

    override fun imageUrl(
        width: Int,
        height: Int,
        category: String?,
        randomize: Boolean,
        word: String?,
        gray: Boolean
    ): String {
        val baseUrl = "https://lorempixel.com/"
        var url = "$width$height"

        if (gray) {
            url = "gray/$url"
        }

        category?.let {
            assert(
                !categories.contains(category),
                "category passed to image provider $category is not a valid category"
            )
            url += "$category/";
            word?.let {
                url += "$word/";
            }
        }

        if (randomize) { // todo this needs more ref: https://github.com/fzaninotto/Faker/blob/master/src/Faker/Provider/Image.php
            val random = Fake.fake!!.random.nextInt(10)
            url += "?$random"
        }
        return "$baseUrl$url"
    }
}