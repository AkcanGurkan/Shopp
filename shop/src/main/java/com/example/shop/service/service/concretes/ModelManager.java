package com.example.shop.service.service.concretes;

import com.example.shop.entity.entities.Model;
import com.example.shop.repository.productRepositories.ModelRepository;
import com.example.shop.service.service.DTO.mapper.ModelMapper;
import com.example.shop.service.service.abstractsInterface.ModelService;
import com.example.shop.service.service.requests.modelRequests.CreateModelRequest;
import com.example.shop.service.service.requests.modelRequests.UpdateModelRequest;
import com.example.shop.service.service.responses.modelResponses.GetAllModelResponse;
import com.example.shop.service.service.responses.modelResponses.GetIdModelResponse;
import jakarta.persistence.EntityNotFoundException;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class ModelManager implements ModelService {

    private ModelRepository modelRepository;
    private ModelMapper modelMapper;


    @Override
    public List<GetAllModelResponse> getAll() {
        List<Model> models = modelRepository.findAll();
        return models.stream()
                .map(modelMapper::toGetAllModelResponse)
                .collect(Collectors.toList());
    }
    @Override
    public GetIdModelResponse getModelById(int id) {
        Model model = modelRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Model not found with id: " + id));
        return modelMapper.toGetIdModelResponse(model);
    }
    @Override
    public void add(CreateModelRequest createModelRequest) {

        Model model = modelMapper.toModel(createModelRequest);
        modelRepository.save(model);
    }
    @Override
    public void update(UpdateModelRequest updateModelRequest) {
        Model model = modelMapper.toModel(updateModelRequest);
        this.modelRepository.save(model);
    }
    @Override
    public void dalete(int id) {
        this.modelRepository.deleteById(id);
    }

}





