package org.dekelstore.dekelcore.dto;

import lombok.Data;

@Data
public class InfoDTO {

    String site;
    String siteVersion;
    HomeDTO home;
    AboutDTO about;
    CatalogDTO catalog;
    ServicesDTO services;
}
