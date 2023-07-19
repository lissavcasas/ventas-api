package com.hipermaxi.controller;
import com.hipermaxi.dtos.TipoDocumentoCreateDTO;
import com.hipermaxi.dtos.TipoDocumentoDTO;
import com.hipermaxi.dtos.TipoDocumentoUpdateDTO;
import com.hipermaxi.service.TipoDocumentoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/api")
public class TipoDocumentoController {


    @Autowired
    private TipoDocumentoService tipoDocumentoService;

    @GetMapping("tipoDocumentos")
    public ResponseEntity<List<TipoDocumentoDTO>> listarTipoDocumentos(){
        return   new ResponseEntity<>(tipoDocumentoService.listarTipoDocumentos(), HttpStatus.OK);
    }

    @GetMapping("/tipoDocumentos/{tipoDocumentoId}")
    public ResponseEntity<TipoDocumentoDTO> obtenerTipoDocumentoPorId(@PathVariable("tipoDocumentoId") long tipoDocumentoId){
        return  new ResponseEntity<> ( tipoDocumentoService.obtenerTipoDocumentoPorID(tipoDocumentoId),HttpStatus.OK);
    }

    @PostMapping("tipoDocumentos")
    public ResponseEntity<TipoDocumentoDTO> registrarTipoDocumento(@RequestBody TipoDocumentoCreateDTO tipoDocumentoCreateDTO){
        return  new ResponseEntity <>( tipoDocumentoService.registrarTipoDocumento(tipoDocumentoCreateDTO) ,HttpStatus.OK) ;
    }

    @PutMapping("tipoDocumentos")
    public ResponseEntity<TipoDocumentoDTO> actualizarTipoDocumento(@RequestBody TipoDocumentoUpdateDTO tipoDocumentoUpdateDTO){
        return new ResponseEntity<>(tipoDocumentoService.actualizarTipoDocumento(tipoDocumentoUpdateDTO),HttpStatus.OK);
    }

    @DeleteMapping("/tipoDocumentos/{tipoDocumentoId}")
    public ResponseEntity<TipoDocumentoDTO> eliminarTipoDocumento(@PathVariable("tipoDocumentoId") long tipoDocumentoId) {
        return new ResponseEntity<>( tipoDocumentoService.eliminarTipoDocumento(tipoDocumentoId),HttpStatus.OK);
    }
}
