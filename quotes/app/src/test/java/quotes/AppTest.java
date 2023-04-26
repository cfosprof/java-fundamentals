package quotes;

import org.junit.jupiter.api.Test;
import quotes.App.Quote;
import quotes.App.QuoteService;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

public class AppTest {

    // Test case for checking if the getRandomQuote method returns a non-null quote
    @Test
    public void testGetRandomQuote() {
        // Create a new QuoteService instance
        QuoteService quoteService = new QuoteService();
        // Get a random quote
        Quote randomQuote = quoteService.getRandomQuote();
        // Check if the random quote is not null
        assertNotNull(randomQuote, "Random quote should not be null");
    }

    // Test case for checking if the author and text fields in the Quote object are not null and not empty
    @Test
    public void testQuoteFields() {
        // Create a new QuoteService instance
        QuoteService quoteService = new QuoteService();
        // Get a random quote
        Quote randomQuote = quoteService.getRandomQuote();
        // Check if the author field is not null and not empty
        assertNotNull(randomQuote.getAuthor(), "Quote author should not be null");
        assertFalse(randomQuote.getAuthor().isEmpty(), "Quote author should not be empty");
        // Check if the text field is not null and not empty
        assertNotNull(randomQuote.getText(), "Quote text should not be null");
        assertFalse(randomQuote.getText().isEmpty(), "Quote text should not be empty");
    }

    // Test case for checking if the quotes list in the QuoteService class is populated
    @Test
    public void testQuotesListIsPopulated() {
        // Create a new QuoteService instance
        QuoteService quoteService = new QuoteService();
        // Get the list of quotes
        List<Quote> quotes = quoteService.getQuotes();
        // Check if the quotes list is not null
        assertNotNull(quotes, "Quotes list should not be null");
        // Check if the quotes list is not empty
        assertFalse(quotes.isEmpty(), "Quotes list should not be empty");
    }
}
