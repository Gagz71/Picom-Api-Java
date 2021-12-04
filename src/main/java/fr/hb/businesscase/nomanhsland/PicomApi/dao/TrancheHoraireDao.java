package fr.hb.businesscase.nomanhsland.PicomApi.dao;

import fr.hb.businesscase.nomanhsland.PicomApi.business.TrancheHoraire;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface TrancheHoraireDao extends JpaRepository<TrancheHoraire, Long> {
    TrancheHoraire findByStartAndEnd(Long start, Long end);
}
