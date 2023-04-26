package quotes;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import java.util.ArrayList;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;
import java.util.Random;

public class App {
    public static void main(String[] args) {
        // Create a new QuoteService instance
        QuoteService quoteService = new QuoteService();

        // Get a random quote from the quote service
        Quote randomQuote = quoteService.getRandomQuote();
        // Print the random quote to the console
        System.out.println(randomQuote);
    }

    // Quote class to store quote information
    public static class Quote {
        // Declare author and text as instance variables
        private String author;
        private String text;

        // Constructor for the Quote class
        public Quote(String author, String text) {
            this.author = author;
            this.text = text;
        }

        // Getter for the author
        public String getAuthor() {
            return author;
        }

        // Setter for the author
        public void setAuthor(String author) {
            this.author = author;
        }

        // Getter for the text
        public String getText() {
            return text;
        }

        // Setter for the text
        public void setText(String text) {
            this.text = text;
        }

        // Override the toString method to display quote information
        @Override
        public String toString() {
            return "Quote{" +
                    "author='" + author + '\'' +
                    ", text='" + text + '\'' +
                    '}';
        }
    }

    // QuoteService class to handle quote-related operations
    public static class QuoteService {
        // Declare a list to store quotes
        private List<Quote> quotes;

        // Constructor for the QuoteService class
        public QuoteService() {
            try {
                // Read the JSON file containing the quotes
                InputStream is = new FileInputStream("src/main/resources/recentquotes.json");
                Reader reader = new InputStreamReader(is);

                // Use Gson to parse the JSON file into a list of Quote objects
                this.quotes = new Gson().fromJson(reader, new TypeToken<List<Quote>>(){}.getType());
            } catch (FileNotFoundException e) {
                // Handle the case when the file is not found
                System.err.println("File not found: " + e.getMessage());
                this.quotes = new ArrayList<>(); // Initialize quotes as an empty list
            }
        }

        // Method to get a random quote from the list of quotes
        public Quote getRandomQuote() {
            // Create a Random object
            Random random = new Random();
            // Generate a random index within the range of the quotes list size
            int index = random.nextInt(quotes.size());
            // Return the quote at the randomly generated index
            return quotes.get(index);
        }

        // Getter for the list of quotes
        public List<Quote> getQuotes() {
            return quotes;
        }
    }
}
