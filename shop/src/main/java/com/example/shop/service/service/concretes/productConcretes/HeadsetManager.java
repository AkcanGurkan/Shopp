package com.example.shop.service.service.concretes.productConcretes;

import com.example.shop.entity.entities.productEntities.Headset;
import com.example.shop.repository.productRepositories.productRepositories.HeadsetRepository;
import com.example.shop.service.service.DTO.mapper.productDtoMapper.HeadsetMapper;
import com.example.shop.service.service.abstractsInterface.productAbs.HeadsetService;
import com.example.shop.service.service.requests.productRequests.headsetRequests.CreateHeadsetRequest;
import com.example.shop.service.service.requests.productRequests.headsetRequests.UpdateHeadsetRequest;
import com.example.shop.service.service.responses.productResponses.headsetResponses.GetAllHeadsetResponse;
import com.example.shop.service.service.responses.productResponses.headsetResponses.GetIdHeadsetResponse;
import jakarta.persistence.EntityNotFoundException;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class HeadsetManager implements HeadsetService {

    private HeadsetRepository headsetRepository;
    private HeadsetMapper headsetMapper;

    @Override
    public List<GetAllHeadsetResponse> getAll() {
        List<Headset> headset = headsetRepository.findAll();
        return headset.stream()
                .map(headsetMapper::toGetAllHeadsetResponse)
                .collect(Collectors.toList());
    }

    @Override
    public GetIdHeadsetResponse getTvlById(int id) {
        Headset headset = headsetRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("not found with id: " + id));
        return headsetMapper.toGetIdHeadsetResponse(headset);
    }

    @Override
    public void add(CreateHeadsetRequest createHeadsetRequest) {
        Headset headset  = headsetMapper.toHeadset(createHeadsetRequest);
        headsetRepository.save(headset);
    }

    @Override
    public void update(UpdateHeadsetRequest updateHeadsetRequest) {
        Headset headset = headsetMapper.toHeadset(updateHeadsetRequest);
        this.headsetRepository.save(headset);
    }

    @Override
    public void dalete(int id) {
        this.headsetRepository.deleteById(id);
    }
}
