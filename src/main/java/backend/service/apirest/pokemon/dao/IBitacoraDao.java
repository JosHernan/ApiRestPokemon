package backend.service.apirest.pokemon.dao;

import org.springframework.data.repository.CrudRepository;

import backend.service.apirest.pokemon.entity.Bitacora;

public interface IBitacoraDao  extends CrudRepository<Bitacora,Long>{

}
