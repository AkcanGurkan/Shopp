package com.example.shop.service.service.abstractsInterface.productAbs;

import com.example.shop.service.service.requests.productRequests.tvRequest.CreateTvRequest;
import com.example.shop.service.service.requests.productRequests.tvRequest.UpdateTvRequest;
import com.example.shop.service.service.responses.productResponses.TvResponses.GetAllTvResponse;
import com.example.shop.service.service.responses.productResponses.TvResponses.GetIdTvResponse;

import java.util.List;

public interface TvService {

    List<GetAllTvResponse> getAll();
    GetIdTvResponse getTvlById(int id);
    void add(CreateTvRequest createTvRequest);
    void update(UpdateTvRequest updateTvRequest);
    void dalete(int id);
}
