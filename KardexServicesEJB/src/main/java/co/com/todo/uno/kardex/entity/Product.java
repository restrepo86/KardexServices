package co.com.todo.uno.kardex.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import java.io.Serializable;

@Entity
@Table(name = "productos")
public class Product implements Serializable {

    @Id
    @Column(name = "id")
    @GeneratedValue(generator = "productos_seq", strategy = GenerationType.SEQUENCE)
    @SequenceGenerator(name = "productos_seq", sequenceName = "productos_seq", allocationSize = 1)
    private Long id;

    @Column(name = "nombre")
    private String productName;

    @Column(name = "cantidad_minima")
    private Long minimumAmount;

    @Column(name = "cantidad_maxima")
    private Long maximumAmount;

    @Column(name = "valor_unitario")
    private Long unitValue;


    public Long getId() {
        return id;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
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

    public Long getUnitValue() {
        return unitValue;
    }

    public void setUnitValue(Long unitValue) {
        this.unitValue = unitValue;
    }
}
