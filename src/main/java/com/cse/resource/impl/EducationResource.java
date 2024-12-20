package com.cse.resource.impl;

import com.cse.dto.EducationDTO;
import com.cse.entity.Education;
import com.cse.repository.BaseRepository;
import com.cse.resource.EducationAPI;
import com.cse.utils.PageResponse;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class EducationResource extends BaseResource<Education, EducationDTO,EducationDTO> implements EducationAPI {
    public EducationResource(BaseRepository<Education, Long> baseRepository) {
        super(baseRepository);

    }
    @Override
    public ResponseEntity<EducationDTO> create(EducationDTO payloadDTO) {
        return super.create(payloadDTO);
    }

    @Override
    public ResponseEntity<EducationDTO> update(Long id, EducationDTO payloadDTO) {
        return super.update(id, payloadDTO);
    }

    @Override
    public ResponseEntity<EducationDTO> getById(Long id) {
        return super.getById(id);
    }

    @Override
    public ResponseEntity<PageResponse<EducationDTO>> getAll(Pageable pageable) {
        return super.getAll(pageable);
    }

    @Override
    public ResponseEntity<Void> deleteById(Long id) {
        return super.deleteById(id);
    }

    @Override
    protected EducationDTO toDTO(Education entity) {
        return getGenericMapper().toDTO(entity);
    }

    @Override
    protected Education toEntity(EducationDTO dto) {
        return getGenericMapper().toEntity(dto);
    }

}
