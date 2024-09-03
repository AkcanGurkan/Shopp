package com.example.shop.service.service.DTO.mapper.productDtoMapper;

import com.example.shop.entity.entities.productEntities.Watch;
import com.example.shop.service.service.requests.productRequests.watchRequests.CreateWatchRequest;
import com.example.shop.service.service.requests.productRequests.watchRequests.UpdateWatchRequest;
import com.example.shop.service.service.responses.productResponses.watchResponses.GetAllWatchResponse;
import com.example.shop.service.service.responses.productResponses.watchResponses.GetIdWatchResponse;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface WatchMapper {

    @Mapping(source = "id", target = "id")
    @Mapping(source = "name", target = "name")
    @Mapping(source = "brandName", target = "brand.name")
    @Mapping(source = "modelName", target = "model.name")
    Watch toWatch(GetAllWatchResponse getAllWatchResponses);
    @Mapping(source = "id", target = "id")
    @Mapping(source = "name", target = "name")
    @Mapping(source = "brand.name", target = "brandName")
    @Mapping(source = "model.name", target = "modelName")
    GetAllWatchResponse toGetAllWatchResponse(Watch watch);

    @Mapping(source = "id", target = "id")
    @Mapping(source = "name", target = "name")
    @Mapping(source = "brandName", target = "brand.name")
    @Mapping(source = "modelName", target = "model.name")
    Watch toWatch(GetIdWatchResponse getIdWatchResponse);
    @Mapping(source = "id", target = "id")
    @Mapping(source = "name", target = "name")
    @Mapping(source = "brand.name", target = "brandName")
    @Mapping(source = "model.name", target = "modelName")
    GetIdWatchResponse toGetIdWatchResponse(Watch watch);

    // @Mapping(source = "name", target = "name")
    @Mapping(source = "brandId", target = "brand.id")
    @Mapping(source = "modelId", target = "model.id")
    Watch toWatch(CreateWatchRequest createWatchRequest);
    //@Mapping(source = "name", target = "name")
    @Mapping(source = "brand.id", target = "brandId")
    @Mapping(source = "model.id", target = "modelId")
    CreateWatchRequest toCreateWatchRequest(Watch watch);

    @Mapping(source = "id", target = "id")
    @Mapping(source = "name", target = "name")
    @Mapping(source = "brandName", target = "brand.name")
    @Mapping(source = "modelName", target = "model.name")
    Watch toWatch(UpdateWatchRequest updateWatchRequest);
    @Mapping(source = "id", target = "id")
    @Mapping(source = "name", target = "name")
    @Mapping(source = "brand.name", target = "brandName")
    @Mapping(source = "model.name", target = "modelName")
    UpdateWatchRequest toUpdateWatchRequest(Watch watch);


}
