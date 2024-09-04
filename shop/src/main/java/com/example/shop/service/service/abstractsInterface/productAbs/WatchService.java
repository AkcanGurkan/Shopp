package com.example.shop.service.service.abstractsInterface.productAbs;

import com.example.shop.service.service.requests.productRequests.watchRequests.CreateWatchRequest;
import com.example.shop.service.service.requests.productRequests.watchRequests.UpdateWatchRequest;
import com.example.shop.service.service.responses.productResponses.watchResponses.GetAllWatchResponse;
import com.example.shop.service.service.responses.productResponses.watchResponses.GetIdWatchResponse;

import java.util.List;

public interface WatchService {

    List<GetAllWatchResponse> getAll();
    GetIdWatchResponse getWatchById(int id);
    void add(CreateWatchRequest createWatchRequest);
    void update(UpdateWatchRequest updateWatchRequest);
    void dalete(int id);
}
