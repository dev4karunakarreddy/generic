package com.cse.resource;

import com.cse.dto.StudentDTO;
import com.cse.utils.PageResponse;
import org.springframework.core.io.Resource;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


@RequestMapping("/api/v1/student")
public interface StudentAPI extends BaseAPI<StudentDTO,StudentDTO> {
    @PostMapping
    ResponseEntity<StudentDTO> create(@RequestBody StudentDTO inputDTO);

    @GetMapping
    ResponseEntity<PageResponse<StudentDTO>> getAll(Pageable pageable);

    @GetMapping("/{id}")
    ResponseEntity<StudentDTO> getById(@PathVariable("id") Long id);

    @PutMapping("/{id}")
    ResponseEntity<StudentDTO> update(@PathVariable("id") Long id, @RequestBody StudentDTO inputDTO);

    @DeleteMapping("/{id}")
    ResponseEntity<Void> deleteById(@PathVariable("id") Long id);

    @GetMapping("/image")
    ResponseEntity<Resource> getImage(@RequestParam("fileName") String fileName);
    @GetMapping("/getBy")
    ResponseEntity<StudentDTO> getByRoll(@RequestParam("roll") String roll);
}
