package com.admin.clients.mapper;


import com.admin.clients.dto.ClientDto;
import com.admin.clients.entities.ClientEntity;
import java.util.ArrayList;
import java.util.List;

public class ClientMapper {

    public static ClientEntity mapToClient(ClientDto in){
        ClientEntity clientEntity= new ClientEntity();
        clientEntity.setName(in.getName());
        clientEntity.setLastName(in.getLastName());
        clientEntity.setEmail(in.getEmail());
        clientEntity.setPhone(in.getPhone());
        clientEntity.setStartDate(in.getStartDate());
        clientEntity.setEndDate(in.getEndDate());
        return clientEntity;
    }

    public static ClientDto mapToClientDto(ClientEntity in){
        ClientDto clientDto= new ClientDto();
        clientDto.setId(in.getId());
        clientDto.setName(in.getName());
        clientDto.setLastName(in.getLastName());
        clientDto.setEmail(in.getEmail());
        clientDto.setPhone(in.getPhone());
        clientDto.setStartDate(in.getStartDate());
        clientDto.setEndDate(in.getEndDate());
        return clientDto;
    }

    public static List<ClientDto> mapToList(List<ClientEntity> in){
        List<ClientDto> clientDtoList = new ArrayList<>();
        for(ClientEntity out : in){
            clientDtoList.add(mapToClientDto(out));
        }
        return clientDtoList;
    }
}
