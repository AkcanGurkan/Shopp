package com.example.shop.service.service.abstractsInterface.productAbs;

import com.example.shop.service.service.requests.productRequests.headsetRequests.CreateHeadsetRequest;
import com.example.shop.service.service.requests.productRequests.headsetRequests.UpdateHeadsetRequest;
import com.example.shop.service.service.responses.productResponses.headsetResponses.GetAllHeadsetResponse;
import com.example.shop.service.service.responses.productResponses.headsetResponses.GetIdHeadsetResponse;

import java.util.List;

public interface HeadsetService {
    List<GetAllHeadsetResponse> getAll();
    GetIdHeadsetResponse getTvlById(int id);
    void add(CreateHeadsetRequest createHeadsetRequest);
    void update(UpdateHeadsetRequest updateHeadsetRequest);
    void dalete(int id);
}
