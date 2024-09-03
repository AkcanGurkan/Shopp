package com.example.shop.service.service.DTO.mapper;

import com.example.shop.entity.entities.Model;
import com.example.shop.service.service.requests.modelRequests.CreateModelRequest;
import com.example.shop.service.service.requests.modelRequests.UpdateModelRequest;
import com.example.shop.service.service.responses.modelResponses.GetAllModelResponse;
import com.example.shop.service.service.responses.modelResponses.GetIdModelResponse;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface ModelMapper {

    @Mapping(source = "id", target = "id")
    @Mapping(source = "name", target = "name")
    @Mapping(source = "brandName", target = "brand.name")
    Model toModel(GetAllModelResponse getAllModelResponse);
    @Mapping(source = "id", target = "id")
    @Mapping(source = "name", target = "name")
    @Mapping(source = "brand.name", target = "brandName")
    GetAllModelResponse toGetAllModelResponse(Model model);

    @Mapping(source = "id", target = "id")
    @Mapping(source = "name", target = "name")
    @Mapping(source = "brandName", target = "brand.name")
    Model toModel(GetIdModelResponse getIdModelResponse);
    @Mapping(source = "id", target = "id")
    @Mapping(source = "name", target = "name")
    @Mapping(source = "brand.name", target = "brandName")
    GetIdModelResponse toGetIdModelResponse(Model model);

    @Mapping(source = "name", target = "name")
    @Mapping(source = "brandId", target = "brand.id")
    Model toModel(CreateModelRequest createModelRequest);
    @Mapping(source = "name", target = "name")
    @Mapping(source = "brand.id", target = "brandId")
    CreateModelRequest toCreateModelRequest(Model model);

    @Mapping(source = "id", target = "id")
    @Mapping(source = "name", target = "name")
    @Mapping(source = "brandName", target = "brand.name")
    Model toModel(UpdateModelRequest updateModelRequest);
    @Mapping(source = "id", target = "id")
    @Mapping(source = "name", target = "name")
    @Mapping(source = "brand.name", target = "brandName")
    UpdateModelRequest toUpdateModelRequest(Model model);

}
