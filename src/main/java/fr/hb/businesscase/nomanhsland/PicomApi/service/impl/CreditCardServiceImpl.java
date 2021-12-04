package fr.hb.businesscase.nomanhsland.PicomApi.service.impl;

import fr.hb.businesscase.nomanhsland.PicomApi.business.CreditCard;
import fr.hb.businesscase.nomanhsland.PicomApi.business.Customer;
import fr.hb.businesscase.nomanhsland.PicomApi.business.User;
import fr.hb.businesscase.nomanhsland.PicomApi.dao.CreditCardDao;
import fr.hb.businesscase.nomanhsland.PicomApi.service.CreditCardService;
import fr.hb.businesscase.nomanhsland.PicomApi.service.UserService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CreditCardServiceImpl implements CreditCardService {

    private CreditCardDao creditCardDao;
    private UserService userService;

    public CreditCardServiceImpl(CreditCardDao creditCardDao) {
        super();
        this.creditCardDao = creditCardDao;
    }

    @Override
    public CreditCard addCard(CreditCard card) {
        return creditCardDao.save(card);
    }

//    @Override
//    public CreditCard addCard(String cardNumbers, String expirationMonth, String expirationYear, String cryptogramme) {
//
//        return creditCardDao.save(new CreditCard(cardNumbers, expirationMonth, expirationYear, cryptogramme));
//
//    }


    @Override
    public CreditCard getCreditCard(Long id) {
        if(creditCardDao.findById(id).isPresent()){
            return creditCardDao.findById(id).get();
        }else{
            return null;
        }
    }

    @Override
    public CreditCard getCreditCard(String userEmail) {
        User user = userService.getUser(userEmail);
        if(user == null){
            return null;
        } else{
           return creditCardDao.getCreditCardByCustomer(userEmail);
        }
    }

    @Override
    public List<CreditCard> getAllCreditCards() {
        return creditCardDao.findAll();
    }

    @Override
    public Page<CreditCard> getCreditCards(Pageable pageable) {
        return creditCardDao.findAll(pageable);
    }
}
