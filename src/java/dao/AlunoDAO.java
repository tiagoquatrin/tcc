/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import model.Aluno;
import model.Vaga;
/**
 *
 * @author tiago.silva
 */
public class AlunoDAO {
    
     private Conexao conexao;
    private Statement stmt;
    private boolean sucesso = false;
    Aluno aluno = new Aluno();
 
    public AlunoDAO() {
        conexao = new Conexao();
        try {
            stmt = (Statement) conexao.getConn().createStatement();
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }
    
     public boolean alterarPerfil(Aluno aluno) {
        try {
            stmt.execute("UPDATE aluno SET nome = '"+aluno.getNome()  +"', curso = '"+aluno.getCurso()  +"', semestre = '" +aluno.getSemestre() +"', datadenasc= '" +aluno.getDatadenasc()  + "',contato= '" +aluno.getContato() + "', telefone= '" +aluno.getTelefone() + "',areadeinteresse = '" +aluno.getAreadeinteresse()  + "', areadeinteresse1 ='" +aluno.getAreadeinteresse1()  + "', cargopretendido ='" +aluno.getCargopretendido() + "', cargopretendido1='" +aluno.getCargopretendido1() + "', infoadicionais= '" +aluno.getInfoadicionais() + "', experienciaanteriorcargo ='" +aluno.getExperienciaanteriorcargo()  + "', experienciaanteriorcargo1 = '"+aluno.getExperienciaanteriorcargo1() +"', experienciaanteriordescricao ='"+aluno.getExperienciaanteriordescricao()+"', experienciaanteriordescricao1='" +aluno.getExperienciaanteriordescricao1() + "', experienciaanteriorempresa = '"+aluno.getExperienciaanteriorempresa()+"', experienciaanteriorempresa1='"+aluno.getExperienciaanteriorempresa1()+"' WHERE id = '" + aluno.getId()+ "'");
            sucesso = true;
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            conexao.fecharConexao();
        }
 
        return sucesso;
    }
      public boolean alterarSenha(Aluno aluno) {
          String senhaatual = aluno.getSenha();
          System.out.print(senhaatual);
          String novasenha = aluno.getNovasenha();
          String novasenha1 = aluno.getNovasenha1();
          System.out.print(novasenha);
           System.out.print(novasenha1);
        int tamanho =   novasenha.length();
           
          if (aluno.getSenha().equals(senhaatual) & novasenha.equals(novasenha1) & !novasenha1.equals(senhaatual) & tamanho==6 ){
          
        try {
            stmt.execute("UPDATE aluno SET  senha='"+aluno.getNovasenha()+"' WHERE id = '" + aluno.getId()+ "'");
            sucesso = true;
            
            
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            conexao.fecharConexao();
        }
          }
          
          
        return sucesso;
    }
     public boolean selecionarAluno(Aluno aluno){
          try {
            ResultSet rs = stmt.executeQuery("SELECT * FROM aluno where matricula ='"+aluno.getMatricula()+"' ");
            while (rs.next()) {
                String teste;
                aluno.setAreadeinteresse(rs.getString("areadeinteresse"));
                aluno.setAreadeinteresse1(rs.getString("areadeinteresse1"));
                aluno.setCargopretendido(rs.getString("cargopretendido"));     
                aluno.setCargopretendido1(rs.getString("cargopretendido1"));
                aluno.setContato(rs.getString("contato"));
              aluno.setCurso(rs.getString("curso"));
                aluno.setDatadenasc(rs.getString("datadenasc"));
                aluno.setExperienciaanteriorcargo(rs.getString("experienciaanteriorcargo"));
                aluno.setExperienciaanteriorcargo1(rs.getString("experienciaanteriorcargo1"));
                aluno.setExperienciaanteriordescricao(rs.getString("experienciaanteriordescricao"));
               aluno.setExperienciaanteriordescricao1(rs.getString("experienciaanteriordescricao1"));
               aluno.setExperienciaanteriorempresa(rs.getString("experienciaanteriorempresa"));
                 aluno.setExperienciaanteriorempresa1(rs.getString("experienciaanteriorempresa1"));
                   aluno.setInfoadicionais(rs.getString("infoadicionais"));
                     aluno.setNome(rs.getString("nome"));
                       aluno.setSemestre(rs.getString("semestre"));
                         aluno.setTelefone(rs.getString("telefone"));
                          teste= rs.getString("curso");
                         System.out.print(teste);
                         
                         
                         
                         sucesso = true;
            }
                         } catch (Exception e) {
            e.printStackTrace();
        } finally {
            conexao.fecharConexao();
        }
 
        return sucesso;
         
     }
     
     
     public List<Aluno> listar(Aluno aluno) {
        List<Aluno> alunos = new ArrayList<>();
        try {
            ResultSet rs = stmt.executeQuery("SELECT * FROM aluno where matricula ='"+aluno.getMatricula()+"' ");
            while (rs.next()) {
                
                aluno.setAreadeinteresse(rs.getString("areadeinteresse"));
                aluno.setAreadeinteresse1(rs.getString("areadeinteresse1"));
                aluno.setCargopretendido(rs.getString("cargopretendido"));     
                aluno.setCargopretendido1(rs.getString("cargopretendido1"));
                aluno.setContato(rs.getString("contato"));
                aluno.setCurso(rs.getString("curso"));
                aluno.setDatadenasc(rs.getString("datadenasc"));
                aluno.setExperienciaanteriorcargo(rs.getString("experienciaanteriorcargo"));
                aluno.setExperienciaanteriorcargo1(rs.getString("experienciaanteriorcargo1"));
                aluno.setExperienciaanteriordescricao(rs.getString("experienciaanteriordescricao"));
               aluno.setExperienciaanteriordescricao1(rs.getString("experienciaanteriordescricao1"));
               aluno.setExperienciaanteriorempresa(rs.getString("experienciaanteriorempresa"));
                 aluno.setExperienciaanteriorempresa1(rs.getString("experienciaanteriorempresa1"));
                   aluno.setInfoadicionais(rs.getString("infoadicionais"));
                     aluno.setNome(rs.getString("nome"));
                       aluno.setSemestre(rs.getString("semestre"));
                         aluno.setTelefone(rs.getString("telefone"));
               
                alunos.add(aluno);
            }
 
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            conexao.fecharConexao();
        }
 
        return alunos;
    }
}
