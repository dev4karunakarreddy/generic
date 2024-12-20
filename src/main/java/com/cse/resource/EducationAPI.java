package com.cse.resource;

import com.cse.dto.EducationDTO;
import com.cse.utils.PageResponse;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RequestMapping("/api/v1/education")
public interface EducationAPI extends BaseAPI<EducationDTO,EducationDTO> {
    @PostMapping
    ResponseEntity<EducationDTO> create(@RequestBody EducationDTO inputDTO);

    @GetMapping("/{id}")
    ResponseEntity<EducationDTO> getById(@PathVariable("id") Long id);

    @GetMapping
    ResponseEntity<PageResponse<EducationDTO>> getAll(Pageable pageable);

    @PutMapping("/{id}")
    ResponseEntity<EducationDTO> update(@PathVariable("id") Long id,@RequestBody EducationDTO inputDTO);

    @DeleteMapping("/{id}")
    ResponseEntity<Void> deleteById(@PathVariable("id") Long id);
}
