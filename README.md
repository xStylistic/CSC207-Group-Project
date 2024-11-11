Team Members: \
Bonny Chen | xStylistic \
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


## Main Story,
As a student user, I want ot be able to load a batch of questions and then start reviewing those questions in a more intuitive and motivated way.
Interactions 1: 
* User clicks a choose file button 
* (The user can look for his associated question set)

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
As a student studying throughout the term, I want different levels of intensities of revising content depending on how 
urgent and important the learning is. This will allow me to stay engaged in my revision and have a more relaxed time, 
or a more vigorous session, as required.

### Use Case 1: Selecting Revision Intensity Level
Interactions:
* User opens the app and is presented with mode options (Easy, Medium, Hard) 
* User selects the mode they want by clicking on the corresponding button, depending on the intensity of revision 
  required. 

### Use Case 2: Adjusting Parameters Based on Selected Mode
Interactions:
* If 'Easy' or 'Medium' was chosen, user is prompted to enter the amount of questions they want to solve.
* User clicks 'Start Session' to begin a session which opens the questions interface with the parameters adjusted based 
  on the mode (i.e. How much time is given to answer each question, the severity of the punishment/rewards for answers 
  and the quantity of questions)

  * If 'Easy' is chosen, in the session while answering each question (Story 1), no timer is set, punishment amount is low
  * If 'Medium' is chosen, in the session, for each question, timer is set (Story 4) to a longer time, punishment and
    reward amount is medium
  * If 'Hard' is chosen, in the session, for each question, timer is set (Story 4) to a short time, punishment amount is 
    high (and reward is high) and all questions from the set are asked

* The user then interacts with the use cases from story 1 or story 4 based on the selections

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

## Story 5:
Polly is trying to get 100 on her psychology exam. She needs to know every term and concept very well. In order for her to achieve 100 on the exam, she needs to be able to answer all the flashcards word for word under a certain time limit to simulate a testing environment. So as a student user, she needs to be able to check if she truly understands the material fully. 

### Use Case 1: Answer Evaluation and Feedback
Interactions 1:
* System evaluates the user's submitted answer.
* System displays feedback below the submission button, indicating whether the answer was correct or incorrect.
* If incorrect, the system provides the correct answer for the user to review
### Use Case 2: Timed Response to Questions
Interactions 2:
* User initiates the question session by clicking a "Start Timer" button.
* A countdown timer will be visible on the screen.
* User enters their answer within the time limit and clicks "Submit".
* Program provides immediate feedback and resets the timer for the next question.
### Use Case 3: End-of-Game Feedback
Interactions 3:
* User completes the final question and clicks "Finish".
* An overall performance summary will be displayed, including the percentage of correct answers and total time taken.
* The program will provide options for the user to repeat the study set or to upload a new one.


