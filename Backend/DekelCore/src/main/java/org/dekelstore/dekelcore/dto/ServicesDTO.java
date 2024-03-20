package org.dekelstore.dekelcore.dto;

import lombok.Data;

@Data
public class ServicesDTO {
    String title;
    String message;
    CardDTO[] cards;
}
