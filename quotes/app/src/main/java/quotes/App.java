package quotes;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

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
                Gson gson = new Gson();
                InputStream inputStream = new FileInputStream("app/src/main/java/resources/recentquotes.json");
                BufferedReader reader = new BufferedReader(new InputStreamReader(inputStream));
                quotes = gson.fromJson(reader, new TypeToken<List<Quote>>() {}.getType());
                reader.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

        public Quote getRandomQuote() {
            Random random = new Random();
            int index = random.nextInt(quotes.size());
            return quotes.get(index);
        }
    }
}
