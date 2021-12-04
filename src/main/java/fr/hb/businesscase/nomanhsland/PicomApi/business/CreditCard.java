package fr.hb.businesscase.nomanhsland.PicomApi.business;

import javax.persistence.*;


@Entity
public class CreditCard {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "customer_id")
    private Customer customer;


    private String cardNumbers;


    private String expirationYear;


    private String expirationMonth;


    private String cryptogram;

    public CreditCard(String cardNumbers, String expirationMonth, String expirationYear, String cryptogramme) {
    }

    public CreditCard(CreditCard card) {
    }

    public CreditCard() {

    }


    public String getCryptogram() {
        return cryptogram;
    }

    public void setCryptogram(String cryptogram) {
        this.cryptogram = cryptogram;
    }

    public String getExpirationMonth() {
        return expirationMonth;
    }

    public void setExpirationMonth(String expirationMonth) {
        this.expirationMonth = expirationMonth;
    }

    public String getExpirationYear() {
        return expirationYear;
    }

    public void setExpirationYear(String expirationYear) {
        this.expirationYear = expirationYear;
    }

    public String getCardNumbers() {
        return cardNumbers;
    }

    public void setCardNumbers(String cardNumbers) {
        this.cardNumbers = cardNumbers;
    }

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    @Override
    public String toString() {
        return "Carte bancaire : " +
                "client propriétaire:" + customer + '\'' +
                "carte n°" + cardNumbers + '\'' +
                "année d'expiration: " + expirationYear + '\'' +
                "mois d'expiration: " + expirationMonth + '\'' +
                "C.V.V.: " + cryptogram + '\'' ;
    }
}