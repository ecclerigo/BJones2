package com.plantplaces.ui.test;

import org.junit.Test;

import com.plantplaces.dto.Plant;
import com.plantplaces.ui.SearchPlants;

import junit.framework.TestCase;

public class TestSearchPlants extends TestCase {
	
	private SearchPlants searchPlants;
	private String execute;

	@Test
	public void testSearchPlantsExecute() {
		
		givenSearchPlantsCreatedWithRedbud();
		whenInvokeExecute();
		thenVerifyReturnSuccess();
	}
	
	@Test
	public void testSearchPlantNoRedbud() {
		givenSearchPlantsCreatedWithNoRedbud();
		whenInvokeExecute();
		thenVerifyReturnNoresults();
	}
	
	@Test
	public void testSearchPlantNull() {
		givenSearchPlantsCreatedWithNullPlant();
		whenInvokeExecute();
		thenVerifyReturnNoresults();
	}
	
	

	private void givenSearchPlantsCreatedWithNullPlant() {
		searchPlants = new SearchPlants();		
	}

	private void thenVerifyReturnNoresults() {
		assertEquals("noresults", execute);
	}

	private void givenSearchPlantsCreatedWithNoRedbud() {
		searchPlants = new SearchPlants();
		Plant plant = new Plant();
		plant.setName("Pawpaw");
		searchPlants.setPlant(plant);
	}

	private void thenVerifyReturnSuccess() {
		assertEquals("search", execute);
	}

	private void whenInvokeExecute() {
		execute = searchPlants.execute();
	}

	private void givenSearchPlantsCreatedWithRedbud() {
		searchPlants = new SearchPlants();
		Plant plant = new Plant();
		plant.setName("Redbud");
		searchPlants.setPlant(plant);
	}

}
