package com.example.shop.controller.ProductToController;

import com.example.shop.service.service.DTO.mapper.BrandMapper;
import com.example.shop.service.service.abstractsInterface.BrandService;
import com.example.shop.service.service.requests.brandRequests.CreateBrandRequest;
import com.example.shop.service.service.requests.brandRequests.UpdateBrandRequest;
import com.example.shop.service.service.responses.brandResponses.GetAllBrandsResponse;
import com.example.shop.service.service.responses.brandResponses.GetIdBrandResponse;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/brand")
@AllArgsConstructor
public class BrandsController {

    private BrandService brandService;
    private BrandMapper brandMapper;

    @GetMapping()
    public List<GetAllBrandsResponse> getAll(){
        return brandService.getAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<GetIdBrandResponse> getBrandById(@PathVariable int id) {
        GetIdBrandResponse response = brandService.getBrandById(id);
        return ResponseEntity.ok(response);
    }

    @PostMapping()
    @ResponseStatus(code= HttpStatus.CREATED)
    public void add(@RequestBody CreateBrandRequest createBrandRequest){
        this.brandService.add(createBrandRequest);
    }

    @PutMapping
    public void update(@RequestBody UpdateBrandRequest updateBrandRequest){
        this.brandService.update(updateBrandRequest);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable int id){
        this.brandService.dalete(id);
    }




}














