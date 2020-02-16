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
@Table(name = "entradas")
public class Entry implements Serializable {

    @Id
    @GeneratedValue(generator = "entradas_seq", strategy = GenerationType.SEQUENCE)
    @SequenceGenerator(name = "entradas_seq", sequenceName = "entradas_seq", allocationSize = 1)
    @Column(name = "id")
    private Long id;

    @Column(name = "id_producto")
    private Long productId;

    @Column(name = "cantidad")
    private Long amount;

    @Column(name = "fecha")
    private Date fecha;

    @Column(name = "valor_unitario")
    private Long valorUnitario;

    @Column(name = "valor_total")
    private Long valorTotal;

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

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    public Long getValorUnitario() {
        return valorUnitario;
    }

    public void setValorUnitario(Long valorUnitario) {
        this.valorUnitario = valorUnitario;
    }

    public Long getValorTotal() {
        return valorTotal;
    }

    public void setValorTotal(Long valorTotal) {
        this.valorTotal = valorTotal;
    }
}
