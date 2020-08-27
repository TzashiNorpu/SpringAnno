package com.tz.bean;

import lombok.AllArgsConstructor;
import lombok.Data;
import org.springframework.stereotype.Component;

//@Component("car1")
@Component
@Data
public class Car {

    private String brand = "Haval";

    public Car(String brand) {
        this.brand = brand;
        System.out.println("car constructor with one para...");
    }

    public Car() {
        System.out.println("car constructor...");
    }

    public void init() {
        System.out.println("car ... init...");
    }

    public void destroy() {
        System.out.println("car ... destroy...");
    }

}
