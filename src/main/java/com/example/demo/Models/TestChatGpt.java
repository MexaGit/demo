package com.example.demo.Models;

import jakarta.validation.Valid;
import jakarta.websocket.server.PathParam;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController
public class TestChatGpt {

    @GetMapping("/hello")
    String getRespuesta(){
        return "Hola estas usando Get";
    }

    @PostMapping("/create")
    String postRespuesa(@RequestParam String name){
        return "Nombre del usuario es " + name;
    }


    @GetMapping("/user/{id}")
    public ResponseEntity<String> getUserById(@PathVariable Long id) {
        // Lógica simulada
        if (id == 1) {
            return ResponseEntity.ok("Usuario encontrado: Eddie");
        }else{
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                    .body("Usuario NO encontrado");
            //return ResponseEntity.notFound().build();
        }
    }

    @PostMapping("/users")
    public ResponseEntity<String> createUser(@Valid @RequestBody User user) {
        // Validación simulada: Si el nombre está vacío, falla
        if (user.getName() == null || user.getName().isEmpty()) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST)
                    .body("El usuario esta vacio");
        }
        return ResponseEntity.status(HttpStatus.CREATED)
                .body("El usuario fue creado correctamente");
    }

    @GetMapping("/product/{id}")
    ResponseEntity<String> getProduct(@PathVariable int id) {
        if (id > 0) {
            return ResponseEntity.status(HttpStatus.ACCEPTED)
                    .body("Producto con ID " + id + " encontrado");
        } else {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST)
                    .body("El ID " + id + " no es válido.");
        }
    }

}


class User {
    private String name;

    public Map<Object, Object> getName() {
        return null;
    }
    // Getters y setters (puedes usar Lombok aquí si lo prefieres)
}