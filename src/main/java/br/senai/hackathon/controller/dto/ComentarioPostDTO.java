package br.senai.hackathon.controller.dto;

public record ComentarioPostDTO(
        String usuario,
        String comentario,
        Long memeId

) {
}
