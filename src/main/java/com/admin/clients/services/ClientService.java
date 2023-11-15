package com.admin.clients.services;


import com.admin.clients.dto.ClientDto;
import com.admin.clients.dto.Documents;
import com.admin.clients.dto.ResponseDto;
import com.admin.clients.entities.ClientEntity;
import com.admin.clients.mapper.ClientMapper;
import com.admin.clients.repository.ClientRepository;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ClientService {

    private static final Logger LOGGER = LoggerFactory.getLogger(ClientService.class);

    @Autowired
    private ClientRepository clientRepository;


    public ResponseDto createClient(ClientDto clientDto) {
        ResponseDto responseDto = new ResponseDto();
        try{
            ClientEntity clientEntity = ClientMapper.mapToClient(clientDto);
            clientRepository.save(clientEntity);
            LOGGER.info("se creo un cliente :{}", clientDto);
            responseDto = estandarResponse(200, "Clientes creado", "Post", clientDto);

        } catch (Exception e){
            LOGGER.error("Fallo al guardar el cliente. {}", e.getMessage());
            responseDto = estandarResponse(400, "Fallo la creacion de cliente", "Post", clientDto);
        }

        return responseDto;
    }


    public ResponseDto getClient() {
        List<ClientDto> clientDto = new ArrayList<>();
        ResponseDto responseDto;
        List<ClientEntity> clientEntityList = clientRepository.findAll();
        if (!clientEntityList.isEmpty()) {
            clientDto = ClientMapper.mapToList(clientEntityList);
            responseDto = estandarResponse(200, "Clientes actuales", "Get", clientDto);
            LOGGER.info("se consulto todos los clientes :{}", clientDto);
        } else {
            responseDto = estandarResponse(400, "No hay clientes por consultar", "Get", clientDto);
            LOGGER.info("No hay clientes por consultar");
        }

        return responseDto;
    }

    public ResponseDto getClientById(Integer id) {
        ClientDto clientDto = new ClientDto();
        ResponseDto responseDto;
        Optional<ClientEntity> clientEntityOptional = clientRepository.findById(id);
        if (clientEntityOptional.isPresent()) {
            clientDto = ClientMapper.mapToClientDto(clientEntityOptional.get());
            responseDto = estandarResponse(200, "", "", clientDto);
            LOGGER.info("se consulto un cliente con id :{}", id);
        } else {
            responseDto = estandarResponse(400, "", "", clientDto);
            LOGGER.info("No existe el cliente con id :{}", id);
        }

        return responseDto;
    }

    public ResponseDto estandarResponse(Integer status, String message, String method, Object obj) {
        ResponseDto res = new ResponseDto();
        res.setStatus(status);
        res.setMessage(message);
        res.setMethod(method);
        res.setSuccess(true);
        Documents documents = new Documents();
        documents.setResponsedata(obj);
        res.setDocuments(documents);
        return res;
    }
}
