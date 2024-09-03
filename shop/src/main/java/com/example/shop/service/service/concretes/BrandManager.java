package com.example.shop.service.service.concretes;

import com.example.shop.entity.entities.Brand;
import com.example.shop.repository.productRepositories.BrandRepository;
import com.example.shop.service.service.DTO.mapper.BrandMapper;
import com.example.shop.service.service.abstractsInterface.BrandService;
import com.example.shop.service.service.requests.brandRequests.CreateBrandRequest;
import com.example.shop.service.service.requests.brandRequests.UpdateBrandRequest;
import com.example.shop.service.service.responses.brandResponses.GetAllBrandsResponse;
import com.example.shop.service.service.responses.brandResponses.GetIdBrandResponse;
import jakarta.persistence.EntityNotFoundException;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor

public class BrandManager implements BrandService {

    private BrandRepository brandRepository;
    private BrandMapper brandMapper;

    @Override
    public List<GetAllBrandsResponse> getAll() {
        List<Brand> allBrand = brandRepository.findAll();
        List<GetAllBrandsResponse> brandsResponses = allBrand.stream()
                .map(brandMapper::toGetAllBrandsResponse)
                .collect(Collectors.toList());
        return brandsResponses;
    }
    @Override
    public GetIdBrandResponse getBrandById(int id) {
        Brand brand = brandRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Brand not found with id: " + id));
        return brandMapper.toGetIdBrandResponse(brand);
    }
    @Override
    public void add(CreateBrandRequest createBrandRequest) {
        Brand brand = brandMapper.toBrand(createBrandRequest);
        // Brand nesnesini veritabanına kaydet
        brandRepository.save(brand);
       // this.brandRepository.save(brandMapper.map(createBrandRequest));
    }
    @Override
    public void update(UpdateBrandRequest updateBrandRequest) {
        Brand brand = brandMapper.toBrand(updateBrandRequest);
        this.brandRepository.save(brand);
    }
    @Override
    public void dalete(int id) {
            this.brandRepository.deleteById(id);
    }











}









































