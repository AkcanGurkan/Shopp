package com.example.shop.controller.ProductToController.productToDoController;


import com.example.shop.service.service.DTO.mapper.productDtoMapper.TvMapper;
import com.example.shop.service.service.abstractsInterface.productAbs.TvService;
import com.example.shop.service.service.requests.productRequests.tvRequest.CreateTvRequest;
import com.example.shop.service.service.requests.productRequests.tvRequest.UpdateTvRequest;
import com.example.shop.service.service.responses.productResponses.TvResponses.GetAllTvResponse;
import com.example.shop.service.service.responses.productResponses.TvResponses.GetIdTvResponse;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/tv")
@AllArgsConstructor

public class TvController {

    private TvService tvService;
    private TvMapper tvMapper;

    @GetMapping()
    public List<GetAllTvResponse> getAll(){
        return tvService.getAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<GetIdTvResponse> getTvById(@PathVariable int id) {
        GetIdTvResponse response = tvService.getTvlById(id);
        return ResponseEntity.ok(response);
    }
    @PostMapping()
    @ResponseStatus(code= HttpStatus.CREATED)
    public void add(@RequestBody CreateTvRequest createTvRequest){
        this.tvService.add(createTvRequest);
    }

    @PutMapping
    public void update(@RequestBody UpdateTvRequest updateTvRequest){
        this.tvService.update(updateTvRequest);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable int id){
        this.tvService.dalete(id);
    }


}
