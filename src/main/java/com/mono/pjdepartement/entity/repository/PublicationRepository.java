package com.mono.pjdepartement.entity.repository;

import com.mono.pjdepartement.entity.app.Publication;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface PublicationRepository extends JpaRepository<Publication, Long> {
    List<Publication> findByDescription(String description);
    List<Publication> findByTitle(String title);
}
