package fr.hb.businesscase.nomanhsland.PicomApi.service.impl;

import fr.hb.businesscase.nomanhsland.PicomApi.business.Admin;
import fr.hb.businesscase.nomanhsland.PicomApi.business.Customer;
import fr.hb.businesscase.nomanhsland.PicomApi.business.User;
import fr.hb.businesscase.nomanhsland.PicomApi.dao.AdminDao;
import fr.hb.businesscase.nomanhsland.PicomApi.dao.CustomerDao;
import fr.hb.businesscase.nomanhsland.PicomApi.dao.UserDao;
import fr.hb.businesscase.nomanhsland.PicomApi.service.UserService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImpl implements UserService {

    private CustomerDao customerDao;
    private AdminDao adminDao;
    private UserDao userDao;

    public UserServiceImpl(CustomerDao customerDao, AdminDao adminDao, UserDao userDao) {
        super();
        this.customerDao = customerDao;
        this.adminDao = adminDao;
        this.userDao = userDao;
    }

    @Override
    public List<Customer> getCustomers() {
        return customerDao.findAll();
    }

    @Override
    public Customer getUser(Long id) {
        return customerDao.findById(id).orElse(null);
    }

    @Override
    public Customer saveCustomer(Customer customer) {
        return customerDao.save(customer);
    }

    @Override
    public boolean deleteUser(Long id) {
        User user = getUser(id);
        if(user != null){
            userDao.deleteById(id);
            return true;
        }
        return false;
    }

    @Override
    public Admin saveAdmin(Admin admin) {
        return adminDao.save(admin);
    }

    @Override
    public User getUser(String email, String password) {
        return userDao.findByEmailAndPassword(email, password);
    }

    @Override
    public User getUser(String userEmail) {
        return userDao.findByEmail(userEmail);
    }

    @Override
    public Page<User> getUsers(Pageable pageable) {
        return userDao.findAll(pageable);
    }

    @Override
    public Page<User> getUsers(Pageable pageable, String nameFilter) {
        return userDao.findByLastnameContaining(pageable, nameFilter);
    }

    @Override
    public List<User> getAllUsers() {
        return userDao.findAll();
    }

    @Override
    public long totalUser() {
        return userDao.count();
    }
}
