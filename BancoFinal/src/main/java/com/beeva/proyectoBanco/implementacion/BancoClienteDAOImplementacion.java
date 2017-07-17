package com.beeva.proyectoBanco.implementacion;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.transaction.Transactional;

import org.springframework.stereotype.Repository;

import com.beeva.proyectoBanco.DAO.BancoClienteDAO;
import com.beeva.proyectoBanco.DAO.BancoDAO;
import com.beeva.proyectoBanco.models.Banco;
import com.beeva.proyectoBanco.models.Bancoscliente;


@Repository
public class BancoClienteDAOImplementacion extends BancoClienteDAO{

	@PersistenceContext
	EntityManager em;
	
	@Override
	@Transactional
	public boolean agregarClienteBanco(Bancoscliente bancoCliente) {
		em.persist(bancoCliente);
		return true;
	}

	@Override
	@Transactional
	public List<Bancoscliente> obtenerClientesBanco(int idBanco) {
		Query query = em.createQuery("SELECT e FROM Bancoscliente e WHERE e.banco.idbanco = :idbanco").setParameter("idbanco", idBanco);
		List<Bancoscliente> listaRegreso= query.getResultList();
		return listaRegreso;
	}

	@SuppressWarnings("null")
	@Override
	@Transactional
	public Banco getBancoCliente(int idCliente) {
		BancoDAO n = null;
		Banco res = new Banco();
		if(em.find(Bancoscliente.class, idCliente) != null){
			if(n.obtenerBanco(em.find(Bancoscliente.class, idCliente).getIdbancosclientes()) == null){
				System.err.println("objecto vacio");
			}else{
				res = n.obtenerBanco(em.find(Bancoscliente.class, idCliente).getIdbancosclientes());
			}
			
		}
		return res;
	}

}
