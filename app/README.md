Gregory's Police app
=================================

Todo List
---------------
1. Create App in Compose
2. Extract Strings
3. Migrate common UI to a common UI file
4. Bring in DI
5. Migrate MVVM to MVI
6. Add test coverage
7. ADD police style logo
8. ADD dark mode

Current thinking for screens
--------------
Screen 1: List of Forces  - add star wars photos to these?
Screen 2: Specific Force
Screen 3: Senior Officers?

Notes/Reminders
---------------
Warning: Singleton pattern is not a recommended practice. Singletons represent global states that are hard to predict, particularly in tests. Objects should define which dependencies they need, instead of describing how to create them.

Use Dependency injection over singleton pattern, you will learn how to implement Dependency injection in a later codelab.