package org.dekelstore.dekelcore.services.Impl;

import org.dekelstore.dekelcore.services.CoreServices;
import org.springframework.stereotype.Repository;

import java.text.MessageFormat;
import java.util.Random;

@Repository
public class CoreImpl implements CoreServices {

    public String generateId() {
        return MessageFormat.format("ID-{0}-{1}", generateRandomChars(), generateRandomChars());
    }

    private static String generateRandomChars() {
        String allowedChars = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789";
        int length = 4;
        return new Random().ints(length, 0, allowedChars.length())
                .mapToObj(allowedChars::charAt)
                .collect(StringBuilder::new, StringBuilder::append, StringBuilder::append)
                .toString();
    }
}
