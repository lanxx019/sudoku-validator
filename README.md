# Sudoku Grid Validator
A simple Sudoku board grid validator. A grid is a `3 x 3` area that contains numbers. It is considered valid iff:

  1. It contains number 1 to 9.
  2. Each number can only appear once.
  
# Requirement
* This project use [Gradle](http://gradle.org/) as build tool. You need to install gradle locally to run it.
* JDK 7+. Manually typing generic type is a waste of time and life.

# Eclipse Integration
The Gradle build file included support for eclipse plugin already. To generate a eclipse project, run:

```
$ ./gradlew eclipse
```

# Run the Project
* To run the tests:

```
$ ./gradlew test
```

* To run the main class against a simple XML file:

```
$ ./gradlew run -Pfile=SOME_XML_FIEL.xml
```


