package Library;

public class Movie {
    private String imdb;
    private String name;
    private String publishedYear;
    private String direcktor;
    private String rating;

    public Movie(String imdb, String name, String publishedYear, String direcktor, String rating) {
        this.imdb = imdb;
        this.name = name;
        this.publishedYear = publishedYear;
        this.direcktor = direcktor;
        this.rating = rating;
    }

    public String getImdb() {
        return imdb;
    }

    public String getName() {
        return name;
    }

    public String getPublishedYear() {
        return publishedYear;
    }

    public String getDirecktor() {
        return direcktor;
    }

    public String getRating() {
        return rating;
    }
}
