package org.dekelstore.dekelcore.controllers;

import org.dekelstore.dekelcore.services.CoreServices;
import org.springframework.boot.configurationprocessor.json.JSONException;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

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

    @GetMapping(value = "/getInfo", produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    public String getInfo() throws JSONException {
        return coreServices.getInfo();
    }

}
