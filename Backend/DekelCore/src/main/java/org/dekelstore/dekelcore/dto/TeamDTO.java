package org.dekelstore.dekelcore.dto;

import lombok.Data;

@Data
public class TeamDTO {
    String teamSubtitle;
    MemberDTO[] members;
}
