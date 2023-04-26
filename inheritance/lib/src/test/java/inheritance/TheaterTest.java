package inheritance;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class TheaterTest {

    @Test
    void testConstructor() {
        Theater theater = new Theater("Cinema Central");
        assertNotNull(theater);
    }

    @Test
    void testToString() {
        Theater theater = new Theater("Cinema Central");
        String expected = "Theater{name='Cinema Central', movies=[]}";
        assertEquals(expected, theater.toString());
    }

    @Test
    void testAddMovie() {
        Theater theater = new Theater("Cinema Central");
        theater.addMovie("Movie A");
        String expected = "Theater{name='Cinema Central', movies=[Movie A]}";
        assertEquals(expected, theater.toString());
    }

    @Test
    void testRemoveMovie() {
        Theater theater = new Theater("Cinema Central");
        theater.addMovie("Movie A");
        theater.removeMovie("Movie A");
        String expected = "Theater{name='Cinema Central', movies=[]}";
        assertEquals(expected, theater.toString());
    }

    @Test
    void testAddReview() {
        Theater theater = new Theater("Cinema Central");
        theater.addMovie("Movie A");
        Review review = new Review("Great movie!", "Bob", 4.5, "Movie A");
        theater.addReview(review);
        assertNotNull(theater);
    }

    @Test
    void testAddReviewForNonexistentMovie() {
        Theater theater = new Theater("Cinema Central");
        theater.addMovie("Movie A");
        Review review = new Review("Great movie!", "Bob", 4.5, "Movie B");
        assertThrows(IllegalArgumentException.class, () -> theater.addReview(review));
    }
}
