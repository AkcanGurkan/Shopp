package com.example.shop.service.service.abstractsInterface.productAbs;

import com.example.shop.service.service.requests.productRequests.computerRequests.CreateComputerRequest;
import com.example.shop.service.service.requests.productRequests.computerRequests.UpdateComputerRequest;
import com.example.shop.service.service.responses.productResponses.computerResponses.GetAllComputerResponse;
import com.example.shop.service.service.responses.productResponses.computerResponses.GetIdComputerResponse;

import java.util.List;

public interface ComputerService {
    List<GetAllComputerResponse> getAll();
    GetIdComputerResponse getTvlById(int id);
    void add(CreateComputerRequest createComputerRequest);
    void update(UpdateComputerRequest updateComputerRequest);
    void dalete(int id);
}
