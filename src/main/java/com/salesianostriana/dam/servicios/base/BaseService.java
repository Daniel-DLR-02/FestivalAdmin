package com.salesianostriana.dam.servicios.base;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

public class BaseService<T, ID, R extends JpaRepository<T, ID>> implements IBaseService<T, ID> {

	protected R repos;
	
	
	public BaseService(R repo) {
		this.repos = repo;
	}
	

	@Override
	public T save(T t) {
		return repos.save(t);
	}
	

	@Override
	public T findById(ID id) {
		return repos.findById(id).orElse(null);
	}

	@Override
	public List<T> findAll() {
		return repos.findAll();
	}
	

	@Override
	public T edit(T t) {
		return repos.save(t);
	}
	
	
	@Override
	public void delete(T t) {
		repos.delete(t);
	}
	
	@Override
	public void deleteById(ID id) {
		repos.deleteById(id);
	}
	

}
