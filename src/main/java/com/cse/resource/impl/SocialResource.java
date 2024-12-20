package com.cse.resource.impl;

import com.cse.dto.SocialDTO;
import com.cse.entity.Social;
import com.cse.repository.BaseRepository;
import com.cse.utils.PageResponse;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class SocialResource extends BaseResource<Social, SocialDTO,SocialDTO> {
    public SocialResource(BaseRepository<Social, Long> baseRepository) {
        super(baseRepository);
    }

    @Override
    public ResponseEntity<SocialDTO> create(SocialDTO payloadDTO) {
        return super.create(payloadDTO);
    }

    @Override
    public ResponseEntity<SocialDTO> update(Long id, SocialDTO payloadDTO) {
        return super.update(id, payloadDTO);
    }

    @Override
    public ResponseEntity<SocialDTO> getById(Long id) {
        return super.getById(id);
    }

    @Override
    public ResponseEntity<PageResponse<SocialDTO>> getAll(Pageable pageable) {
        return super.getAll(pageable);
    }

    @Override
    public ResponseEntity<Void> deleteById(Long id) {
        return super.deleteById(id);
    }

    @Override
    protected SocialDTO toDTO(Social entity) {
        return getGenericMapper().toDTO(entity);
    }

    @Override
    protected Social toEntity(SocialDTO dto) {
        return getGenericMapper().toEntity(dto);
    }
}
