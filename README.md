# SpaceZ

This application has been prepared for YTU entrepreneurship club students which the simple architecture recommended by Google.

* Google to research the recommended architecture; [Architecture](https://developer.android.com/jetpack/guide)

<p align="center">
    <img src="https://github.com/GorkemKarayel/SpaceZ/blob/main/images/architecture.png"/>
</p>


#### The app has following packages:
1. **data**: It contains all the data accessing and manipulating components.[Data](https://github.com/GorkemKarayel/SpaceZ/tree/main/app/src/main/java/com/app/spacez/data)
2. **datasource**: It contains local and remote data source.[DataSource](https://github.com/GorkemKarayel/SpaceZ/tree/main/app/src/main/java/com/app/spacez/datasource)
3. **ui**: View classes along with their corresponding ViewModel.
4. **widget**: It contains custom view group [RocketView](https://github.com/GorkemKarayel/SpaceZ/blob/main/app/src/main/java/com/app/spacez/widget/RocketView.kt)
5. **repository**: Repository providing class [RocketRepository](https://github.com/GorkemKarayel/SpaceZ/blob/main/app/src/main/java/com/app/spacez/repository/RocketsRepository.kt)


### Library reference resources:
1. Retrofit: https://square.github.io/retrofit/
2. ViewModel: https://developer.android.com/topic/libraries/architecture/viewmodel
3. Android Lifecycle: https://developer.android.com/guide/components/activities/activity-lifecycle
4. Fragment Lifecycle: https://developer.android.com/guide/fragments/lifecycle
5. Clean Architecture: https://blog.cleancoder.com/uncle-bob/2012/08/13/the-clean-architecture.html

### Looking for MVVM Architecture for Beginners - [Check here](https://developer.android.com/jetpack/guide#common-principles) 

### Contributing to Android MVVM Architecture
Just make pull request. You are in!
