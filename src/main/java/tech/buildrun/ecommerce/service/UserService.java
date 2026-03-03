package tech.buildrun.ecommerce.service;

import org.springframework.stereotype.Service;
import tech.buildrun.ecommerce.controller.dto.CreateUserDto;
import tech.buildrun.ecommerce.entity.BillingAddressEntity;
import tech.buildrun.ecommerce.entity.UserEntity;
import tech.buildrun.ecommerce.repository.BillingAddressRepository;
import tech.buildrun.ecommerce.repository.UserRepository;

import java.util.Optional;
import java.util.UUID;

@Service
public class UserService {

    private final UserRepository userRepository;
    private final BillingAddressRepository billingAddressRepository;

    public UserService(UserRepository userRepository, BillingAddressRepository billingAddressRepository) {
        this.userRepository = userRepository;
        this.billingAddressRepository = billingAddressRepository;
    }

    public UserEntity createUser(CreateUserDto dto) {

        // Primeiro salva o billingAddress no banco

        BillingAddressEntity billingAddressEntity = new BillingAddressEntity();
        billingAddressEntity.setAddress(dto.address());
        billingAddressEntity.setNumber(dto.number());
        billingAddressEntity.setComplement(dto.complement());
//        BillingAddressEntity billingAddresSaved = billingAddressRepository.save(billingAddressEntity);

        // Segundo salva o user no banco

        UserEntity userEntity = new UserEntity();
        userEntity.setFullName(dto.fullName());
        userEntity.setBillingAddress(billingAddressEntity);
        UserEntity userSaved = userRepository.save(userEntity);

        return userSaved;
    }

    public Optional<UserEntity> findById(UUID userId) {

        Optional<UserEntity> userEntity = userRepository.findById(userId);
        return  userEntity;
    }

    public boolean deleteById(UUID userId) {

        Optional<UserEntity> user = userRepository.findById(userId);

        if(user.isPresent()) {
            userRepository.deleteById(user.get().getId());
//            billingAddressRepository.deleteById(user.get().getBillingAddress().getBillingAddressId());
        }

        return user.isPresent();
    }
}
