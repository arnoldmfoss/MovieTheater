# Download src code
# build file:
* javac Main.java
* testing:
* - add Junit jar file into class path
* - javac -cp junit-4.12.jar;. TestTheaterSeats.java
# enter file path:
* any .txt files
# test:
* use a direct path for test.txt or test2.txt
* use junit tests: 
*  - java -cp junit-4.12.jar;hamcrest-core-1.3.jar;. org.junit.runner.JUnitCore TestTheaterSeats
*  - the junit test wanted, ie create...

assumptions:
files separated by one space
theater chooses maximum safety over profit
people only want to watch the movie if they can sit together
people prefer the front to the back
