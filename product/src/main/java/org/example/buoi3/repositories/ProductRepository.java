package org.example.buoi3.repositories;

import org.example.buoi3.models.Product;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProductRepository extends JpaRepository<Product,Long> {

    @Query("select p from Product p where :name is null or p.name like concat('%',:name,'%')")
    List<Product> getListProduct(@Param("name") String name, Pageable pageable);
}
