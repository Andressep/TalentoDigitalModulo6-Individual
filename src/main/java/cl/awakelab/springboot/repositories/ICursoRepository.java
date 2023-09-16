package cl.awakelab.springboot.repositories;

import cl.awakelab.springboot.models.entities.Curso;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ICursoRepository extends JpaRepository<Curso, Integer> {
}
