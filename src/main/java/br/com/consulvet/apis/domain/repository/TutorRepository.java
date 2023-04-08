package br.com.consulvet.apis.domain.repository;

import br.com.consulvet.apis.domain.entity.Tutor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TutorRepository extends JpaRepository<Tutor,Long> {
}
