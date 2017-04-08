package br.cesjf.lppo;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(name = "ListaRegistrosServlet", urlPatterns = {"/lista.html"})
public class ListaRegistrosServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            
            throws ServletException, IOException {
        
        List<Equipamento> equipamentos = new ArrayList<>();
        String filtro = request.getParameter("filtro");
     
        try {

            Class.forName("org.apache.derby.jdbc.ClientDriver");
            Connection conexao = DriverManager.getConnection("jdbc:derby://localhost:1527/lppo-2017-1", "usuario", "senha");
            Statement operacao = conexao.createStatement();
            ResultSet resultado = operacao.executeQuery("SELECT * FROM equipamento " + filtro);

            while(resultado.next()){
                Equipamento equipamentoAtual = new Equipamento();
                equipamentoAtual.setId(resultado.getLong("id"));
                equipamentoAtual.setSerie(resultado.getString("serie"));
                equipamentoAtual.setLocal(resultado.getString("local"));
                equipamentoAtual.setDescricao(resultado.getString("descricao"));
                equipamentoAtual.setEstado(resultado.getInt("estado"));
                equipamentos.add(equipamentoAtual);
            }
            System.out.println(equipamentos);

        } catch (ClassNotFoundException ex) {
            Logger.getLogger(ListaRegistrosServlet.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(ListaRegistrosServlet.class.getName()).log(Level.SEVERE, null, ex);
        }
         request.setAttribute("equipamentos", equipamentos);
          request.setAttribute("filtro", filtro);
          
        request.getRequestDispatcher("WEB-INF/lista-registro.jsp").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            
            throws ServletException, IOException {

    }

}