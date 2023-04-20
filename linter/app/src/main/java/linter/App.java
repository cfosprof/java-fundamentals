package linter;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.regex.Pattern;
import java.util.regex.Matcher;
import java.util.regex.Pattern;


public class App {
    public String getGreeting() {
        return "Hello world!";
    }

    public static void main(String[] args) throws IOException {
        Path gatesJsPath = Paths.get("src/main/resources/gates.js");
        String errors = lintJavaScriptFile(gatesJsPath);
        System.out.println(errors);
    }

    public static String lintJavaScriptFile(Path filePath) throws IOException {
        StringBuilder errors = new StringBuilder();

        try (BufferedReader reader = new BufferedReader(new FileReader(filePath.toFile()))) {
            String line;
            int lineNumber = 0;

            while ((line = reader.readLine()) != null) {
                lineNumber++;
                if (isLineMissingSemicolon(line)) {
                    errors.append("Line ").append(lineNumber).append(": Missing semicolon.\n");
                }
            }
        }

        return errors.toString();
    }


    public static boolean isLineMissingSemicolon(String line) {
        line = line.trim();

        if (line.isEmpty()) {
            return false;
        }

        if (line.endsWith("{") || line.endsWith("}")) {
            return false;
        }

        Pattern keywordPattern = Pattern.compile("\\b(if|else)\\b");
        if (keywordPattern.matcher(line).find()) {
            return false;
        }

        return !line.endsWith(";");
    }
}