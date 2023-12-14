package com.tekup.classdiagram.repository;

import com.tekup.classdiagram.model.RentalContract;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RentalContractRepository extends JpaRepository<RentalContract, Long> {
}
