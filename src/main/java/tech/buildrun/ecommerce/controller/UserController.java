package tech.buildrun.ecommerce.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import tech.buildrun.ecommerce.controller.dto.CreateUserDto;
import tech.buildrun.ecommerce.entity.UserEntity;
import tech.buildrun.ecommerce.service.UserService;

import java.net.URI;
import java.util.Optional;
import java.util.UUID;

@RestController
@RequestMapping("/users")
public class UserController {

    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @PostMapping
    public ResponseEntity<Void> createUser(@RequestBody CreateUserDto createUserDto) {

        UserEntity userCreated = userService.createUser(createUserDto);

        return ResponseEntity.created(URI.create("/users/" + userCreated.getId())).build();
    }

    @GetMapping("/{userId}")
    public ResponseEntity<UserEntity> findUserById(@PathVariable UUID userId) {

        Optional<UserEntity> user = userService.findById(userId);

        return user.isPresent() ?
            ResponseEntity.ok(user.get()) :
            ResponseEntity.notFound().build();
    }
}
