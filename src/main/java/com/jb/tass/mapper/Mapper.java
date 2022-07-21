package com.jb.tass.mapper;

import java.util.List;

//Created by sniryosefof on 29 יוני
public interface Mapper <DAO,DTO> {

    DAO toDao(DTO dto);

    DTO toDto(DAO dao);

    List<DAO> toDaoList(List<DTO> dtos);

    List<DTO> toDtoList(List<DAO> daos);
}
