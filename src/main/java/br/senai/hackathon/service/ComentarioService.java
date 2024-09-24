package br.senai.hackathon.service;

import br.senai.hackathon.controller.dto.ComentarioPostDTO;
import br.senai.hackathon.entity.Comentario;
import br.senai.hackathon.entity.Meme;
import br.senai.hackathon.repository.ComentarioRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class ComentarioService {
    private ComentarioRepository repository;

    public Comentario criarComentario(ComentarioPostDTO dto) {
        Comentario comentario = new Comentario(dto);
        comentario.setMeme(new Meme(dto.memeId()));
        return repository.save(comentario);
    }
}
