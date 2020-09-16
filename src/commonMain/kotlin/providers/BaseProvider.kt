package providers

open class BaseProvider {

    private val valuesMap = HashMap<String, String>()

    private fun putValue(key: String, value: String) {
        valuesMap[key] = value
    }

    fun getValue(key: String, fakeItValue: () -> String): String {
        return if (Fake.getUniqueValue()) {
            if (!valuesMap.contains(key)) {
                putValue(key, fakeItValue())
            }
            valuesMap[key]!!
        } else {
            fakeItValue()
        }
    }
}