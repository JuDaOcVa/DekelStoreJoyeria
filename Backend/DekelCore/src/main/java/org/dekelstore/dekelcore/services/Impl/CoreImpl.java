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

    public String convertObjectToJson(Object object) {
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
        AboutDTO aboutDTO = new AboutDTO();
        HomeDTO homeDTO = new HomeDTO();
        CatalogDTO catalogDTO = new CatalogDTO();
        ServicesDTO servicesDTO = new ServicesDTO();

        infoDTO.setSite(AppConstants.AppName);
        infoDTO.setSiteVersion(AppConstants.AppVersion);
        infoDTO.setHome(homeDTO);
        infoDTO.setAbout(aboutDTO);
        infoDTO.setCatalog(catalogDTO);
        infoDTO.setServices(servicesDTO);

        return convertObjectToJson(infoDTO);
    }
}
