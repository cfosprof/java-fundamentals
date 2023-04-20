package linter;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;

public class App {
    public String getGreeting() {
        return "Hello world!";
    }

    public static void main(String[] args) throws IOException {
        Path gatesJsPath = Paths.get("/Users/chrisfoster/java-fundamentals/linter/app/src/main/resources/gates.js");
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

        if (line.contains("if") || line.contains("else")) {
            return false;
        }

        return !line.endsWith(";");
    }
}