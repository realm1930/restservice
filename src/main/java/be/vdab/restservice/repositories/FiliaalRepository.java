package be.vdab.restservice.repositories;

import be.vdab.restservice.domain.Filiaal;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * @author Arne Van Eycken
 * @version 1.0
 */

public interface FiliaalRepository extends JpaRepository<Filiaal,Long> {

}
