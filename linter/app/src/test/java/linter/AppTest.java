package linter;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.PrintStream;
import java.nio.file.Path;
import java.nio.file.Paths;

import static org.junit.jupiter.api.Assertions.assertEquals;

class AppTest {
    private final ByteArrayOutputStream outContent = new ByteArrayOutputStream();
    private final PrintStream originalOut = System.out;

    @BeforeEach
    void setUp() {
        System.setOut(new PrintStream(outContent));
    }

    @Test
    void testLintJavaScriptFile_gatesJs() throws IOException {
        Path gatesJsPath = Paths.get("/Users/chrisfoster/java-fundamentals/linter/app/src/main/resources/gates.js");
        String errors = App.lintJavaScriptFile(gatesJsPath);
        String expectedErrors = "Line 3: Missing semicolon.\n" +
                "Line 11: Missing semicolon.\n" +
                "Line 14: Missing semicolon.\n" +
                "Line 24: Missing semicolon.\n" +
                "Line 27: Missing semicolon.\n" +
                "Line 30: Missing semicolon.\n" +
                "Line 33: Missing semicolon.\n" +
                "Line 36: Missing semicolon.\n" +
                "Line 39: Missing semicolon.\n" +
                "Line 42: Missing semicolon.\n" +
                "Line 45: Missing semicolon.\n" +
                "Line 48: Missing semicolon.\n" +
                "Line 51: Missing semicolon.\n" +
                "Line 54: Missing semicolon.\n";
        System.out.println("Actual errors:\n" + errors);
        assertEquals(expectedErrors, errors);
    }
}