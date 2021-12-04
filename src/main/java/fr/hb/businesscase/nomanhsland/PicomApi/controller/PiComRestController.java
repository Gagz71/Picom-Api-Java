package fr.hb.businesscase.nomanhsland.PicomApi.controller;

import fr.hb.businesscase.nomanhsland.PicomApi.business.Advert;
import fr.hb.businesscase.nomanhsland.PicomApi.business.Customer;
import fr.hb.businesscase.nomanhsland.PicomApi.business.User;
import fr.hb.businesscase.nomanhsland.PicomApi.service.AdvertService;
import fr.hb.businesscase.nomanhsland.PicomApi.service.UserService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/")
public class PiComRestController {

    private AdvertService advertService;
    private UserService userService;

    public PiComRestController(AdvertService advertService,UserService userService) {
        super();
        this.advertService = advertService;
        this.userService = userService;
    }

    //Récup tout les users
    @GetMapping("users")
    public List<User> getUsers(){
        return userService.getAllUsers();
    }

    //Récup tout les clients
    @GetMapping("customers")
    public List<Customer> getCustomers(){
        return userService.getCustomers();
    }

    //Récup User par son id
    @GetMapping("customer/{id}")
    public  Customer getCustomer(@PathVariable Long id){
        return userService.getUser(id);
    }

    //Récup User par son id
    @GetMapping("customer/{email}/{password}")
    public  Customer getCustomer(@PathVariable String email, @PathVariable String password){
        return (Customer) userService.getUser(email, password);
    }

    @PostMapping("customer/{email}/{password}")
    public  Customer login(@PathVariable String email, @PathVariable String password){
        return (Customer) userService.getUser(email, password);
    }

    //Ajout d'un client
    @PostMapping("inscription")
    public Customer addCustomer(@RequestBody Customer customer){
        return userService.saveCustomer(customer);
    }

    //Supprime un client
    @DeleteMapping("customers/{id}")
    public boolean deleteCustomer(@PathVariable Long id){
        return userService.deleteUser(id);
    }

    //Récupère les annonces d'un client
    @GetMapping("customer/{emailCustomer}/adverts")
    public List<Advert> getAdvertsByCustomer(@PathVariable String emailCustomer){
        Customer customer = (Customer) userService.getUser(emailCustomer);
        return advertService.getAdverts(customer);
    }

    //Récupère toutes les annonces
    @GetMapping("adverts")
    public List<Advert> getAllAdverts(){
        return advertService.getAllAdverts();
    }

    @GetMapping("advert/{id}")
    public Advert getAdvertById(@PathVariable Long id){
        return advertService.getAdvert(id);
    }
}

