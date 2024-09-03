package com.example.shop.service.service.concretes.productConcretes;

import com.example.shop.entity.entities.productEntities.Phone;
import com.example.shop.repository.productRepositories.productRepositories.PhoneRepository;
import com.example.shop.service.service.DTO.mapper.productDtoMapper.PhoneMapper;
import com.example.shop.service.service.abstractsInterface.productAbs.PhoneService;
import com.example.shop.service.service.requests.productRequests.phoneRequests.CreatePhoneRequest;
import com.example.shop.service.service.requests.productRequests.phoneRequests.UpdatePhoneRequest;
import com.example.shop.service.service.responses.productResponses.phoneResponses.GetAllPhoneResponse;
import com.example.shop.service.service.responses.productResponses.phoneResponses.GetIdPhoneResponse;
import jakarta.persistence.EntityNotFoundException;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class PhoneManager implements PhoneService {

    private PhoneRepository phoneRepository;
    private PhoneMapper phoneMapper;


    @Override
    public List<GetAllPhoneResponse> getAll() {
        List<Phone> phone = phoneRepository.findAll();
        return phone.stream()
                .map(phoneMapper::toGetAllPhoneResponse)
                .collect(Collectors.toList());
    }

    @Override
    public GetIdPhoneResponse getTvlById(int id) {
        Phone phone = phoneRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("not found with id: " + id));
        return phoneMapper.toGetIdPhoneResponse(phone);
    }

    @Override
    public void add(CreatePhoneRequest createPhoneRequest) {
        Phone phone = phoneMapper.toPhone(createPhoneRequest);
        phoneRepository.save(phone);
    }

    @Override
    public void update(UpdatePhoneRequest updatePhoneRequest) {
        Phone phone = phoneMapper.toPhone(updatePhoneRequest);
        this.phoneRepository.save(phone);

    }

    @Override
    public void dalete(int id) {
        this.phoneRepository.deleteById(id);
    }
}
