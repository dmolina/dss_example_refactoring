package org.uca.dss.refactor.examplebook;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.List;

import org.junit.Before;
import org.junit.Test;
import org.uca.dss.refactor.examplebook.Movie;

public class CustomerTest {
	Customer c1, c2;
	List<Movie> movies;
	Movie movie_children;
	Movie movie_normal;
	Movie movie_new;
	
	@Before
	public void initMovies() {
		movies = new ArrayList<Movie>();
		movie_children = new Movie("The King Lion", Movie.CHILDRENS);
		movies.add(movie_children);
		movie_normal = new Movie("Titanic", Movie.REGULAR);
		movies.add(movie_normal);
		movie_new = new Movie("Star Wars VII", Movie.NEW_RELEASE);
		movies.add(movie_new);
	}
	
	@Before
	public void initCustomer() {
		initMovies();
		c1 = new Customer("C1");
		c2 = new Customer("C2");
		
		c1.addRental(new Rental(movie_children, 5));
		c1.addRental(new Rental(movie_new, 2));
		
		c1.addRental(new Rental(movie_normal, 3));
	}
	
	@Test
	public void test() {
		String result_c1 = c1.statement();
		System.out.println(result_c1);
		assertTrue(result_c1.contains("Amount owed is 14.0"));
		assertTrue(result_c1.contains("The King Lion	4.5"));
		assertTrue(result_c1.contains("Star Wars VII	6.0"));
		assertTrue(result_c1.contains("Titanic	3.5"));
	}
	
	@Test
	public void testC1() {
		assertFalse(c1.statement().equalsIgnoreCase(""));
	}

}
