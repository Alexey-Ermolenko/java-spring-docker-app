package com.example.app.service;

import com.example.app.dto.CreateVehicleDto;
import com.example.app.dto.VehicleDto;

import java.util.List;
import java.util.UUID;

public interface VehicleServiceInterface {
    CreateVehicleDto saveVehicle(CreateVehicleDto createVehicleDto);
    List<VehicleDto> getAllVehicles();
    VehicleDto getVehicleById(UUID id);
    List<VehicleDto> findVehicleByName(String name);
    List<VehicleDto> findFixedVehicles();
    List<VehicleDto> findNotFixedVehicles();
}
