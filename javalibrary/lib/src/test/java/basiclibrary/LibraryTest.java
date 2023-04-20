package basiclibrary;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class LibraryTest {
    @Test
    public void testRoll() {
        ArrayList<Integer> rolls = Library.roll(4);
        assertEquals(4, rolls.size());
        for (int roll : rolls) {
            assertTrue(roll >= 1 && roll <= 6);
        }
    }

    @Test
    public void testContainsDuplicates() {
        assertTrue(Library.containsDuplicates(new int[] { 1, 2, 3, 4, 5, 6, 1 }));
        assertFalse(Library.containsDuplicates(new int[] { 1, 2, 3, 4, 5, 6, 7 }));
    }

    @Test
    public void testCalculateAverage() {
        assertEquals(4.0, Library.calculateAverage(new int[] { 1, 2, 3, 4, 5, 6, 7 }), 0.0001);
        assertEquals(6.0, Library.calculateAverage(new int[] { 6, 6, 6, 6, 6, 6 }), 0.0001);
    }

    @Test
    public void testGetLowestAverageArray() {
        int[][] arr = {
                { 66, 64, 58, 65, 71, 57, 60 },
                { 57, 65, 65, 70, 72, 65, 51 },
                { 55, 54, 60, 53, 59, 57, 61 },
                { 65, 56, 55, 52, 55, 62, 57 }
        };
        assertArrayEquals(new int[] { 55, 54, 60, 53, 59, 57, 61 }, Library.getLowestAverageArray(arr));
    }

    @Test
    public void testAnalyzeWeatherData() {
        int[][] weatherData = {
                { 66, 64, 58, 65, 71, 57, 60 },
                { 57, 65, 65, 70, 72, 65, 51 },
                { 55, 54, 60, 53, 59, 57, 61 },
                { 65, 56, 55, 52, 55, 62, 57 }
        };
        String expectedOutput = "High: 72\n" +
                "Low: 51\n" +
                "Never saw temperature: 63\n" +
                "Never saw temperature: 67\n" +
                "Never saw temperature: 68\n" +
                "Never saw temperature: 69\n";
        assertEquals(expectedOutput, Library.analyzeWeatherData(weatherData));
    }

    @Test
    public void testTally() {
        List<String> votes = new ArrayList<>(Arrays.asList("Bush", "Bush", "Bush", "Shrub", "Hedge",
                "Shrub", "Bush", "Hedge", "Bush"));
        assertEquals("Bush", Library.tally(votes));
    }
}