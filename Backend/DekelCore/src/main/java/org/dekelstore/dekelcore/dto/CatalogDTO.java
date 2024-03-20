package org.dekelstore.dekelcore.dto;

import lombok.Data;

@Data
public class CatalogDTO {
    int productsCount;
    ProductDTO[] products;
}
