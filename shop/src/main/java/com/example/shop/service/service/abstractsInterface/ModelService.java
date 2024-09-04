package com.example.shop.service.service.abstractsInterface;

import com.example.shop.service.service.requests.modelRequests.CreateModelRequest;
import com.example.shop.service.service.requests.modelRequests.UpdateModelRequest;
import com.example.shop.service.service.responses.modelResponses.GetAllModelResponse;
import com.example.shop.service.service.responses.modelResponses.GetIdModelResponse;

import java.util.List;

public interface ModelService {

    List<GetAllModelResponse> getAll();
    GetIdModelResponse getModelById(int id);
    void add(CreateModelRequest createModelRequest);
   void update(UpdateModelRequest updateModelRequest);
   void dalete(int id);
}
