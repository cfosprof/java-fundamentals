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

    @Test
    void testMovieConstructor() {
        Review review = new Review("Great movie!", "Bob", 4.5, "Movie A");
        assertNotNull(review);
    }

    @Test
    void testMovieToString() {
        Review review = new Review("Great movie!", "Bob", 4.5, "Movie A");
        String expected = "Review{body='Great movie!', author='Bob', stars=4.5, movie='Movie A'}";
        assertEquals(expected, review.toString());
    }
}
