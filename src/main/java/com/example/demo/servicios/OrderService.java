package com.example.demo.servicios;

import com.example.demo.Rutas;
import com.example.demo.models.Prodcuto;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
//import org.springframework.stereotype.Service;

import java.util.List;

//@Service se comenta para yo tener control de esta clase
public class OrderService implements IOrderService {

    @Value("${miurls.database.test}")
    private String databaseURL;

    private final Logger logger = LoggerFactory.getLogger(OrderService.class);

    public OrderService(){}

    public void saveOrder(List<Prodcuto> prodcutos){
        System.out.println("Guardando en la base de datos, la url: " + databaseURL);

        prodcutos.forEach(prodcuto -> logger.debug("el nombre del producto: {} ", prodcuto.nombre));
    }
}
