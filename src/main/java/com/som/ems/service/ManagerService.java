package com.som.ems.service;

import java.util.List;

import com.som.ems.entity.Manager;

public interface ManagerService {
	
	public Manager create(Manager manager);

	public Manager getById(Long id);

	public Manager update(Long id, Manager manager);

	public boolean deleteById(Long id);

	public List<Manager> getAll();

	public void deleteAll();
	

}
