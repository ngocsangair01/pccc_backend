package org.example.buoi3.repositories;

import org.example.buoi3.models.AttributeDescription;
import org.example.buoi3.models.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface AttributeDescriptionRepository extends JpaRepository<AttributeDescription,Long> {
    @Query("select a from AttributeDescription a where a.product = ?1")
    List<AttributeDescription> findAllByProduct(Product product);
}
