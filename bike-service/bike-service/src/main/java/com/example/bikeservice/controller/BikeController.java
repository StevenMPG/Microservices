package com.example.bikeservice.controller;

import com.example.bikeservice.entity.Bike;
import com.example.bikeservice.service.BikeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@RestController
@RequestMapping("/bike")
public class BikeController {

    @Autowired
    BikeService bikeService;

    @GetMapping
    public ResponseEntity<List<Bike>> getAll() {

        List<Bike> bikes = bikeService.getAll();
        if (bikes.isEmpty())
            return  ResponseEntity.noContent().build();

        return ResponseEntity.ok(bikes);

    }

    @GetMapping("/{id}")
    public ResponseEntity <Bike> getById(@PathVariable("id") int id ) {

        Bike bike = bikeService.getBikeById(id);
        if (bike== null)
            return  ResponseEntity.notFound().build();

        return ResponseEntity.ok(bike);

    }

    @PostMapping
    public ResponseEntity <Bike> save(@RequestBody Bike bike ) {

        Bike carNew = bikeService.save(bike);
        return ResponseEntity.ok(carNew);

    }

    @GetMapping("/byuser/{userId}")
    public ResponseEntity<List<Bike>> getByUserId(@PathVariable("userId") int userId) {

        List<Bike> cars = bikeService.byUserId(userId);

        return ResponseEntity.ok(cars);

    }
}
