package com.cse.resource.impl;

import com.cse.dto.ParentsDTO;
import com.cse.entity.Parents;
import com.cse.repository.BaseRepository;
import com.cse.resource.ParentsAPI;
import com.cse.utils.PageResponse;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ParentsResource extends BaseResource<Parents, ParentsDTO,ParentsDTO> implements ParentsAPI {
    public ParentsResource(BaseRepository<Parents, Long> baseRepository) {
        super(baseRepository);
    }

    @Override
    public ResponseEntity<ParentsDTO> create(ParentsDTO payloadDTO) {
        return super.create(payloadDTO);
    }

    @Override
    public ResponseEntity<ParentsDTO> update(Long id, ParentsDTO payloadDTO) {
        return super.update(id, payloadDTO);
    }

    @Override
    public ResponseEntity<ParentsDTO> getById(Long id) {
        return super.getById(id);
    }

    @Override
    public ResponseEntity<PageResponse<ParentsDTO>> getAll(Pageable pageable) {
        return super.getAll(pageable);
    }

    @Override
    public ResponseEntity<Void> deleteById(Long id) {
        return super.deleteById(id);
    }

    @Override
    protected ParentsDTO toDTO(Parents entity) {
        return getGenericMapper().toDTO(entity);
    }

    @Override
    protected Parents toEntity(ParentsDTO dto) {
        return getGenericMapper().toEntity(dto);
    }
}
