package com.example.shop.service.service.DTO.mapper.productDtoMapper;

import com.example.shop.entity.entities.productEntities.Headset;
import com.example.shop.service.service.requests.productRequests.headsetRequests.CreateHeadsetRequest;
import com.example.shop.service.service.requests.productRequests.headsetRequests.UpdateHeadsetRequest;
import com.example.shop.service.service.responses.productResponses.headsetResponses.GetAllHeadsetResponse;
import com.example.shop.service.service.responses.productResponses.headsetResponses.GetIdHeadsetResponse;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface HeadsetMapper {

    @Mapping(source = "id", target = "id")
   // @Mapping(source = "name", target = "name")
    @Mapping(source = "brandName", target = "brand.name")
    @Mapping(source = "modelName", target = "model.name")
    Headset toHeadset(GetAllHeadsetResponse getAllHeadsetResponses);
    @Mapping(source = "id", target = "id")
    //@Mapping(source = "name", target = "name")
    @Mapping(source = "brand.name", target = "brandName")
    @Mapping(source = "model.name", target = "modelName")
    GetAllHeadsetResponse toGetAllHeadsetResponse(Headset headset);
    @Mapping(source = "id", target = "id")
    //@Mapping(source = "name", target = "name")
    @Mapping(source = "brandName", target = "brand.name")
    @Mapping(source = "modelName", target = "model.name")
    Headset toHeadset(GetIdHeadsetResponse getIdHeadsetResponse);
    @Mapping(source = "id", target = "id")
    //@Mapping(source = "name", target = "name")
    @Mapping(source = "brand.name", target = "brandName")
    @Mapping(source = "model.name", target = "modelName")
    GetIdHeadsetResponse toGetIdHeadsetResponse(Headset headset);
    //@Mapping(source = "name", target = "name")
    @Mapping(source = "brandId", target = "brand.id")
    @Mapping(source = "modelId", target = "model.id")
    Headset toHeadset(CreateHeadsetRequest createHeadsetRequest);
   // @Mapping(source = "name", target = "name")
    @Mapping(source = "brand.id", target = "brandId")
    @Mapping(source = "model.id", target = "modelId")
    CreateHeadsetRequest toCreateHeadsetRequest(Headset headset);
    @Mapping(source = "id", target = "id")
    //@Mapping(source = "name", target = "name")
    @Mapping(source = "brandName", target = "brand.name")
    @Mapping(source = "modelName", target = "model.name")
    Headset toHeadset(UpdateHeadsetRequest updateHeadsetRequest);
    @Mapping(source = "id", target = "id")
   // @Mapping(source = "name", target = "name")
    @Mapping(source = "brand.name", target = "brandName")
    @Mapping(source = "model.name", target = "modelName")
    UpdateHeadsetRequest toUpdateHeadsetRequest(Headset headset);

}
