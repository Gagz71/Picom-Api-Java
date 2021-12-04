package fr.hb.businesscase.nomanhsland.PicomApi.business;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import javax.validation.constraints.Size;
import java.util.List;


@Entity
public class Customer extends User {

    @Column(name = "phone", length=15)
    @Size(max=15)
    private String phone;

    @JsonIgnore
    @OneToMany(mappedBy="customer")
    private List<CreditCard> creditCards;

    @JsonIgnore
    @OneToMany(mappedBy="customer")
    private List<Advert> adverts;

    public Customer() {
    }


    public Customer(String email, String password, String lastname, String firstname, String phone) {
        super(email, password, lastname, firstname);
        this.phone = phone;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public List<CreditCard> getCreditCards() {
        return creditCards;
    }

    public void setCreditCards(List<CreditCard> creditCards) {
        this.creditCards = creditCards;
    }

    public List<Advert> getAdverts() {
        return adverts;
    }

    public void setAdverts(List<Advert> adverts) {
        this.adverts = adverts;
    }

    @Override
    public String toString() {
        return "Client 🤴 n°" + getId()+ " ➡ " + getFirstname() + ' ' + getLastname() + '\'' +
                "Contact : 📥 " + getEmail() + " , 📞 " +  phone + '\'' +
                ", Carte de crédits 💳:" + creditCards +
                ' ';
    }
}