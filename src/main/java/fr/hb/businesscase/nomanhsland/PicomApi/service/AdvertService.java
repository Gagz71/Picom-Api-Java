package fr.hb.businesscase.nomanhsland.PicomApi.service;

import fr.hb.businesscase.nomanhsland.PicomApi.business.Advert;
import fr.hb.businesscase.nomanhsland.PicomApi.business.Customer;
import fr.hb.businesscase.nomanhsland.PicomApi.business.HtmlAdvert;
import fr.hb.businesscase.nomanhsland.PicomApi.business.ImgAdvert;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface AdvertService {

    List<Advert> getAdverts(Customer customer);
    List<Advert> getAllAdverts();
    ImgAdvert saveImgAdvert(ImgAdvert imgAdvert);
    HtmlAdvert saveHtmlAdvert(HtmlAdvert htmlAdvert);
    Advert getAdvert(Long id);
    Page<Advert> getAdverts(Pageable pageable, Customer customer);
    boolean deleteAdvert(Long id);

}
