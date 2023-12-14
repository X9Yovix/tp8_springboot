package com.tekup.classdiagram.repository;

import com.tekup.classdiagram.model.Owner;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OwnerRepository extends JpaRepository<Owner, Long> {
}
