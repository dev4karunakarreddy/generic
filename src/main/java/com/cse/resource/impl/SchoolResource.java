package com.cse.resource.impl;

import com.cse.dto.SchoolDTO;
import com.cse.entity.Schools;
import com.cse.repository.BaseRepository;
import com.cse.resource.SchoolAPI;
import com.cse.utils.PageResponse;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class SchoolResource extends BaseResource<Schools, SchoolDTO,SchoolDTO> implements SchoolAPI {
    public SchoolResource(BaseRepository<Schools, Long> baseRepository) {
        super(baseRepository);
    }

    @Override
    public ResponseEntity<SchoolDTO> create(SchoolDTO payloadDTO) {
        return super.create(payloadDTO);
    }

    @Override
    public ResponseEntity<SchoolDTO> update(Long id, SchoolDTO payloadDTO) {
        return super.update(id, payloadDTO);
    }

    @Override
    public ResponseEntity<SchoolDTO> getById(Long id) {
        return super.getById(id);
    }

    @Override
    public ResponseEntity<PageResponse<SchoolDTO>> getAll(Pageable pageable) {
        return super.getAll(pageable);
    }

    @Override
    public ResponseEntity<Void> deleteById(Long id) {
        return super.deleteById(id);
    }

    @Override
    protected Schools toEntity(SchoolDTO dto) {
        return getGenericMapper().toEntity(dto);
    }

    @Override
    protected SchoolDTO toDTO(Schools entity) {
        return getGenericMapper().toDTO(entity);
    }
}
