package com.hipermaxi.mappers;

import com.hipermaxi.dtos.TipoDocumentoCreateDTO;
import com.hipermaxi.dtos.TipoDocumentoDTO;
import com.hipermaxi.dtos.TipoDocumentoUpdateDTO;
import com.hipermaxi.model.TipoDocumento;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper
public interface TipoDocumentoMapper {

    TipoDocumentoMapper instancia= Mappers.getMapper(TipoDocumentoMapper.class);

    TipoDocumentoDTO tipoDocumentoATipoDocumentoDTO(TipoDocumento tipoDocumento);
    TipoDocumento tipoDocumentoDTOATipoDocumento(TipoDocumentoDTO tipoDocumentoDTO);
    TipoDocumento tipoDocumentoCreateDTOATipoDocumento(TipoDocumentoCreateDTO tipoDocumentoCreateDTO);
    TipoDocumento tipoDocumentoUpdateDTOATipoDocumento(TipoDocumentoUpdateDTO tipoDocumentoUpdateDTO);
    List<TipoDocumentoDTO> listaTipoDocumentoAListaTipoDocumentoDTO (List<TipoDocumento> listaTipoDocumento);
}
