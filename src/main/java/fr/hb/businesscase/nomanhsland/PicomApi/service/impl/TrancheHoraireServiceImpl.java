package fr.hb.businesscase.nomanhsland.PicomApi.service.impl;

import fr.hb.businesscase.nomanhsland.PicomApi.business.TrancheHoraire;
import fr.hb.businesscase.nomanhsland.PicomApi.dao.TrancheHoraireDao;
import fr.hb.businesscase.nomanhsland.PicomApi.service.TrancheHoraireService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TrancheHoraireServiceImpl implements TrancheHoraireService {
    private TrancheHoraireDao trancheHoraireDao;

    public TrancheHoraireServiceImpl(TrancheHoraireDao trancheHoraireDao) {
        super();
        this.trancheHoraireDao = trancheHoraireDao;
    }

    @Override
    public TrancheHoraire addTrancheHoraire(Long start, Long end) {
        return trancheHoraireDao.save(new TrancheHoraire(start, end));
    }

    @Override
    public TrancheHoraire getTrancheHoraire(Long id) {
        if(trancheHoraireDao.findById(id).isPresent()){
            return trancheHoraireDao.findById(id).get();
        } else{
            return null;
        }
    }

    @Override
    public TrancheHoraire getTrancheHoraire(Long start, Long end) {
        if (trancheHoraireDao.findByStartAndEnd(start, end) != null) {
            return trancheHoraireDao.findByStartAndEnd(start, end);
        }else{
            return null;
        }

    }

    @Override
    public List<TrancheHoraire> getAllTrancheHoraires() {
        return trancheHoraireDao.findAll();
    }

    @Override
    public boolean deleteTrancheHoraire(Long id) {
        TrancheHoraire trancheHoraire = getTrancheHoraire(id);
        if(trancheHoraire !=null){
            trancheHoraireDao.delete(trancheHoraire);
            return true;
        }
        return false;
    }
}
