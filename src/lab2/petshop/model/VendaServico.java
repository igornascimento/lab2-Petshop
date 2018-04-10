package lab2.petshop.model;

import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;

/**
*
* @author Igor Nascimento <igornascimento@gmail.com>
*/
public class VendaServico {

	private static Random vendaServicoIdGenerator = new Random();
	private int id;
	private LocalDateTime datahora;
	private Cliente cliente;
	private Map<Pet, List<Servico>> mapPetServicos;
	
	public VendaServico() {
	}

	public VendaServico(LocalDateTime datahora, Cliente cliente, Pet pet, List<Servico> listaServicos) {
		this.id = vendaServicoIdGenerator.nextInt(100);
		this.datahora = datahora;
		this.cliente = cliente;
		this.mapPetServicos = new HashMap();
		this.mapPetServicos.put(pet, listaServicos);
	}
	
	public int getId() {
		return id;
	}

	public LocalDateTime getDatahora() {
		return datahora;
	}

	public void setDatahora(LocalDateTime datahora) {
		this.datahora = datahora;
	}

	public Cliente getCliente() {
		return cliente;
	}

	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}

	public Map<Pet, List<Servico>> getMapPetServicos() {
		return mapPetServicos;
	}

	public void setListaPets(Pet pet, List<Servico> listaServicos) {
		this.mapPetServicos.put(pet, listaServicos);
	}
	
}
