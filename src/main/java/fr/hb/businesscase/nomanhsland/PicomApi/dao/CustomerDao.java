package fr.hb.businesscase.nomanhsland.PicomApi.dao;

import fr.hb.businesscase.nomanhsland.PicomApi.business.Customer;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CustomerDao extends JpaRepository<Customer, Long> {
}
