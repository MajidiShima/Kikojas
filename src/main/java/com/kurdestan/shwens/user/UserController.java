package com.kurdestan.shwens.user;


import lombok.AllArgsConstructor;
import lombok.val;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


@RestController
@AllArgsConstructor
@RequestMapping("/User")
public class UserController {
    private final UserService service;
    private final UserIMapper mapper;


    @PostMapping
    public ResponseEntity<Void> save(@RequestBody UserDTO userDTO) {
        User user = mapper.toUser(userDTO);
        service.save(user);
        return ResponseEntity.status(HttpStatus.CREATED).build();
    }

    @PutMapping
    public ResponseEntity<UserDTO> update(@RequestBody UserDTO userDTO) {
        User user = mapper.toUser(userDTO);
        val userDTO1 = mapper.toUserDTO(service.update(user));
        return ResponseEntity.ok(userDTO1);
    }


    @GetMapping("/{id}")
    public ResponseEntity<UserDTO> getById(@PathVariable Long id) {
        User user = service.getById(id);
        UserDTO userDTO = mapper.toUserDTO(user);
        return ResponseEntity.ok(userDTO);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<UserDTO> delete(@PathVariable Long id) {
        service.delete(id);
        return ResponseEntity.ok().build();
    }


}
