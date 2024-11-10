Team Members: \
Bonny C | xStylistic \
Saswata Mohanta | SazzGuy \
Ongphat Piyabenjarad | bem-boi \
Ji Qi | jerryq0101 \
Zeke Weng | ZekeWeng

# TODOs for each story
- Cut down the stories into the more independent format on the slides (IN YOUR DOMAIN)
"As a user, I want to be able to discover, RSVP to, and manage events in
my organization so that I can easily participate in relevant social and
professional gatherings. (Thanks ChatGPT!)" into "As a user, I want to browse a list of upcoming events in my organization so
that I can find ones that interest me."
- Convert each user story into a list of use cases that allow this to happen (Sequence of actions)
- Each use case has a set of interactions with the system 


## Story 1:
As a student user, I want to be able to be given a random review question that I inputted at the beginning of the app session, submit the question and check if I was right or wrong.

### Use Case 1: Give user a question
Interactions 1: 
* User clicks a button (Start / Next Question)
* (A question appears, and a text field under line appears)
### User Case 2: Allow User to enter a text field answer and submit the question
Interactions 2:
* User types out their answer to the generated review question in the text field
* User clicks "Next" 
### User Case 3: Check if the user's answer is right or wrong and give an output on the application
Interactions 3:
* After user clicks "Next", a dialogue appears below the button, indicating whether the user is right, or wrong and the correct answer

## Story 2:
Ben has a chemistry exam tomorrow but hasn’t started studying for it. Ben is not motivated to study and wants to spend time playing games. 
Thankfully for Ben, this flashcard game will keep Ben motivated and entertained to study for his chemistry exam. The fun facts about these 
animals will keep Ben entertained while studying for his chemistry exam.

So as a student user, I want to be able to keep track of the animals and learn about the animals that I've gathered over the period I've been 
studying for my exam so that it would keep me entertained and encourage me to keep studying. 

### Use Case 1: Gain an animal when correctly answers the question
Interactions 1:
* User answers the question based on the question type (Textfield or Button)
* Use the interactor to check if the question is correct.
* The program randomly creates an instance of the abstract Animal class and adds the animal to the farm.
### Use Case 2: Allow users to view the fun fact about the animal they just obtained
Interaction 2:
* User clicks the 'View Fact' Button on the right side of the GUI
* JLabel appears which shows the fact-specific to the animal through the use of API
### Use Case 3: Removes an animal when incorrectly answers the question
Interactions 3:
* User answers the question based on the question type (Textfield or Button)
* Use the interactor to check if the question is incorrect.
* The program randomly chooses an instance of the abstract Animal class in the farm and removes it.
  

## Story 3:
John is not in the mood for serious studying as he is tired and his biology exam is 2 weeks away so he wants to 
casually revise his flashcards. He just wants to practice and casually test his knowledge. So he will open the Study 
Tool on EASY mode which is without a timer so he can answer without too much pressure and enjoy looking at his animals 
and see them die less. After using this tool, John feels less stressed from studying and also feels his time was 
productive.

## Story 4:
Jeremy struggles under time pressure, leading to suboptimal results in his exams. Hence, as a student user, the ability to have a simulated 
clock or some tool to keep him accountable on his time is critical. 

### Use Case 1: Timed Questions Answering
Interactions 1:
* While the user is answering questions (Story #1), he has a timer that paces him
* There is a ticking clock on every single question
* There is also an overall clock tracking his total time spent
### Use Case 2: Questions-Time post study analysis
Interactions 2:
* After the user is done with a study session, provide analytical statistics on his studying
* The program stores the amount of time, correctness of the study program
* After the study session a JFrame views allows for analysis on questions


