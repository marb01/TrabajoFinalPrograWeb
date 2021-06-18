package pe.org.incatrek.repository;


import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import pe.org.incatrek.model.Declaracion;

@Repository
public interface IDeclaracionRepository extends JpaRepository<Declaracion, Integer>{	
	@Query("from Declaracion d where d.idDeclaracion like %:idDeclaracion%")
	List<Declaracion> buscarPorId(@Param("idDeclaracion") int idDeclaracion);
	
	@Query("select count(d.idDeclaracion) from Declaracion d where d.idDeclaracion = :idDeclaracion")
	public int busquedaIDdeclaracion(@Param("idDeclaracion") int idDeclaracion);
	
	@Query("from Declaracion d where d.turista.idTurista like %:idTurista%")
	List<Declaracion> buscarTurista(@Param("idTurista") int idTurista);
}
