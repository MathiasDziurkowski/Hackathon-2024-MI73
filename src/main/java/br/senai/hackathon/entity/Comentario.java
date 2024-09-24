package br.senai.hackathon.entity;

import br.senai.hackathon.controller.dto.ComentarioPostDTO;
import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.beans.BeanUtils;

@Entity
@Data
@NoArgsConstructor
public class Comentario {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(nullable = false)
    private String usuario;
    @Column(nullable = false)
    private String comentario;
    @ManyToOne
    @JsonIgnore
    private Meme meme;

    public Comentario(ComentarioPostDTO dto){
        BeanUtils.copyProperties(dto, this);
    }
}
