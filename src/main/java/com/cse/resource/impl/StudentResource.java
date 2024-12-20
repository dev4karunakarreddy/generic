package com.cse.resource.impl;

import com.cse.dto.StudentDTO;
import com.cse.entity.Student;
import com.cse.exceptions.ResourceNotFoundException;
import com.cse.repository.BaseRepository;
import com.cse.repository.StudentRepository;
import com.cse.resource.StudentAPI;
import com.cse.utils.PageResponse;
import org.springframework.core.io.Resource;
import org.springframework.core.io.UrlResource;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

import java.net.MalformedURLException;
import java.nio.file.Path;
import java.nio.file.Paths;

@RestController
public class StudentResource extends BaseResource<Student, StudentDTO,StudentDTO> implements StudentAPI {
    private final StudentRepository studentRepository;
    public StudentResource(BaseRepository<Student, Long> baseRepository, StudentRepository studentRepository) {
        super(baseRepository);
        this.studentRepository = studentRepository;
    }

    @Override
    public ResponseEntity<StudentDTO> create(StudentDTO inputDTO) {
        return super.create(inputDTO);
    }

    @Override
    public ResponseEntity<StudentDTO> getById(Long id) {
        return super.getById(id);
    }

    @Override
    public ResponseEntity<PageResponse<StudentDTO>> getAll(Pageable pageable) {
        return super.getAll(pageable);
    }

    @Override
    public ResponseEntity<StudentDTO> update(Long id, StudentDTO inputDTO) {
        return super.update(id,inputDTO);
    }

    @Override
    public ResponseEntity<Void> deleteById(Long id) {
        return super.deleteById(id);
    }

    @Override
    public ResponseEntity<Resource> getImage(String fileName) {
        Path imagePath;
        Path defaultImagePath = Paths.get("C:\\workspace\\others\\Class\\src\\main\\webapp\\WEB-INF\\view\\pic\\noimg.jpg");
        try {
            imagePath = Paths.get("C:\\workspace\\others\\Class\\src\\main\\webapp\\WEB-INF\\view\\pic").resolve(fileName).normalize();
            Resource resource = new UrlResource(imagePath.toUri());

            if (!resource.exists() || !resource.isReadable()) {
                resource = new UrlResource(defaultImagePath.toUri());
            }

            if (resource.exists() && resource.isReadable()) {
                return ResponseEntity.ok()
                        .header(HttpHeaders.CONTENT_DISPOSITION, "inline; filename=\"" + resource.getFilename() + "\"")
                        .header(HttpHeaders.CONTENT_TYPE, "image/jpeg")
                        .body(resource);
            } else {
                return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
            }
        } catch (MalformedURLException e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }

    @Override
    public ResponseEntity<StudentDTO> getByRoll(String roll) {
        Student student=studentRepository.findByRoll(roll).orElseThrow(
                ()->new ResourceNotFoundException("Not found","with roo",1L));
        return new ResponseEntity<>(getGenericMapper().toDTO(student),HttpStatus.OK);
    }

    @Override
    protected Student toEntity(StudentDTO dto) {
        return getGenericMapper().toEntity(dto);
    }

    @Override
    protected StudentDTO toDTO(Student entity) {
        return getGenericMapper().toDTO(entity);
    }
}
