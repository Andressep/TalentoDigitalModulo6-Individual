package cl.awakelab.springboot.repositories;

import cl.awakelab.springboot.models.entities.Alumno;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IAlumnoRepository extends JpaRepository<Alumno, Integer> {
}
