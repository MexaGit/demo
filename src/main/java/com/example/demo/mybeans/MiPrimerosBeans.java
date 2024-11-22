package com.example.demo.mybeans;

import com.example.demo.models.Prodcuto;
import com.example.demo.servicios.IOrderService;
import com.example.demo.servicios.OrderService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.List;

// singlenton
@Configuration
public class MiPrimerosBeans {

    @Bean
    public MiBean crearMiBean(){
        return new MiBean();
    }

    @Bean
    public IOrderService instanciarOrderService(){
        boolean esProduccion = true;

        if(esProduccion){
            return new OrderService();
        }{
            return new IOrderService() {
                @Override
                public void saveOrder(List<Prodcuto> prodcutos) {
                    System.out.println("Guardando en base datos dummy (local)");
                }
            };
        }
    }
}
