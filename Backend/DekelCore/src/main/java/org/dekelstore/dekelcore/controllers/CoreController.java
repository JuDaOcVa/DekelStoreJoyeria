package org.dekelstore.dekelcore.controllers;

import org.dekelstore.dekelcore.services.CoreServices;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.text.MessageFormat;
import java.util.Random;

@RestController
@RequestMapping("/Api")
public class CoreController {
    public final CoreServices coreServices;

    public CoreController(CoreServices coreServices) {
        this.coreServices = coreServices;
    }

    @GetMapping("/generateId")
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
