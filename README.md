# Prayer Notifier V2
A simple application that push notification on each prayer time.

* Currently pushing notification is under development...

## App logic
* The used API provide prayer data for a complete month and for each month, the app stores current month data locally using [Room](https://developer.android.com/topic/libraries/architecture/paging/).
* Every time the app is opened it checks if today's date exists in the database, if not, it will download the new month data.
* The Application is using [Retrofit library](https://square.github.io/retrofit/) to load data and [Kotlin Coroutines on Android](https://developer.android.com/kotlin/coroutines) for threading operations.

## API 
The app uses APT provided by [http://aladhan.com](http://aladhan.com), you can find more details about the API [HERE](https://aladhan.com/islamic-calendar-api).

## License
This project is licensed under the Apache License 2.0
 - see the [LICENSE.md](https://github.com/AAli9400/Prayer_Notifier_V2/blob/master/LICENSE) file for details.
