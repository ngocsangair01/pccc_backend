package org.example.buoi3.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface ClassRepository extends JpaRepository<Classs,Long> {
    Classs findByName(String name);
}
