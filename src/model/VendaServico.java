package model;

import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.Map;

/**
*
* @author Igor Nascimento <igornascimento@gmail.com>
*/
public class VendaServico {

	private static int id = 0;
	private LocalDateTime datahora;
	private Cliente cliente;
	private Pet pet;
	private Map<Integer, Servico> servicoMap;
        private double total;
	
	public VendaServico() {
	}

	public VendaServico(LocalDateTime datahora, Cliente cliente, Pet pet, Map<Integer, Servico> servicoMap) {
		this.id = ++this.id;
		this.datahora = datahora;
		this.cliente = cliente;
		this.pet = pet;
		this.servicoMap = servicoMap;
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
        
        public Pet getPet() {
		return pet;
	}

	public void setPet(Pet pet) {
		this.pet = pet;
	}

        public Map<Integer, Servico> getServicoMap() {
            return servicoMap;
        }

        public void setServicoMap(Map<Integer, Servico> servicoMap) {
            this.servicoMap = servicoMap;
        }
        
        public void setTotal(double val) {
            this.total = val;
        }
        
        public double getTotal() {
            return total;
        }
	
}
