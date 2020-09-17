package providers.definition

interface ImageProvider : Provider {

    val imageUrl: String

    fun imageUrl(width:Int = 640, height:Int = 480, category:String? = null, randomize: Boolean = true, word:String? = null, gray:Boolean = false):String
}