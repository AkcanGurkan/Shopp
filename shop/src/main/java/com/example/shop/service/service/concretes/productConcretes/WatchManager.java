package com.example.shop.service.service.concretes.productConcretes;

import com.example.shop.entity.entities.productEntities.Watch;
import com.example.shop.repository.productRepositories.productRepositories.WatchRepository;
import com.example.shop.service.service.DTO.mapper.productDtoMapper.WatchMapper;
import com.example.shop.service.service.abstractsInterface.productAbs.WatchService;
import com.example.shop.service.service.requests.productRequests.watchRequests.CreateWatchRequest;
import com.example.shop.service.service.requests.productRequests.watchRequests.UpdateWatchRequest;
import com.example.shop.service.service.responses.productResponses.watchResponses.GetAllWatchResponse;
import com.example.shop.service.service.responses.productResponses.watchResponses.GetIdWatchResponse;
import jakarta.persistence.EntityNotFoundException;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class WatchManager implements WatchService {

    private WatchRepository watchRepository;
    private WatchMapper watchMapper;

    @Override
    public List<GetAllWatchResponse> getAll() {
        List<Watch> watch = watchRepository.findAll();
        return watch.stream()
                .map(watchMapper::toGetAllWatchResponse)
                .collect(Collectors.toList());
    }

    @Override
    public GetIdWatchResponse getWatchById(int id) {
        Watch watch = watchRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("not found with id: " + id));
        return watchMapper.toGetIdWatchResponse(watch);
    }

    @Override
    public void add(CreateWatchRequest createWatchRequest) {
        Watch watch  = watchMapper.toWatch(createWatchRequest);
        watchRepository.save(watch);

    }

    @Override
    public void update(UpdateWatchRequest updateWatchRequest) {
        Watch watch  = watchMapper.toWatch(updateWatchRequest);
        this.watchRepository.save(watch);
    }

    @Override
    public void dalete(int id) {
        this.watchRepository.deleteById(id);
    }
}
