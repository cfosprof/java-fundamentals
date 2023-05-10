package quotes;

import org.junit.jupiter.api.Test;
import quotes.App.Quote;
import quotes.App.QuoteService;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

public class AppTest {

    // Test case checking if getRandomQuote method returns non-null quote
    @Test
    public void testGetRandomQuote() {
        QuoteService quoteService = new QuoteService();
        Quote randomQuote = quoteService.getRandomQuote(new String[]{});
        // Check if random quote not null
        assertNotNull(randomQuote, "Random quote should not be null");
    }

    // Test case checking if author and text fields in Quote object are not null and not empty
    @Test
    public void testQuoteFields() {
        QuoteService quoteService = new QuoteService();
        Quote randomQuote = quoteService.getRandomQuote(new String[]{});
        // Check if author field not null and not empty
        assertNotNull(randomQuote.getAuthor(), "Quote author should not be null");
        assertFalse(randomQuote.getAuthor().isEmpty(), "Quote author should not be empty");
        // Check if text field not null and not empty
        assertNotNull(randomQuote.getText(), "Quote text should not be null");
        assertFalse(randomQuote.getText().isEmpty(), "Quote text should not be empty");
    }

    // Test case checking if quotes list in QuoteService class populated
    @Test
    public void testQuotesListIsPopulated() {
        QuoteService quoteService = new QuoteService();
        // Get list of quotes
        List<Quote> quotes = quoteService.getQuotes();
        // Check if quotes list not null
        assertNotNull(quotes, "Quotes list should not be null");
        // Check if quotes list not empty
        assertFalse(quotes.isEmpty(), "Quotes list should not be empty");
    }

    @Test
    public void testQuoteAddedFromAPI() {
        QuoteService quoteService = new QuoteService();
        // Get initial size of quotes list
        int initialSize = quoteService.getQuotes().size();
        // Fetch quote from API
        Quote fetchedQuote = quoteService.getRandomQuote(new String[]{"internet"});
        // Check if size of quotes list has increased by 1
        assertEquals(initialSize + 1, quoteService.getQuotes().size(), "Quote from API should be added to the local list");
    }

    @Test
    public void testQuoteFetchedFromLocal() {
        QuoteService quoteService = new QuoteService();
        // Get initial size of quotes list
        int initialSize = quoteService.getQuotes().size();
        // Fetch quote from local file
        Quote localQuote = quoteService.getRandomQuote(new String[]{"local"});
        // Check if size of quotes list remains same
        assertEquals(initialSize, quoteService.getQuotes().size(), "Quote should be fetched from the local file");
    }

    @Test
    public void testQuoteToString() {
        // Create new Quote instance
        Quote quote = new Quote("Author", "Text");
        // Check if toString method returns expected format
        String expectedString = "\"Text\"" + System.lineSeparator() + "Author";
        assertEquals(expectedString, quote.toString(), "Quote toString method should return the expected format");
    }
}