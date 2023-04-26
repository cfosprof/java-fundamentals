package inheritance;

public class Review {
    // Instance variables
    private String body;
    private String author;
    private double stars; //( 4.5)
    private String movie; // Store movie name for theater review (optional)

    // Constructor for the Review class without a movie parameter
    public Review(String body, String author, double stars) {
        this.body = body;
        this.author = author;
        this.stars = stars;
        this.movie = null; // Set to null as movie is not provided in this constructor
    }

    // Constructor for the Review class with a movie parameter
    public Review(String body, String author, double stars, String movie) {
        this.body = body;
        this.author = author;
        this.stars = stars;
        this.movie = movie;
    }

    // Getter method for the review's star rating
    public double getStars() {
        return stars;
    }

    // Getter method for the movie name in the review (for theater reviews)
    public String getMovie() {
        return movie;
    }

    // toString method to return a string representation of the review object
    @Override
    public String toString() {
        String movieStr = movie != null ? ", movie='" + movie + '\'' : "";
        return "Review{" +
                "body='" + body + '\'' +
                ", author='" + author + '\'' +
                ", stars=" + stars +
                movieStr +
                '}';
    }
}
