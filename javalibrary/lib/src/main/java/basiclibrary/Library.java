package basiclibrary;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Random;

public class Library {

    // Rolls a six-sided die n times and returns an ArrayList of the roll results
    public static ArrayList<Integer> roll(int n) {
        ArrayList<Integer> rolls = new ArrayList<>();
        Random rand = new Random();
        for (int i = 0; i < n; i++) {
            rolls.add(rand.nextInt(6) + 1);
        }
        return rolls;
    }

    // Checks if the input array has duplicate elements
    public static boolean containsDuplicates(int[] arr) {
        for (int i = 0; i < arr.length; i++) {
            for (int j = i + 1; j < arr.length; j++) {
                if (arr[i] == arr[j]) {
                    return true;
                }
            }
        }
        return false;
    }

    // Calculates and returns the average of the input array
    public static double calculateAverage(int[] arr) {
        int sum = 0;
        for (int i = 0; i < arr.length; i++) {
            sum = sum + arr[i];
        }
        return (double) sum / arr.length;
    }

    // Returns the sub-array with the lowest average from a two-dimensional array
    public static int[] getLowestAverageArray(int[][] arr) {
        double minAvg = Double.MAX_VALUE;
        int minIndex = 0;
        for (int i = 0; i < arr.length; i++) {
            double avg = calculateAverage(arr[i]);
            if (avg < minAvg) {
                minAvg = avg;
                minIndex = i;
            }
        }
        return arr[minIndex];
    }

    // Analyzes weather data and returns a string with information about the highest and lowest temperatures and any missing temperatures
    public static String analyzeWeatherData(int[][] weatherData) {
        int min = Integer.MAX_VALUE;
        int max = Integer.MIN_VALUE;
        HashSet<Integer> uniqueTemps = new HashSet<>();

        for (int[] weeklyData : weatherData) {
            for (int temp : weeklyData) {
                min = Math.min(min, temp);
                max = Math.max(max, temp);
                uniqueTemps.add(temp);
            }
        }

        String result = "High: " + max + "\n" + "Low: " + min + "\n";

        for (int i = min; i <= max; i++) {
            if (!uniqueTemps.contains(i)) {
                result += "Never saw temperature: " + i + "\n";
            }
        }

        return result;
    }

    // Tallies the votes in a list and returns the candidate with the most votes
    public static String tally(List<String> votes) {
        List<String> candidates = new ArrayList<>();
        List<Integer> voteCounts = new ArrayList<>();

        for (String vote : votes) {
            int index = candidates.indexOf(vote);
            if (index == -1) {
                candidates.add(vote);
                voteCounts.add(1);
            } else {
                int updatedVoteCount = voteCounts.get(index) + 1;
                voteCounts.set(index, updatedVoteCount);
            }
        }

        String winner = null;
        int maxVotes = 0;

        for (int i = 0; i < candidates.size(); i++) {
            if (voteCounts.get(i) > maxVotes) {
                maxVotes = voteCounts.get(i);
                winner = candidates.get(i);
            }
        }
        return winner;

    }
}
