package inheritance;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;

public class Theater {
    private String name;
    private Set<String> movies;
    private ArrayList<Review> reviews;

    public Theater(String name) {
        this.name = name;
        this.movies = new HashSet<>();
        this.reviews = new ArrayList<>();
    }

    ;

    public void addMovie(String movie) {
        movies.add(movie);
    }

    public void removeMovie(String movie) {
        movies.remove(movie);
    }

    public void addReview(Review review) {
        if (review.getMovie() == null || movies.contains(review.getMovie())) {
            reviews.add(review);
        } else {
            throw new IllegalArgumentException("Cannot add review for a movie that is not being shown in the theater.");
        }
    }


    @Override
    public String toString() {
        return "Theater{" +
                "name='" + name + '\'' +
                ", movies=" + movies +
                '}';
    }
}