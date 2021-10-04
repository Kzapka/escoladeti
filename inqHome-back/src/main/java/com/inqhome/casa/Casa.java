package com.inqhome.casa;

import javax.persistence.*;

import com.inqhome.usuario.Usuario;

import lombok.Data;

import java.io.Serializable;

@Entity
@Table (name = "casa")
@Data
public class Casa implements Serializable {
   
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    @Column(name = "id_casa")
	private Long idCasa;
    @OneToOne
    @JoinColumn(name = "id_usuario")
    private Usuario usuarioResponsavel;
    private String cep;
    private String rua;
    private String cidade;
    private String estado;
    private String numeroCasa;
    private Double valorAluguel;
    

    public Casa(Usuario usuarioResponsavel,Double valorAluguel) {
    this.usuarioResponsavel = usuarioResponsavel;
    this.valorAluguel = valorAluguel;
    }

    public Casa() {

    }
}
