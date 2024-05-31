This project lets the user play a WORD GAME. This is loosely based on a word puzzle called the Spelling Beehive found in the Sunday New York Times magazine. In that game, a player is given a set of seven letters and has to find as many words as possible using some portion, but at least five, of those seven letters. Letters may be used more than once. Each correct word earns one point.
The game I am making for this project is similar to that. But this time, the user won't be bounded to any limit of maximum quantity of letters, meaning, you can guess word with the subject/hint letters which may contain as much letter as you want. But it must contain a minimum of five letters anyway. You must follow the following rules to ace the game:

1. You can not use a letter in your guessing word that is not one of the given hint/subject letters. 

2. Your guess must be at least 5 letters long. 

3. You will get point(s) for guessing only if your guessed word is valid and present in the solutions list.

4. The first letter of the subject letters must be contained in all the correct guessed words. For example: If you see the game is showing hint letters as: CHOREDUKAT, and you guess "Trade," although your guessed word is valid, contains only the subject letters, and contains at least 5 letters, still you won't get any point as the first subject letter in this example is "C" which is not present in your valid word.

5. If your guessed word contains ALL of the subject letters, that is worth 3 points. For all other correctly guessed words, you will get +1 point.

This is the Project #2 of Dr. Lord's CSCI-212 Java OOP course (Spring'2024) and it is built on top of the Project #1. You can find that project one in this same directory of CSCI-212 projects folder in my GitHub. Project 1 is similar to this, you can play a word game with that too. But this Project2 has some update and it is a modified and better version of the previous Project1. The updates that I made on this Project2 from Project1 are:

1. In this version of game, you have an additional rule to maintain: "The first letter of the subject letters must be contained in all the correct guessed words."

2. In this version of game, you have nice opportunity to get +3 points if you can guess a word containing all the subject letters which was not available in the Project1 version of our WordGame.

3. This Project2 is based on LinkedList data structure. In Project1, I used array index to store and use data. By using linked-list structure in this updated version, the program becomes more efficient as LinkedList has a time complexity of O(n).

4. In project1, most of the part of the project had public access. In this updated version of Word Game, I used "protected access" for the instance variables to increase data safety through encapsulation.

I am providing a sample solution list as text file named "P1input.txt" with this project. You can edit the text file and make your own solution list and subject letters. The game will be changed and work based on the solution list text file you will provide. But the basic rules will remain the same unless you make any change in the java source file which I am providing with this project folder.

As this project contains a decent number of java source files (.java) and one input file also (solution list text file), I am zipping them all in one jar file. To make it easy for you, I am providing the unzipped source files too in this folder. Besides, I am uploading the class files also. But you can just download the .java source files and compile and run with any terminal or your compiler or IDE to run the game. If you want to use the jar fil, then download the "Project2.jar" only, then use your IDE to import it and run it in correct manner. Be aware that this jar file is not an executable/runnable jar file. So, you will need to unarchive first in order to compile/run properly.

Thanks! Happy Coding! "-)
- Mubasshir Al Shahriar (Nihal)