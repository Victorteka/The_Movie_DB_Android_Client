
<p align="center">
<img src="app/src/main/res/mipmap-hdpi/ic_launcher.png" alt="home" width="100"/>
</p>

## The Movie DB Android Client

An android app that consumes TMDB api

Build System : [Gradle](https://gradle.org/)

## Libraries

Libraries used in the whole application are:

- [Jetpack](https://developer.android.com/jetpack)🚀
  - [Viewmodel](https://developer.android.com/topic/libraries/architecture/viewmodel) - Manage UI related data in a lifecycle conscious way
  and act as a channel between use cases and ui
  - [Data Binding](https://developer.android.com/topic/libraries/data-binding) - support library that allows binding of UI components in  layouts to data sources,binds character details and search results to UI

- [kotlinx.coroutines](https://github.com/Kotlin/kotlinx.coroutines) - Library Support for coroutines,provides `runBlocking` coroutine builder used in tests
and supports coroutines out of the box.
- [Retrofit](https://square.github.io/retrofit/) - type safe http client
- [Dagger-Hilt](https://dagger.dev/hilt/) Dependency injection
- [Paging3](https://developer.android.com/topic/libraries/architecture/paging/v3-overview) Loading a lot of data efficiently
- [Gson](https://github.com/google/gson) - A Java serialization/deserialization library to convert Java Objects into JSON and back
- [okhttp-logging-interceptor](https://github.com/square/okhttp/blob/master/okhttp-logging-interceptor/README.md) - logs HTTP request and response data.
- [Material Design](https://material.io/develop/android/docs/getting-started/) - build awesome beautiful UIs.🔥🔥

## Screenshots

|Upcoming movies| Latest movie| Popular movies| Trending shows|
|:----:|:----:|:----:|:----:|
|<img src="screenshots/upcoming.png" width=300/>|<img src="screenshots/latest.png" width=300/>|<img src="screenshots/popular.png" width=300/>|<img src="screenshots/trend.png" width=300/>|
|Search| Tv shows| Movie details|
|<img src="screenshots/search.png" width=300/>|<img src="screenshots/tv.png" width=300/>|<img src="screenshots/details.png" width=300/>|
|:----:|:----:|:----:|
