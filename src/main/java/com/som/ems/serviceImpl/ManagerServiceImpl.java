package com.som.ems.serviceImpl;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import com.som.ems.entity.Manager;
import com.som.ems.exceptions.*;
import com.som.ems.repository.ManagerRepository;
import com.som.ems.service.ManagerService;

@Service
public class ManagerServiceImpl implements ManagerService {

	private static final Logger logger = LoggerFactory.getLogger(ManagerServiceImpl.class);

	@Autowired
	private ManagerRepository managerRepository;

	// CREATE 
	@Override
	public Manager create(Manager manager) {
		logger.info("Saving new manager: {}", manager);
		Manager saved = managerRepository.save(manager);
		logger.info("Manager saved successfully with ID: {}", saved.getId());
		return saved;
	}

	// GET ALL 

	@Override
	public List<Manager> getAll() {
		logger.info("Fetching all managers");
		List<Manager> managers = managerRepository.findAll();
		logger.info("Fetched {} managers", managers.size());
		return managers;
	}

	// GET BY ID 
	@Override
	public Manager getById(Long id) {
		logger.info("Fetching manager by ID: {}", id);

		return managerRepository.findById(id).orElseThrow(() -> {
			logger.error("Manager not found with ID: {}", id);
			return new ManagerIdNotFoundException("Manager not found with ID: " + id);
		});
	}

	// UPDATE
	@Override
	public Manager update(Long id, Manager manager) {

	    logger.info("Updating manager ID: {}", id);

	    Manager existing = managerRepository.findById(id)
	            .orElseThrow(() -> new ManagerIdNotFoundException("Manager not found with ID: " + id));

	    // FULL UPDATE → Replace all fields
	    manager.setId(existing.getId()); // keep same ID  
	    Manager updated = managerRepository.save(manager);

	    logger.info("FULL UPDATE successful for ID: {}", id);

	    return updated;
	}


	// DELETE BY ID
	@Override
	public boolean deleteById(Long id) {
		logger.info("Deleting manager ID: {}", id);

		if (!managerRepository.existsById(id)) {
			logger.error("Cannot delete — manager not found with ID: {}", id);
			throw new EmployeeIdNotFoundException("Manager not found with ID: " + id);
		}

		managerRepository.deleteById(id);
		logger.info("Manager deleted successfully with ID: {}", id);
		return true;
	}

	// DELETE ALL
	@Override
	public void deleteAll() {
		logger.warn("Deleting ALL managers from database");
		managerRepository.deleteAll();
		logger.info("All managers deleted successfully");
	}
}
