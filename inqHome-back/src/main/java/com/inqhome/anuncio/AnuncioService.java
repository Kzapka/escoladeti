package com.inqhome.anuncio;

import java.io.Serializable;
import java.util.List;
import java.util.Optional;

import com.inqhome.casa.Casa;
import com.inqhome.casa.CasaRepository;
import com.inqhome.usuario.Usuario;
import com.inqhome.usuario.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;

@Service
public class AnuncioService implements Serializable{
    private static final Long serialVersionUID = 1L;
    
    @Autowired
    private AnuncioRepository anuncioRepository;

    @Autowired
    private CasaRepository casaRepository;

    @Autowired
    private UsuarioService usuarioService;
    
    public List<Anuncio> buscarAnuncios(){
        return anuncioRepository.findAll();
    }
    
    public Anuncio buscarAnuncio(Long id) {
    	return anuncioRepository.findById(id).orElseThrow(() -> new RuntimeException());
    }

    public Anuncio criar(CriarAnuncioDTO dados) {

        Usuario usuario = usuarioService.buscarUsuarioPeloId(dados.getIdUsuario());
        Casa casa = casaRepository.findCasaByUsuarioResponsavel(usuario);

        Anuncio anuncio = new Anuncio(usuario,dados.getDescricao(), casa, dados.getVagasDisponiveis());
        return anuncioRepository.save(anuncio);
    }

    public void preencherVaga(Long id) {
      Anuncio anuncio =  buscarAnuncio(id);
      anuncio.setVagasDisponiveis(anuncio.getVagasDisponiveis() - 1);
      if(anuncio.getVagasDisponiveis() == 0) anuncio.setAtivo(false);
      anuncioRepository.save(anuncio);
    }
}
