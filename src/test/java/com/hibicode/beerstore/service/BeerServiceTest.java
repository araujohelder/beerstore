package com.hibicode.beerstore.service;

import java.math.BigDecimal;
import java.util.Optional;

import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import com.hibicode.beerstore.model.Beer;
import com.hibicode.beerstore.model.BeerType;
import com.hibicode.beerstore.repository.Beers;
import com.hibicode.beerstore.service.exception.BeerAlreadyExistExcpetion;

import static org.hamcrest.MatcherAssert.assertThat; 
import static org.hamcrest.Matchers.*;
import static org.mockito.Mockito.when;

public class BeerServiceTest {
	
	private BeerService beerService;
	
	@Mock // cria o meu reposit�rio mokado
	private Beers beersMocked;
	
	@Before
	public void setup() {
		MockitoAnnotations.initMocks(this);
		beerService = new BeerService(beersMocked);
	}
	
	@Test(expected = BeerAlreadyExistExcpetion.class)
	public void should_deny_creation_of_beer_that_exists() {
		Beer beerInDatabase = new Beer();
		beerInDatabase.setId(10L);
		beerInDatabase.setName("Heineken");
		beerInDatabase.setVolume(new BigDecimal("355"));
		
		when(beersMocked.findByNameAndType("Heineken", BeerType.LAGER)).thenReturn(Optional.of(beerInDatabase));
		
		Beer newBeer = new Beer();
		newBeer.setName("Heineken");
		newBeer.setType(BeerType.LAGER);
		newBeer.setVolume(new BigDecimal("355"));
		
		beerService.save(newBeer);
	}
	
	@Test
	public void should_creation_new_beer() {
		Beer newBeer = new Beer();
		newBeer.setName("Heineken");
		newBeer.setType(BeerType.LAGER);
		newBeer.setVolume(new BigDecimal("355"));
		
		Beer newBeerInDatabase = new Beer();
		newBeerInDatabase.setId(10L);
		newBeerInDatabase.setName("Heineken");
		newBeerInDatabase.setType(BeerType.LAGER);
		newBeerInDatabase.setVolume(new BigDecimal("355"));
		
		when(beersMocked.save(newBeer)).thenReturn(newBeerInDatabase);
		
		Beer beerSaved = beerService.save(newBeer);
		assertThat(beerSaved.getId(), equalTo(10L));
		assertThat(beerSaved.getName(), equalTo("Heineken"));
		assertThat(beerSaved.getType(), equalTo(BeerType.LAGER));
	}
	
}
