package com.cg.es.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.cg.es.entity.BasketEntity;
import com.cg.es.model.BasketModel;

@Repository
public interface BasketRepository extends JpaRepository<BasketEntity, Long> {

	void saveAndFlush(BasketModel bas);

}
