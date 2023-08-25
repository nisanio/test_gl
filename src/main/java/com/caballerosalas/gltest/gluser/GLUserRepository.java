package com.caballerosalas.gltest.gluser;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.Optional;
import java.util.UUID;

public interface GLUserRepository extends JpaRepository<GLUser, UUID> {
    @Query("SELECT s FROM GLUser s WHERE s.email = ?1")
    Optional<GLUser> findUserByEmail(String email);
}
