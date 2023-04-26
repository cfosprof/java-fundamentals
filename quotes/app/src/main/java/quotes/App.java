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
        QuoteService quoteService = new QuoteService();

        Quote randomQuote = quoteService.getRandomQuote();
        System.out.println(randomQuote);
    }

    public static class Quote {
        private String author;
        private String text;

        public Quote(String author, String text) {
            this.author = author;
            this.text = text;
        }

        public String getAuthor() {
            return author;
        }

        public void setAuthor(String author) {
            this.author = author;
        }

        public String getText() {
            return text;
        }

        public void setText(String text) {
            this.text = text;
        }

        @Override
        public String toString() {
            return "Quote{" +
                    "author='" + author + '\'' +
                    ", text='" + text + '\'' +
                    '}';
        }
    }

    public static class QuoteService {
        private List<Quote> quotes;

        public QuoteService() {
            try {
                InputStream is = new FileInputStream("src/main/resources/recentquotes.json");
                Reader reader = new InputStreamReader(is);
                this.quotes = new Gson().fromJson(reader, new TypeToken<List<Quote>>(){}.getType());
            } catch (FileNotFoundException e) {
                System.err.println("File not found: " + e.getMessage());
                this.quotes = new ArrayList<>(); // Initialize quotes as an empty list
            }
        }


        public Quote getRandomQuote() {
            Random random = new Random();
            int index = random.nextInt(quotes.size());
            return quotes.get(index);
        }
        public List<Quote> getQuotes() {
            return quotes;
        }
    }
}
