# GregorysPoliceForce

### Direct note
----------
Hi Yogen,

Thank you for taking the time to read over my code - I'm looking forward to hearing your thoughts on how I could have improved it.

## App Description
This app consumes data from https://data.police.uk/ and displays a clickable list of police forces.
When a police force is clicked the app displays a more detailed view of the selected police force.

## App Architecture
This app aims to follow Clean Architecture and MVI. It uses Hilt for dependency injection, and Jetpack Compose.

## App Structure
The app's code is split into three directories:

1. data:
Within model we have data classes for our police forces.
We also have our classes for networking (retrofit calls and our repository).

2. di:
Inside di we have our required classes for hilt - our application container and a hilt module.

3. ui:
Inside ui we have common components, our compose screens, and essential View and Intent classes (ViewModel - which manages state and receives intents from the UI - state and intent classes).

## Testing
Unit tests test the repository & ViewModel and instrumentation tests test navigation and the content of the screens.

## Next steps
In future improvements this app could be gamified, like displaying [senior officers](https://data.police.uk/docs/method/senior-officers/) in another screen - and adding a "corrupt officer" into the list with a dodgy cv. 
The user would then be asked to identify this officer by studying each officer. There would be a button on each officers page to mark them as corrupt, and the user would then be told whethe or not they were correct. After 10 wrong guesses they would be told they failed, and be offered the chance to start again.
