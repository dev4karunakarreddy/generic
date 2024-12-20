package com.cse.resource;

import com.cse.dto.SocialDTO;
import com.cse.utils.PageResponse;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RequestMapping("/api/v1/social")
public interface SocialAPI extends BaseAPI<SocialDTO,SocialDTO> {
    @PostMapping
    ResponseEntity<SocialDTO> create(@RequestBody SocialDTO inputDTO);

    @GetMapping("/{id}")
    ResponseEntity<SocialDTO> getById(@PathVariable("id") Long id);

    @GetMapping
    ResponseEntity<PageResponse<SocialDTO>> getAll(Pageable pageable);

    @PutMapping("/{id}")
    ResponseEntity<SocialDTO> update(@PathVariable("id") Long id,@RequestBody SocialDTO inputDTO);

    @DeleteMapping("/{id}")
    ResponseEntity<Void> deleteById(@PathVariable("id") Long id);
}
