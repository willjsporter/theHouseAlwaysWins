#The House Always Wins

###Project Summary
This project was to create a method given the following signature:
```$xslt
public List<Integer> getHighRollers(List<PlayerSession>
playerSessions)
```
which processes a list of player sessions for an online gaming platform and lets the casino know who are the 'high rollers' - the people who the casino are making the most profit from.

###How to get me

- Clone the repository from github by running `git clone git@github.com:willjsporter/theHouseAlwaysWins.git`
- The project requires Java 11 to run - this can be installed from: https://jdk.java.net/archive/ and selecting the relevant operating system under the 11.0.2 heading.
- Once installed, set `export JAVA_HOME=/path/to/java11/folder/` to have Java 11 set as JAVA_HOME for the current session.
- Maven is required to manage dependencies. To install maven, go to https://maven.apache.org/download.cgi

###How to run my tests
The main method of the project is currently empty so there isn't anything to run as such although a user could play around with the function in the main method.

However, to run the tests which illustrate the behaviour this can be done by running 
```
mvn clean install
```
which will clear any compiled files, get all the external dependencies, build the project and then run the tests.

###Design decisions

As a fan of Test Driven Development I was keen to test drive the project. However, after an initial evaluation of the problem, I concluded that the required method `Casino.getHighRollers` was probably too complicated to effectively test drive by writing a single test for the method up front and still be driven by small incremental requirements.

As such, I decided that I would build the method up step by step by writing tests for the helper methods.

Ideally a unit test should the functionality of private methods by their implementation but my approach was to initially have all my helper methods as public methods so that they could be test driven. I used this approach to build up the getHighRollers method bit by bit, but then when I had a passing test for the key getHighRollers method, I made all the helper methods private and removed all the tests that had been written for them. 