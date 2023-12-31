package com.example.app.service;

import com.example.app.repository.VehicleRepository;
import com.example.app.dto.CreateVehicleDto;
import com.example.app.dto.VehicleDto;
import com.example.app.model.Vehicle;
import org.modelmapper.ModelMapper;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;
import java.util.UUID;
import java.util.stream.Collectors;

@Service
public class VehicleService implements VehicleServiceInterface {

    private final VehicleRepository vehicleRepository;
    private final ModelMapper modelMapper;

    public VehicleService(VehicleRepository vehicleRepository, ModelMapper modelMapper) {
        this.vehicleRepository = vehicleRepository;
        this.modelMapper = modelMapper;
    }

    @Override
    @Transactional
    public CreateVehicleDto saveVehicle(CreateVehicleDto createVehicleDto) {
        Vehicle vehicle = modelMapper.map(createVehicleDto, Vehicle.class);
        vehicle.setFixed(false);
        Vehicle persistedEntity = vehicleRepository.save(vehicle);
        return modelMapper.map(persistedEntity, CreateVehicleDto.class);
    }

    public VehicleDto fixVehicleById(UUID id) {
        Vehicle vehicleToUpdate = vehicleRepository.getById(id);
        vehicleToUpdate.setFixed(true);
        vehicleRepository.save(vehicleToUpdate);
        return modelMapper.map(vehicleToUpdate, VehicleDto.class);
    }

    @Override
    @Transactional
    public List<VehicleDto> getAllVehicles() {
        List<Vehicle> allVehicles = vehicleRepository.findAll();
        return allVehicles.stream()
                .map(vehicle -> modelMapper.map(allVehicles, VehicleDto.class))
                .collect(Collectors.toList());
    }

    @Override
    @Transactional
    public VehicleDto getVehicleById(UUID id) {
        Optional<Vehicle> vehicleById = vehicleRepository.findById(id);
        return modelMapper.map(vehicleById, VehicleDto.class);
    }

    @Override
    @Transactional
    public List<VehicleDto> findVehicleByName(String name) {
        return vehicleRepository.findByName(name)
                .stream()
                .map(vehicle -> modelMapper.map(vehicle,VehicleDto.class))
                .collect(Collectors.toList());
    }

    @Transactional
    public List<VehicleDto> findByRegistrationNumber(String registrationNumber){
        List<Vehicle> vehicleByRegistration = vehicleRepository.findByRegistrationNumberAndFixed(registrationNumber);
        return vehicleByRegistration.stream()
                .map(vehicle -> modelMapper.map(vehicle, VehicleDto.class))
                .collect(Collectors.toList());
    }

    @Override
    public List<VehicleDto> findFixedVehicles() {
        return vehicleRepository.findByFixed(Sort.by(Sort.Direction.DESC, "updatedAt"))
                .stream()
                .map(vehicle -> modelMapper.map(vehicle, VehicleDto.class))
                .collect(Collectors.toList());
    }

    @Override
    public List<VehicleDto> findNotFixedVehicles() {
        return vehicleRepository.findNotFixed(Sort.by(Sort.Direction.ASC, "createdAt"))
                .stream()
                .map(vehicle -> modelMapper.map(vehicle, VehicleDto.class))
                .collect(Collectors.toList());
    }
}
