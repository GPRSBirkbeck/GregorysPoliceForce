# GregorysPoliceForce
=================================

Todo List
---------------
2. Extract Strings
3. Migrate common UI to a common UI file
4. tidy up the code: big refactor - ensure you focus on DI
5. reoganise tho packages
6. Go over Todos
7. Migrate MVVM to MVI
8. ADD police style logo
9. ADD dark mode
10. Unit  & UI tests 
11. test Hilt
12. WorkManager
13. Is this still needed? DI testing: https://developer.android.com/codelabs/basic-android-kotlin-compose-add-repository?continue=https%3A%2F%2Fdeveloper.android.com%2Fcourses%2Fpathways%2Fandroid-basics-compose-unit-5-pathway-2%23codelab-https%3A%2F%2Fdeveloper.android.com%2Fcodelabs%2Fbasic-android-kotlin-compose-add-repository#6
14. If we do the "find officer X game", then we should be able to hide items we've seen by marking them as read
15. Bonus feature: add search bar

Current thinking for screens
--------------
Screen 1: List of Forces  - add star wars photos to these?
Screen 2: Specific Force
Screen 3: Senior Officers? - once you identify the person - go back to main screen


Notes/Reminders
---------------
Warning: Singleton pattern is not a recommended practice. Singletons represent global states that are hard to predict, particularly in tests. Objects should define which dependencies they need, instead of describing how to create them.
