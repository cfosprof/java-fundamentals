package inheritance;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ShopTest {

    @Test
    void testConstructor() {
        Shop shop = new Shop("Cool Shop", "A shop that sells cool things", "$$$");
        assertNotNull(shop);
    }

    @Test
    void testToString() {
        Shop shop = new Shop("Cool Shop", "A shop that sells cool things", "$$$");
        String expected = "Shop{name='Cool Shop', description='A shop that sells cool things', priceCategory='$$$'}";
        assertEquals(expected, shop.toString());
    }

    @Test
    void testAddReview() {
        Shop shop = new Shop("Cool Shop", "A shop that sells cool things", "$$$");
        Review review = new Review("Fantastic store!", "Charlie", 4.5);
        shop.addReview(review);
        assertNotNull(shop);
    }
}
