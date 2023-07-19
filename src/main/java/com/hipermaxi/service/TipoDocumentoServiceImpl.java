package com.hipermaxi.service;

import com.hipermaxi.dtos.TipoDocumentoCreateDTO;
import com.hipermaxi.dtos.TipoDocumentoDTO;
import com.hipermaxi.dtos.TipoDocumentoUpdateDTO;
import com.hipermaxi.mappers.TipoDocumentoMapper;
import com.hipermaxi.model.TipoDocumento;
import com.hipermaxi.repository.TipoDocumentoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;

@Service
public class TipoDocumentoServiceImpl implements TipoDocumentoService {

    @Autowired
    private TipoDocumentoRepository tipoDocumentoRepository;

    @Override
    public List<TipoDocumentoDTO> listarTipoDocumentos() {
        return TipoDocumentoMapper.instancia.listaTipoDocumentoAListaTipoDocumentoDTO( tipoDocumentoRepository.findAll());
    }

    @Override
    public TipoDocumentoDTO obtenerTipoDocumentoPorID(long id) {
        Optional<TipoDocumento> tipoDocumento= tipoDocumentoRepository.findById(id);
        TipoDocumentoDTO tipoDocumentoDTO =null;
        if(tipoDocumento.isPresent()){
            tipoDocumentoDTO = TipoDocumentoMapper.instancia.tipoDocumentoATipoDocumentoDTO(tipoDocumento.get());
        }
        return  tipoDocumentoDTO;
    }

    @Override
    public TipoDocumentoDTO registrarTipoDocumento(TipoDocumentoCreateDTO tipoDocumentoCreateDTO) {
        TipoDocumento tipoDocumento=TipoDocumentoMapper.instancia.tipoDocumentoCreateDTOATipoDocumento(tipoDocumentoCreateDTO);
        TipoDocumento respuestaEntity=tipoDocumentoRepository.save(tipoDocumento);
        TipoDocumentoDTO respuestaDTO= TipoDocumentoMapper.instancia.tipoDocumentoATipoDocumentoDTO(respuestaEntity);
        return respuestaDTO;
    }

    @Override
    public TipoDocumentoDTO actualizarTipoDocumento(TipoDocumentoUpdateDTO tipoDocumentoUpdateDTO) {
        TipoDocumento tipoDocumento=TipoDocumentoMapper.instancia.tipoDocumentoUpdateDTOATipoDocumento(tipoDocumentoUpdateDTO);
        TipoDocumento respuestaEntity=tipoDocumentoRepository.save(tipoDocumento);
        TipoDocumentoDTO respuestaDTO= TipoDocumentoMapper.instancia.tipoDocumentoATipoDocumentoDTO(respuestaEntity);
        return respuestaDTO;
    }

    @Override
    public TipoDocumentoDTO eliminarTipoDocumento(long id) {
        Optional<TipoDocumento> tipoDocumentoOptional = tipoDocumentoRepository.findById(id);
        if (tipoDocumentoOptional.isPresent()) {
            TipoDocumentoDTO tipoDocumentoDTO = TipoDocumentoMapper.instancia.tipoDocumentoATipoDocumentoDTO(tipoDocumentoOptional.get());
            tipoDocumentoRepository.delete(tipoDocumentoOptional.get());
            return tipoDocumentoDTO;
        } else {
            throw new NoSuchElementException("No se pudo realizar la eliminación para el ID proporcionado");
        }
    }
}
