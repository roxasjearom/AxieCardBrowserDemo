# AxieCardBrowserDemo
Demonstrates the recommended app architecture from [Android documentation guide](https://developer.android.com/topic/architecture). This also uses some of the recommended components for Modern Android Development such as Room, Retrofit, Hilt, Kotlin Flows and Coroutines, and other core Jetpack libraries.

The app has a basic functionality which is to fetch data from a remote data source, save it to a local database, then display the content based from that data. With this functionality, the app demonstrates how to implement the recommended app architecture, which contains the following:

*  UI Layer - The role of the UI layer (or presentation layer) is to display the application data on the screen. Whenever the data changes, either due to user interaction (such as pressing a button) or external input (such as a network response), the UI should update to reflect the changes.
*  Data Layer - contains the business logic. The business logic is what gives value to your app—it's made of rules that determine how your app creates, stores, and changes data. The data layer is made of repositories that each can contain zero to many data sources. 
*  Domain Layer - an optional layer that sits between the UI and data layers. It is responsible for encapsulating complex business logic, or simple business logic that is reused by multiple ViewModels.

The app uses the following libraries/components:

* Retrofit + Moshi - for handling network related tasks
* Room - for local persistence
* Hilt - for dependency injection
* Coil - for image display
* Kotlin Flows + Coroutines - for app operations and long running tasks
