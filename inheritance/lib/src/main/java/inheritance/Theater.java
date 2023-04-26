package inheritance;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;

public class Theater {
    // Instance variables
    private String name;
    private Set<String> movies; // Stores a set of unique movie names currently playing at the theater
    private ArrayList<Review> reviews; // Stores a list of review objects for the theater

    // Constructor for Theater class
    public Theater(String name) {
        this.name = name;
        this.movies = new HashSet<>(); // Initializes the set of movies
        this.reviews = new ArrayList<>(); // Initializes the list of reviews
    }

    // Adds a movie to the theater's movie set
    public void addMovie(String movie) {
        movies.add(movie);
    }

    // Removes a movie from the theater's movie set
    public void removeMovie(String movie) {
        movies.remove(movie);
    }

    // Adds a review to the theater's review list
    public void addReview(Review review) {
        if (review.getMovie() == null || movies.contains(review.getMovie())) {
            reviews.add(review);
        } else {
            throw new IllegalArgumentException("Cannot add review for a movie that is not being shown in the theater.");
        }
    }

    // toString method to return a string representation of the theater object
    @Override
    public String toString() {
        return "Theater{" +
                "name='" + name + '\'' +
                ", movies=" + movies +
                '}';
    }
}
