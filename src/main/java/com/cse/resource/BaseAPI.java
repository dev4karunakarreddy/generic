package com.cse.resource;

import com.cse.dto.BaseDTO;
import com.cse.utils.PageResponse;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;

import java.util.List;

public interface BaseAPI  <I extends BaseDTO,O extends BaseDTO> {
    ResponseEntity<O> create(I inputDTO);

    ResponseEntity<O> getById( Long id);

    ResponseEntity<PageResponse<O>> getAll(Pageable pageable);

    ResponseEntity<O> update( Long id, I inputDTO);

    ResponseEntity<Void> deleteById(Long id);
}
