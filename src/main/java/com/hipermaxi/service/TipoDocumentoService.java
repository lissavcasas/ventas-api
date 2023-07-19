package com.hipermaxi.service;
import com.hipermaxi.dtos.TipoDocumentoCreateDTO;
import com.hipermaxi.dtos.TipoDocumentoDTO;
import com.hipermaxi.dtos.TipoDocumentoUpdateDTO;

import java.util.List;

public interface TipoDocumentoService {
    List<TipoDocumentoDTO> listarTipoDocumentos();
    TipoDocumentoDTO obtenerTipoDocumentoPorID(long id);
    TipoDocumentoDTO registrarTipoDocumento(TipoDocumentoCreateDTO tipoDocumentoCreateDTO);
    TipoDocumentoDTO actualizarTipoDocumento(TipoDocumentoUpdateDTO tipoDocumentoUpdateDTO);
    TipoDocumentoDTO eliminarTipoDocumento(long id);
}
