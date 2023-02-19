# GregorysPoliceForce
=================================

Todo List
---------------
1. DI with Hilt
2. Pass param to force detail call
3. Unit  & UI tests
4. if there's no value for an engagement method, hide it
5. make method links clickable
6. Format "description" - see Avon & Somerset
7. Extract Strings
8. DI testing: https://developer.android.com/codelabs/basic-android-kotlin-compose-add-repository?continue=https%3A%2F%2Fdeveloper.android.com%2Fcourses%2Fpathways%2Fandroid-basics-compose-unit-5-pathway-2%23codelab-https%3A%2F%2Fdeveloper.android.com%2Fcodelabs%2Fbasic-android-kotlin-compose-add-repository#6
9. WorkManager
10. Migrate common UI to a common UI file
11. Migrate MVVM to MVI
12. Add test coverage
13. ADD police style logo
14. ADD dark mode
15. If we do the "find officer X game", then we should be able to hide items we've seen by marking them as read
16. Bonus feature: add search bap

Current thinking for screens
--------------
Screen 1: List of Forces  - add star wars photos to these?
Screen 2: Specific Force
Screen 3: Senior Officers? - once you identify the person - go back to main screen


Notes/Reminders
---------------
Warning: Singleton pattern is not a recommended practice. Singletons represent global states that are hard to predict, particularly in tests. Objects should define which dependencies they need, instead of describing how to create them.

Use Dependency injection over singleton pattern, you will learn how to implement Dependency injection in a later codelab.
