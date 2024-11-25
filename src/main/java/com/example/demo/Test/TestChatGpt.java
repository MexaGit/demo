package com.example.demo.Test;

import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

<<<<<<< Updated upstream
import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
=======
import java.util.Map;
>>>>>>> Stashed changes

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

<<<<<<< Updated upstream
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

    @GetMapping("/verificar-edad")
    public String verificarEdad(@RequestParam(required = false) String edad) {
        if (edad == null || edad.isEmpty()) {
            return "Edad no proporcionada"; // verificar-edad
        } else {
            return "La edad proporcionada es: " + edad; // verificar-edad?edad=25
        }
    }

    @GetMapping("/verificar-edad")
    public String verificarEdad2(@RequestParam(defaultValue = "desconocida") String edad) {
        return "La edad proporcionada es: " + edad;
    }

    @GetMapping("/usuario/{id}")
    public ResponseEntity<String> obtenerUsuario(@PathVariable int id) {
        if (id > 100){
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                    .body("Usuario no encontrado");
        }else{
            return ResponseEntity.status(HttpStatus.OK)
                    .body("Usuario con ID " + id + " encontrado");
        }
    }

//    @PostMapping("/usuario/crear")
//    public ResponseEntity<String> crearUsuario(@RequestBody Usuario usuario) {
//        if (usuario.nombre.isEmpty() || usuario.edad < 0){
//            return ResponseEntity.status(HttpStatus.BAD_REQUEST)
//                    .body("Datos invalidos");
//        }else{
//            return ResponseEntity.status(HttpStatus.CREATED)
//                    .body("Usuario creado: " + usuario.nombre + " edad: " + usuario.edad);
//        }
//    }

    @PostMapping("/usuario/crear")
    public ResponseEntity<String> crearUsuario(@RequestBody Usuario usuario) {
        if (usuario.getNombre() == null || usuario.getNombre().isEmpty() || usuario.getEdad() <= 0) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST)
                    .body("Datos inválidos");
        }
        return ResponseEntity.status(HttpStatus.CREATED)
                .body("Usuario creado: " + usuario.getNombre() + ", edad: " + usuario.getEdad());
    }

    @PostMapping("/usuario/actualizar")
    public ResponseEntity<String> actualizarUsuario(@RequestBody Usuario usuario) {
        if (usuario.getNombre() == null || usuario.getNombre().isEmpty() || usuario.getEdad() <= 0) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST)
                    .body("Usuario no encontrado");
        }
        return ResponseEntity.status(HttpStatus.OK)
                .body("Usuario actualizado: " + usuario.getNombre() + ", edad: " + usuario.getEdad());
    }


    @PostMapping("/filtrar-nombres")
    public List<String> filtrarNombres(@RequestBody List<String> nombres) {
        if (nombres == null || nombres.isEmpty()) {
            return Collections.emptyList(); // Manejo de lista vacía
        }
        return nombres.stream()
                .filter(name -> name.toUpperCase().startsWith("A")) // Ignorar mayúsculas/minúsculas
                .collect(Collectors.toList());
    }

    @PostMapping("/procesar-nombres")
    public List<String> procesarNombres(@RequestBody List<String> nombres) {
        return nombres.stream()
                .filter(name -> name.length() > 3) // Filtrar nombres con más de 3 caracteres
                .map(String::toUpperCase)         // Transformar a mayúsculas
                .sorted()                         // Ordenar alfabéticamente
                .collect(Collectors.toList());    // Recoger en una lista
    }
=======
//    @GetMapping("/product/{id}")
//    ResponseEntity<String> getProduct(@PathVariable int id) {
//        if (id > 0) {
//            return ResponseEntity.status(HttpStatus.ACCEPTED)
//                    .body("Producto con ID " + id + " encontrado");
//        } else {
//            return ResponseEntity.status(HttpStatus.BAD_REQUEST)
//                    .body("El ID " + id + " no es válido.");
//        }
//    }

    String noumber(){ return "";}
>>>>>>> Stashed changes
}


class User {
    private String name;

    public Map<Object, Object> getName() {
        return null;
    }
    // Getters y setters (puedes usar Lombok aquí si lo prefieres)
}