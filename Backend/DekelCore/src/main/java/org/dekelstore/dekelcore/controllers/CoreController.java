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
        return coreServices.generateId();
    }

}
