package fr.hb.businesscase.nomanhsland.PicomApi.dao;

import fr.hb.businesscase.nomanhsland.PicomApi.business.Customer;
import fr.hb.businesscase.nomanhsland.PicomApi.business.User;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserDao extends JpaRepository<User, Long> {

    User findByEmailAndPassword(String email, String password);
    Page<User> findByLastnameContaining(Pageable pageable, String lastname);

    User findByEmail(String userEmail);

}
