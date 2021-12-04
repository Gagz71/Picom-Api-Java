package fr.hb.businesscase.nomanhsland.PicomApi.service.impl;

import fr.hb.businesscase.nomanhsland.PicomApi.business.Advert;
import fr.hb.businesscase.nomanhsland.PicomApi.business.Customer;
import fr.hb.businesscase.nomanhsland.PicomApi.business.HtmlAdvert;
import fr.hb.businesscase.nomanhsland.PicomApi.business.ImgAdvert;
import fr.hb.businesscase.nomanhsland.PicomApi.dao.AdvertDao;
import fr.hb.businesscase.nomanhsland.PicomApi.dao.HtmlAdvertDao;
import fr.hb.businesscase.nomanhsland.PicomApi.dao.ImgAdvertDao;
import fr.hb.businesscase.nomanhsland.PicomApi.service.AdvertService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AdvertServiceImpl implements AdvertService {

    private AdvertDao advertDao;
    private ImgAdvertDao imgAdvertDao;
    private HtmlAdvertDao htmlAdvertDao;

    public AdvertServiceImpl(AdvertDao advertDao, ImgAdvertDao imgAdvertDao, HtmlAdvertDao htmlAdvertDao) {
        this.advertDao = advertDao;
        this.imgAdvertDao = imgAdvertDao;
        this.htmlAdvertDao = htmlAdvertDao;
    }

    @Override
    public List<Advert> getAllAdverts() {
        return advertDao.findAll();
    }

    @Override
    public List<Advert> getAdverts(Customer customer) {
        return advertDao.findByCustomer(customer);
    }

    @Override
    public ImgAdvert saveImgAdvert(ImgAdvert imgAdvert) {
        return imgAdvertDao.save(imgAdvert);
    }

    @Override
    public HtmlAdvert saveHtmlAdvert(HtmlAdvert htmlAdvert) {
        return htmlAdvertDao.save(htmlAdvert);
    }

    @Override
    public Advert getAdvert(Long id) {
        return advertDao.findById(id).orElse(null);
    }

    @Override
    public Page<Advert> getAdverts(Pageable pageable, Customer customer) {
        return advertDao.findByCustomer(pageable, customer);
    }

    @Override
    public boolean deleteAdvert(Long id) {
        Advert advert = getAdvert(id);
        if(advert != null){
            advertDao.deleteById(id);
            return true;
        }
        return false;
    }
}
