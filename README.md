# OASIS Android Task 5 - Stopwatch App

## Objective
Build a functional stopwatch app with start, stop/pause, and reset controls that accurately tracks elapsed time.

## Tools Used
- Android Studio
- Java
- XML
- Handler & Runnable

## Features
- Large time display in HH:MM:SS format
- Start button: begins timer from 0 or paused state
- Stop/Pause button: freezes timer at current elapsed time
- Reset button: stops and resets display to 00:00:00
- Buttons change state (Start greyed out when running)
- Timer handles onPause/onResume lifecycle correctly

## Steps Performed
1. Created new Android Studio project with Empty Views Activity (Java)
2. Designed UI with LinearLayout — large monospace time display + 3 circular buttons
3. Implemented timer logic using Handler and Runnable in MainActivity.java
4. Added lifecycle handling (onPause/onResume) so timer survives navigation
5. Tested on Android emulator (Pixel 6, API 34)

## Outcome
A fully working stopwatch with accurate time tracking, proper button state management, and no crashes.

## Internship
Oasis Infobyte - Android Application Development Internship
