package inheritance;

import java.util.ArrayList;

public class Shop {
    private String name;
    private String description;
    private String priceCategory;
    private ArrayList<Review> reviews;

    public Shop(String name, String description, String priceCategory) {
        this.name = name;
        this.description = description;
        this.priceCategory = priceCategory;
        this.reviews = new ArrayList<>();
    }

    public void addReview(Review review) {
        reviews.add(review);
    }

    @Override
    public String toString() {
        return "Shop{" +
                "name='" + name + '\'' +
                ", description='" + description + '\'' +
                ", priceCategory='" + priceCategory + '\'' +
                '}';
    }
}
