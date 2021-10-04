package com.inqhome.inquilino;

import com.inqhome.casa.Casa;
import com.inqhome.casa.CasaService;
import com.inqhome.usuario.Usuario;
import com.inqhome.usuario.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.io.Serializable;
import java.util.List;

@Service
public class InquilinoService implements Serializable {
    private static final Long serialVersionUID = 1L;

    @Autowired
    private InquilinoRepository inquilinoRepository;

    @Autowired
    private UsuarioService usuarioService;

    @Autowired
    private CasaService casaservice;

    public List<Inquilino> buscarInquilinos() {
        return inquilinoRepository.findAll();
    }

    public Inquilino buscarInquilinoPeloId(Long id) {
        return inquilinoRepository.findById(id).orElseThrow(() -> new RuntimeException());
    }

    public Inquilino salvarInquilino(CriarInquilinoDTO dados) {
        Usuario usuario = usuarioService.buscarUsuarioPeloId(dados.getUsuarioInquilinoId());
        Casa casa = casaservice.buscarCasaPeloId(dados.getCasaId());

        Inquilino inquilino = new Inquilino(usuario, casa, dados.getContrato());
        return inquilinoRepository.save(inquilino);
    }

    public void deletarInquilinoPeloId(Long id) {
        Inquilino inquilino = buscarInquilinoPeloId(id);
        inquilinoRepository.delete(inquilino);
    }

    public Inquilino atualizarInquilino(Long id, CriarInquilinoDTO dados) {
        Inquilino inquilino = buscarInquilinoPeloId(id);

        inquilino.setContrato(dados.getContrato());
        return inquilinoRepository.save(inquilino);
    }
}
