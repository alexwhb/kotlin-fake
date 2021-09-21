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

## How to add to your project
Add the repository to your project's `build.gradle.kts`. I'm using kotlin for my gradle syntax, but groovy 
will be pretty similar if that's what you use
```kotlin 
repositories {
    ...
    maven("https://repos.awhb.dev")
    ...
}
```

add following in your commonMain source set
```kotlin
sourceSets {
  val commonMain by getting {
    dependencies {
      ...
      implementation("com.blackstone:Fake:0.1.0")
        ...
    }
  }
}
  ...
```




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
val bookmark = buildBookmark {
    /* And in here I can override any of the properties that I don't want faker generating */
}
```

I also use this in conjunction with Ktor in order to fake API responses. I use much the same pattern, but use 
serializable objects instead, so they can be easily converted to JSON and I return those from a fake Ktor API. 

###  How to Add  a New Generator
You might want to add a new generator for a data type that is custom to your app and this system does not 
already include. This is not hard to do. 

```kotlin
// Note that we extend provider interface here. This is needed for the getProvider method to register your provider
class CustomTypeGenerator: Provider {

  fun test(): String {
    return "my custom data"
  }

  // you can use Fake to build your own custom generator types
  fun test2(): String {
    return "${Fake.random().nextInt()}-${Fake.random().nextInt()}"
  }
}

fun someFunction() {
  Fake.customName().test()
  Fake.customName().test2()
}

// This is how we register our custom provider, so we can use it anywhere where Fake is accessible
private fun Fake.Companion.customName(): CustomTypeGenerator = 
    // this getProvider string should be unique to this provider otherwise you might have nasty exceptions
    getProvider("test") { CustomTypeGenerator() } as CustomTypeGenerator

```


### Known Issues and Things That Can Improve
* I don't currently support the native platform. I fixed this for my own 
  local dev environment by editing the `getResources.kt` file in `iOSMain` and updating 
  ` 
  val path = ""
   `
To be the absolute path to the `commonTest/resources/en.yml` which is needed in order to generate many of
  the fake data properties. I'd love to fix this in the future. The current issue is that iOS creates a 
  Emulator folder on your computer somewhere that is not local to the project, so when you try to load the
  file it's not realitive to where your project is at all... Probably the way to solve this would be to 
  add that file, in the gradle build process, to your emulator root dir. 

## Influences: 
[Fakeit](https://github.com/moove-it/fakeit)    
[kotlin-faker](https://github.com/serpro69/kotlin-faker)    
**And my favrate and first used varient of faker:**    
[PHP fzaninotto/Faker](https://github.com/fzaninotto/Faker)  
