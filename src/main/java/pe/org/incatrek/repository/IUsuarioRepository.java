package pe.org.incatrek.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import pe.org.incatrek.model.Users;

@Repository
public interface IUsuarioRepository extends JpaRepository<Users, Long>{
	public Users findByUsername(String username);

}
