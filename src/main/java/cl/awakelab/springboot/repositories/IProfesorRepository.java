package cl.awakelab.springboot.repositories;

import cl.awakelab.springboot.models.entities.Profesor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IProfesorRepository extends JpaRepository<Profesor, Integer> {
}
