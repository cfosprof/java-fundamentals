package inheritance;

public class Library {
    public static void main(String[] args) {
        // Restaurant
        Restaurant restaurant = new Restaurant("Delicious Meals", 4.5, "$$");
        System.out.println(restaurant.toString());

        Review review1 = new Review("Great food!", "Alice", 5);
        System.out.println(review1.toString());

        Review review2 = new Review("Average experience.", "Bob", 3);
        System.out.println(review2.toString());

        restaurant.addReview(review1);
        restaurant.addReview(review2);
        System.out.println(restaurant.toString());

        // Shop
        Shop shop = new Shop("Cool Shop", "A shop that sells cool things", "$$$");
        System.out.println(shop.toString());

        Review shopReview = new Review("Fantastic store!", "Charlie", 4.5);
        System.out.println(shopReview.toString());

        shop.addReview(shopReview);
        System.out.println(shop.toString());

        // Theater
        Theater theater = new Theater("Cinema Central");
        System.out.println(theater.toString());

        theater.addMovie("Movie A");
        theater.addMovie("Movie B");
        System.out.println(theater.toString());

        Review theaterReview = new Review("Great movie!", "Diana", 4, "Movie A");
        System.out.println(theaterReview.toString());

        theater.addReview(theaterReview);
        System.out.println(theater.toString());

        theater.removeMovie("Movie A");
        System.out.println(theater.toString());
    }
}
