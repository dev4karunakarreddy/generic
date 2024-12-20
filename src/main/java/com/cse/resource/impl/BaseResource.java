package com.cse.resource.impl;

import com.cse.dto.BaseDTO;
import com.cse.entity.BaseEntity;
import com.cse.exceptions.ResourceNotFoundException;
import com.cse.mapper.GenericMapper;
import com.cse.repository.BaseRepository;
import com.cse.utils.OperationType;
import com.cse.utils.PageResponse;
import lombok.Getter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Getter
public abstract class BaseResource<V extends BaseEntity,I extends BaseDTO,O extends BaseDTO>{

    @Autowired
    private GenericMapper genericMapper;

    private final BaseRepository<V,Long> baseRepository;

    public BaseResource( BaseRepository<V,Long> baseRepository) {
        this.baseRepository = baseRepository;
    }

    protected void preValidate(I payloadDTO, OperationType operationType){ }

    protected void validate(I payloadDTO,V entity,OperationType operationType ){ }

    protected void prePersist(I payloadDTO,OperationType operationType){ }

    protected void postPersist(I payloadDTO,OperationType operationType){ }

    protected V toEntity(I dto){return null;}

    protected O toDTO(V entity){ return null;}

    public ResponseEntity<O> create(I payloadDTO){
        preValidate(payloadDTO,OperationType.CREATE);
        V entity=toEntity(payloadDTO);
        validate(payloadDTO,entity,OperationType.CREATE);
        prePersist(payloadDTO,OperationType.CREATE);
        V createdEntity=getBaseRepository().save(entity);
        postPersist(payloadDTO,OperationType.CREATE);
        O outPutDTO=toDTO(createdEntity);
        return new ResponseEntity<>(outPutDTO, HttpStatus.CREATED);
    }

    public ResponseEntity<O> update(Long id,I payloadDTO){
        preValidate(payloadDTO,OperationType.UPDATE);
        V entity=toEntity(payloadDTO);
        validate(payloadDTO,entity,OperationType.UPDATE);
        prePersist(payloadDTO,OperationType.UPDATE);
        V updatedEntity=getBaseRepository().save(entity);
        postPersist(payloadDTO,OperationType.UPDATE);
        O outPutDTO=toDTO(updatedEntity);
        return new ResponseEntity<>(outPutDTO, HttpStatus.OK);
    }

    public ResponseEntity<O> getById(Long id){
        preValidate(null,OperationType.GET);
        validate(null,null,OperationType.GET);
        V entity=getBaseRepository().findById(id).orElseThrow(
                ()->new ResourceNotFoundException("Resource not found","id",id));
        O outputDTO=toDTO(entity);
        return new ResponseEntity<>(outputDTO,HttpStatus.OK);
    }

    public ResponseEntity<PageResponse<O>> getAll(Pageable pageable){
        preValidate(null,OperationType.GET);
        validate(null,null,OperationType.GET);

        Page<V> pageData=getBaseRepository().findAll(pageable);
        List<O> outputDTOs=pageData.getContent().stream().map(this::toDTO).toList();
        Map<String,Object> meta=getMetadata(pageData);
        PageResponse<O> pageResponse=new PageResponse<>(meta,outputDTOs);
        return new ResponseEntity<>(pageResponse,HttpStatus.OK);
    }
    public ResponseEntity<Void> deleteById(Long id){
        preValidate(null,OperationType.DELETE);
        validate(null,null,OperationType.DELETE);
        prePersist(null,OperationType.DELETE);
        getBaseRepository().deleteById(id);
        return new ResponseEntity<>(HttpStatus.ACCEPTED);
    }

    public Map<String,Object> getMetadata(Page<V> page){
        Map<String, Object> meta = new HashMap<>();
        meta.put("totalElements",page.getTotalElements());
        meta.put("totalPages",page.getTotalPages());
        meta.put("size",page.getSize());
        return meta;
    }
}
