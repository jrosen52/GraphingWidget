# GraphingWidget
CS441 second project

For our second project, we were assigned to create an app that involved graphing of some kind. At first I was going to do an expansion of the example app shown, in which different colored shapes could be placed down at different coordinate points. But later in development, I decided to change gears a bit by making the app a game in which a random coordinate location is chosen, and a player must use the a shape to find the correct location. As the shape is moved around, it's color changes from blue to red depending on how close it is to the target. Once reached, the shape will turn green. A spinner is used to select between a circle, square, and triangle (A heart was originally included, but was cut for technical reasons.

Here is documentation for each git commit, and any relative citations:

September 9: Created the inital project
September 13: Added the canvas surface, based upon the android-surface code provided to us
September 18: Added touch features in main activity, again based on android-surface code
September 19: Added a way to show coordinates updating based on touch
September 20: Added code for drawing a triangle (based on https://stackoverflow.com/questions/3501126/how-to-draw-a-filled-triangle-in-android-canvas) and drawing a heart (based on https://stackoverflow.com/questions/7007429/android-how-to-draw-triangle-star-square-heart-on-the-canvas/18440622)
September 21: Added code for the spinner, based on the same source as my previous project (demonuts https://demonuts.com/android-spinner/)
September 22: Added secret random coordinates generation and changing shape color based on location
