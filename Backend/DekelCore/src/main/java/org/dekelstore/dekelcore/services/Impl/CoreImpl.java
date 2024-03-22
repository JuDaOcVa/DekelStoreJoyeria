package org.dekelstore.dekelcore.services.Impl;

import com.google.gson.Gson;
import org.dekelstore.dekelcore.dto.*;
import org.dekelstore.dekelcore.miscellaneous.AppConstants;
import org.dekelstore.dekelcore.services.CoreServices;
import org.springframework.stereotype.Repository;

import java.text.MessageFormat;
import java.util.Random;

@Repository
public class CoreImpl implements CoreServices {

    public String generateId() {
        return MessageFormat.format("ID-{0}-{1}", generateRandomChars(), generateRandomChars());
    }

    private String convertObjectToJson(Object object) {
        if (object != null) {
            Gson gson = new Gson();
            return gson.toJson(object);
        }
        return "{}";
    }

    private static String generateRandomChars() {
        String allowedChars = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789";
        int length = 4;
        return new Random().ints(length, 0, allowedChars.length())
                .mapToObj(allowedChars::charAt)
                .collect(StringBuilder::new, StringBuilder::append, StringBuilder::append)
                .toString();
    }

    public String getInfo() {
        InfoDTO infoDTO = new InfoDTO();
        //AboutDTO
        AboutDTO aboutDTO = new AboutDTO();
        aboutDTO.setTitle("Acerca de Nosotros");
        AboutUsDTO aboutUsDTO = new AboutUsDTO();
        aboutUsDTO.setSubtitle("¿Quienes somos?");
        aboutUsDTO.setAboutUsMessage("Somos una empresa dedicada al cuidado de los detalles, y amantes a la alta joyería." +
                "Nos enfatizamos en crear y mostrar piezas de joyería únicas, en donde podrás expresar tus pensamientos y emociones plasmadas en una joya final.\n" +
                "Nos gusta trabajar bajo tus ideas y junto a nuestro equipo hacerlas realidad.");
        aboutDTO.setAboutUs(aboutUsDTO);
        LocationDTO[] locations = new LocationDTO[1];
        LocationDTO locationDTO = new LocationDTO();
        locationDTO.setUbication("Centro Comercial Llano Grande, CARRERA 31 #44 - 239 Local 306, Palmira, Valle del Cauca");
        locations[0] = locationDTO;
        aboutDTO.setLocations(locations);
        HomeDTO homeDTO = new HomeDTO();
        homeDTO.setTitle("Bienvenidos a " + AppConstants.AppName + "!");
        homeDTO.setMessage("Esto es Dekel Store, inigualable");
        TestimonialsDTO[] testimonials = new TestimonialsDTO[1];
        TestimonialsDTO testimonialDTO = new TestimonialsDTO();
        testimonialDTO.setName("Juan Perez");
        testimonialDTO.setDescription("Estoy extremadamente satisfecha con mi compra en su joyería. La calidad de las joyas es excepcional, y el servicio de atención al cliente fue de primera.");
        testimonialDTO.setJewelry("Pulsera de oro");
        testimonials[0] = testimonialDTO;
        aboutDTO.setTestimonials(testimonials);
        HistoryDTO historyDTO = new HistoryDTO();
        historyDTO.setHistoryTitle("Nuestra historia");
        historyDTO.setHistoryDescription("Hace seis años, en un pequeño taller artesanal, nació la visión de Dekel Store. Desde entonces, nos hemos dedicado a cultivar un legado de excelencia y artesanía en cada una de nuestras piezas. Cada diamante pulido a la perfección, cada rubí centelleante y cada zafiro azul profundo lleva consigo el espíritu de la dedicación y la excelencia.\n" +
                "En Dekel Store, no solo ofrecemos joyas; ofrecemos momentos eternos de amor, compromiso y celebración. Desde los anillos de compromiso que sellan promesas de por vida hasta los delicados colgantes que conmemoran momentos especiales, nuestras creaciones son testigos silenciosos de los momentos más preciados de la vida.");
        aboutDTO.setHistory(historyDTO);
        TeamDTO teamDTO = new TeamDTO();
        teamDTO.setTeamSubtitle("Nuestro equipo");
        MemberDTO memberDTO = new MemberDTO();
        memberDTO.setName("Lyor Ocampo");
        memberDTO.setPosition("CEO");
        MemberDTO[] members = new MemberDTO[2];
        members[0] = memberDTO;
        memberDTO = new MemberDTO();
        memberDTO.setName("Juan David Ocampo");
        memberDTO.setPosition("Co-CEO");
        members[1] = memberDTO;
        teamDTO.setMembers(members);
        aboutDTO.setTeam(teamDTO);
        //End AboutDTO
        //Catalog
        CatalogDTO catalogDTO = new CatalogDTO();
        catalogDTO.setProductsCount(1);
        ProductDTO productDTO = new ProductDTO();
        productDTO.setId(generateId());
        productDTO.setName("Anillo de compromiso");
        productDTO.setDescription("Anillo elegante de plata esterlina con un diamante incrustado en el centro. Perfecto para ocasiones especiales.");
        CategoryDTO categoryDTO = new CategoryDTO();
        categoryDTO.setId("1");
        categoryDTO.setName("Anillos");
        productDTO.setCategory(categoryDTO);
        productDTO.setImage("");
        productDTO.setStock(5);
        productDTO.setValue(155000.00);
        MaterialDTO materialDTO = new MaterialDTO();
        materialDTO.setId("1");
        materialDTO.setDescription("Plata esterlina 925 y diamante");
        productDTO.setMaterial(materialDTO);
        ProductDTO[] products = new ProductDTO[1];
        products[0] = productDTO;
        catalogDTO.setProducts(products);
        //End catalog
        //Services
        ServicesDTO servicesDTO = new ServicesDTO();
        servicesDTO.setTitle("Servicios");
        servicesDTO.setMessage("Servicio de Mantenimiento, reparación y creación de joyas nuevas a partir de tus prendas antiguas.");
        CardDTO cardDTO = new CardDTO();
        cardDTO.setCardTitle("Reparación");
        cardDTO.setCardMessage("Reparación de joyas con la máxima finura, calidad y materiales, todo con el sello Dekel.");
        CardDTO[] cards = new CardDTO[1];
        cards[0] = cardDTO;
        servicesDTO.setCards(cards);
        //End Services
        //InfoDTO
        infoDTO.setSite(AppConstants.AppName);
        infoDTO.setSiteVersion(AppConstants.AppVersion);
        infoDTO.setHome(homeDTO);
        infoDTO.setAbout(aboutDTO);
        infoDTO.setCatalog(catalogDTO);
        infoDTO.setServices(servicesDTO);
        //End InfoDTO

        return convertObjectToJson(infoDTO);
    }
}
