package pe.org.incatrek.repository;


import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import pe.org.incatrek.model.Turista;

@Repository
public interface ITuristaRepository extends JpaRepository<Turista, Integer>
{	
	@Query("select count(t.dniTurista) from Turista t where t.dniTurista = :dniTurista")
	public int busquedaDNITurista(@Param("dniTurista") String dniTurista);
	
	@Query("from Turista t where t.nombreTurista like %:nombreTurista%")
	List<Turista> buscarPorNombre(@Param("nombreTurista") String nombreTurista);
	
	@Query("from Turista t where t.dniTurista like %:dniTurista%")
	List<Turista> buscarPorDNI(@Param("dniTurista") String dniTurista);

}
