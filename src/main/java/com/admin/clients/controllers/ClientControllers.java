package com.admin.clients.controllers;

import com.admin.clients.dto.ClientDto;
import com.admin.clients.dto.ResponseDto;
import com.admin.clients.services.ClientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseStatus;

@Controller
@RequestMapping("/clients")
public class ClientControllers {

    @Autowired
    private ClientService clientService;

    /**
     * Servicio para crear un cliente
     *
     * @author Nora Martinez
     */
    @PostMapping(
            consumes = MediaType.APPLICATION_JSON_VALUE
    )
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public ResponseEntity<ResponseDto> postClient(
            @RequestBody() ClientDto clientDto) {
        ResponseDto responseDto= clientService.createClient(clientDto);
        if (null != responseDto) {
            return ResponseEntity.ok(responseDto);
        } else {
            return ResponseEntity.badRequest().build();
        }
    }

    /**
     * Servicio para entregar los clientes creados
     *
     * @author Nora Martinez
     */
    @GetMapping(
            path = "/list"
    )
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public ResponseEntity<ResponseDto> getClients() {
        ResponseDto responseDto= clientService.getClient();
        if (null != responseDto) {
            return ResponseEntity.ok(responseDto);
        } else {
            return ResponseEntity.badRequest().build();
        }
    }

    /**
     * Servicio para consultar un cliente
     *
     * @author Nora Martinez
     */
    @GetMapping()
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public ResponseEntity<ResponseDto> getClientById(
            @RequestParam(required = true)Integer id) {
        ResponseDto responseDto= clientService.getClientById(id);
        if (null != responseDto) {
            return ResponseEntity.ok(responseDto);
        } else {
            return ResponseEntity.badRequest().build();
        }
    }
}
