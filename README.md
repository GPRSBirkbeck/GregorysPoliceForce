# GregorysPoliceForce
=================================

Todo List
---------------
1. tidy up the code: big refactor - ensure you focus on DI
2. reorganise the packages
3. Go over Todos
4. Migrate MVVM to MVI
5. ADD police style logo
6. ADD dark mode
7. Unit  & UI tests 
8. test Hilt
9. WorkManager
10. Remove unneeded imports
11. Fix indenting in each file (Command+Option+L in each!)
12. Is this still needed? DI testing: https://developer.android.com/codelabs/basic-android-kotlin-compose-add-repository?continue=https%3A%2F%2Fdeveloper.android.com%2Fcourses%2Fpathways%2Fandroid-basics-compose-unit-5-pathway-2%23codelab-https%3A%2F%2Fdeveloper.android.com%2Fcodelabs%2Fbasic-android-kotlin-compose-add-repository#6
13. If we do the "find officer X game", then we should be able to hide items we've seen by marking them as read
14. Bonus feature: add search bar

Current thinking for screens
--------------
Screen 1: List of Forces  - add star wars photos to these?
Screen 2: Specific Force
Screen 3: Senior Officers? - once you identify the person - go back to main screen


Notes/Reminders
---------------
Warning: Singleton pattern is not a recommended practice. Singletons represent global states that are hard to predict, particularly in tests. Objects should define which dependencies they need, instead of describing how to create them.
