package fr.hb.businesscase.nomanhsland.PicomApi.business;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;


@Entity
public class Arret {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Long id;

    @JsonIgnore
    @ManyToOne(optional = false)
    @JoinColumn(name = "zone_id", nullable = false)
    @NotNull(message="Merci de préciser la zone")
    private Zone zone;

    @Column(name = "name", nullable = false)
    @NotBlank(message="Merci de renseigner le nom de l'arrêt")
    private String name;

    @Column(name = "type", nullable = false)
    @NotBlank(message="Merci de renseigner le type de l'arrêt")
    private String type;

    public Arret() {
    }

    public Arret(Zone zone, String name, String type) {
        this.zone = zone;
        this.name = name;
        this.type = type;
    }

    public Arret(String name, Zone zone) {
    }

    public Arret(String name, String type, Zone zone) {
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Zone getZone() {
        return zone;
    }

    public void setZone(Zone zone) {
        this.zone = zone;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    @Override
    public String toString() {
        return "Arret n° " + id + '\'' +
                "nom de l'arrêt: " + name + '\'' +
                "type de l'arrêt: " + type + '\'' + zone;
    }
}