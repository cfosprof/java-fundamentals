# Quotes

## Description

This is a simple app that displays random quotes from the quotable api or a local quotes file. When retrieving quote from the internet this app will save any quotes not present in the database to its own database so it can be called locally in the future.

## Features

* Get a random quote from a local list of quotes stored in a JSON file.
* Get a random quote from the internet using the Quotable API.
* Display the fetched quote and its author.
* The app includes unit tests using JUnit.

## How to use

To install dependencies, run the following command:
```
./gradlew install
```

Use the following command to run the app with local quotes:
```
./gradlew run
```

Use the following command to run the app with quotes from quotable api

```
./gradlew run --args='internet'
```



Use the following command to run the tests:
```
./gradlew test
```
