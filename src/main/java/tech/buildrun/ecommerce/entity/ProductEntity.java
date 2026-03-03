package tech.buildrun.ecommerce.entity;


import jakarta.persistence.*;

import java.math.BigDecimal;
import java.util.List;

@Entity
@Table(name = "tb_products")
public class ProductEntity {

    @Id
    @Column(name = "product_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long pruductsId;

    @Column(name = "product_name")
    private String name;

    @Column(name = "price")
    private BigDecimal productPrice;

    @ManyToMany
    @JoinTable(
            name = "tb_products_tags",
            uniqueConstraints = @UniqueConstraint(columnNames = {"product_id","tag_id"}),
            joinColumns = @JoinColumn(name = "product_id"),
            inverseJoinColumns = @JoinColumn(name = "tag_id")
    )
    private List<TagEntity> tags;

    public ProductEntity() {
    }

    public Long getPruductsId() {
        return pruductsId;
    }

    public void setPruductsId(Long pruductsId) {
        this.pruductsId = pruductsId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public BigDecimal getProductPrice() {
        return productPrice;
    }

    public void setProductPrice(BigDecimal productPrice) {
        this.productPrice = productPrice;
    }
}
