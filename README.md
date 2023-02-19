# GregorysPoliceForce
=================================

Todo List
---------------
1. DI with Hilt
2. Unit  & UI tests
3. test Hilt 
4. WorkManager
5. Is this still needed? DI testing: https://developer.android.com/codelabs/basic-android-kotlin-compose-add-repository?continue=https%3A%2F%2Fdeveloper.android.com%2Fcourses%2Fpathways%2Fandroid-basics-compose-unit-5-pathway-2%23codelab-https%3A%2F%2Fdeveloper.android.com%2Fcodelabs%2Fbasic-android-kotlin-compose-add-repository#6
6. if there's no value for an engagement method, hide it
7. make method links clickable
8. Format "description" - see Avon & Somerset
9. Extract Strings
10. Migrate common UI to a common UI file
11. tidy up the code: big refactor
12. Go over Todos
13. Migrate MVVM to MVI
14. ADD police style logo
15. ADD dark mode
16. If we do the "find officer X game", then we should be able to hide items we've seen by marking them as read
17. Bonus feature: add search bar

Current thinking for screens
--------------
Screen 1: List of Forces  - add star wars photos to these?
Screen 2: Specific Force
Screen 3: Senior Officers? - once you identify the person - go back to main screen


Notes/Reminders
---------------
Warning: Singleton pattern is not a recommended practice. Singletons represent global states that are hard to predict, particularly in tests. Objects should define which dependencies they need, instead of describing how to create them.
