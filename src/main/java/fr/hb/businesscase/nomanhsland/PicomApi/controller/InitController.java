package fr.hb.businesscase.nomanhsland.PicomApi.controller;

import fr.hb.businesscase.nomanhsland.PicomApi.business.*;
import fr.hb.businesscase.nomanhsland.PicomApi.service.*;
import org.springframework.stereotype.Controller;

import javax.annotation.PostConstruct;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

@Controller
public class InitController {
    private static final SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");

    private UserService userService;
    private ArretService arretService;
    private ZoneService zoneService;
    private AdvertService advertService;
    private TrancheHoraireService trancheHoraireService;
    private CreditCardService creditCardService;

    public InitController(UserService userService, ArretService arretService, ZoneService zoneService, AdvertService advertService, TrancheHoraireService trancheHoraireService, CreditCardService creditCardService) {
        this.userService = userService;
        this.arretService = arretService;
        this.zoneService = zoneService;
        this.advertService = advertService;
        this.trancheHoraireService = trancheHoraireService;
        this.creditCardService = creditCardService;
    }

    @PostConstruct
    private void init() throws ParseException {
        //Fixtures
        if(trancheHoraireService.getAllTrancheHoraires().isEmpty()){
            trancheHoraireService.addTrancheHoraire(6L,7L);
            trancheHoraireService.addTrancheHoraire(7L,8L);
            trancheHoraireService.addTrancheHoraire(8L,9L);
            trancheHoraireService.addTrancheHoraire(9L,10L);
            trancheHoraireService.addTrancheHoraire(10L,11L);
            trancheHoraireService.addTrancheHoraire(11L,12L);
            trancheHoraireService.addTrancheHoraire(12L,13L);
            trancheHoraireService.addTrancheHoraire(13L,14L);
            trancheHoraireService.addTrancheHoraire(14L,15L);
            trancheHoraireService.addTrancheHoraire(15L,16L);
            trancheHoraireService.addTrancheHoraire(16L,17L);
            trancheHoraireService.addTrancheHoraire(17L,18L);
            trancheHoraireService.addTrancheHoraire(18L,19L);
            trancheHoraireService.addTrancheHoraire(19L,20L);
        }

        if(zoneService.getAllZones().isEmpty()){
            zoneService.addZone("Nord");
            zoneService.addZone("Sud");
            zoneService.addZone("Est");
            zoneService.addZone("Ouest");
            zoneService.addZone("Centre");
            zoneService.addZone("Nord-Est");
            zoneService.addZone("Nord-Ouest");
            zoneService.addZone("Sud-Est");
            zoneService.addZone("Sud-Ouest");
        }

        if(arretService.getAllArrets().isEmpty()) {
            Arret villeurbanne = new Arret();
            villeurbanne.setName("Gare de Villeurbanne");
            villeurbanne.setType("Tramway");
            villeurbanne.setZone(zoneService.getZone("Centre"));

            Arret feyzin = new Arret();
            feyzin.setName("Feyzin La Bégude");
            feyzin.setType("Bus");
            feyzin.setZone(zoneService.getZone("Sud-Est"));


            Arret bellecour = new Arret();
            bellecour.setName("Bellecour");
            bellecour.setType("Métro");
            bellecour.setZone(zoneService.getZone("Nord-Ouest"));


            Arret saxe = new Arret();
            saxe.setName("Saxe-Gambetta");
            saxe.setType("Métro");
            saxe.setZone(zoneService.getZone("Centre"));


            Arret venissieux = new Arret();
            venissieux.setName("Gare de Vénissieux");
            venissieux.setType("Bus");
            venissieux.setZone(zoneService.getZone("Sud-Ouest"));


            Arret doua = new Arret();
            doua.setName("La Doua IUT Feyssine");
            doua.setType("Tramway");
            doua.setZone(zoneService.getZone("Ouest"));

            Arret grangeBlanche = new Arret();
            grangeBlanche.setName("Grange-Blanche");
            grangeBlanche.setType("Bus");
            grangeBlanche.setZone(zoneService.getZone("Centre"));


            Arret gerland = new Arret();
            gerland.setName("Gerland");
            gerland.setType("Tramway");
            gerland.setZone(zoneService.getZone("Centre"));


            Arret valmy = new Arret();
            valmy.setName("Valmy");
            valmy.setType("Métro");
            valmy.setZone(zoneService.getZone("Nord"));


            Arret vaulx = new Arret();
            vaulx.setName("Vaulx-en-Velin La Soie");
            vaulx.setType("Métro");
            vaulx.setZone(zoneService.getZone("Sud"));


            Arret guillotiere = new Arret();
            guillotiere.setName("Guillotière Gabriel Péri");
            guillotiere.setType("Tramway");
            guillotiere.setZone(zoneService.getZone("Centre"));

            arretService.saveArret(saxe);
            arretService.saveArret(villeurbanne);
            arretService.saveArret(feyzin);
            arretService.saveArret(bellecour);
            arretService.saveArret(venissieux);
            arretService.saveArret(doua);
            arretService.saveArret(grangeBlanche);
            arretService.saveArret(gerland);
            arretService.saveArret(valmy);
            arretService.saveArret(vaulx);
            arretService.saveArret(guillotiere);

        }

        if(userService.getAllUsers().isEmpty()){
            Admin admin = new Admin();
            admin.setFirstname("Lagertha");
            admin.setLastname("Queen");
            admin.setEmail("admin@queen.hb");
            admin.setPassword("administrateur");
            userService.saveAdmin(admin);

            Customer mikasa = new Customer();
            mikasa.setLastname("Ackermann");
            mikasa.setFirstname("Mikasa");
            mikasa.setEmail("mikasa@snk.fr");
            mikasa.setPassword("12345678");
            mikasa.setPhone("0606060606");
            userService.saveCustomer(mikasa);
        }

        if (creditCardService.getAllCreditCards().isEmpty()) {
            CreditCard cardMikasa = new CreditCard();
            cardMikasa.setCardNumbers("1234567891234444");
            cardMikasa.setExpirationMonth("03");
            cardMikasa.setExpirationYear("2022");
            cardMikasa.setCryptogram("544");
            cardMikasa.setCustomer((Customer) userService.getUser("mikasa@snk.fr"));
            creditCardService.addCard(cardMikasa);
        }

        if(advertService.getAllAdverts().isEmpty()){
            HtmlAdvert htmlAdvert = new HtmlAdvert();
            htmlAdvert.setContent("PiCom" + '\''+ "Votre diffuseur d'annonces sur le réseau TCL ");
            htmlAdvert.setStartDate(simpleDateFormat.parse("2022-01-01"));
            htmlAdvert.setEndDate(simpleDateFormat.parse("2022-06-01"));
            List<TrancheHoraire> trancheHorairesHtmlAdvert = new ArrayList<>();
            trancheHorairesHtmlAdvert.add(trancheHoraireService.getTrancheHoraire(6L,7L));
            trancheHorairesHtmlAdvert.add(trancheHoraireService.getTrancheHoraire(15L,16L));
            htmlAdvert.setTrancheHoraires(trancheHorairesHtmlAdvert);
            List<Zone> htmlAdvertZones = new ArrayList<>();
            htmlAdvertZones.add(zoneService.getZone("Ouest"));
            htmlAdvertZones.add(zoneService.getZone("Nord-Est"));
            htmlAdvertZones.add(zoneService.getZone("Centre"));
            htmlAdvert.setZones(htmlAdvertZones);
            htmlAdvert.setCustomer((Customer) userService.getUser("mikasa@snk.fr"));
            advertService.saveHtmlAdvert(htmlAdvert);

        }

    }
}
