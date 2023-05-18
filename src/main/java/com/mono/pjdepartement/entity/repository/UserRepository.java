package com.mono.pjdepartement.entity.repository;

import com.mono.pjdepartement.entity.metier.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserRepository extends JpaRepository<User, Long>{
	List<User> findByNom(String theme);
	List<User> findByNumTel(Long numTel);
}
