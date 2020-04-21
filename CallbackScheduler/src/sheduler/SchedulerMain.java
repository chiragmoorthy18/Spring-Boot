package sheduler;

import java.time.ZonedDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ScheduledFuture;
import java.util.concurrent.TimeUnit;

import sheduler.pojo.Movie;
import sheduler.util.Constants;
import sheduler.util.MovieUtil;

/*
 * @author vivek-shukla
 */
public class SchedulerMain {

	public static void main(String[] args) throws InterruptedException, ExecutionException {
		
		int count = Constants.ZERO;
		List<Movie> filteredMovies = new ArrayList<>();
		do {
			System.out.println("*******Thread Excecution*********");
			ScheduledExecutorService scheduler = Executors.newSingleThreadScheduledExecutor();
			ScheduledFuture<List<Movie>> scheduledResult = scheduler.schedule
					(new Callable<List<Movie>>() {

						@Override
						public List<Movie> call() throws Exception {
							float randomRating = (float) (Math.random()*Constants.TEN);				
					        System.out.format("Movies filter for random rating %f at time::  %s", 
					        		randomRating,ZonedDateTime.now().toString());
							return MovieUtil.filterRating(randomRating);
						}
						
			}, Constants.DELAY, TimeUnit.SECONDS);
			scheduler.shutdown();
			scheduler.awaitTermination(Constants.TEN, TimeUnit.SECONDS);
			
			System.out.println("\n****** Filtered Movies ****** ");
			filteredMovies = scheduledResult.get();
			filteredMovies.stream().forEach(System.out::println);
			count++;
			System.out.println(":::::::::::::::::::::::::::::::::::::::::::::");
			filteredMovies.clear();
		}while(count<Constants.TWO);
		
	}

}
