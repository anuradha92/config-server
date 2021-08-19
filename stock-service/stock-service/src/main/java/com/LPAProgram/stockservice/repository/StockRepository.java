package com.LPAProgram.stockservice.repository;

import com.LPAProgram.stockservice.entity.Stock;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface StockRepository extends JpaRepository<Stock,Long> {

    Stock findByMedicineId(Long medicineId);
}
