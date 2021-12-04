package fr.hb.businesscase.nomanhsland.PicomApi.dao;

import fr.hb.businesscase.nomanhsland.PicomApi.business.Advert;
import fr.hb.businesscase.nomanhsland.PicomApi.business.Customer;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Date;
import java.util.List;

public interface AdvertDao extends JpaRepository<Advert, Long> {

    List<Advert> findByCustomer(Customer customer);
    List<Advert> findByCustomerAndStartDateBetween(Customer customer, Date startDate, Date endDate);
    Page<Advert> findByCustomer(Pageable pageable, Customer customer);
}
