package com.cse.resource;

import com.cse.dto.AddressDTO;
import com.cse.utils.PageResponse;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RequestMapping("/api/v1/address")
public interface AddressAPI extends BaseAPI<AddressDTO,AddressDTO> {
    @PostMapping
    ResponseEntity<AddressDTO> create(@RequestBody AddressDTO inputDTO);

    @GetMapping("/{id}")
    ResponseEntity<AddressDTO> getById(@PathVariable("id") Long id);

    @GetMapping
    ResponseEntity<PageResponse<AddressDTO>> getAll(Pageable pageable);

    @PutMapping("/{id}")
    ResponseEntity<AddressDTO> update(@PathVariable("id") Long id, @RequestBody AddressDTO inputDTO);

    @DeleteMapping("/{id}")
    ResponseEntity<Void> deleteById(@PathVariable("id") Long id);
}
