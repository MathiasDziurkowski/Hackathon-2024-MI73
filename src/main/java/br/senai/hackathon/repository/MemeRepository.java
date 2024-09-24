package br.senai.hackathon.repository;

import br.senai.hackathon.entity.Meme;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Date;
import java.util.List;
import java.util.Optional;

public interface MemeRepository extends JpaRepository<Meme, Long> {

}
