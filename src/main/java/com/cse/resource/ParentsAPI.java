package com.cse.resource;

import com.cse.dto.ParentsDTO;
import com.cse.utils.PageResponse;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RequestMapping("/api/v1/parents")
public interface ParentsAPI extends BaseAPI<ParentsDTO,ParentsDTO>{
    @PostMapping
    ResponseEntity<ParentsDTO> create(@RequestBody ParentsDTO inputDTO);

    @GetMapping("/{id}")
    ResponseEntity<ParentsDTO> getById(@PathVariable("id") Long id);

    @GetMapping
    ResponseEntity<PageResponse<ParentsDTO>> getAll(Pageable pageable);

    @PutMapping("/{id}")
    ResponseEntity<ParentsDTO> update(@PathVariable("id") Long id,@RequestBody ParentsDTO inputDTO);

    @DeleteMapping("/{id}")
    ResponseEntity<Void> deleteById(@PathVariable("id") Long id);
}
