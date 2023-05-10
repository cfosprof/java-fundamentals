package quotes;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonObject;
import com.google.gson.reflect.TypeToken;
import java.io.*;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;


public class App {
    public static void main(String[] args) {
        // Create QuoteService instance
        QuoteService quoteService = new QuoteService();

        // Get random quote from quote service
        Quote randomQuote = quoteService.getRandomQuote(args);

        // Print random quote
        System.out.println(randomQuote);
    }

    // Quote class store quote information
    public static class Quote {
        private String author;
        private String text;

        // Constructor Quote class
        public Quote(String author, String text) {
            this.author = author;
            this.text = text;
        }

        // Getter author
        public String getAuthor() {
            return author;
        }

        // Setter for author
        public void setAuthor(String author) {
            this.author = author;
        }

        // Getter for text
        public String getText() {
            return text;
        }

        // Setter for text
        public void setText(String text) {
            this.text = text;
        }

        // Override toString method display quote information
        @Override
        public String toString() {
            return '"' + text + '"' + System.lineSeparator() + author;
        }
    }

    // Handle quote operations
    public static class QuoteService {
        private List<Quote> quotes;

        // Constructor QuoteService class
        public QuoteService() {
            try {
                // Read JSON file containing quotes
                InputStream is = new FileInputStream("./src/main/resources/recentquotes.json");
                Reader reader = new InputStreamReader(is);

                // Use Gson parse JSON file into list of Quote objects
                this.quotes = new Gson().fromJson(reader, new TypeToken<List<Quote>>() {
                }.getType());
            } catch (FileNotFoundException e) {
                // Handle case when file not found
                System.err.println("File not found: " + e.getMessage());
                this.quotes = new ArrayList<>(); // Initialize quotes as an empty list
            }
        }

        private void saveQuotesToFile() {
            try {
                // Create new FileWriter save updated list of quotes JSON file
                FileWriter fileWriter = new FileWriter("./src/main/resources/recentquotes.json");

                // Use Gson convert list of Quote objects JSON string with pretty printing
                Gson gson = new GsonBuilder().setPrettyPrinting().create();
                String quotesJson = gson.toJson(quotes);

                // Write JSON string file
                fileWriter.write(quotesJson);

                // Close FileWriter
                fileWriter.close();
            } catch (IOException e) {
                // Handle case when an error occurs while writing file
                System.err.println("Error writing to the file: " + e.getMessage());
            }
        }


        // Method get random quote from list of quotes

        private Quote fetchRandomQuoteFromAPI() {
            try {
                // Replace URL with Quotable API URL
                URL url = new URL("https://api.quotable.io/random");
                HttpURLConnection connection = (HttpURLConnection) url.openConnection();
                connection.setRequestMethod("GET");

                int responseCode = connection.getResponseCode();
                if (responseCode == HttpURLConnection.HTTP_OK) {
                    // Read response from API
                    BufferedReader in = new BufferedReader(new InputStreamReader(connection.getInputStream()));
                    String inputLine;
                    StringBuilder content = new StringBuilder();
                    while ((inputLine = in.readLine()) != null) {
                        content.append(inputLine);
                    }
                    // Close connections
                    in.close();
                    connection.disconnect();

                    // Parse JSON response
                    Gson gson = new Gson();
                    JsonObject responseObject = gson.fromJson(content.toString(), JsonObject.class);

                    String author = responseObject.get("author").getAsString();
                    String text = responseObject.get("content").getAsString();

                    // Create new Quote object with fetched information
                    Quote randomQuote = new Quote(author, text);

                    // Add fetched quote list of quotes
                    quotes.add(randomQuote);

                    // Save updated list of quotes JSON file
                    saveQuotesToFile();

                    return randomQuote;
                } else {
                    System.err.println("API request failed with response code: " + responseCode);
                }
            } catch (IOException e) {
                System.err.println("Error connecting to the API: " + e.getMessage());
            }
            return null;
        }

        public Quote getRandomQuote(String[] args) {
            // Try fetch quote from API unless command line parameter passed
            if (args.length == 0 || "internet".equalsIgnoreCase(args[0])) {
                Quote fetchedQuote = fetchRandomQuoteFromAPI();
                if (fetchedQuote != null) {
                    return fetchedQuote;
                }
            }

            // If API request failed or user wants local quote, return random quote from local file
            Random random = new Random();
            int index = random.nextInt(quotes.size());
            return quotes.get(index);
        }


        // Getter list of quotes
        public List<Quote> getQuotes() {
            return quotes;
        }
    }
}

