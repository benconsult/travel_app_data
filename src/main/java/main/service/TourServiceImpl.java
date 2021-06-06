package main.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import main.model.Tour;
import main.repository.TourRepository;

@Service
public class TourServiceImpl implements TourService{
	
	@Autowired
	private TourRepository tourRepository;

	@Override
	public List<Tour> getAll() {
		
		return tourRepository.findAll();
	}

	@Override
	public Tour getById(int id) {
	
		return tourRepository.getById(id);
		
	}
	@Override
	public void saveOrUpdate(Tour tour) {
		
		tourRepository.save(tour);
	}

	@Override
	public void delete(int id) {
		tourRepository.deleteById(id);
	}

}
