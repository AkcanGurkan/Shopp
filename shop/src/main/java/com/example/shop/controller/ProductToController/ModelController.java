package com.example.shop.controller.ProductToController;

import com.example.shop.service.service.DTO.mapper.ModelMapper;
import com.example.shop.service.service.abstractsInterface.ModelService;
import com.example.shop.service.service.requests.modelRequests.CreateModelRequest;
import com.example.shop.service.service.requests.modelRequests.UpdateModelRequest;
import com.example.shop.service.service.responses.modelResponses.GetAllModelResponse;
import com.example.shop.service.service.responses.modelResponses.GetIdModelResponse;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/model")
@AllArgsConstructor

public class ModelController {

    private ModelService modelService;
    private ModelMapper modelMapper;

    @GetMapping()
    public List<GetAllModelResponse> getAll(){
        return modelService.getAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<GetIdModelResponse> getModelById(@PathVariable int id) {
        GetIdModelResponse response = modelService.getModelById(id);
        return ResponseEntity.ok(response);
    }

    @PostMapping()
    @ResponseStatus(code= HttpStatus.CREATED)
    public void add(@RequestBody CreateModelRequest createModelRequest){
        this.modelService.add(createModelRequest);
    }

    @PutMapping
    public void update(@RequestBody UpdateModelRequest updateModelRequest){
        this.modelService.update(updateModelRequest);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable int id){
        this.modelService.dalete(id);
    }

}
