package com.tekup.classdiagram.repository;

import com.tekup.classdiagram.model.Property;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PropertyRepository extends JpaRepository<Property, Long> {
}
