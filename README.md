Gesture Tutorial
=========

GestureTutorial is an Android library created for Android API number 8 and higher, to show users of your app the gesture you support.

It's easy to implement in XML or code.

XML
----
````xml
    <com.gesturetutorial.awesomeness.TutorialView 
        android:id="@+id/tutorial"
        android:layout_width="wrap_content"
        android:layout_height="wrap_content" />
````

````java
    TutorialView myTutorialView = (TutorialView) this.findViewById(R.id.tutorial);
    myTutorialView.show();
    //Do some stuff.
    myTutorialView.hide();    
````


Code
----
````java
    TutorialView myTutorialView = tv = TutorialView.create(this, TutorialView.LeftToRight, 0, v);
    myTutorialView.show();
    //Do some stuff.
    myTutorialView.hide();    
````

or

````java
    TutorialView myTutorialView = tv = TutorialView.create(this, TutorialView.LeftToRight, 0, v).show();
    //Do some stuff.
    myTutorialView.hide();    
````



Sample Project
-----------

To be made.

Installation
--------------
Download the .zip, in Eclipse, right click, import existing code, select unziped content.

Right click project to use with, properties, Android, Add..., Select GestureTutorial


Bugs
----
Please submit an issue or contact me.  
warner.73 [a sign] wright.edu

License
----
    Copyright 2013 Justin Warner
    
    Licensed under the Apache License, Version 2.0 (the "License");
    you may not use this file except in compliance with the License.
    You may obtain a copy of the License at

        http://www.apache.org/licenses/LICENSE-2.0

    Unless required by applicable law or agreed to in writing, software
    distributed under the License is distributed on an "AS IS" BASIS,
    WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
    See the License for the specific language governing permissions and
    limitations under the License.


    