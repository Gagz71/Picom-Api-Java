package fr.hb.businesscase.nomanhsland.PicomApi.service.impl;

import fr.hb.businesscase.nomanhsland.PicomApi.business.Zone;
import fr.hb.businesscase.nomanhsland.PicomApi.dao.ZoneDao;
import fr.hb.businesscase.nomanhsland.PicomApi.service.ZoneService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ZoneServiceImpl implements ZoneService {
    private ZoneDao zoneDao;

    public ZoneServiceImpl(ZoneDao zoneDao) {
        super();
        this.zoneDao = zoneDao;
    }


    @Override
    public Zone addZone(String name) {
        return zoneDao.save(new Zone(name));
    }

    @Override
    public Zone getZone(Long id) {
        if(zoneDao.findById(id).isPresent()){
            return zoneDao.findById(id).get();
        } else{
            return null;
        }
    }

    @Override
    public Zone getZone(String name) {
        return zoneDao.findByName(name).orElse(null);
    }

    @Override
    public List<Zone> getAllZones() {
        return zoneDao.findAll();
    }

    @Override
    public Page<Zone> getZones(Pageable pageable) {
        return zoneDao.findAll(pageable);
    }

    @Override
    public boolean deleteZone(Long id) {
        Zone zone = getZone(id);
        if(zone != null){
            zoneDao.delete(zone);
            return true;
        }
        return false;
    }
}
