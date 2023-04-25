package inheritance;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ReviewTest {

    @Test
    void testConstructor() {
        Review review = new Review("Great food!", "Alice", 5);
        assertNotNull(review);
    }

    @Test
    void testToString() {
        Review review = new Review("Great food!", "Alice", 5);
        String expected = "Review{body='Great food!', author='Alice', stars=5.0}";
        assertEquals(expected, review.toString());
    }
}