package fr.hb.businesscase.nomanhsland.PicomApi.dao;

import fr.hb.businesscase.nomanhsland.PicomApi.business.Zone;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface ZoneDao extends JpaRepository<Zone, Long> {
    // requête par dérivation
    // Optional: nouveauté de Java 8
    Optional<Zone> findByName(String name);
}
