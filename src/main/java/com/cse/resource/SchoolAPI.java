package com.cse.resource;

import com.cse.dto.SchoolDTO;
import com.cse.utils.PageResponse;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RequestMapping(value = "/api/v1/school")
public interface SchoolAPI extends BaseAPI<SchoolDTO,SchoolDTO> {
    @PostMapping
    ResponseEntity<SchoolDTO> create(@RequestBody SchoolDTO inputDTO);

    @GetMapping("/{id}")
    ResponseEntity<SchoolDTO> getById(@PathVariable Long id);

    @GetMapping
    ResponseEntity<PageResponse<SchoolDTO>> getAll(Pageable pageable);

    @PutMapping("/{id}")
    ResponseEntity<SchoolDTO> update(@PathVariable Long id, @RequestBody SchoolDTO inputDTO);

    @DeleteMapping("/{id}")
    ResponseEntity<Void> deleteById(@PathVariable Long id);
}
