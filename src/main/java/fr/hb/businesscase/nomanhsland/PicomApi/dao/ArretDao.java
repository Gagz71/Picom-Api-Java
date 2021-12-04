package fr.hb.businesscase.nomanhsland.PicomApi.dao;

import fr.hb.businesscase.nomanhsland.PicomApi.business.Arret;
import fr.hb.businesscase.nomanhsland.PicomApi.business.Zone;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ArretDao extends JpaRepository<Arret, Long> {
    List<Arret> findByZone(Zone zone);

    List<Arret> findByNameContaining(String filtre);

    List<Arret> findByType(String type);
}
