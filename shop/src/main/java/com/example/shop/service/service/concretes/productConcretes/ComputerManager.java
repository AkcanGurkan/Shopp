package com.example.shop.service.service.concretes.productConcretes;

import com.example.shop.entity.entities.productEntities.Computer;
import com.example.shop.repository.productRepositories.productRepositories.ComputerRepository;
import com.example.shop.service.service.DTO.mapper.productDtoMapper.ComputerMapper;
import com.example.shop.service.service.abstractsInterface.productAbs.ComputerService;
import com.example.shop.service.service.requests.productRequests.computerRequests.CreateComputerRequest;
import com.example.shop.service.service.requests.productRequests.computerRequests.UpdateComputerRequest;
import com.example.shop.service.service.responses.productResponses.computerResponses.GetAllComputerResponse;
import com.example.shop.service.service.responses.productResponses.computerResponses.GetIdComputerResponse;
import jakarta.persistence.EntityNotFoundException;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class ComputerManager implements ComputerService {

    private ComputerRepository computerRepository;
    private ComputerMapper computerMapper;

    @Override
    public List<GetAllComputerResponse> getAll() {
        List<Computer> computer = computerRepository.findAll();
        return computer.stream()
                .map(computerMapper::toGetAllComputerResponse)
                .collect(Collectors.toList());
    }

    @Override
    public GetIdComputerResponse getTvlById(int id) {
        Computer computer = computerRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("not found with id: " + id));
        return computerMapper.toGetIdComputerResponse(computer);
    }

    @Override
    public void add(CreateComputerRequest createComputerRequest) {
        Computer computer  = computerMapper.toComputer(createComputerRequest);
        computerRepository.save(computer);
    }

    @Override
    public void update(UpdateComputerRequest updateComputerRequest) {
        Computer computer  = computerMapper.toComputer(updateComputerRequest);
        this.computerRepository.save(computer);
    }

    @Override
    public void dalete(int id) {
        this.computerRepository.deleteById(id);
    }
}
