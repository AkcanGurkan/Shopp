package com.example.shop.controller.ProductToController.productToDoController;


import com.example.shop.service.service.DTO.mapper.productDtoMapper.WatchMapper;
import com.example.shop.service.service.abstractsInterface.productAbs.WatchService;
import com.example.shop.service.service.requests.productRequests.watchRequests.CreateWatchRequest;
import com.example.shop.service.service.requests.productRequests.watchRequests.UpdateWatchRequest;
import com.example.shop.service.service.responses.productResponses.watchResponses.GetAllWatchResponse;
import com.example.shop.service.service.responses.productResponses.watchResponses.GetIdWatchResponse;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/watch")
@AllArgsConstructor
public class WatchController {

    private WatchService watchService;
    private WatchMapper watchMapper;

    @GetMapping()
    public List<GetAllWatchResponse> getAll(){
        return watchService.getAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<GetIdWatchResponse> getWatchById(@PathVariable int id) {
        GetIdWatchResponse response = watchService.getWatchById(id);
        return ResponseEntity.ok(response);
    }
    @PostMapping()
    @ResponseStatus(code= HttpStatus.CREATED)
    public void add(@RequestBody CreateWatchRequest createWatchRequest){
        this.watchService.add(createWatchRequest);
    }

    @PutMapping
    public void update(@RequestBody UpdateWatchRequest updateWatchRequest){
        this.watchService.update(updateWatchRequest);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable int id){
        this.watchService.dalete(id);
    }

}
