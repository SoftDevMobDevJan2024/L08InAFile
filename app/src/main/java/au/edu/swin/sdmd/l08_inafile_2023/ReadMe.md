L08InAFile - Reading and writing data
==========================================

This is a small app that has the following functionalities. Some are extended from the original lecture source code.

* reads an HTML file from /res/raw and shows the text on the screen. File reading is moved to a separate class.
* contains a converter that stores numbers entered and their conversions to a history file;
* stores the last number converted to SharedPreferences;
* shows the contents of that file in a list. 

The app makes use of the Bottom Navigation template -- this means fragments are used however these should not detract from the file reading and writing processes.

# To do
1. When a new conversion has been performed, to automatically update HistoryFragment to show the entry