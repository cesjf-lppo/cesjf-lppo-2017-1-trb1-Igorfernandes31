package br.cesjf.lppo;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(name = "EditaRegistroServlet", urlPatterns = {"/edita.html"})
public class EditaRegistroServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        Equipamento equipamento = new Equipamento();
        
        Long id = Long.parseLong(request.getParameter("id"));

        try {
           
            Class.forName("org.apache.derby.jdbc.ClientDriver");
            Connection conexao = DriverManager.getConnection("jdbc:derby://localhost:1527/lppo-2017-1", "usuario", "senha");
            Statement operacao = conexao.createStatement();
            ResultSet resultado = operacao.executeQuery("SELECT * FROM equipamento WHERE id=" + id);
            if (resultado.next()) {
                
                equipamento = new Equipamento(); equipamento.setId(resultado.getLong("id"));
                
                equipamento.setSerie(resultado.getString("serie")); equipamento.setLocal(resultado.getString("local"));
                
                equipamento.setDescricao(resultado.getString("descricao"));equipamento.setEstado(resultado.getInt("estado"));
            }

        } catch (ClassNotFoundException ex) {
            Logger.getLogger(ListaRegistrosServlet.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(ListaRegistrosServlet.class.getName()).log(Level.SEVERE, null, ex);
        }

        request.setAttribute("equipamento", equipamento);
        request.getRequestDispatcher("WEB-INF/edita-registro.jsp").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
         Equipamento equipamento = new Equipamento();
         
        equipamento.setId(Long.parseLong(request.getParameter("id")));
        
        equipamento.setSerie(request.getParameter("serie"));equipamento.setLocal(request.getParameter("local"));
        
        equipamento.setDescricao(request.getParameter("descricao"));equipamento.setEstado(Integer.parseInt(request.getParameter("estado")));

        try {
            
            Class.forName("org.apache.derby.jdbc.ClientDriver");
            Connection conexao = DriverManager.getConnection("jdbc:derby://localhost:1527/lppo-2017-1", "usuario", "senha");
            Statement operacao = conexao.createStatement();
            
            operacao.executeUpdate("UPDATE equipamento SET serie='"
                    + equipamento.getSerie() + "', local='"
                    + equipamento.getLocal() + "', descricao='"
                    + equipamento.getDescricao() + "', estado="
                    + equipamento.getEstado() + " WHERE id=" 
                    + equipamento.getId());

        } catch (ClassNotFoundException ex) {
            Logger.getLogger(ListaRegistrosServlet.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(ListaRegistrosServlet.class.getName()).log(Level.SEVERE, null, ex);
        }

        response.sendRedirect("lista.html"); 

    }

}