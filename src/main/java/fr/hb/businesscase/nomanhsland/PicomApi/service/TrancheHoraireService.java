package fr.hb.businesscase.nomanhsland.PicomApi.service;

import fr.hb.businesscase.nomanhsland.PicomApi.business.Advert;
import fr.hb.businesscase.nomanhsland.PicomApi.business.TrancheHoraire;

import java.util.List;

public interface TrancheHoraireService {
   TrancheHoraire addTrancheHoraire(Long start, Long end);
   TrancheHoraire getTrancheHoraire(Long id);
   TrancheHoraire getTrancheHoraire(Long start, Long end);
   List<TrancheHoraire> getAllTrancheHoraires();
   boolean deleteTrancheHoraire(Long id);

}
