package backend.service.apirest.pokemon.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import backend.service.apirest.pokemon.dao.IBitacoraDao;
import backend.service.apirest.pokemon.entity.Bitacora;

@Service
public class BitacoraServiceImpl implements IBitacoraService{

	
	@Autowired
	private IBitacoraDao bitacoraDao;
	@Override
	@Transactional
	public Bitacora guardar(Bitacora bitacora) {
		return bitacoraDao.save(bitacora);
	}

}
