package fr.hb.businesscase.nomanhsland.PicomApi.service;

import fr.hb.businesscase.nomanhsland.PicomApi.business.CreditCard;
import fr.hb.businesscase.nomanhsland.PicomApi.business.Customer;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface CreditCardService {


    CreditCard getCreditCard(String userEmail);
    CreditCard getCreditCard(Long id);
    List<CreditCard> getAllCreditCards();
    Page<CreditCard> getCreditCards(Pageable pageable);

    CreditCard addCard(CreditCard card);
}
