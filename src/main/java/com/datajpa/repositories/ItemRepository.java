package com.datajpa.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

import com.datajpa.Item;
import com.datajpa.ItemId;

// TODO: Auto-generated Javadoc
/**
 * The Interface ItemRepository.
 */
public interface ItemRepository extends JpaRepository<Item, ItemId>, JpaSpecificationExecutor<Item> {

	
}
