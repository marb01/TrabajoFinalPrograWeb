package pe.org.incatrek.repository;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

import pe.org.incatrek.model.Reserva;

@Repository
public interface IReservaRepository extends JpaRepository<Reserva, Integer>{
	
	@Query("from Reserva r where r.nombreReserva like %:nombreReserva%")
	List<Reserva> buscarNombreReserva(@Param("nombreReserva") String nombreReserva);
	
	@Query("from Reserva r where r.paquete.nombrePaquete like %:nombrePaquete%")
	List<Reserva> buscarPaquete(@Param("nombrePaquete") String nombrePaquete);

	@Query("from Reserva r where r.turista.nombreTurista like %:nombreTurista%")
	List<Reserva> buscarTurista(@Param("nombreTurista") String nombreTurista);
	
}
