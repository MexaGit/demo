package com.example.demo;

import com.example.demo.Models.Libro;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

//Nuevo artifactory
@RestController // Clases que definen rutas
public class Rutas {

    private static final Logger logger = LoggerFactory.getLogger(Rutas.class);

    @GetMapping("/hola")
    String miPrimeraRuta(){
        System.out.println("Hola Mundo GETMAPPING");
        return "Hola! Mundo";
    }

    @GetMapping("/test")
    String miLista(){
        List<String> newList = Arrays.asList("Ed", "Edd", "Eddy");

        return newList.stream()
                .filter(name2 -> name2.startsWith("E"))
                .collect(Collectors.joining(", "));
    }

    @GetMapping("/libro1/{id}/editorial/{editorial}")
    String leerLibro1(@PathVariable int id, @PathVariable String editorial){
        return "Libro numero id: " + id + " editorial: " + editorial;
    }

    @GetMapping("/libro/{id}")
    String leerLibro(@PathVariable int id, @RequestParam String params, @RequestParam String editorial){
        return "Libro numero id: " + id + ", params " + params + ", editorial " + editorial;
    }

    @PostMapping("/libroMap") // Post llevan un JSON en el body
    String libroLSalvadp(@RequestBody Map<String, Object> libro){ // Mapa es un Dictionario para llave y valor
        libro.keySet().forEach(value -> logger.info("El valor es " + value));
        return "libro guardado";
    }

    @PostMapping("/libroSinMap") // Post llevan un JSON en el body
    String libroLSalvadoSiinMap(@RequestBody Libro libro){
        logger.info("El valor es {} editorial {}", libro.nombre, libro.editorial);

        // if(libro.nombre == null) throw new IllegalArgumentException("Null");
        return "libro guardado";
    }

    @GetMapping("/saludar")
    @ResponseStatus(value=HttpStatus.UNAUTHORIZED, reason="No tienes permisos suficientes!")
    String miSegundaRutaConStatus(){
        return "Aprendiendo status en HTTP en Spring Boot";
    }

    @GetMapping("/animales/{lugar}")
    public ResponseEntity<String> getAnimals(@PathVariable String lugar){
        if (lugar.equals("granja")){
            return ResponseEntity.status(HttpStatus.OK).body("Caballo");
        }else if(lugar.equals("selva")){
            return ResponseEntity.status(HttpStatus.OK).body("mono");
        }else{
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("No existe");
        }
    }

    @GetMapping("/calcular/{numero}")
    public int getCaulculo(@PathVariable int numero){
        throw new NullPointerException("Esta exception ocurrio porque esta informacion no debe saber el cliente");
    }

    @GetMapping("/userData")
    public ResponseEntity<String> getUserData(){
        return ResponseEntity
                .status(HttpStatus.OK)
                .header("Content-Type", "application/jason")
                .body("{\"name\": \"mary\"}");
    }

    @GetMapping("/userData/v2")
    public Map<String, Map<String, Object>> getUserDataV2(){
        return Map.of("user", Map.of("name", "mary", "age",30));
    }

}
