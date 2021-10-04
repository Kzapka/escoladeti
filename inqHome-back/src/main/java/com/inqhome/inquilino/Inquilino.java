package com.inqhome.inquilino;

import com.inqhome.casa.Casa;
import com.inqhome.usuario.Usuario;
import lombok.Data;

import javax.persistence.*;

@Entity
@Table(name = "inquilino")
@Data
public class Inquilino {

    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private Long id;
    @OneToOne
    @JoinColumn(name = "id_usuario")
    private Usuario usuarioInquilino;
    @OneToOne
    @JoinColumn(name = "id_casa")
    private Casa casa;
    private String contrato;

    public Inquilino(Usuario usuarioInquilino, Casa casa, String contrato) {
        this.usuarioInquilino = usuarioInquilino;
        this.casa = casa;
        this.contrato = contrato;
    }

    public Inquilino() {

    }
}
