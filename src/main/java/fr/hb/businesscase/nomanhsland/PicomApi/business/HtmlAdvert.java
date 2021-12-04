package fr.hb.businesscase.nomanhsland.PicomApi.business;

import javax.persistence.*;

@Entity
public class HtmlAdvert extends Advert {


    @Lob
    @Column(name = "content", nullable = false)
    private String content;

    public HtmlAdvert() {
    }

    public HtmlAdvert(String content) {
        this.content = content;
    }


    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }
}