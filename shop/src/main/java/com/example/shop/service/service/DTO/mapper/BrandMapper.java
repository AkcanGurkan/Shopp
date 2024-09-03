package com.example.shop.service.service.DTO.mapper;

import com.example.shop.entity.entities.Brand;
import com.example.shop.service.service.requests.brandRequests.CreateBrandRequest;
import com.example.shop.service.service.requests.brandRequests.UpdateBrandRequest;
import com.example.shop.service.service.responses.brandResponses.GetAllBrandsResponse;
import com.example.shop.service.service.responses.brandResponses.GetIdBrandResponse;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface BrandMapper {

    Brand toBrand(GetAllBrandsResponse getAllBrandsResponse);
    GetAllBrandsResponse toGetAllBrandsResponse(Brand brand);

    Brand toBrand(CreateBrandRequest createBrandRequest);
    CreateBrandRequest toCreateBrandRequest(Brand brand);

    Brand toBrand(UpdateBrandRequest updateBrandRequest);
    UpdateBrandRequest toUpdateBrandRequest(Brand brand);

    Brand toBrand(GetIdBrandResponse getIdBrandResponse);
    GetIdBrandResponse toGetIdBrandResponse(Brand brand);

}
