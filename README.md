# GregorysPoliceForce
=================================

Todo List
---------------
1. Migrate common UI to a common UI file
2. tidy up the code: big refactor - ensure you focus on DI
3. reoganise the packages
4. Go over Todos
5. Migrate MVVM to MVI
6. ADD police style logo
7. ADD dark mode
8. Unit  & UI tests 
9. test Hilt
10. WorkManager
11. Is this still needed? DI testing: https://developer.android.com/codelabs/basic-android-kotlin-compose-add-repository?continue=https%3A%2F%2Fdeveloper.android.com%2Fcourses%2Fpathways%2Fandroid-basics-compose-unit-5-pathway-2%23codelab-https%3A%2F%2Fdeveloper.android.com%2Fcodelabs%2Fbasic-android-kotlin-compose-add-repository#6
12. If we do the "find officer X game", then we should be able to hide items we've seen by marking them as read
13. Bonus feature: add search bar

Current thinking for screens
--------------
Screen 1: List of Forces  - add star wars photos to these?
Screen 2: Specific Force
Screen 3: Senior Officers? - once you identify the person - go back to main screen


Notes/Reminders
---------------
Warning: Singleton pattern is not a recommended practice. Singletons represent global states that are hard to predict, particularly in tests. Objects should define which dependencies they need, instead of describing how to create them.
