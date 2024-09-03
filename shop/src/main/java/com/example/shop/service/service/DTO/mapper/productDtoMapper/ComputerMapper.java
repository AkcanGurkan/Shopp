package com.example.shop.service.service.DTO.mapper.productDtoMapper;

import com.example.shop.entity.entities.productEntities.Computer;
import com.example.shop.service.service.requests.productRequests.computerRequests.CreateComputerRequest;
import com.example.shop.service.service.requests.productRequests.computerRequests.UpdateComputerRequest;
import com.example.shop.service.service.responses.productResponses.computerResponses.GetAllComputerResponse;
import com.example.shop.service.service.responses.productResponses.computerResponses.GetIdComputerResponse;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface ComputerMapper {

    @Mapping(source = "id", target = "id")
    @Mapping(source = "name", target = "name")
    @Mapping(source = "brandName", target = "brand.name")
    @Mapping(source = "modelName", target = "model.name")
    Computer toComputer(GetAllComputerResponse getAllComputerResponses);
    @Mapping(source = "id", target = "id")
    @Mapping(source = "name", target = "name")
    @Mapping(source = "brand.name", target = "brandName")
    @Mapping(source = "model.name", target = "modelName")
    GetAllComputerResponse toGetAllComputerResponse(Computer computer);

    @Mapping(source = "id", target = "id")
    @Mapping(source = "name", target = "name")
    @Mapping(source = "brandName", target = "brand.name")
    @Mapping(source = "modelName", target = "model.name")
    Computer toComputer(GetIdComputerResponse getIdComputerResponse);
    @Mapping(source = "id", target = "id")
    @Mapping(source = "name", target = "name")
    @Mapping(source = "brand.name", target = "brandName")
    @Mapping(source = "model.name", target = "modelName")
    GetIdComputerResponse toGetIdComputerResponse(Computer computer);

    // @Mapping(source = "name", target = "name")
    @Mapping(source = "brandId", target = "brand.id")
    @Mapping(source = "modelId", target = "model.id")
    Computer toComputer(CreateComputerRequest createComputerRequest);
    //@Mapping(source = "name", target = "name")
    @Mapping(source = "brand.id", target = "brandId")
    @Mapping(source = "model.id", target = "modelId")
    CreateComputerRequest toCreateComputerRequest(Computer computer);

    @Mapping(source = "id", target = "id")
    @Mapping(source = "name", target = "name")
    @Mapping(source = "brandName", target = "brand.name")
    @Mapping(source = "modelName", target = "model.name")
    Computer toComputer(UpdateComputerRequest updateComputerRequest);
    @Mapping(source = "id", target = "id")
    @Mapping(source = "name", target = "name")
    @Mapping(source = "brand.name", target = "brandName")
    @Mapping(source = "model.name", target = "modelName")
    UpdateComputerRequest toUpdateComputerRequest(Computer computer);

}
