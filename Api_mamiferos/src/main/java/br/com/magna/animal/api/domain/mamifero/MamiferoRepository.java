package br.com.magna.animal.api.domain.mamifero;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MamiferoRepository extends JpaRepository<Mamifero, Long>{

}
