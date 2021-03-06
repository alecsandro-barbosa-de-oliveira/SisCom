/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;


import Controle.Usuario;
import java.net.ConnectException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Alex
 */
public class UsuarioDao {
    
    
    private Connection conn = null;
    
    
    public UsuarioDao(){
    
        conn = ConexaoJdbc.getConnection();
    }
    
    public boolean cadastra (Usuario usuario){
    
        String query = "INSERT INTO usuario(nome, login, senha, cpf, telefone, email, rua, numero, bairro, cidade, estado)VALUES(?,?,?,?,?,?,?,?,?,?,?)";
    
        
        PreparedStatement stmt = null;
        
      
        try {
            
            stmt = conn.prepareStatement(query);
            stmt.setString(1, usuario.getNome());
            stmt.setString(2, usuario.getLogin());
            stmt.setString(3, usuario.getSenha());
            stmt.setString(4, usuario.getCpf());
            stmt.setString(5, usuario.getTelefone());
            stmt.setString(6, usuario.getEmail());
            stmt.setString(7, usuario.getRua());
            stmt.setString(8, usuario.getNumero());
            stmt.setString(9, usuario.getBairro());
            stmt.setString(10, usuario.getCidade());
            stmt.setString(11, usuario.getEstado());
            
            stmt.executeUpdate();
            
            
           return true; 
        } catch (SQLException ex) {
            Logger.getLogger(UsuarioDao.class.getName()).log(Level.SEVERE, null, ex);
            return false;
        }finally{
        
            ConexaoJdbc.closeConnection(conn, stmt);
        }
        
        
    
        
    }
    
    
}
