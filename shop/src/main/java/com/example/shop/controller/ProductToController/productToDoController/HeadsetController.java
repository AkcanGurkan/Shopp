package com.example.shop.controller.ProductToController.productToDoController;


import com.example.shop.service.service.DTO.mapper.productDtoMapper.HeadsetMapper;
import com.example.shop.service.service.abstractsInterface.productAbs.HeadsetService;
import com.example.shop.service.service.requests.productRequests.headsetRequests.CreateHeadsetRequest;
import com.example.shop.service.service.requests.productRequests.headsetRequests.UpdateHeadsetRequest;
import com.example.shop.service.service.responses.productResponses.headsetResponses.GetAllHeadsetResponse;
import com.example.shop.service.service.responses.productResponses.headsetResponses.GetIdHeadsetResponse;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/headset")
@AllArgsConstructor
public class HeadsetController {

    private HeadsetService headsetService;
    private HeadsetMapper headsetMapper;

    @GetMapping()
    public List<GetAllHeadsetResponse> getAll(){
        return headsetService.getAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<GetIdHeadsetResponse> getTvById(@PathVariable int id) {
        GetIdHeadsetResponse response = headsetService.getTvlById(id);
        return ResponseEntity.ok(response);
    }
    @PostMapping()
    @ResponseStatus(code= HttpStatus.CREATED)
    public void add(@RequestBody CreateHeadsetRequest createHeadsetRequest){
        this.headsetService.add(createHeadsetRequest);
    }

    @PutMapping
    public void update(@RequestBody UpdateHeadsetRequest updateHeadsetRequest){
        this.headsetService.update(updateHeadsetRequest);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable int id){
        this.headsetService.dalete(id);
    }

}
