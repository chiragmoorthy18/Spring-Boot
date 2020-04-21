package sheduler.pojo;

public class Movie {

	private String title;
	
	private String genre;
	
	private float rating;

	public Movie(String title, String genre, float rating) {
		super();
		this.title = title;
		this.genre = genre;
		this.rating = rating;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getGenre() {
		return genre;
	}

	public void setGenre(String genre) {
		this.genre = genre;
	}

	public float getRating() {
		return rating;
	}

	public void setRating(float rating) {
		this.rating = rating;
	}
	
	@Override
	public String toString() {
		return "Movie [title=" + title + ", genre=" + genre + ", rating=" + rating + "]";
	}
	
}
