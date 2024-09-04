package com.example.shop.controller.ProductToController.productToDoController;


import com.example.shop.service.service.DTO.mapper.productDtoMapper.ComputerMapper;
import com.example.shop.service.service.abstractsInterface.productAbs.ComputerService;
import com.example.shop.service.service.requests.productRequests.computerRequests.CreateComputerRequest;
import com.example.shop.service.service.requests.productRequests.computerRequests.UpdateComputerRequest;
import com.example.shop.service.service.responses.productResponses.computerResponses.GetAllComputerResponse;
import com.example.shop.service.service.responses.productResponses.computerResponses.GetIdComputerResponse;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/computer")
@AllArgsConstructor
public class ComputerController {

    private ComputerService computerService;
    private ComputerMapper computerMapper;

    @GetMapping()
    public List<GetAllComputerResponse> getAll(){
        return computerService.getAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<GetIdComputerResponse> getTvById(@PathVariable int id) {
        GetIdComputerResponse response = computerService.getTvlById(id);
        return ResponseEntity.ok(response);
    }
    @PostMapping()
    @ResponseStatus(code= HttpStatus.CREATED)
    public void add(@RequestBody CreateComputerRequest createComputerRequest){
        this.computerService.add(createComputerRequest);
    }

    @PutMapping
    public void update(@RequestBody UpdateComputerRequest updateComputerRequest){
        this.computerService.update(updateComputerRequest);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable int id){
        this.computerService.dalete(id);
    }
}
