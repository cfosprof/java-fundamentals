package quotes;

import org.junit.jupiter.api.Test;
import quotes.App.Quote;
import quotes.App.QuoteService;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

public class AppTest {

    @Test
    public void testGetRandomQuote() {
        QuoteService quoteService = new QuoteService();
        Quote randomQuote = quoteService.getRandomQuote();
        assertNotNull(randomQuote, "Random quote should not be null");
    }

    @Test
    public void testQuoteFields() {
        QuoteService quoteService = new QuoteService();
        Quote randomQuote = quoteService.getRandomQuote();
        assertNotNull(randomQuote.getAuthor(), "Quote author should not be null");
        assertFalse(randomQuote.getAuthor().isEmpty(), "Quote author should not be empty");
        assertNotNull(randomQuote.getText(), "Quote text should not be null");
        assertFalse(randomQuote.getText().isEmpty(), "Quote text should not be empty");
    }

    @Test
    public void testQuotesListIsPopulated() {
        QuoteService quoteService = new QuoteService();
        List<Quote> quotes = quoteService.getQuotes();
        assertNotNull(quotes, "Quotes list should not be null");
        assertFalse(quotes.isEmpty(), "Quotes list should not be empty");
    }
}