package com.plantplaces.dao;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Named;

import org.apache.log4j.Logger;

import com.plantplaces.dto.Plant;
import com.plantplaces.ui.AddPlant;

@Named("plantDAO")
public class PlantDAOStub implements IPlantDAO {

	final static Logger logger = Logger.getLogger(PlantDAOStub.class);
	
	@Override
	public List<Plant> fetchPlants() {
		ArrayList<Plant> allPlants = new ArrayList<Plant>();

		// create plant
		Plant redbud = new Plant();
		redbud.setName("Eastern Redbud");
		allPlants.add(redbud);

		Plant pawpaw = new Plant();
		pawpaw.setName("Paw Paw");
		allPlants.add(pawpaw);

		Plant nasturtium = new Plant();
		nasturtium.setName("nasturtium");
		allPlants.add(nasturtium);
		
		Plant redOak = new Plant();
		redOak.setName("Quercus");
		allPlants.add(redOak);
		
		Plant redMaple = new Plant();
		redMaple.setName("Acer");
		allPlants.add(redMaple);

		return allPlants;
	}

	@Override
	public void insert(Plant plant) throws Exception {
		// TODO Auto-generated method stub
		logger.warn("Inserting to stub: this does not persist the item");

	}

	@Override
	public void update(Plant plant) throws Exception {
		// TODO Auto-generated method stub

	}

	@Override
	public void delete(Plant plant) throws Exception {
		// TODO Auto-generated method stub

	}

}
