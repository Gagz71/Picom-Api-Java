package fr.hb.businesscase.nomanhsland.PicomApi.business;

import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.time.LocalDate;
import java.util.Date;
import java.util.List;

@Entity
@Inheritance
public abstract class Advert {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Long id;

    @ManyToOne(optional = false)
    @JoinColumn(name = "customer_id", nullable = false)
    @NotNull(message="Une annonce doit être associée à un client")
    private Customer customer;

    @Column(name = "creation_date", nullable = false)
    private Date creationDate;

    @Column(name = "start_date", nullable = false)
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    @NotNull(message="Merci de préciser la date à laquelle la diffusion de l'annonce doit débuter")
    private Date startDate;

    @Column(name = "end_date", nullable = false)
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    @NotNull(message="Merci de préciser la date à laquelle la diffusion de l'annonce doit se terminer")
    private Date endDate;

    @ManyToMany
    @NotEmpty(message="Une annonce doit être associée à au moins une zone")
    private List<Zone> zones;

    @ManyToMany
    private List<TrancheHoraire> trancheHoraires;

    public Advert() {
        creationDate = new Date();
    }

    public Date getEndDate() {
        return endDate;
    }

    public void setEndDate(Date endDate) {
        this.endDate = endDate;
    }

    public Date getStartDate() {
        return startDate;
    }

    public void setStartDate(Date startDate) {
        this.startDate = startDate;
    }

    public Date getCreationDate() {
        return creationDate;
    }

    public void setCreationDate(Date creationDate) {
        this.creationDate = creationDate;
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

    public List<Zone> getZones() {
        return zones;
    }

    public void setZones(List<Zone> zones) {
        this.zones = zones;
    }

    public List<TrancheHoraire> getTrancheHoraires() {
        return trancheHoraires;
    }

    public void setTrancheHoraires(List<TrancheHoraire> trancheHoraires) {
        this.trancheHoraires = trancheHoraires;
    }

    @Override
    public String toString() {
        return "Annonce n° " + id +'\''+
                "Date de création: " + creationDate + '\''+
                "Date de début de diffusion: " + startDate + '\''+
                "Date de fin de diffusion :" + endDate + '\''+
                "zones: " + '\''+ '\''+ zones + '\''+
                "trancheHoraires: " + '\''+'\''+trancheHoraires + '\''+
                "Propriétaire de l'annonce: " + customer ;
    }
}