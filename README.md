# GregorysPoliceForce
=================================

Todo List
---------------
1. Create App in Compose
3. Bring in DI
4. if there's no value for an engagement method, hide it
5. make method links clickable
6. Extract Strings
7. WorkManager
8. Migrate common UI to a common UI file
9. Migrate MVVM to MVI
10. Add test coverage
11. ADD police style logo
12. ADD dark mode

Current thinking for screens
--------------
Screen 1: List of Forces  - add star wars photos to these?
Screen 2: Specific Force
Screen 3: Senior Officers?

Notes/Reminders
---------------
Warning: Singleton pattern is not a recommended practice. Singletons represent global states that are hard to predict, particularly in tests. Objects should define which dependencies they need, instead of describing how to create them.

Use Dependency injection over singleton pattern, you will learn how to implement Dependency injection in a later codelab.
