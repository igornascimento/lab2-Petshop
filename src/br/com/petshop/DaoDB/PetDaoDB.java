/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.petshop.DaoDB;

import br.com.petshop.DB.BDException;
import br.com.petshop.DB.DaoDB;
import br.com.petshop.DaoDB.ClienteDaoDB;
import br.com.petshop.dao.PetDao;
import br.com.petshop.dominio.Cliente;
import br.com.petshop.dominio.Pet;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Igor Nascimento <igornascimento@gmail.com>
 */
public class PetDaoDB extends DaoDB<Pet> implements PetDao {

    @Override
    public void salvar(Pet pet) {
        int id = 0;
        try {
            String sql = "INSERT INTO pet (nome, tipo, cliente) VALUES (?,?,?)";
            conectarObtendoId(sql);
            comando.setString(2, pet.getNome());
            comando.setInt(1, pet.getTipo());
            comando.setInt(3, pet.getCliente().getId());
            comando.executeUpdate();
            ResultSet resultado = comando.getGeneratedKeys();
            if (resultado.next()) {
                //seta o id para o objeto
                id = resultado.getInt(1);
                pet.setId(id);
            }
            else{
                System.err.println("Erro de Sistema - Nao gerou o id conforme esperado!");
                throw new BDException("Nao gerou o id conforme esperado!");
            }
        } catch (SQLException ex) {
            System.err.println("Erro de Sistema - Problema ao salvar cliente no Banco de Dados!");
            throw new BDException(ex);
        } finally {
            fecharConexao();
        }
    }

    @Override
    public void deletar(Pet pet) {
        try {
            String sql = "DELETE FROM pet WHERE id = ?";
            conectar(sql);
            comando.setInt(1, pet.getId());
            comando.executeUpdate();
        } catch (SQLException ex) {
            System.err.println("Erro de Sistema - Problema ao deletar cliente no Banco de Dados!");
            throw new RuntimeException(ex);
        } finally {
            fecharConexao();
        }
    }

    @Override
    public void atualizar(Pet pet) {
        try {
            String sql = "UPDATE pet SET nome=?, tipo=?, cliente=? WHERE id=?";
            conectar(sql);
            comando.setString(1, pet.getNome());
            comando.setInt(2, pet.getTipo());
            comando.setInt(3, pet.getCliente().getId());
            comando.setInt(4, pet.getId());
            comando.executeUpdate();
        } catch (SQLException ex) {
            System.err.println("Erro de Sistema - Problema ao atualizar paciente no Banco de Dados!");
            throw new BDException(ex);
        } finally {
            fecharConexao();
        }
    }

    @Override
    public List<Pet> listar() {
        List<Pet> listaPets = new ArrayList<>();
        String sql = "SELECT * FROM pet";

        try {
            conectar(sql);
            ResultSet resultado = comando.executeQuery();
            while (resultado.next()) {
                int id = resultado.getInt("id");
                String nome = resultado.getString("nome");
                int tipo = resultado.getInt("tipo");
                Cliente cliente = ClienteDaoDB.buscarPorId( resultado.getInt("cliente") );
                Pet pet = new Pet(id, nome, tipo, cliente);
                listaPets.add(pet);
            }
        } catch (SQLException ex) {
            System.err.println("Erro de Sistema - Problema ao buscar os pacientes do Banco de Dados!");
            throw new BDException(ex);
        } finally {
            fecharConexao();
        }
        return (listaPets);
    }

    @Override
    public Pet buscarPorId(int idBusca) {
        String sql = "SELECT * FROM paciente WHERE id = ?";

        try {
            conectar(sql);
            comando.setInt(1, idBusca);
            ResultSet resultado = comando.executeQuery();
            if (resultado.next()) {
                int id = resultado.getInt("id");
                String nome = resultado.getString("nome");
                int tipo = resultado.getInt("tipo");
                Cliente cliente = ClienteDaoDB.buscarPorId( resultado.getInt("cliente") );
                Pet pet = new Pet(id, nome, tipo, cliente);
                return pet;
            }
        } catch (SQLException ex) {
            System.err.println("Erro de Sistema - Problema ao buscar o paciente pelo id do Banco de Dados!");
            throw new BDException(ex);
        } finally {
            fecharConexao();
        }
        return (null);
    }

    @Override
    public List<Cliente> buscarPorNome(String nome) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
