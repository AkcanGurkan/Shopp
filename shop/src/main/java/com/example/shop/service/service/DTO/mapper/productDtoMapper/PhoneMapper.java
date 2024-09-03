package com.example.shop.service.service.DTO.mapper.productDtoMapper;

import com.example.shop.entity.entities.productEntities.Phone;
import com.example.shop.service.service.requests.productRequests.phoneRequests.CreatePhoneRequest;
import com.example.shop.service.service.requests.productRequests.phoneRequests.UpdatePhoneRequest;
import com.example.shop.service.service.responses.productResponses.phoneResponses.GetAllPhoneResponse;
import com.example.shop.service.service.responses.productResponses.phoneResponses.GetIdPhoneResponse;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface PhoneMapper {
    @Mapping(source = "id", target = "id")
    @Mapping(source = "name", target = "name")
    @Mapping(source = "brandName", target = "brand.name")
    @Mapping(source = "modelName", target = "model.name")
    Phone toPhone(GetAllPhoneResponse getAllPhoneResponses);
    @Mapping(source = "id", target = "id")
    @Mapping(source = "name", target = "name")
    @Mapping(source = "brand.name", target = "brandName")
    @Mapping(source = "model.name", target = "modelName")
    GetAllPhoneResponse toGetAllPhoneResponse(Phone phone);

    @Mapping(source = "id", target = "id")
    @Mapping(source = "name", target = "name")
    @Mapping(source = "brandName", target = "brand.name")
    @Mapping(source = "modelName", target = "model.name")
    Phone toPhone(GetIdPhoneResponse getIdPhoneResponse);
    @Mapping(source = "id", target = "id")
    @Mapping(source = "name", target = "name")
    @Mapping(source = "brand.name", target = "brandName")
    @Mapping(source = "model.name", target = "modelName")
    GetIdPhoneResponse toGetIdPhoneResponse(Phone phone);

    // @Mapping(source = "name", target = "name")
    @Mapping(source = "brandId", target = "brand.id")
    @Mapping(source = "modelId", target = "model.id")
    Phone toPhone (CreatePhoneRequest createPhoneRequest);
    //@Mapping(source = "name", target = "name")
    @Mapping(source = "brand.id", target = "brandId")
    @Mapping(source = "model.id", target = "modelId")
    CreatePhoneRequest toCreatePhoneRequest(Phone phone);

    @Mapping(source = "id", target = "id")
    @Mapping(source = "name", target = "name")
    @Mapping(source = "brandName", target = "brand.name")
    @Mapping(source = "modelName", target = "model.name")
    Phone toPhone(UpdatePhoneRequest updatePhoneRequest);
    @Mapping(source = "id", target = "id")
    @Mapping(source = "name", target = "name")
    @Mapping(source = "brand.name", target = "brandName")
    @Mapping(source = "model.name", target = "modelName")
    UpdatePhoneRequest toUpdatePhoneRequest(Phone phone);

}
