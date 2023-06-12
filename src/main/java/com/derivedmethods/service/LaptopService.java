package com.derivedmethods.service;

import com.derivedmethods.model.Laptop;
import com.derivedmethods.repository.LaptopRepository;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Service
public class LaptopService {

    @Autowired
    public LaptopRepository laptopRepository;


    public Laptop saveLaptop(Laptop laptop){
        return laptopRepository.save(laptop);
    }

    public List<Laptop> getLaptops(){
        return laptopRepository.findAll();
    }

    public Laptop updateLaptop(Laptop laptop){
        Laptop existingLaptop = laptopRepository.findById(laptop.getId()).orElse(null);
                existingLaptop.setColor(laptop.getColor());
                existingLaptop.setSize(laptop.getSize());
                existingLaptop.setQuality(laptop.getQuality());
                existingLaptop.setQuantity(laptop.getQuantity());
                return laptopRepository.save(existingLaptop);
    }

    public String deleteById(int id) {
        laptopRepository.deleteById(id);
        return "removed laptop"+id;
    }


    public List<Laptop> getByQuality(String quality) {
        return laptopRepository.findByQuality(quality);
    }


    public List<Laptop> getAllLaptops() {
        return  laptopRepository.findAll();
    }
}
