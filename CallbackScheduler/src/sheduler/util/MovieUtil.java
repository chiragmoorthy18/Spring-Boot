package sheduler.util;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.function.Consumer;
import java.util.stream.Collectors;

import sheduler.pojo.Movie;

public class MovieUtil {
    
	public static List<Movie> movies= new ArrayList<>();
	
	public static List<Movie> filterRating(float randomRating) {
		
		return populateMovies().stream().filter(m->m.getRating()>randomRating)
				.collect(Collectors.toList());
	}

	private static List<Movie> populateMovies() {
		
		List<String> movieDetail;
		try {
			movieDetail = Files.readAllLines(Paths.get("C:\\Users\\IBMADMIN\\Desktop\\Project\\Spring-Boot\\CallbackScheduler\\src\\sheduler\\util\\Movies.txt"));
			Consumer<String> consumeAndProcess = m -> {
				String[] details = m.split(Constants.COMMA);
				movies.add(new Movie(details[Constants.ZERO], details[Constants.ONE],Float.valueOf(details[Constants.TWO])));
				
			};
			movieDetail.stream().forEach(consumeAndProcess );
		} catch (IOException e) {
			
			e.printStackTrace();
		}
		return movies;
//		return Arrays.asList(childrenOfMen,takeShelter,fromUpOnPoppyHills,theSkinOfAWolf,
//				whatDidJackDo,theKing,jurrasicWorld);
	}

}
