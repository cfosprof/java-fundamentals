package inheritance;

public class Review {
    private String body;
    private String author;
    private double stars;
    private String movie;

    public Review(String body, String author, double stars) {
        this.body = body;
        this.author = author;
        this.stars = stars;
        this.movie = null;
    }

    public Review(String body, String author, double stars, String movie) {
        this.body = body;
        this.author = author;
        this.stars = stars;
        this.movie = movie;
    }

    public double getStars() {
        return stars;
    }

    public String getMovie() {
        return movie;
    }

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
