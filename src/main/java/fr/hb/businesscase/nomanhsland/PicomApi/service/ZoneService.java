package fr.hb.businesscase.nomanhsland.PicomApi.service;

import fr.hb.businesscase.nomanhsland.PicomApi.business.Zone;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface ZoneService {

    Zone addZone(String name);
    Zone getZone(Long id);
    Zone getZone(String name);
    List<Zone> getAllZones();
    Page<Zone> getZones(Pageable pageable);
    boolean deleteZone(Long id);
}
