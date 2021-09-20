# Kotlin Fake
[![License: MIT](https://img.shields.io/badge/License-MIT-yellow.svg)](https://opensource.org/licenses/MIT)  
A data faker library that works with Kotlin Multiplatform. 

This library was inspired by a lot of the good "faking" libraries out there already, 
and I did not really create anything too new or revolutionary. However, I wanted to have this tool 
for one of my work projects, and I could not find one that attempted to port things to a multiplatform project, 
so I figured I'd give it a shot.

This project builds off of a lot of really great code that is out there. A word of warning to anyone who uses this:
I have not yet written any of the implementation for loading files on native. If you'd like to contribute please send me 
a PR... I'd be happy to merge it in if it looks goods. 

## Examples of how to use

In my App I am creating a Redux style state management system, so here's an example of how I use this

```kotlin

class BookmarkBuilder {

    var trackIndex: Int = Fake.random().nextInt(0, 50)
    var trackPos: Long = Fake.random().nextLong(1.minutes.millisecondsLong, 45.minutes.millisecondsLong)
    var trackName = "Track ${trackIndex + 1}"
    var dateCreated = DateTimeTz.nowLocal()
    
    fun build(): Bookmark {
        return Bookmark(-1, trackIndex, PlayTime(trackPos), trackName, dateCreated)
    }
}

inline fun buildBookmark(init: BookmarkBuilder.() -> Unit): Bookmark {
    val builder = BookmarkBuilder()
    builder.init()
    return builder.build()
}

```

Then when I want to build a bookmark I can just go like this: 
```kotlin
val bookmark = buildBookmark {/* And in here I can override any of the properties that I don't want faker generating */}
```

I also use this in conjunction with Ktor in order to fake API responses.. I use much the same pattern, but use 
serializable objects instead so they can be easily converted to JSON and I return those from a fake Ktor API. 



## Influences: 
[Fakeit](https://github.com/moove-it/fakeit)    
[kotlin-faker](https://github.com/serpro69/kotlin-faker)    
**And my favrate and first used varient of faker:**    
[PHP fzaninotto/Faker](https://github.com/fzaninotto/Faker)  
