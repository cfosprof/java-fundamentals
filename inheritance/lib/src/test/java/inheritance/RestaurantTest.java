package inheritance;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class RestaurantTest {

    @Test
    void testConstructor() {
        Restaurant restaurant = new Restaurant("Delicious Meals", 4.5, "$$");
        assertNotNull(restaurant);
    }

    @Test
    void testToString() {
        Restaurant restaurant = new Restaurant("Delicious Meals", 4.5, "$$");
        String expected = "Restaurant{name='Delicious Meals', stars=4.5, priceCategory='$$'}";
        assertEquals(expected, restaurant.toString());
    }

    @Test
    void testAddReview() {
        Restaurant restaurant = new Restaurant("Delicious Meals", 4.5, "$$");
        Review review = new Review("Great food!", "Alice", 5);
        restaurant.addReview(review);
        double expectedStars = 5;
        assertEquals(expectedStars, restaurant.getStars());
    }
}
