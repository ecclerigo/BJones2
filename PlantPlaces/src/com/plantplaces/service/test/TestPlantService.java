package com.plantplaces.service.test;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;

import com.plantplaces.dao.IPlantDAO;
import com.plantplaces.dto.Plant;
import com.plantplaces.service.PlantService;

import junit.framework.TestCase;

public class TestPlantService extends TestCase{
	
	private PlantService plantService;
	private List<Plant> filterPlants;
	private IPlantDAO plantDAO;

	@Test
	public void testFilterPlants() {
		givenThatPlantServiceIsPopulatedWithPlantDAO();
		whenFilterWithRed();
		thenVerifyTwoResults();
	}

	private void thenVerifyTwoResults() {
		// TODO Auto-generated method stub
		assertEquals(2,filterPlants.size());
		
	}

	private void whenFilterWithRed() {
		filterPlants = plantService.filterPlants("Red");
		verify(plantDAO, times(1)).fetchPlants();
		
	}

	private void givenThatPlantServiceIsPopulatedWithPlantDAO() {
		plantService = new PlantService();
		
		plantDAO = mock(IPlantDAO.class);
		// a known set of hard coded plants
		List<Plant> plantList = constructPlantList();
		//tell the mock object to return our known set of hardcoded plants, when requested.
		when(plantDAO.fetchPlants()).thenReturn(plantList);
		
		// associate the mock object with the object we are testing
		plantService.setPlantDAO(plantDAO);
		
	}

	public List<Plant> constructPlantList() {
		ArrayList<Plant> allPlants = new ArrayList<Plant>();

		// create plant
		Plant redbud = new Plant();
		redbud.setName("Eastern Redbud");
		redbud.setGenus("Cercis");
		redbud.setSpecies("canadensis");
		redbud.setCommon("Redbud");
		redbud.setCultivar("Redbud");
		allPlants.add(redbud);

		Plant pawpaw = new Plant();
		pawpaw.setName("Paw Paw");
		pawpaw.setGenus("Asimina");
		pawpaw.setSpecies("triloba");
		pawpaw.setCommon("Paw");
		redbud.setCultivar("Asimina");
		allPlants.add(pawpaw);

		Plant nasturtium = new Plant();
		nasturtium.setName("nasturtium");
		nasturtium.setGenus("Trapoleanum");
		nasturtium.setSpecies("spp");
		nasturtium.setCommon("nasturtium");
		redbud.setCultivar("nasturtium");
		allPlants.add(nasturtium);
		
		Plant redOak = new Plant();
		redOak.setName("Quercus");
		redOak.setGenus("Cercis");
		redOak.setSpecies("canadensis");
		redOak.setCommon("Red Oak");
		redbud.setCultivar("Quercus");
		allPlants.add(redOak);
		
		Plant redMaple = new Plant();
		redMaple.setName("Acer");
		redMaple.setGenus("Cercis");
		redMaple.setSpecies("canadensis");
		redMaple.setCommon("Acer");
		redbud.setCultivar("Acer");
		allPlants.add(redMaple);

		return allPlants;
	}
}
