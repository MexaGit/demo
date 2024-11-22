package com.example.demo.servicios;

import com.example.demo.models.Prodcuto;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface IOrderService {

    public void saveOrder(List<Prodcuto> prodcutos);
}
