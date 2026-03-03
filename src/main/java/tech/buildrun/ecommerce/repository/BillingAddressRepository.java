package tech.buildrun.ecommerce.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import tech.buildrun.ecommerce.entity.BillingAddressEntity;

public interface BillingAddressRepository extends JpaRepository<BillingAddressEntity,Long> {
}
