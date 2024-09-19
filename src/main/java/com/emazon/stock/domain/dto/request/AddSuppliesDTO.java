package com.emazon.stock.domain.dto.request;

public class AddSuppliesDTO {

    private Long productId;

    private Long amountProduct;

    public AddSuppliesDTO(Long productId, Long amountProduct){
        this.amountProduct = amountProduct;
        this.productId = productId;
    }

    public Long getProductId() {
        return productId;
    }

    public void setProductId(Long productId) {
        this.productId = productId;
    }

    public Long getAmountProduct() {
        return amountProduct;
    }

    public void setAmountProduct(Long amountProduct) {
        this.amountProduct = amountProduct;
    }
}
