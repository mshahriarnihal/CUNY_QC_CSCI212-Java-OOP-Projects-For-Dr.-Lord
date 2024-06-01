* Download and run "WordGame P3.exe" file to directly run and play the game.


The motive of this project is to let the users play a WORD GAME. This is loosely based on a word puzzle called the Spelling Beehive found in the Sunday New York Times magazine. In that game, a player is given a set of seven letters and has to find as many words as possible using some portion, but at least five, of those seven letters. Letters may be used more than once. Each correct word earns one point.
The game I am making for this project is similar to that. But this time, the user won't be bounded to any limit of maximum quantity of letters, meaning, you can guess word with the subject/hint letters which may contain as much letter as you want. But it must contain a minimum of five letters anyway. You must follow the following rules to ace the game:

1. To start playing the game, click File > Open, then select the text file which you want to use as a solution file. The first line of the text file will shown as hint/subject letters in game, the rest of the each lines will be considered as each solution words. If the file contains any invalid word, like contains a word which has capital letter on it, the program will catch an exception, the illegal word will be printed, and that illegal word will NOT be a part of solution list for the game, rest of the words will be counted and player will be able to guess them and earn point(s). 

2. You can not use a letter in your guessing word that is not one of the given hint/subject letters. 

3. Your guess must be at least 5 letters long. 

4. You will get point(s) for guessing only if your guessed word is valid and present in the solutions list.

5. The first letter of the subject letters must be contained in all the correct guessed words. For example: If you see the game is showing hint letters as: CHOREDUKAT, and you guess "Trade," although your guessed word is valid, contains only the subject letters, and contains at least 5 letters, still you won't get any point as the first subject letter in this example is "C" which is not present in your valid word.

6. If your guessed word contains ALL of the subject letters, that is worth 3 points. For all other correctly guessed words, you will get +1 point.

7. If you guess a word which you already guessed before and got point(s), you won't get any point for re-entering that word. That's not fair! 

8. A Word is illegal if it doesn’t contain all lower-case letters. So, if you enter a word with capital letter in any part of the word, you'll get an error message. Try re-enter that word in all lower-case to see if that's a correct guess.

9. You will be notified when you win the game by guessing all the words on the solutions list. Then you will be asked if you would like to play again. By pressing yes, the game will be reset and restarted with the same words' solution file.


This is the Project #3 (4th project) of Dr. Lord's CSCI-212 Java OOP course (Spring'2024) and it is built on top of the Project #1 and Project #2. You can find that project 1 and 2 in this same directory of CSCI-212 projects folder in my GitHub. Project 1 and 2 are similar to this, you can play a word game with them too. But this Project3 has some update and it is a modified and better version of the previous Project2. The updates that I made on this Project3 from Project1 and Project2 are:

1. In this version of game, you have an additional rule to maintain: "The first letter of the subject letters must be contained in all the correct guessed words."

2. In this version of game, you have nice opportunity to get +3 points if you can guess a word containing all the subject letters which was not available in the Project1 version of our WordGame.

3. This Project3 is based on LinkedList data structure. In Project1, I used array index to store and use data. By using linked-list structure in this updated version, the program becomes more efficient as LinkedList has a time complexity of O(n).

4. In project1, most of the part of the project had public access. In this updated version of Word Game, I used "protected access" for the instance variables to increase data safety through encapsulation.

5.* In previous Project 1 and 2, the program had a fixed named text file to be used as a solution list file. But from now, you will have the option to choose any text file to use as solution list and play the game based on that list. You can select "File" and click "Open" to choose any text file from your device. 

6.* For Project3, I have made an executable (.exe) file for the Windows OS users. So, now it is more easy, one click is enough to run the game. You don't need to compile or use any IDE if you want to play the game only. I am providing the .exe file in this same folder of "Project_3_WordGame P3." Find the executable file named as "WordGame P3.exe."

7.* In both Project 1 and 2 version, you could enter a guess word in any case, but from this version, you must have to enter a guess word with all lower-case letters. Even there is a exception catcher for the text file of solution list as well to eradicate words with capital letter(s) from the solution list.

8.* When you guess all the valid words present in the solution list, we will be notified and congratulated. Then you can choose to quit or reset and restart the game with same solution list and let your friend(s)/play-mate(s) play to see how they do with it.  

[* indicates the updates which were not present in both Project1 and Project2] 

I am providing a sample solution list as text file named "P1input.txt" with this project's folder which you can use as a solution list text file to play the game. You can edit the text file or select any other text file as your solution list file, that is totally up to you! The game's maximum possible score will be changed based on the solution list text file you will provide. But the basic rules will remain the same unless you make any change in the java source file which I am providing with this project folder.

As this project contains a decent number of java source files (.java), I am zipping them all in one jar file. To make it easy for you, I am providing the unzipped source files too in this folder. Besides, I am uploading the class files also. But you can just download the .java source files and compile and run with any terminal or your compiler or IDE to run the game. If you want to use the jar file, then download the "Project3.jar" only, then use your IDE to import it and run it in correct manner, or download the "Project3_executable_jar.jar" to avoid the compiling part. "Project3.jar" is not an executable/runnable jar file, but "Project3_executable_jar.jar" is an executable/runnable jar file. And again, if you want to just play the game and you are a Windows OS user, the easiest way is to Download and run "WordGame P3.exe" file. You can find it in this same folder with a brown-orange icon.

Thanks! Happy Coding! "-)
- Mubasshir Al Shahriar (Nihal)