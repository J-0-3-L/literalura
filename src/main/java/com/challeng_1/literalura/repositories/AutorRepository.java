package com.challeng_1.literalura.repositories;

import com.challeng_1.literalura.entity.Autor;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AutorRepository extends JpaRepository<Autor, Long> {
}