package tech.buildrun.ecommerce.entity;

import jakarta.persistence.*;

import java.util.UUID;

@Entity
@Table(name = "tb_users")
public class UserEntity {

    @Id
    @Column(name = "user_id")
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;

    @Column(name = "full_name")
    private String fullName;

//    @OneToOne(fetch = FetchType.LAZY)
//    @JoinColumn(name = "billing_address_id")
//    private BillingAddressEntity billingAddress;

    @OneToOne(fetch = FetchType.EAGER)
    @JoinColumn(name="billing_address_id")
    private BillingAddressEntity billingAddress;

    public UserEntity() {
    }

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public BillingAddressEntity getBillingAddress() {
        return billingAddress;
    }

    public void setBillingAddress(BillingAddressEntity billingAddress) {
        this.billingAddress = billingAddress;
    }
}
