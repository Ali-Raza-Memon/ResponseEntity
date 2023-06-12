package com.derivedmethods.controller;

import com.derivedmethods.model.Laptop;
import com.derivedmethods.service.LaptopService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
public class LaptopController {

    @Autowired
    public LaptopService laptopService;

    @GetMapping("/getLaptops")
    public  ResponseStatus<List<Laptop>> getLaptops(){


        List<Laptop> list = laptopService.getAllLaptops();

        if(list.size() == 0){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }

        return ResponseEntity.of(Optional.of(list));
    }




    @PostMapping("/addLaptop")
    public Laptop addLaptop(@RequestBody Laptop laptop){
        return laptopService.saveLaptop(laptop);
    }


    @PutMapping("/update")
    public Laptop updateLaptop(@RequestBody Laptop laptop){
        return laptopService.updateLaptop(laptop);
    }


    @DeleteMapping("/delete/{id}")
    public String deleteById(@PathVariable int id){
        return laptopService.deleteById(id);
    }

    @GetMapping("/quality/{quality}")
    public  List<Laptop> findByQuality(@PathVariable String quality){
        return laptopService.getByQuality(quality);
    }




}
