package com.example.shop.service.service.concretes.productConcretes;


import com.example.shop.entity.entities.productEntities.Tv;
import com.example.shop.repository.productRepositories.productRepositories.TvRepository;
import com.example.shop.service.service.DTO.mapper.productDtoMapper.TvMapper;
import com.example.shop.service.service.abstractsInterface.productAbs.TvService;
import com.example.shop.service.service.requests.productRequests.tvRequest.CreateTvRequest;
import com.example.shop.service.service.requests.productRequests.tvRequest.UpdateTvRequest;
import com.example.shop.service.service.responses.productResponses.TvResponses.GetAllTvResponse;
import com.example.shop.service.service.responses.productResponses.TvResponses.GetIdTvResponse;
import jakarta.persistence.EntityNotFoundException;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class TvManager implements TvService {

    private TvRepository tvRepository;
    private TvMapper tvMapper;


    @Override
    public List<GetAllTvResponse> getAll() {
        List<Tv> tv = tvRepository.findAll();
        return tv.stream()
                .map(tvMapper::toGetAllTvResponse)
                .collect(Collectors.toList());
    }
    @Override
    public GetIdTvResponse getTvlById(int id) {
        Tv tv = tvRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("not found with id: " + id));
        return tvMapper.toGetIdTvResponse(tv);
    }
    @Override
    public void add(CreateTvRequest createTvRequest) {
        Tv tv = tvMapper.toTv(createTvRequest);
        tvRepository.save(tv);
    }
    @Override
    public void update(UpdateTvRequest updateTvRequest) {
        Tv tv = tvMapper.toTv(updateTvRequest);
        this.tvRepository.save(tv);
    }

    @Override
    public void dalete(int id) {
        this.tvRepository.deleteById(id);
    }
}
