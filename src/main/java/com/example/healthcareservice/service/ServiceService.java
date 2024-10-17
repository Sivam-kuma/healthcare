package com.example.healthcareservice.service;

import com.example.healthcareservice.model.HealthcareService;
import com.example.healthcareservice.repository.ServiceRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service; // Ensure the correct import

import java.util.List;
import java.util.Optional;

@Service
public class ServiceService {

    @Autowired
    private ServiceRepository serviceRepository;

    public HealthcareService addService(HealthcareService service) {
        return serviceRepository.save(service);
    }

    public List<HealthcareService> getAllServices() {
        return serviceRepository.findAll();
    }

    public Optional<HealthcareService> getServiceById(String id) {
        return serviceRepository.findById(id);
    }

    public HealthcareService updateService(String id, HealthcareService serviceDetails) {
        Optional<HealthcareService> service = serviceRepository.findById(id);
        if (service.isPresent()) {
            HealthcareService existingService = service.get();
            existingService.setName(serviceDetails.getName());
            existingService.setDescription(serviceDetails.getDescription());
            existingService.setPrice(serviceDetails.getPrice());
            return serviceRepository.save(existingService);
        }
        return null;
    }

    public void deleteService(String id) {
        serviceRepository.deleteById(id);
    }
}
