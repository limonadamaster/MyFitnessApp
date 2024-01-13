package com.example.MyFitnessApp.dto;

import org.modelmapper.ModelMapper;

public class EntityDtoConverter {

    private final static ModelMapper modelMapper = new ModelMapper();


    public static <D, E> D convertToDto(E entity, Class<D> dtoClass) {
        return modelMapper.map(entity, dtoClass);
    }

    public static <D, E> E convertToEntity(D dto, Class<E> entityClass) {
        return modelMapper.map(dto, entityClass);
    }

}