Program: JavaScript Linter

Description: This program reads a JavaScript file and generates an error message whenever it finds a line that doesn't end in a semi-colon. The other one does the data stuff.

Criteria:

1. Analyzing Weather Data
    - Input: 2D array of integers representing daily average temperatures
    - Output: String containing min, max temperatures and temperatures not seen during the month
    - Method: analyzeWeatherData
    - Test: Write testing code for this method.

2. Tallying Election
    - Input: List of Strings representing votes
    - Output: String showing the candidate with the most votes
    - Method: tally
    - Test: Write testing code for this method.

3. JavaScript Linter
    - Input: Path to a JavaScript file
    - Output: String containing error messages for lines missing a semi-colon
    - Method: lintJavaScriptFile
    - Test: Write unit tests for the linter
    - Exceptions:
        - Don't show an error if the line is empty.
        - Don't show an error if the line ends with an opening curly brace {
        - Don't show an error if the line ends with a closing curly brace }
        - Don't show an error if the line contains if or else