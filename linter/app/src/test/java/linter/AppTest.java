package linter;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.PrintStream;
import java.nio.file.Path;
import java.nio.file.Paths;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class AppTest {
    private final ByteArrayOutputStream outContent = new ByteArrayOutputStream();
    private final PrintStream originalOut = System.out;

    @BeforeEach
    void setUp() {
        System.setOut(new PrintStream(outContent));
    }

    @Test
    void testLintJavaScriptFile_gatesJs() throws IOException {
        Path gatesJsPath = Paths.get("src/main/resources/gates.js");
        String errors = App.lintJavaScriptFile(gatesJsPath);
        String expectedErrors = """
        Line 3: Missing semicolon.
        Line 5: Missing semicolon.
        Line 11: Missing semicolon.
        Line 13: Missing semicolon.
        Line 15: Missing semicolon.
        Line 26: Missing semicolon.
        Line 28: Missing semicolon.
        Line 32: Missing semicolon.
        Line 36: Missing semicolon.
        Line 40: Missing semicolon.
        Line 41: Missing semicolon.
        Line 50: Missing semicolon.
        Line 51: Missing semicolon.
        Line 59: Missing semicolon.
        Line 65: Missing semicolon.
        Line 66: Missing semicolon.
        Line 67: Missing semicolon.
        Line 68: Missing semicolon.
        Line 69: Missing semicolon.
        Line 71: Missing semicolon.
        Line 72: Missing semicolon.
        Line 73: Missing semicolon.
        Line 74: Missing semicolon.
        Line 75: Missing semicolon.
        Line 77: Missing semicolon.
        Line 78: Missing semicolon.
        Line 79: Missing semicolon.
        Line 80: Missing semicolon.
        Line 81: Missing semicolon.
        Line 83: Missing semicolon.
        Line 84: Missing semicolon.
        Line 85: Missing semicolon.
        Line 86: Missing semicolon.
        Line 87: Missing semicolon.
        Line 89: Missing semicolon.
        Line 90: Missing semicolon.
        Line 91: Missing semicolon.
        Line 92: Missing semicolon.
        Line 93: Missing semicolon.
        Line 94: Missing semicolon.
        Line 95: Missing semicolon.
        Line 96: Missing semicolon.
        """;

        System.out.println("Expected errors:\n" + expectedErrors);
        System.out.println("Actual errors:\n" + errors);

        assertEquals(expectedErrors, errors);
    }
}