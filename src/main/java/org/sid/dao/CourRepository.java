package org.sid.dao;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.transaction.annotation.Transactional;

import org.sid.entities.Cour;

@Transactional
public interface CourRepository extends JpaRepository<Cour, Long> {
	
	public Page<Cour> findByTitleContains(String mc, Pageable pageable);
	public Cour findByName(String name);
}
