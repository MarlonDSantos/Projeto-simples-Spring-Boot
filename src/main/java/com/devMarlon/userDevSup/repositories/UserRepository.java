package com.devMarlon.userDevSup.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.devMarlon.userDevSup.entities.User;

public interface UserRepository extends JpaRepository<User, Long> {

}
