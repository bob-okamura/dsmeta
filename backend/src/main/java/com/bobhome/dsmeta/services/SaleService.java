package com.bobhome.dsmeta.services;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.bobhome.dsmeta.dto.SaleDTO;
import com.bobhome.dsmeta.entities.Sale;
import com.bobhome.dsmeta.repositories.SaleRepository;

@Service
public class SaleService {
	
	@Autowired
	private SaleRepository repository;

	@Transactional(readOnly = true)	
	public Page<SaleDTO> findAllPaged(Pageable pageable) {
		Page<Sale> page = repository.findAll(pageable);
		return page.map(x -> new SaleDTO(x));
	}

}
