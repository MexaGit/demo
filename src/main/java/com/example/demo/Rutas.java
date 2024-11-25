package com.example.demo;

<<<<<<< Updated upstream
import com.example.demo.models.Libro;
import com.example.demo.models.Prodcuto;
import com.example.demo.models.UserDAta;
import com.example.demo.mybeans.MiComponente;
import com.example.demo.servicios.IOrderService;
import com.example.demo.servicios.OrderService;
import com.example.demo.mybeans.MiBean;
=======
import com.example.demo.Models.Libro;
import com.example.demo.Models.UserData;
>>>>>>> Stashed changes
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;
import java.util.MissingFormatArgumentException;

@RestController
public class Rutas {

    // Dependencia Dura - NOO
    // private OrderService orderService = new OrderService():
    private IOrderService orderService;
    // private OrderService orderService;
    private MiBean miBean;
    private MiComponente miComponente;

//    @Autowired
//    private MiComponente miComponente;

    public Rutas(IOrderService orderService, MiBean miBean, MiComponente miComponente){
        this.orderService = orderService;
        this.miBean = miBean;
        this.miComponente = miComponente;
    }

    private final Logger logger = LoggerFactory.getLogger(Rutas.class);

    @GetMapping("/ruta")
    String miPrimeraRuta(){
        return "hola mundo";
    }

    @GetMapping("/libro/{id2}/editorial/{editorial}")
    String miPrimeraRuta(@PathVariable int id2, @PathVariable String editorial){
        return "Leyendo el libro id: " + id2 + " and editorial: " + editorial;
    }

    @GetMapping("/libro2/{id2}")
    String miPrimeraRuta2(@PathVariable int id2, @RequestParam String cualquierNombre, @RequestParam String editorial){
        return "Leyendo el libro id: " + id2 + ", params: " + cualquierNombre + " editorial: " + editorial;
    }

    @PostMapping("/libro")
    String guardarLibro(@RequestBody Libro libro){
        logger.debug("libro {} editorial {}", libro.nombre, libro.editorial);

        return "libro guardado" ;
    }

//    String guardarLibro(@RequestBody Map<String, Object> libro){
//        libro.keySet().forEach(llave -> {
//            logger.debug("llave {} valor {}", llave, libro.get(llave));
//        });
//        return "libro guardado";
//    }


    @GetMapping("/saludar")
    @ResponseStatus(value = HttpStatus.MOVED_PERMANENTLY, reason="Fue movida a la version API 1.0")
    String miSegundaRutaStatus(){
        return "Aprendiendo status http en spring Boot";
    }

    @GetMapping("/animales/{lugar}")
    public ResponseEntity<String> getAnimals(@PathVariable String lugar){
        if (lugar.contains("granja")){
            return ResponseEntity.status(HttpStatus.OK).body("Caballo, vaca, cerdo, gallo, oveja, toro");
        }else if (lugar.equals("selva")){
            return ResponseEntity.status(HttpStatus.OK).body("Cocodrilo, chango, anaconda, tortuga");
        }else{
            return  ResponseEntity.status(HttpStatus.BAD_REQUEST).body("lugar valido");
        }
    }

    @GetMapping("/calcular/{numero}")
    public int getCalculo(@PathVariable int numero){
        throw new NullPointerException("la clave del usuario es password1234");
    }

    @GetMapping("/userData")
    public ResponseEntity<String> getUserData(){
        return ResponseEntity
                .status(HttpStatus.OK)
<<<<<<< Updated upstream
                .header("Content-Type", "application/jason")
                .body("{\"name\": \"mary\"}");
=======
                .header("Content-Type", "application/json")
                .body("{\"name\":\"mary\"}");
>>>>>>> Stashed changes
    }

    @GetMapping("/userData/v2")
    public Map<String, Map<String, Object>> getUserDataV2(){
<<<<<<< Updated upstream
        return Map.of("user", Map.of("name", "mary", "age",30));
    }

    @GetMapping("/userData/v3")
    public UserDAta getUserDataV3(){
        return new UserDAta("mary", 30, "alameda1234");
    }

    @PostMapping("/order")
    public String createdOrder(@RequestBody List<Prodcuto> products){
        orderService.saveOrder(products);
        return "productos guardados";
    }

    @GetMapping("/mibean")
    public String saludarDesdeBean(){
        miBean.saludar();
        return "Completado";
    }

    @GetMapping("/micomponente")
    public String saludarDesdeComponente(){
        miComponente.saludarDesdeComponente();
        return "Completado miComponente";
    }
=======
        return Map.of("user", Map.of("name", "mary", "age", 25));
    }

    @GetMapping("/userData/v3")
    public UserData getUserDataV3(){
        return new UserData("mary", 26);
    }


>>>>>>> Stashed changes

}
