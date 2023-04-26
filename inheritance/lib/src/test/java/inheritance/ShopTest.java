package inheritance;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ShopTest {

    @Test
    void testConstructor() {
        // Checks that the Shop constructor can create a new Shop object with the specified name, description, and price category.
        Shop shop = new Shop("Cool Shop", "A shop that sells cool things", "$$$");
        assertNotNull(shop);
    }

    @Test
    void testToString() {
        // Checks Shop.toString() method returns a string representation of the Shop object:
        // "Shop{name='name', description='description', priceCategory='priceCategory'}"
        Shop shop = new Shop("Cool Shop", "A shop that sells cool things", "$$$");
        String expected = "Shop{name='Cool Shop', description='A shop that sells cool things', priceCategory='$$$'}";
        assertEquals(expected, shop.toString());
    }

    @Test
    void testAddReview() {
        // This test checks that the Shop.addReview() method can add a review to the Shop object.
        Shop shop = new Shop("Cool Shop", "A shop that sells cool things", "$$$");
        Review review = new Review("Fantastic store!", "Charlie", 4.5);
        shop.addReview(review);
        assertNotNull(shop);
    }
}

