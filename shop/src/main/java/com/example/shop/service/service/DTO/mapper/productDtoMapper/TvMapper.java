package com.example.shop.service.service.DTO.mapper.productDtoMapper;

import com.example.shop.entity.entities.productEntities.Tv;
import com.example.shop.service.service.requests.productRequests.tvRequest.CreateTvRequest;
import com.example.shop.service.service.requests.productRequests.tvRequest.UpdateTvRequest;
import com.example.shop.service.service.responses.productResponses.TvResponses.GetAllTvResponse;
import com.example.shop.service.service.responses.productResponses.TvResponses.GetIdTvResponse;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface TvMapper {

    @Mapping(source = "id", target = "id")
    @Mapping(source = "name", target = "name")
    @Mapping(source = "brandName", target = "brand.name")
    @Mapping(source = "modelName", target = "model.name")
    Tv toTv(GetAllTvResponse getAllTvResponse);
    @Mapping(source = "id", target = "id")
    @Mapping(source = "name", target = "name")
    @Mapping(source = "brand.name", target = "brandName")
    @Mapping(source = "model.name", target = "modelName")
    GetAllTvResponse toGetAllTvResponse(Tv tv);

    @Mapping(source = "id", target = "id")
    @Mapping(source = "name", target = "name")
    @Mapping(source = "brandName", target = "brand.name")
    @Mapping(source = "modelName", target = "model.name")
    Tv toTv(GetIdTvResponse getIdTvResponse);
    @Mapping(source = "id", target = "id")
    @Mapping(source = "name", target = "name")
    @Mapping(source = "brand.name", target = "brandName")
    @Mapping(source = "model.name", target = "modelName")
    GetIdTvResponse toGetIdTvResponse(Tv tv);

   // @Mapping(source = "name", target = "name")
    @Mapping(source = "brandId", target = "brand.id")
    @Mapping(source = "modelId", target = "model.id")
    Tv toTv(CreateTvRequest createTvRequest);
    //@Mapping(source = "name", target = "name")
    @Mapping(source = "brand.id", target = "brandId")
    @Mapping(source = "model.id", target = "modelId")
    CreateTvRequest toCreateTvRequest(Tv tv);

    @Mapping(source = "id", target = "id")
    @Mapping(source = "name", target = "name")
    @Mapping(source = "brandName", target = "brand.name")
    @Mapping(source = "modelName", target = "model.name")
    Tv toTv(UpdateTvRequest updateTvRequest);
    @Mapping(source = "id", target = "id")
    @Mapping(source = "name", target = "name")
    @Mapping(source = "brand.name", target = "brandName")
    @Mapping(source = "model.name", target = "modelName")
    UpdateTvRequest toUpdateTvRequest(Tv tv);


}
