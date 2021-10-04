package com.inqhome.inquilino;

import com.inqhome.casa.Casa;
import com.inqhome.usuario.Usuario;
import lombok.Data;

@Data
public class CriarInquilinoDTO {
    private Long usuarioInquilinoId;
    private Long casaId;
    private String contrato;
}
