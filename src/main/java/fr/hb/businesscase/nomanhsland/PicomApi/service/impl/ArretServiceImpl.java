package fr.hb.businesscase.nomanhsland.PicomApi.service.impl;

import fr.hb.businesscase.nomanhsland.PicomApi.business.Arret;
import fr.hb.businesscase.nomanhsland.PicomApi.business.Zone;
import fr.hb.businesscase.nomanhsland.PicomApi.dao.ArretDao;
import fr.hb.businesscase.nomanhsland.PicomApi.service.ArretService;
import fr.hb.businesscase.nomanhsland.PicomApi.service.ZoneService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ArretServiceImpl implements ArretService {

    private ArretDao arretDao;
    private ZoneService zoneService;

    public ArretServiceImpl(ArretDao arretDao, ZoneService zoneService) {
        this.arretDao = arretDao;
        this.zoneService = zoneService;
    }

    @Override
    public Arret saveArret(Arret arret) {
        return arretDao.save(arret);
    }

    @Override
    public List<Arret> getAllArrets() {
        return arretDao.findAll();
    }

    @Override
    public List<Arret> getArrets(Zone zone) {
        return arretDao.findByZone(zone);
    }
}
