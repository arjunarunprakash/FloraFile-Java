# My Personal Project: UBCFloraFile

## A tool to catalog your botantical finds 

**What does my application do?**

I want to create a desktop application where a user can 
- *enter* and *keep* a *collection* of botanical finds. 
- specify a *set* of field where they enter in their entry: common name, species name, date, location (limited to UBC Vancouver grounds).
- be able to delete/edit entries. 
- Data is securely saved even when program is closed. 

**Who is this application for?**

This simple application is for anyone that enjoys leisurly walks around the UBC campus, wants to catalog what plant they collected, and write down their thoughts when they see cool flora.

**Why is this Project of Interest to you?**

I want to learn how to create file and registar systems, which has countless applications. I beleive its a unique idea on a subject I have always been passionate about as a LFS student. Having both practical application and being something I will enjoy trying to create.

## User Stories:
- As a user, I want to be able to *add* plant life to my collection and *specify* the common name, species name, location(via dropdown menu), and observations. 
- As a user, I want to be able to *view* a list of the common names of the plant life in my collection. 
- As a user, I want to be able to *select* a plant in my collection and *view* the plant in detail. 
- As a user, I want to be able to *delete* a plant entry from my collection
- As a user, I want to be able to *view* the total number of entries in my collection
- As a user, I want to be able to *edit* entries in my collection  
- As a user, when I select the exit option from the user menu, I want to be reminded to save my FloraFolder to file and have the option to do so or not.
- As a user, when I start the application, I want to be given the option to load my FloraFolder from file.

# Instructions for End User

- You can view the panel that displays the plants that have already been added to the Folder by scrolling down the menu on the right side of the dashboard
- You can generate the first required action related to the user story "I want to be able to *add* plant life to my collection and *specify* the common name, species name, location (via dropdown menu), date, and observations." by clicking on the "New Entry" Button on the left handside of the dashboard.
- You can generate the second required action related to the user story "As a user, I want to be able to *delete* a plant entry from my collection" by selecting the plant you want to delete from the menu on the right hand side of the dashboard. Then in the popup menu, select delete. Your list on the right had side will automatically update, with adjusted folder items.
- You can locate my visual component by running the application and looking out for the splash screen
- You can save the state of my application by navigating to the top left of the application, then clicking "file" on the menubar. From the dropdown, select "save". Additionally, you can also click on "save and exit" which will prompt you to save the application. Finally, you have another oppurtunity to save the application when you try to close the window, in which case you will be given the option to save the application
- You can reload the state of my application by clicking navigating to the top left of the application, then clicking "file" on the menubar. From the dropdown, select "load".

# Phase 4: Task 2
Fri Nov 28 12:32:22 PST 2025
Red Rose has been added to Folder


Fri Nov 28 12:32:22 PST 2025
Blackberry has been added to Folder


Fri Nov 28 12:33:41 PST 2025
Species name updated too: Lavandula Denta


Fri Nov 28 12:33:41 PST 2025
Location updated too: West Mall


Fri Nov 28 12:33:41 PST 2025
Observations updated too: Smells nice


Fri Nov 28 12:33:41 PST 2025
French Lavendar has been added to Folder


Fri Nov 28 12:35:07 PST 2025
Common name updated too: French Lavendar


Fri Nov 28 12:35:07 PST 2025
Species name updated too: Lavandula Denta


Fri Nov 28 12:35:07 PST 2025
Location updated too: University Blvd


Fri Nov 28 12:35:07 PST 2025
Observations updated too: Smells nice and is a nice pastel purple in colour


Fri Nov 28 12:35:21 PST 2025
Blackberry has been removed from Folder


Fri Nov 28 12:37:26 PST 2025
Species name updated too: Rubus armeniacus


Fri Nov 28 12:37:26 PST 2025
Location updated too: East Mall


Fri Nov 28 12:37:26 PST 2025
Observations updated too: Sharp thorny branches. Around 5 Meters tall


Fri Nov 28 12:37:26 PST 2025
Himalayan Blackberry has been added to Folder

# Phase 4: Task 3

If I had more time, I would refactor the design to reduce the high coupling caused by the UI classes' heavy dependence on my concrete Model classes. Currently, my design relies heavily on dependencies where MainFrame and DashboardPanel directly instantiate or access the internal methods of Folder and Plant. For example, the DashboardPanel reads text fields and directly constructs new Plant objects, and MainFrame instantiates specific JsonWriter objects within its logic. I read that my use of dependencies (objects that are local variables and/or parameters) keeps the memory footprint low compared to permanent associations, but it's obvious that my UI is tightly coupled to the specific implementation of the Model because of this. If I were to change the constructor of Plant or the structure of Folder, I would have to hunt down and fix code inside MainFrame, DashboardPanel, and UbcFloraFileApp all over again to work with their own specific implementation.

To improve this, I would introduce a new abstract class that can control and separate the UI and model class better. Instead of the UI classes depending directly on the Model to create or save data, the UI would simply hold an association to the Controller. The UI would pass user inputs to the Controller, and the Controller would handle the logic of instantiating Plant objects or calling the JsonWriter. This refactoring would convert the scattered dependencies into a single, clean association, making the code more modular, easier to test, and significantly easier to maintain if the Model logic changes in the future.
