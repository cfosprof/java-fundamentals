package inheritance;

import java.util.ArrayList;

public class Restaurant {
    // Instance variables
    private String name;
    private double stars;
    private String priceCategory; // Price category (e.g., "$$")
    private ArrayList<Review> reviews; // List of review objects for the restaurant

    // Constructor for the Restaurant class
    public Restaurant(String name, double stars, String priceCategory) {
        this.name = name;
        this.stars = stars;
        this.priceCategory = priceCategory;
        this.reviews = new ArrayList<>(); // Initializes the list of reviews
    }

    // Adds a review to the restaurant's review list
    public void addReview(Review review) {
        reviews.add(review);
        updateStars(); // Updates the restaurant's star rating based on the new review
    }

    // Updates the restaurant's star rating based on the current reviews
    private void updateStars() {
        int totalStars = 0;
        for (Review review : reviews) {
            totalStars += review.getStars();
        }
        this.stars = totalStars / reviews.size();
    }

    // toString method to return a string representation of the restaurant object
    @Override
    public String toString() {
        return "Restaurant{" +
                "name='" + name + '\'' +
                ", stars=" + stars +
                ", priceCategory='" + priceCategory + '\'' +
                '}';
    }

    // Getter method for the restaurant's star rating
    public double getStars() {
        return stars;
    }
}
