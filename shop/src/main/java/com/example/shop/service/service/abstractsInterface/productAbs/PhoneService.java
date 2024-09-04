package com.example.shop.service.service.abstractsInterface.productAbs;

import com.example.shop.service.service.requests.productRequests.phoneRequests.CreatePhoneRequest;
import com.example.shop.service.service.requests.productRequests.phoneRequests.UpdatePhoneRequest;
import com.example.shop.service.service.responses.productResponses.phoneResponses.GetAllPhoneResponse;
import com.example.shop.service.service.responses.productResponses.phoneResponses.GetIdPhoneResponse;

import java.util.List;

public interface PhoneService {

    List<GetAllPhoneResponse> getAll();
    GetIdPhoneResponse getTvlById(int id);
    void add(CreatePhoneRequest createPhoneRequest);
    void update(UpdatePhoneRequest updatePhoneRequest);
    void dalete(int id);
}
