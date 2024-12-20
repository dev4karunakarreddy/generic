package com.cse.resource.impl;

import com.cse.dto.AddressDTO;
import com.cse.entity.Address;
import com.cse.repository.BaseRepository;
import com.cse.resource.AddressAPI;
import com.cse.utils.PageResponse;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class AddressResource extends BaseResource<Address, AddressDTO,AddressDTO> implements AddressAPI {
    public AddressResource(BaseRepository<Address, Long> baseRepository) {
        super(baseRepository);
    }

    @Override
    public ResponseEntity<AddressDTO> create(AddressDTO payloadDTO) {
        return super.create(payloadDTO);
    }

    @Override
    public ResponseEntity<AddressDTO> update(Long id, AddressDTO payloadDTO) {
        return super.update(id, payloadDTO);
    }

    @Override
    public ResponseEntity<AddressDTO> getById(Long id) {
        return super.getById(id);
    }

    @Override
    public ResponseEntity<PageResponse<AddressDTO>> getAll(Pageable pageable) {
        return super.getAll(pageable);
    }

    @Override
    public ResponseEntity<Void> deleteById(Long id) {
        return super.deleteById(id);
    }

    @Override
    protected AddressDTO toDTO(Address entity) {
        return getGenericMapper().toDTO(entity);
    }

    @Override
    protected Address toEntity(AddressDTO dto) {
        return getGenericMapper().toEntity(dto);
    }
}
