# Asteroid Evader

#### Google Playstore link https://play.google.com/store/apps/details?id=com.amcd.asteroid

#### This app is made using the Unity Engine with c# for scripting, the Android Native elements of the Application are made use XML for the UI and Kotlin for the coding.

#### Initially this appllication started as just the mobile game element, but as time went on and I learnt more about mobile game development, I started to think about whether it would be possible to make a mobile game one element of an application. As I am in a career as an Android developer, it made sense to see whether it would be possible to integrate a Unity Mobile game into a wider Android applciation. The answer was yes. I learnt that you can expand the capabilities of a standard Android application by integrating Unity elements into it.

#### The game itslef allows the user to control a Star ship and attempt to avoid asteroids that are spawning around the edges of the map. The user has a pre-set health, and if they collide with too many Asteroids the game will finish.

![Screenshot_20230608_153439](https://github.com/AlexJMcD/AsteroidEvaderAndroidApplication/assets/92163117/be6b41be-bde6-4f74-b1a2-5d5c13e56fa0)




#### As this was a research excercise I did not add extensive functionallity to the Android application, my effort was more to explore the possibilities. Below is a list of features in the non-Unity element of the application.
* A Room database that is used to store the scores of the usr achieved in the game. The Room database is setup in Android. I extended the UnityPlayerActivity and added a function in the new class to store database info. That function is then called from inside the Unity game code. Thus I learnt that you can have significant Utility between the Unity and Android Native elements of the app.
```
// Kotlin Code in the Android activity.
companion object {
        private lateinit var instance: KotlinUnityActivity

       @JvmStatic
        fun setInstance(instance: KotlinUnityActivity) {
            this.instance = instance
        }

        // Called from c# scripts in the unity files.
        @JvmStatic
        fun saveScore(score: Int) {
            instance.saveScoreData(score)
         }
   }
   ```
   ```
   // c# code in one of the Unity scripts
   public class AndroidFunctionCaller : MonoBehaviour
{
    private static AndroidJavaClass androidJavaClass;
    public void SaveScoreData(int score)
    {
        // Retrieve the current activity to access Android functions
        AndroidJavaClass unityPlayerClass = new AndroidJavaClass("com.amcd.unity.activities.KotlinUnityActivity");

        unityPlayerClass.CallStatic("saveScore", new object[] {score});
    }
}
```
* A score board that displays all of the scores achieved by the user in the game. The information is retrieved from the Room database, sorted according to score, and then displayed in a recycler view.
![scores_list](https://github.com/AlexJMcD/AsteroidEvaderAndroidApplication/assets/92163117/ab0b9430-1e4d-49f0-a8b8-7dc8de2d9af1)

*The MainActivity of the app has a bottom navigation meny that allows the user to navigate between three fragments.
*The app has a repository that interacts with the database, and then viewModels that interact with the repository, therefore this app follows MVVM architecture patterns.
*The app uses DaggerHilt for dependency injection.
The app uses a custom splash screen.

### Below is a demo video of the app in action
https://github.com/AlexJMcD/AsteroidEvaderAndroidApplication/assets/92163117/4e549015-24db-4d2c-9a77-cc9841d9c0c1


#### The size of the app when the game loads represents a screen rotation to landscape, the game still uses the full screen.

#### If you got this far thank you very much for reading. I learnt alot while working on this project, and am keen to explore the further possibilites of combining Android and Unity technologies. Have a nice day!

