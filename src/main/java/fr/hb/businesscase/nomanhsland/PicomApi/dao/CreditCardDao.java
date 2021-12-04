package fr.hb.businesscase.nomanhsland.PicomApi.dao;

import fr.hb.businesscase.nomanhsland.PicomApi.business.CreditCard;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CreditCardDao extends JpaRepository<CreditCard, Long> {
    CreditCard getCreditCardByCustomer(String userEmail);
}
