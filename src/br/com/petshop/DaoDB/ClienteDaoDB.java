/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.petshop.DaoDB;

import br.com.petshop.DB.BDException;
import br.com.petshop.DB.DaoDB;
import br.com.petshop.dominio.Cliente;
import br.com.petshop.dao.ClienteDao;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author 180503743
 */
public class ClienteDaoDB extends DaoDB<Cliente> implements ClienteDao  {
    
    @Override
    public void salvar(Cliente cliente) {
        int id = 0;
        try {
            String sql = "INSERT INTO cliente (rg, nome, telefone) VALUES (?,?,?)";
            conectarObtendoId(sql);
            comando.setString(1, cliente.getRg());
            comando.setString(2, cliente.getNome());
            comando.setString(3, cliente.getTelefone());
            comando.executeUpdate();
            ResultSet resultado = comando.getGeneratedKeys();
            if (resultado.next()) {
                //seta o id para o objeto
                id = resultado.getInt(1);
                cliente.setId(id);
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
    public void deletar(Cliente cliente) {
        try {
            String sql = "DELETE FROM cliente WHERE id = ?";
            conectar(sql);
            comando.setInt(1, cliente.getId());
            comando.executeUpdate();
        } catch (SQLException ex) {
            System.err.println("Erro de Sistema - Problema ao deletar cliente no Banco de Dados!");
            throw new RuntimeException(ex);
        } finally {
            fecharConexao();
        }
    }

    @Override
    public void atualizar(Cliente cliente) {
        try {
            String sql = "UPDATE paciente SET rg=?, nome=?, telefone=? WHERE id=?";
            conectar(sql);
            comando.setString(1, cliente.getNome());
            comando.setString(2, cliente.getTelefone());
            comando.setString(3, cliente.getRg());
            comando.setInt(4, cliente.getId());
            comando.executeUpdate();
        } catch (SQLException ex) {
            System.err.println("Erro de Sistema - Problema ao atualizar paciente no Banco de Dados!");
            throw new BDException(ex);
        } finally {
            fecharConexao();
        }
    }

    @Override
    public List<Cliente> listar() {
        List<Cliente> listaClientes = new ArrayList<>();

        String sql = "SELECT * FROM paciente";

        try {
            conectar(sql);
            ResultSet resultado = comando.executeQuery();
            while (resultado.next()) {
                int id = resultado.getInt("id");
                String rg = resultado.getString("rg");
                String nome = resultado.getString("nome");
                String telefone = resultado.getString("telefone");
                Cliente cliente = new Cliente(id, rg, nome, telefone);
                listaClientes.add(cliente);
            }
        } catch (SQLException ex) {
            System.err.println("Erro de Sistema - Problema ao buscar os pacientes do Banco de Dados!");
            throw new BDException(ex);
        } finally {
            fecharConexao();
        }
        return (listaClientes);
    }

    @Override
    public Cliente buscarPorId(int id) {
        String sql = "SELECT * FROM paciente WHERE id = ?";

        try {
            conectar(sql);
            comando.setInt(1, id);
            ResultSet resultado = comando.executeQuery();
            if (resultado.next()) {
                String rg = resultado.getString("rg");
                String nome = resultado.getString("nome");
                String telefone = resultado.getString("telefone");
                Cliente cliente = new Cliente(id, rg, nome, telefone);
                return cliente;
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
    public Cliente buscarPorRg(String rg) {
        String sql = "SELECT * FROM paciente WHERE rg = ?";

        try {
            conectar(sql);
            comando.setString(1, rg);
            ResultSet resultado = comando.executeQuery();

            if (resultado.next()) {
                int id = resultado.getInt("id");
                String nome = resultado.getString("nome");
                String telefone = resultado.getString("telefone");
                Cliente cliente = new Cliente(id, rg, nome, telefone);
                return cliente;
            }
        } catch (SQLException ex) {
            System.err.println("Erro de Sistema - Problema ao buscar o paciente pelo rg do Banco de Dados!");
            throw new BDException(ex);
        } finally {
            fecharConexao();
        }
        return (null);
    }
    
    @Override
    public List<Cliente> buscarPorNome(String nomeBusca) {
        List<Cliente> listaClientes = new ArrayList<>();
        String sql = "SELECT * FROM paciente WHERE nome LIKE ?";

        try {
            conectar(sql);
            comando.setString(1, "%" + nomeBusca + "%");
            ResultSet resultado = comando.executeQuery();

            while (resultado.next()) {
                int id = resultado.getInt("id");
                String rg = resultado.getString("rg");
                String nome = resultado.getString("nome");
                String telefone = resultado.getString("telefone");
                Cliente pac = new Cliente(id, rg, nome, telefone);
                listaClientes.add(pac);
            }
        } catch (SQLException ex) {
            System.err.println("Erro de Sistema - Problema ao buscar os pacientes pelo nome do Banco de Dados!");
            throw new BDException(ex);
        } finally {
            fecharConexao();
        }
        return (listaClientes);
    }
    
}
