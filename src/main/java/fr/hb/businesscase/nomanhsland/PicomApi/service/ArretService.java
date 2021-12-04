package fr.hb.businesscase.nomanhsland.PicomApi.service;

import fr.hb.businesscase.nomanhsland.PicomApi.business.Arret;
import fr.hb.businesscase.nomanhsland.PicomApi.business.Zone;

import java.util.List;

public interface ArretService {
    Arret saveArret(Arret arret);
    List<Arret> getAllArrets();
    List<Arret> getArrets(Zone zone);
}
