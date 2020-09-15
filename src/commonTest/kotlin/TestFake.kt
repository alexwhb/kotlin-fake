import com.suparnatural.core.fs.ContentEncoding
import com.suparnatural.core.fs.FileSystem
import providers.UniqueDelegate
import kotlin.test.*


class TestFake {


    @Test
    fun `it should create a fake full name that is different from the next one`() {
        val fake = Fake()

        val fullName = fake.name.fullName
        val fullName1 = fake.name.fullName

        assertNotEquals(fullName, fullName1)
    }


    class Dumb {
        val b by UniqueDelegate(mutableSetOf(5)) {
            5
        }
    }

    @Test()
    fun `it should throw exception when value is not unique after 15 attempts`() {
        val d = Dumb()
        // because b is going to attempt to regenerate 5 over and over it will fail after 15 attempts since
        // it is unable to find a unique value.
        assertFailsWith<Exception> {
            d.b
        }
    }


    @Test
    fun temp() {
        val t = getResourcePath(TestFake::class, "temp.txt")
        val output = FileSystem.readFile(t, ContentEncoding.Utf8)

        assertFalse(t.isEmpty())
    }

//    @Test
//    fun temp2(){
//        val fake = Fake()
//        val path = fake.name.temp
//
//        assertFalse(path.isEmpty())
//    }

    @Test
    fun `it should return a unique element of the list each time`() {
        val fake = Fake()
        val list = listOf("a", "b", "c", "d")

        val output = fake.unique.uniqueElementsOf(list, 3)

        assertEquals(3, output.size)
    }

    @Test
    fun `it should generate 10 unique books`() {
        val fake = Fake()


        val bookTitles = mutableListOf<String>()
        for (i in 0 until 10) {
            bookTitles.add(fake.book.title)
        }

        // I'm assessing that there are not only 10 titles, but that they are also unique.
        assertEquals(10, bookTitles.toSet().size)
    }


    @Test
    fun `it should generate a fake sentence`(){
        val fake = Fake()
//        val sentence = fake.text.sentince
//        val sentence1 = fake.text.sentince
//        assertNotEquals(sentence, sentence1)
//        assertTrue(sentence.length > 10)
        fail()
    }


//    fun `it should get a unique integer`() {
//        val fake = Fake()
//        val list = mutableListOf<Int?>()
//
//        for (x in 0..7){
//            list.add(fake.unique.randomInt(0, 5))
//        }
//        // assert that the last two items are null
//
//        assertNull(list.last())
//        assertNotNull(list.first())
//        assertTrue(list.first()!! < 6)
//    }

//    @Test
//    fun `it should return a unique book title`() {
//        val set = mutableSetOf<String>()
//        val fake = Fake()
//        for(x in 0..100){
//            val title = fake.book.title
//            if(set.contains(title)){
//                fail("Book title: \"$title\" was not unique.")
//            } else {
//                set.add(title)
//            }
//        }
//    }


}

