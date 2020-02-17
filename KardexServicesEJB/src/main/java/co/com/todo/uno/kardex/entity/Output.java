package co.com.todo.uno.kardex.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import java.io.Serializable;
import java.util.Date;

@Entity
@Table(name = "salidas")
public class Output implements Serializable {

    @Id
    @GeneratedValue(generator = "salidas_seq", strategy = GenerationType.SEQUENCE)
    @SequenceGenerator(name = "salidas_seq", sequenceName = "salidas_seq", allocationSize = 1)
    @Column(name = "id")
    private Long id;

    @Column(name = "id_producto")
    private Long productId;

    @Column(name = "cantidad")
    private Long amount;

    @Column(name = "fecha")
    private Date date;

    @Column(name = "valor_unitario")
    private Long unitValue;

    @Column(name = "valor_total")
    private Long totalValue;

    public Long getId() {
        return id;
    }

    public Long getProductId() {
        return productId;
    }

    public void setProductId(Long productId) {
        this.productId = productId;
    }

    public Long getAmount() {
        return amount;
    }

    public void setAmount(Long amount) {
        this.amount = amount;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public Long getUnitValue() {
        return unitValue;
    }

    public void setUnitValue(Long unitValue) {
        this.unitValue = unitValue;
    }

    public Long getTotalValue() {
        return totalValue;
    }

    public void setTotalValue(Long totalValue) {
        this.totalValue = totalValue;
    }
}
