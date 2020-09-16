import kotlin.test.*


class TestFake {

    @Test
    fun `it should provide a fake name`() {
        Fake.init()
        val name = Fake.name().name()
        assertNotNull(name)
        assertTrue(name.split(" ").size == 2)
    }

    @Test
    fun `it should provide a fake first name`() {
        Fake.init()
        val fistName = Fake.name().firstName()

        assertNotNull(fistName)
    }

    @Test
    fun `it should provide an address`() {
        Fake.init()
        val streetAddress = Fake.address().streetAddress()
        val city = Fake.address().city()
        val state = Fake.address().state()
        val stateAbrev = Fake.address().stateAbbreviation()
        val zip = Fake.address().zipCode()

        assertNotNull(streetAddress)
        assertNotNull(city)
        assertNotNull(state)
        assertNotNull(stateAbrev)
        assertNotNull(zip)
    }


    @Test
    fun `it should create a formatted date`() {
        Fake.init()

        val date = Fake.dateTime().dateFormatter()

        assertNotNull(date)
        assertPatternMatches(date, "[0-9]{2}/[0-9]{2}/[0-9]{4}")
    }


    @Test
    fun `it should return demographic data`() {
        Fake.init()

        val race = Fake.demographic().race()
        val sex = Fake.demographic().sex()
        val maritalStatus = Fake.demographic().maritalStatus()

        assertNotNull(race)
        assertNotNull(maritalStatus)
        assertNotNull(sex)
    }

    @Test
    fun `it should return file data`() {
        Fake.init()

        val mimeType = Fake.file().mimeType()
        val extension = Fake.file().extension()

        assertNotNull(mimeType)
        assertNotNull(extension)
        assertPatternMatches(mimeType, "[a-z]+/[a-z]+")
        assertPatternMatches(extension, "[a-zA-Z]+")
    }

    @Test
    fun `it should provide a phone number`() {
        Fake.init()

        val phoneNumber = Fake.phone().formats()

        assertNotNull(phoneNumber)
    }

    @Test
    fun `it should provide a fake sentence`() {
        Fake.init()
        val text = Fake.lorem().sentence()

        assertNotNull(text)
        assertTrue(text.split(" ").size > 5)
    }

    @Test
    fun `it should generate more than one sentence`(){
        Fake.init()
        val paragraph = Fake.lorem().paragraph()

        assertNotNull(paragraph)
        assertTrue(paragraph.split(".").size > 2)
    }

    private fun assertPatternMatches(text: String, pattern: String, message: String = "") {
        assertTrue(Regex(pattern).matches(text), "the pattern $pattern did not match $text. $message")
    }
}

