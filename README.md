# SpaceZ

This application has been prepared for YTU entrepreneurship club students which the simple architecture recommended by Google.

* Google to research the recommended architecture; [Architecture](https://developer.android.com/jetpack/guide)

<p align="center">
    <img src="https://github.com/GorkemKarayel/SpaceZ/blob/main/images/architecture.png"/>
</p>


#### The app has following packages:
1. **data**: It contains all the data accessing and manipulating components.
2. **di**: Dependency providing classes using Manual Dependency (Navigator).
3. **ui**: View classes along with their corresponding ViewModel.
4. **widget**: It contains custom view group [RocketView](https://github.com/GorkemKarayel/SpaceZ/blob/main/app/src/main/java/com/app/spacez/widget/RocketView.kt)
5. **repository**: Repository providing class [RocketRepository](https://github.com/GorkemKarayel/SpaceZ/blob/main/app/src/main/java/com/app/spacez/repository/RocketsRepository.kt)


### Library reference resources:
1. Room: https://developer.android.com/topic/libraries/architecture/room.html
2. Coroutines: https://developer.android.com/kotlin/coroutines
3. Retrofit: https://square.github.io/retrofit/

### Looking for MVVM Architecture for Beginners - [Check here](https://developer.android.com/jetpack/guide#common-principles) 


### Contributing to Android MVVM Architecture
Just make pull request. You are in!
