package providers

import Fake.Companion.fake
import com.soywiz.klock.DateFormat
import com.soywiz.klock.DateTime
import providers.definition.DateTimeProvider

class DateTimeProviderImp : BaseProvider(), DateTimeProvider {

    override fun dateFormatter(): String {
        val dateFormat = DateFormat(getValue("name") { fake!!.fetch("date.formats") })
        return DateTime.now().format(dateFormat)
    }

    override fun timeFormatter(): String {
        val dateFormat = DateFormat(getValue("name") { fake!!.fetch("time.formats") })
        return DateTime.now().format(dateFormat)
    }

    override fun dateTimeFormatter(): String {
        val dateFormat = DateFormat(getValue("name") { fake!!.fetch("date.format_with_time") })
        return DateTime.now().format(dateFormat)
    }
}