package com.caballerosalas.gltest.phone;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

public interface PhoneRepository  extends JpaRepository<Phone, UUID> {
    @Query("SELECT s FROM Phone s WHERE s.user.id = ?1")
    Optional<List<Phone>> findPhonesByUserId(UUID userId);
}
