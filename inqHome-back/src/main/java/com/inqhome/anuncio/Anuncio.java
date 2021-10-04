package com.inqhome.anuncio;

import javax.annotation.Generated;
import javax.persistence.*;

import com.inqhome.casa.Casa;
import com.inqhome.inquilino.Inquilino;
import com.inqhome.usuario.Usuario;
import lombok.Data;

import java.io.Serializable;

@Entity
@Table(name = "Anuncio")
@Data
public class Anuncio implements Serializable {
 
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @OneToOne
    @JoinColumn(name = "id_usuario")
    private Usuario usuario;
    private String descricao;
    private int vagasDisponiveis;
    @OneToOne
    @JoinColumn(name = "id_casa")
    private Casa casa;
    private boolean ativo = true;

    public Anuncio(Usuario usuario, String descricao, Casa casa, int vagasDisponiveis) {
        super();
        this.usuario = usuario;
        this.descricao = descricao;
        this.casa = casa;
        this.vagasDisponiveis = vagasDisponiveis;
    }

    public Anuncio() {

    }

    public void setAtivo(boolean ativo) {
        this.ativo = ativo;
    }
}
