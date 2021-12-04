package fr.hb.businesscase.nomanhsland.PicomApi.service;

import fr.hb.businesscase.nomanhsland.PicomApi.business.Admin;
import fr.hb.businesscase.nomanhsland.PicomApi.business.Customer;
import fr.hb.businesscase.nomanhsland.PicomApi.business.User;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface UserService {

    Customer saveCustomer(Customer customer);
    Admin saveAdmin(Admin admin);
    User getUser(String email, String password);
    Page<User> getUsers(Pageable pageable);
    Page<User> getUsers(Pageable pageable, String nameFilter);
    List<User> getAllUsers();
    long totalUser();

    User getUser(String userEmail);

    Customer getUser(Long id);



    List<Customer> getCustomers();

    boolean deleteUser(Long id);
}
