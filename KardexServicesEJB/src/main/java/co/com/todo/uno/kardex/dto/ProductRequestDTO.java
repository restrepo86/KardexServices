package co.com.todo.uno.kardex.dto;

public class ProductRequestDTO {

    private String productName;
    private Long unitValue;
    private Long minimumAmount;
    private Long maximumAmount;

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public Long getUnitValue() {
        return unitValue;
    }

    public void setUnitValue(Long unitValue) {
        this.unitValue = unitValue;
    }

    public Long getMinimumAmount() {
        return minimumAmount;
    }

    public void setMinimumAmount(Long minimumAmount) {
        this.minimumAmount = minimumAmount;
    }

    public Long getMaximumAmount() {
        return maximumAmount;
    }

    public void setMaximumAmount(Long maximumAmount) {
        this.maximumAmount = maximumAmount;
    }

}
