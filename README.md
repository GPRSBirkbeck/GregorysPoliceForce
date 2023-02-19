# GregorysPoliceForce
=================================

Todo List
---------------
1. make method links clickable
2. Format "description" - see Avon & Somerset
3. Extract Strings
4. Migrate common UI to a common UI file
5. tidy up the code: big refactor - ensure you focus on DI
6. reoganise tho packages
7. Go over Todos
8. Migrate MVVM to MVI
9. ADD police style logo
10. ADD dark mode
11. Unit  & UI tests 
12. test Hilt
13. WorkManager
14. Is this still needed? DI testing: https://developer.android.com/codelabs/basic-android-kotlin-compose-add-repository?continue=https%3A%2F%2Fdeveloper.android.com%2Fcourses%2Fpathways%2Fandroid-basics-compose-unit-5-pathway-2%23codelab-https%3A%2F%2Fdeveloper.android.com%2Fcodelabs%2Fbasic-android-kotlin-compose-add-repository#6
15. If we do the "find officer X game", then we should be able to hide items we've seen by marking them as read
16. Bonus feature: add search bar

Current thinking for screens
--------------
Screen 1: List of Forces  - add star wars photos to these?
Screen 2: Specific Force
Screen 3: Senior Officers? - once you identify the person - go back to main screen


Notes/Reminders
---------------
Warning: Singleton pattern is not a recommended practice. Singletons represent global states that are hard to predict, particularly in tests. Objects should define which dependencies they need, instead of describing how to create them.
