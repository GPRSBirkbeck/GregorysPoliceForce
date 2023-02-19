# GregorysPoliceForce
=================================

Todo List
---------------
1. Create App in Compose 
2. DI with Hilt
3. if there's no value for an engagement method, hide it
4. make method links clickable
5. Extract Strings
6. DI testing: https://developer.android.com/codelabs/basic-android-kotlin-compose-add-repository?continue=https%3A%2F%2Fdeveloper.android.com%2Fcourses%2Fpathways%2Fandroid-basics-compose-unit-5-pathway-2%23codelab-https%3A%2F%2Fdeveloper.android.com%2Fcodelabs%2Fbasic-android-kotlin-compose-add-repository#6
7. WorkManager
8. Migrate common UI to a common UI file
9. Migrate MVVM to MVI
10. Add test coverage
11. ADD police style logo
12. ADD dark mode
13. If we do the "find officer X game", then we should be able to hide items we've seen by marking them as read
14. Bonus feature: add search bap

Current thinking for screens
--------------
Screen 1: List of Forces  - add star wars photos to these?
Screen 2: Specific Force
Screen 3: Senior Officers? - once you identify the person - go back to main screen


Notes/Reminders
---------------
Warning: Singleton pattern is not a recommended practice. Singletons represent global states that are hard to predict, particularly in tests. Objects should define which dependencies they need, instead of describing how to create them.

Use Dependency injection over singleton pattern, you will learn how to implement Dependency injection in a later codelab.
