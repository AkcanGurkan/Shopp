package com.example.shop.controller.ProductToController.productToDoController;


import com.example.shop.service.service.DTO.mapper.productDtoMapper.PhoneMapper;
import com.example.shop.service.service.abstractsInterface.productAbs.PhoneService;
import com.example.shop.service.service.requests.productRequests.phoneRequests.CreatePhoneRequest;
import com.example.shop.service.service.requests.productRequests.phoneRequests.UpdatePhoneRequest;
import com.example.shop.service.service.responses.productResponses.phoneResponses.GetAllPhoneResponse;
import com.example.shop.service.service.responses.productResponses.phoneResponses.GetIdPhoneResponse;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/phone")
@AllArgsConstructor
public class PhoneController {

    private PhoneService phoneService;
    private PhoneMapper phoneMapper;

    @GetMapping()
    public List<GetAllPhoneResponse> getAll(){
        return phoneService.getAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<GetIdPhoneResponse> getTvById(@PathVariable int id) {
        GetIdPhoneResponse response = phoneService.getTvlById(id);
        return ResponseEntity.ok(response);
    }
    @PostMapping()
    @ResponseStatus(code= HttpStatus.CREATED)
    public void add(@RequestBody CreatePhoneRequest createPhoneRequest){
        this.phoneService.add(createPhoneRequest);
    }

    @PutMapping
    public void update(@RequestBody UpdatePhoneRequest updatePhoneRequest){
        this.phoneService.update(updatePhoneRequest);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable int id){
        this.phoneService.dalete(id);
    }



}
