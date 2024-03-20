package org.dekelstore.dekelcore.dto;

import lombok.Data;

@Data
public class AboutDTO {
    String title;
    AboutUsDTO aboutUs;
    LocationDTO[] locations;
    TestimonialsDTO[] testimonials;
    HistoryDTO history;
    TeamDTO team;
}
