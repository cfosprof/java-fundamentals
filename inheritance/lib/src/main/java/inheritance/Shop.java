package inheritance;

import java.util.ArrayList;

public class Shop {
    // Instance variables
    private String name;
    private String description;
    private String priceCategory; // Price category (e.g., "$$$")
    private ArrayList<Review> reviews; // List of review objects for the shop

    // Constructor for the Shop class
    public Shop(String name, String description, String priceCategory) {
        this.name = name;
        this.description = description;
        this.priceCategory = priceCategory;
        this.reviews = new ArrayList<>(); // Initializes the list of reviews
    }

    // Adds a review to the shop's review list
    public void addReview(Review review) {
        reviews.add(review);
    }

    // toString method to return a string representation of the shop object
    @Override
    public String toString() {
        return "Shop{" +
                "name='" + name + '\'' +
                ", description='" + description + '\'' +
                ", priceCategory='" + priceCategory + '\'' +
                '}';
    }
}
