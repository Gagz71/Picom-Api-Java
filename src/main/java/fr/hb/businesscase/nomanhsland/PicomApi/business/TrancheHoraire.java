package fr.hb.businesscase.nomanhsland.PicomApi.business;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.util.List;


@Entity
public class TrancheHoraire {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Long id;

    @Column(name = "start", nullable = false)
    private Long start;

    @Column(name = "end", nullable = false)
    private Long end;

    @JsonIgnore
    @ManyToMany(mappedBy="trancheHoraires")
    private List<Advert> adverts;

    public TrancheHoraire() {
    }

    public TrancheHoraire(Long start, Long end) {
        this.start = start;
        this.end = end;
    }

    public Long getEnd() {
        return end;
    }

    public void setEnd(Long end) {
        this.end = end;
    }

    public Long getStart() {
        return start;
    }

    public void setStart(Long start) {
        this.start = start;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public List<Advert> getAdverts() {
        return adverts;
    }

    public void setAdverts(List<Advert> adverts) {
        this.adverts = adverts;
    }

    @Override
    public String toString() {
        return "TrancheHoraire n° " + id + +'\''+
                "debut: " + start + +'\''+
                "fin: " + end;
    }
}