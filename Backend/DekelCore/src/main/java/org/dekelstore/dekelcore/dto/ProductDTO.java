package org.dekelstore.dekelcore.dto;

import lombok.Data;

@Data
public class ProductDTO {
    String id;
    String name;
    String description;
    CategoryDTO category;
    String image;
    int stock;
    double value;
    MaterialDTO material;
}
