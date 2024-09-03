package com.example.shop.service.service.abstractsInterface;

import com.example.shop.service.service.requests.brandRequests.CreateBrandRequest;
import com.example.shop.service.service.requests.brandRequests.UpdateBrandRequest;
import com.example.shop.service.service.responses.brandResponses.GetAllBrandsResponse;
import com.example.shop.service.service.responses.brandResponses.GetIdBrandResponse;

import java.util.List;

public interface BrandService {

    List<GetAllBrandsResponse> getAll();
    GetIdBrandResponse getBrandById(int id);

    void add(CreateBrandRequest createBrandRequest);
    void update(UpdateBrandRequest updateBrandRequest);
    void dalete(int id);
}
