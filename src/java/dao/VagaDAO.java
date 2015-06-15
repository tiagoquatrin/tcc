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
import model.Vaga;

/**
 *
 * @author tiago.silva
 */

    public class VagaDAO {
 
    private Conexao conexao;
    private Statement stmt;
    private boolean sucesso = false;
    Vaga vaga = new Vaga();
 
    public VagaDAO() {
        conexao = new Conexao();
        try {
            stmt = (Statement) conexao.getConn().createStatement();
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }
 
    public boolean inserirMonitoria(Vaga vaga) {
        try {
            stmt.execute("INSERT INTO vaga (loc,tipo,descricao,titulo,contato,cargahoraria,valor,nomeorientador,duracao,tipoprojeto,cursorelacionado,beneficios,disciplina,cargo,area,cursorelacionado1) VALUES ('" + vaga.getLoc() + "','Monitoria','" + vaga.getDescricao()+ "','" + vaga.getTitulo()+ "', '" + vaga.getContato()+ "','" + vaga.getCargahoraria()+ "', '" + vaga.getValor()+ "','" + vaga.getNomeorientador()+ "', '','','" + vaga.getCursorelacionado()+ "', '','" + vaga.getDisciplina()+ "', '"+vaga.getCargo()+"', '"+vaga.getArea()+"','" + vaga.getCursorelacionado1()+ "' )");
            sucesso = true;
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            conexao.fecharConexao();
        }
 
        return sucesso;
    }
    public boolean inserirProjeto(Vaga vaga) {
        try {
            stmt.execute("INSERT INTO vaga (loc,tipo,descricao,titulo,contato,cargahoraria,valor,nomeorientador,duracao,tipoprojeto,cursorelacionado,beneficios,disciplina, cargo, area, cursorelacionado1) VALUES ('" + vaga.getLoc() + "','Projeto','" + vaga.getDescricao()+ "','" + vaga.getTitulo()+ "', '" + vaga.getContato()+ "','" + vaga.getCargahoraria()+ "', '" + vaga.getValor()+ "','" + vaga.getNomeorientador()+ "', '','" + vaga.getTipoprojeto()+ "','" + vaga.getCursorelacionado()+ "', '','', '"+vaga.getCargo()+"', '"+vaga.getArea()+"', '" + vaga.getCursorelacionado1()+ "')");
            sucesso = true;
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            conexao.fecharConexao();
        }
 
        return sucesso;
    }
    public boolean inserirEmprego(Vaga vaga) {
        try {
            stmt.execute("INSERT INTO vaga (loc,tipo,descricao,titulo,contato,cargahoraria,valor,nomeorientador,duracao,tipoprojeto,cursorelacionado,beneficios,disciplina, cargo, area,cursorelacionado1) VALUES ('" + vaga.getLoc() + "','Emprego','" + vaga.getDescricao()+ "','" + vaga.getTitulo()+ "', '" + vaga.getContato()+ "','" + vaga.getCargahoraria()+ "', '" + vaga.getValor()+ "','', '','','" + vaga.getCursorelacionado()+ "', '" + vaga.getBeneficios()+ "','', '"+vaga.getCargo()+"', '"+vaga.getArea()+"', '" + vaga.getCursorelacionado1()+ "')");
            sucesso = true;
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            conexao.fecharConexao();
        }
 
        return sucesso;
    }
    public boolean inserirEstagio(Vaga vaga) {
        try {
            stmt.execute("INSERT INTO vaga (loc,tipo,descricao,titulo,contato,cargahoraria,valor,nomeorientador,duracao,tipoprojeto,cursorelacionado,beneficios,disciplina, cargo, area,cursorelacionado1) VALUES ('" + vaga.getLoc() + "','Estagio','" + vaga.getDescricao()+ "','" + vaga.getTitulo()+ "', '" + vaga.getContato()+ "','" + vaga.getCargahoraria()+ "', '" + vaga.getValor()+ "','', '','','" + vaga.getCursorelacionado()+ "', '" + vaga.getBeneficios()+ "','', '"+vaga.getCargo()+"', '"+vaga.getArea()+"', '" + vaga.getCursorelacionado1()+ "')");
            sucesso = true;
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            conexao.fecharConexao();
        }
 
        return sucesso;
    }
     public boolean inserirBolsa(Vaga vaga) {
        try {
            stmt.execute("INSERT INTO vaga (loc,tipo,descricao,titulo,contato,cargahoraria,valor,nomeorientador,duracao,tipoprojeto,cursorelacionado,beneficios,disciplina, cargo, area, cursorelacionado1) VALUES ('" + vaga.getLoc() + "','Bolsa','" + vaga.getDescricao()+ "','" + vaga.getTitulo()+ "', '" + vaga.getContato()+ "','" + vaga.getCargahoraria()+ "', '" + vaga.getValor()+ "','', '','','" + vaga.getCursorelacionado()+ "', '','', '"+vaga.getCargo()+"', '"+vaga.getArea()+"','" + vaga.getCursorelacionado1()+ "')");
            sucesso = true;
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            conexao.fecharConexao();
        }
 
        return sucesso;
    }
 
    public boolean alterar(Vaga vaga) {
        try {
            stmt.execute("UPDATE vaga SET loc = '" + vaga.getLoc()+ "', descricao = '" + vaga.getDescricao() + "', titulo = '" + vaga.getTitulo() + "', contato= '" + vaga.getContato() + "',cargahoraria= '" + vaga.getCargahoraria() + "', valor= '" + vaga.getValor()+ "', cursorelacionado= '" + vaga.getCursorelacionado() + "', beneficios ='" + vaga.getBeneficios() + "', nomeorientador ='" + vaga.getNomeorientador() + "', duracao='" + vaga.getDuracao() + "', tipoprojeto= '" + vaga.getTipoprojeto()+ "', disciplina ='" + vaga.getDisciplina() + "', cargo = '"+vaga.getCargo()+"', area ='"+vaga.getArea()+"', cursorelacionado1='" + vaga.getCursorelacionado1()+ "' WHERE id = '" + vaga.getId() + "'");
            sucesso = true;
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            conexao.fecharConexao();
        }
 
        return sucesso;
    }
 
    public boolean remover(Vaga vaga) {
        try {
            System.out.print("deletando");
            stmt.execute("DELETE from vaga  WHERE id = '" + vaga.getId() + "'");
            sucesso = true;
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            conexao.fecharConexao();
        }
 
        return sucesso;
    }
 
    public List<Vaga> listarMonitorias(String teste) {
        List<Vaga> monitorias = new ArrayList<>();
        try {
            ResultSet rs = stmt.executeQuery("SELECT id,loc,descricao,titulo,contato,cargahoraria,valor,nomeorientador,duracao,cursorelacionado,disciplina, cargo, area,cursorelacionado1 FROM vaga where tipo ='Monitoria' and titulo || descricao || loc || id LIKE '%"+teste+"%' ORDER BY id");
            while (rs.next()) {
                Vaga vaga = new Vaga();
                 vaga.setId(rs.getInt("id"));
                vaga.setLoc(rs.getString("loc"));
                vaga.setDescricao(rs.getString("descricao"));     
                vaga.setTitulo(rs.getString("titulo"));
                vaga.setContato(rs.getString("contato"));
                vaga.setCargahoraria(rs.getString("cargahoraria"));
                vaga.setValor(rs.getString("valor"));
                vaga.setNomeorientador(rs.getString("nomeorientador"));
                vaga.setDuracao(rs.getString("duracao"));
                vaga.setCursorelacionado(rs.getString("cursorelacionado"));
                vaga.setDisciplina(rs.getString("disciplina"));              
                vaga.setCargo(rs.getString("cargo"));
                vaga.setArea(rs.getString("area"));  
                vaga.setCursorelacionado1(rs.getString("cursorelacionado1"));
                monitorias.add(vaga);
            }
 
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            conexao.fecharConexao();
        }
 
        return monitorias;
    }
    public List<Vaga> listarBolsas() {
        List<Vaga> bolsas = new ArrayList<>();
        try {
            ResultSet rs = stmt.executeQuery("SELECT id,loc,descricao,titulo,contato,cargahoraria,valor,nomeorientador,duracao,cursorelacionado,disciplina, cargo, area,cursorelacionado1 FROM vaga where tipo ='Bolsa' and ORDER BY id");
            while (rs.next()) {
                Vaga vaga = new Vaga();
                 vaga.setId(rs.getInt("id"));
                vaga.setLoc(rs.getString("loc"));
                vaga.setDescricao(rs.getString("descricao"));     
                vaga.setTitulo(rs.getString("titulo"));
                vaga.setContato(rs.getString("contato"));
                vaga.setCargahoraria(rs.getString("cargahoraria"));
                vaga.setValor(rs.getString("valor"));
                vaga.setNomeorientador(rs.getString("nomeorientador"));
                vaga.setDuracao(rs.getString("duracao"));
                vaga.setCursorelacionado(rs.getString("cursorelacionado"));
                vaga.setDisciplina(rs.getString("disciplina"));  
                vaga.setCargo(rs.getString("cargo"));
                vaga.setArea(rs.getString("area")); 
                vaga.setCursorelacionado1(rs.getString("cursorelacionado1"));
 
                bolsas.add(vaga);
            }
 
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            conexao.fecharConexao();
        }
 
        return bolsas;
    }
    public boolean pesquisaBolsas(Vaga vaga) {
       
        
        try {
           stmt.executeQuery("SELECT * FROM vaga where tipo ='Bolsa' ORDER BY id");
            
              
                 
                sucesso = true;
            
 
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            conexao.fecharConexao();
        }
 
        return sucesso;
    }
     public boolean pesquisaProjetos(Vaga vaga) {
       
        
        try {
           stmt.executeQuery("SELECT * FROM vaga where tipo ='Projeto' ORDER BY id");
            
              
                 
                sucesso = true;
            
 
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            conexao.fecharConexao();
        }
 
        return sucesso;
    }
     public boolean pesquisaEstagios(Vaga vaga) {
       
        
        try {
           stmt.executeQuery("SELECT * FROM vaga where tipo ='Estagio' ORDER BY id");
            
              
                 
                sucesso = true;
            
 
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            conexao.fecharConexao();
        }
 
        return sucesso;
    }
    public boolean pesquisaEmpregos(Vaga vaga) {
       
        
        try {
           stmt.executeQuery("SELECT * FROM vaga where tipo ='Emprego' ORDER BY id");
            
              
                 
                sucesso = true;
            
 
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            conexao.fecharConexao();
        }
 
        return sucesso;
    }
    public boolean pesquisaMonitorias(Vaga vaga) {
       
        
        try {
           stmt.executeQuery("SELECT * FROM vaga where tipo ='Monitoria' ORDER BY id");
            
              
                 
                sucesso = true;
            
 
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            conexao.fecharConexao();
        }
 
        return sucesso;
    }
    public List<Vaga> pesquisarBolsas(String teste) {
        List<Vaga> pesquisabolsas = new ArrayList<>();
           pesquisabolsas.clear();
           System.out.println(teste );
           if(teste==null)
           {
            try {
            ResultSet rs = stmt.executeQuery("SELECT id,loc,descricao,titulo,contato,cargahoraria,valor,cursorelacionado, cargo, area, cursorelacionado1 FROM vaga where tipo ='Bolsa' order by id");
            while (rs.next()) {
              Vaga vaga = new Vaga();
                 vaga.setId(rs.getInt("id"));
                vaga.setLoc(rs.getString("loc"));
                vaga.setDescricao(rs.getString("descricao"));     
                vaga.setTitulo(rs.getString("titulo"));
                vaga.setContato(rs.getString("contato"));
                vaga.setCargahoraria(rs.getString("cargahoraria"));
                vaga.setValor(rs.getString("valor"));
                vaga.setCursorelacionado(rs.getString("cursorelacionado"));
                vaga.setCargo(rs.getString("cargo"));
                vaga.setArea(rs.getString("area")); 
                vaga.setCursorelacionado1(rs.getString("cursorelacionado1"));           
 vaga.setTipo(rs.getString("tipo"));
                pesquisabolsas.add(vaga);
            }
 
        } catch (Exception e) {
            e.printStackTrace();
        } finally {  
            conexao.fecharConexao();
            }
           }
            else {
        try {
            ResultSet rs = stmt.executeQuery("SELECT id,loc,descricao,titulo,contato,cargahoraria,valor,cursorelacionado, cargo, area,cursorelacionado1 FROM vaga where tipo ='Bolsa' and titulo || descricao || loc || id LIKE '%"+teste+"%' order by id");
            while (rs.next()) {
              Vaga vaga = new Vaga();
                 vaga.setId(rs.getInt("id"));
                vaga.setLoc(rs.getString("loc"));
                vaga.setDescricao(rs.getString("descricao"));     
                vaga.setTitulo(rs.getString("titulo"));
                vaga.setContato(rs.getString("contato"));
                vaga.setCargahoraria(rs.getString("cargahoraria"));
                vaga.setValor(rs.getString("valor"));
                vaga.setCursorelacionado1(rs.getString("cursorelacionado1"));
                vaga.setCursorelacionado(rs.getString("cursorelacionado"));
                vaga.setCargo(rs.getString("cargo"));
                vaga.setArea(rs.getString("area")); 
                  vaga.setTipo(rs.getString("tipo"));           
 
                pesquisabolsas.add(vaga);
            }
 
        } catch (Exception e) {
            e.printStackTrace();
        } finally 
            {
            conexao.fecharConexao();
        }
                    }
        return pesquisabolsas;
    }
    public List<Vaga> pesquisarEmpregos(String teste) {
        List<Vaga> empregos = new ArrayList<>();
           empregos.clear();
           System.out.println(teste );
           if(teste==null)
           {
            try {
            ResultSet rs = stmt.executeQuery("SELECT id,loc,descricao,titulo,contato,cargahoraria,valor,beneficios, cargo,area,cursorelacionado1 FROM vaga where tipo ='Emprego' order by id");
            while (rs.next()) {
              Vaga vaga = new Vaga();
                 vaga.setId(rs.getInt("id"));
                vaga.setLoc(rs.getString("loc"));
                vaga.setDescricao(rs.getString("descricao"));     
                vaga.setTitulo(rs.getString("titulo"));
                vaga.setContato(rs.getString("contato"));
                vaga.setCargahoraria(rs.getString("cargahoraria"));
                vaga.setValor(rs.getString("valor"));
                vaga.setBeneficios(rs.getString("beneficios"));
                vaga.setCargo(rs.getString("cargo"));
                vaga.setArea(rs.getString("area")); 
                vaga.setCursorelacionado1(rs.getString("cursorelacionado1"));          
                vaga.setCursorelacionado(rs.getString("cursorelacionado")); 
                vaga.setTipo(rs.getString("tipo"));
                empregos.add(vaga);
            }
 
        } catch (Exception e) {
            e.printStackTrace();
        } finally {  
            conexao.fecharConexao();
            }
           }
            else {
        try {
            ResultSet rs = stmt.executeQuery("SELECT id,loc,descricao,titulo,contato,cargahoraria,valor,cursorelacionado,beneficios, cargo, area, cursorelacionado1 FROM vaga where tipo ='Emprego' and titulo || descricao || loc || id LIKE '%"+teste+"%' order by id");
            while (rs.next()) {
              Vaga vaga = new Vaga();
                 vaga.setId(rs.getInt("id"));
                vaga.setLoc(rs.getString("loc"));
                vaga.setDescricao(rs.getString("descricao"));     
                vaga.setTitulo(rs.getString("titulo"));
                vaga.setContato(rs.getString("contato"));
                vaga.setCargahoraria(rs.getString("cargahoraria"));
                vaga.setValor(rs.getString("valor"));
        
                vaga.setBeneficios(rs.getString("beneficios"));
                vaga.setCargo(rs.getString("cargo"));
                vaga.setArea(rs.getString("area")); 
               vaga.setCursorelacionado1(rs.getString("cursorelacionado1"));     
                 vaga.setCursorelacionado(rs.getString("cursorelacionado"));
                 vaga.setTipo(rs.getString("tipo"));
                empregos.add(vaga);
            }
 
        } catch (Exception e) {
            e.printStackTrace();
        } finally 
            {
            conexao.fecharConexao();
        }
                    }
        return empregos;
    }
     public List<Vaga> pesquisarProjetos(String teste) {
        List<Vaga> projetos = new ArrayList<>();
           projetos.clear();
           System.out.println(teste );
           if(teste==null)
           {
            try {
            ResultSet rs = stmt.executeQuery("SELECT id,loc,descricao,titulo,contato,cargahoraria,valor,cursorelacionado,tipoprojeto,nomeorientador, cargo, area, cursorelacionado1 FROM vaga where tipo ='Projeto' order by id");
            while (rs.next()) {
              Vaga vaga = new Vaga();
                 vaga.setId(rs.getInt("id"));
                vaga.setLoc(rs.getString("loc"));
                vaga.setDescricao(rs.getString("descricao"));     
                vaga.setTitulo(rs.getString("titulo"));
                vaga.setContato(rs.getString("contato"));
                vaga.setCargahoraria(rs.getString("cargahoraria"));
                vaga.setValor(rs.getString("valor"));               
                  vaga.setNomeorientador(rs.getString("nomeorientador"));  
                    vaga.setTipoprojeto(rs.getString("tipoprojeto"));
                     vaga.setCursorelacionado(rs.getString("cursorelacionado"));
                     vaga.setCargo(rs.getString("cargo"));
                vaga.setArea(rs.getString("area")); 
                vaga.setCursorelacionado1(rs.getString("cursorelacionado1"));
                vaga.setTipo(rs.getString("tipo"));
                projetos.add(vaga);
            }
 
        } catch (Exception e) {
            e.printStackTrace();
        } finally {  
            conexao.fecharConexao();
            }
           }
            else {
        try {
            ResultSet rs = stmt.executeQuery("SELECT id,loc,descricao,titulo,contato,cargahoraria,valor,cursorelacionado,tipoprojeto,nomeorientador, cargo, area, cursorelacionado1 FROM vaga where tipo ='Projeto' and titulo || descricao || loc || id || tipoprojeto LIKE '%"+teste+"%' order by id");
            while (rs.next()) {
              Vaga vaga = new Vaga();
                 vaga.setId(rs.getInt("id"));
                vaga.setLoc(rs.getString("loc"));
                vaga.setDescricao(rs.getString("descricao"));     
                vaga.setTitulo(rs.getString("titulo"));
                vaga.setContato(rs.getString("contato"));
                vaga.setCargahoraria(rs.getString("cargahoraria"));
                vaga.setValor(rs.getString("valor"));
                vaga.setNomeorientador(rs.getString("nomeorientador"));  
                vaga.setTipoprojeto(rs.getString("tipoprojeto"));
                   vaga.setCursorelacionado(rs.getString("cursorelacionado"));
                   vaga.setCargo(rs.getString("cargo"));
                vaga.setArea(rs.getString("area")); 
                vaga.setCursorelacionado1(rs.getString("cursorelacionado1"));
                vaga.setTipo(rs.getString("tipo"));
                projetos.add(vaga);
            }
 
        } catch (Exception e) {
            e.printStackTrace();
        } finally 
            {
            conexao.fecharConexao();
        }
                    }
        return projetos;
    }
     public List<Vaga> pesquisarEstagios(String teste) {
        List<Vaga> estagios = new ArrayList<>();
           estagios.clear();
           System.out.println(teste );
           if(teste==null)
           {
            try {
            ResultSet rs = stmt.executeQuery("SELECT id,loc,descricao,titulo,contato,cargahoraria,valor,cursorelacionado,beneficios, cargo, area, cursorelacionado FROM vaga where tipo ='Estagio' order by id");
            while (rs.next()) {
              Vaga vaga = new Vaga();
                 vaga.setId(rs.getInt("id"));
                vaga.setLoc(rs.getString("loc"));
                vaga.setDescricao(rs.getString("descricao"));     
                vaga.setTitulo(rs.getString("titulo"));
                vaga.setContato(rs.getString("contato"));
                vaga.setCargahoraria(rs.getString("cargahoraria"));
                vaga.setValor(rs.getString("valor"));
                vaga.setCursorelacionado(rs.getString("cursorelacionado"));
                vaga.setBeneficios(rs.getString("beneficios"));
                vaga.setCargo(rs.getString("cargo"));
                vaga.setArea(rs.getString("area")); 
                vaga.setCursorelacionado1(rs.getString("cursorelacionado1"));
                 vaga.setTipo(rs.getString("tipo"));          
 
                estagios.add(vaga);
            }
 
        } catch (Exception e) {
            e.printStackTrace();
        } finally {  
            conexao.fecharConexao();
            }
           }
            else {
        try {
            ResultSet rs = stmt.executeQuery("SELECT id,loc,descricao,titulo,contato,cargahoraria,valor,cursorelacionado,beneficios, cargo, area, cursorelacionado1 FROM vaga where tipo ='Estagio' and titulo || descricao || loc || id LIKE '%"+teste+"%' order by id");
            while (rs.next()) {
              Vaga vaga = new Vaga();
                 vaga.setId(rs.getInt("id"));
                vaga.setLoc(rs.getString("loc"));
                vaga.setDescricao(rs.getString("descricao"));     
                vaga.setTitulo(rs.getString("titulo"));
                vaga.setContato(rs.getString("contato"));
                vaga.setCargahoraria(rs.getString("cargahoraria"));
                vaga.setValor(rs.getString("valor"));
                  vaga.setCursorelacionado(rs.getString("cursorelacionado"));
        
                vaga.setBeneficios(rs.getString("beneficios"));
                vaga.setCargo(rs.getString("cargo"));
                vaga.setArea(rs.getString("area")); 
                vaga.setCursorelacionado1(rs.getString("cursorelacionado1")); 
                vaga.setTipo(rs.getString("tipo"));
 
                estagios.add(vaga);
            }
 
        } catch (Exception e) {
            e.printStackTrace();
        } finally 
            {
            conexao.fecharConexao();
        }
                    }
        return estagios;
    }
      public List<Vaga> listar() {
        List<Vaga> vagas = new ArrayList<>();
        try {
            ResultSet rs = stmt.executeQuery("SELECT id,loc,descricao,titulo,contato,cargahoraria,valor,nomeorientador,duracao,cursorelacionado,disciplina FROM vaga where tipo ='Monitoria' ORDER BY id");
            while (rs.next()) {
                Vaga vaga = new Vaga();
                vaga.setId(rs.getInt("id"));
                vaga.setLoc(rs.getString("loc"));
                vaga.setLoc(rs.getString("descricao"));     
                vaga.setNomeorientador(rs.getString("titulo"));
                vaga.setNomeorientador(rs.getString("contato"));
                vaga.setLoc(rs.getString("cargahoraria"));
                vaga.setLoc(rs.getString("valor"));
                vaga.setLoc(rs.getString("nomeorientador"));
                vaga.setLoc(rs.getString("duracao"));
                vaga.setLoc(rs.getString("cursorelacionado"));
                vaga.setLoc(rs.getString("disciplina"));
                vaga.setTipo(rs.getString("tipo"));
                vagas.add(vaga);
            }
 
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            conexao.fecharConexao();
        }
 
        return vagas;
    }
      public List<Vaga> localizarBolsas(String teste, String teste1, int teste2) {
        List<Vaga> bolsas = new ArrayList<>();
           bolsas.clear();
           //System.out.println(teste );
            System.out.println(teste );
               System.out.println(teste1 );
               System.out.print(teste2);
           if(teste==null & teste1==null & teste2==0 )
           {
            try {
            ResultSet rs = stmt.executeQuery("SELECT id,loc,descricao,titulo,contato,cargahoraria,valor,cursorelacionado, cargo, area, cursorelacionado1 FROM vaga where tipo ='Bolsa' order by id");
            while (rs.next()) {
              Vaga vaga = new Vaga();
                 vaga.setId(rs.getInt("id"));
                vaga.setLoc(rs.getString("loc"));
                vaga.setDescricao(rs.getString("descricao"));     
                vaga.setTitulo(rs.getString("titulo"));
                vaga.setContato(rs.getString("contato"));
                vaga.setCargahoraria(rs.getString("cargahoraria"));
                vaga.setValor(rs.getString("valor"));
                vaga.setCursorelacionado(rs.getString("cursorelacionado"));
                vaga.setCargo(rs.getString("cargo"));
                vaga.setArea(rs.getString("area")); 
                vaga.setCursorelacionado1(rs.getString("cursorelacionado1"));           
                vaga.setTipo(rs.getString("tipo"));
                bolsas.add(vaga);
            }
 
        } catch (Exception e) {
            e.printStackTrace();
        } finally {  
            conexao.fecharConexao();
            }
           }
           else if (teste2==0){
        try {
            ResultSet rs = stmt.executeQuery("SELECT * FROM vaga where tipo ='Bolsa' and  (descricao  LIKE '%"+teste+"%' or (cursorelacionado like '%"+teste1+"%' or cursorelacionado1 like '%"+teste1+"%') ) order by id");
            while (rs.next()) {
              Vaga vaga = new Vaga();
                 vaga.setId(rs.getInt("id"));
                vaga.setLoc(rs.getString("loc"));
                vaga.setDescricao(rs.getString("descricao"));     
                vaga.setTitulo(rs.getString("titulo"));
                vaga.setContato(rs.getString("contato"));
                vaga.setCargahoraria(rs.getString("cargahoraria"));
                vaga.setValor(rs.getString("valor"));
                vaga.setCursorelacionado1(rs.getString("cursorelacionado1"));
                vaga.setCursorelacionado(rs.getString("cursorelacionado"));
                vaga.setCargo(rs.getString("cargo"));
                vaga.setArea(rs.getString("area")); 
                vaga.setTipo(rs.getString("tipo"));             
 
                bolsas.add(vaga);
            }
 
        } catch (Exception e) {
            e.printStackTrace();
        } finally 
            {
            conexao.fecharConexao();
        }
                    }
           
           
           
           
           
            else {
        try {
            ResultSet rs = stmt.executeQuery("SELECT * FROM vaga where tipo ='Bolsa' and  (descricao  LIKE '%"+teste+"%' and id = '"+teste2+"' and (cursorelacionado like '%"+teste1+"%' or cursorelacionado1 like '%"+teste1+"%') ) order by id");
            while (rs.next()) {
              Vaga vaga = new Vaga();
                 vaga.setId(rs.getInt("id"));
                vaga.setLoc(rs.getString("loc"));
                vaga.setDescricao(rs.getString("descricao"));     
                vaga.setTitulo(rs.getString("titulo"));
                vaga.setContato(rs.getString("contato"));
                vaga.setCargahoraria(rs.getString("cargahoraria"));
                vaga.setValor(rs.getString("valor"));
                vaga.setCursorelacionado1(rs.getString("cursorelacionado1"));
                vaga.setCursorelacionado(rs.getString("cursorelacionado"));
                vaga.setCargo(rs.getString("cargo"));
                vaga.setArea(rs.getString("area")); 
                  vaga.setTipo(rs.getString("tipo"));           
 
                bolsas.add(vaga);
            }
 
        } catch (Exception e) {
            e.printStackTrace();
        } finally 
            {
            conexao.fecharConexao();
        }
                    }
        return bolsas;
    } 
      public List<Vaga> localizarEmpregos(String teste, String teste1, int teste2) {
        List<Vaga> empregospesquisa = new ArrayList<>();
           empregospesquisa.clear();
           //System.out.println(teste );
            System.out.println(teste );
               System.out.println(teste1 );
               System.out.print(teste2);
           if(teste==null & teste1==null & teste2==0 )
           {
            try {
            ResultSet rs = stmt.executeQuery("SELECT id,loc,descricao,titulo,contato,cargahoraria,valor,cursorelacionado, cargo, area, cursorelacionado1 FROM vaga where tipo ='Emprego' order by id");
            while (rs.next()) {
              Vaga vaga = new Vaga();
                 vaga.setId(rs.getInt("id"));
                vaga.setLoc(rs.getString("loc"));
                vaga.setDescricao(rs.getString("descricao"));     
                vaga.setTitulo(rs.getString("titulo"));
                vaga.setContato(rs.getString("contato"));
                vaga.setCargahoraria(rs.getString("cargahoraria"));
                vaga.setValor(rs.getString("valor"));
                vaga.setCursorelacionado(rs.getString("cursorelacionado"));
                vaga.setCargo(rs.getString("cargo"));
                vaga.setArea(rs.getString("area")); 
                vaga.setCursorelacionado1(rs.getString("cursorelacionado1"));           
                   vaga.setBeneficios(rs.getString("beneficios"));
                   vaga.setTipo(rs.getString("tipo"));
                empregospesquisa.add(vaga);
            }
 
        } catch (Exception e) {
            e.printStackTrace();
        } finally {  
            conexao.fecharConexao();
            }
           }
           else if (teste2==0){
        try {
            ResultSet rs = stmt.executeQuery("SELECT * FROM vaga where tipo ='Emprego' and  (descricao  LIKE '%"+teste+"%' or (cursorelacionado like '%"+teste1+"%' or cursorelacionado1 like '%"+teste1+"%') ) order by id");
            while (rs.next()) {
              Vaga vaga = new Vaga();
                 vaga.setId(rs.getInt("id"));
                vaga.setLoc(rs.getString("loc"));
                vaga.setDescricao(rs.getString("descricao"));     
                vaga.setTitulo(rs.getString("titulo"));
                vaga.setContato(rs.getString("contato"));
                vaga.setCargahoraria(rs.getString("cargahoraria"));
                vaga.setValor(rs.getString("valor"));
                vaga.setCursorelacionado1(rs.getString("cursorelacionado1"));
                vaga.setCursorelacionado(rs.getString("cursorelacionado"));
                vaga.setCargo(rs.getString("cargo"));
                vaga.setArea(rs.getString("area")); 
                 vaga.setBeneficios(rs.getString("beneficios"));            
                 vaga.setTipo(rs.getString("tipo"));
                empregospesquisa.add(vaga);
            }
 
        } catch (Exception e) {
            e.printStackTrace();
        } finally 
            {
            conexao.fecharConexao();
        }
                    }
           
           
           
           
           
            else {
        try {
            ResultSet rs = stmt.executeQuery("SELECT * FROM vaga where tipo ='Emprego' and  (descricao  LIKE '%"+teste+"%' and id = '"+teste2+"' and (cursorelacionado like '%"+teste1+"%' or cursorelacionado1 like '%"+teste1+"%') ) order by id");
            while (rs.next()) {
              Vaga vaga = new Vaga();
                 vaga.setId(rs.getInt("id"));
                vaga.setLoc(rs.getString("loc"));
                vaga.setDescricao(rs.getString("descricao"));     
                vaga.setTitulo(rs.getString("titulo"));
                vaga.setContato(rs.getString("contato"));
                vaga.setCargahoraria(rs.getString("cargahoraria"));
                vaga.setValor(rs.getString("valor"));
                vaga.setCursorelacionado1(rs.getString("cursorelacionado1"));
                vaga.setCursorelacionado(rs.getString("cursorelacionado"));
                vaga.setCargo(rs.getString("cargo"));
                vaga.setArea(rs.getString("area")); 
                vaga.setBeneficios(rs.getString("beneficios"));
                vaga.setTipo(rs.getString("tipo"));             
 
        empregospesquisa.add(vaga);
            }
 
        } catch (Exception e) {
            e.printStackTrace();
        } finally 
            {
            conexao.fecharConexao();
        }
                    }
        return empregospesquisa;
    }  
      
      public List<Vaga> localizarEstagios(String teste, String teste1, int teste2) {
        List<Vaga> estagiospesquisa = new ArrayList<>();
       estagiospesquisa.clear();
           //System.out.println(teste );
            System.out.println(teste );
               System.out.println(teste1 );
               System.out.print(teste2);
           if(teste==null & teste1==null & teste2==0 )
           {
            try {
            ResultSet rs = stmt.executeQuery("SELECT * FROM vaga where tipo ='Estagio' order by id");
            while (rs.next()) {
              Vaga vaga = new Vaga();
                 vaga.setId(rs.getInt("id"));
                vaga.setLoc(rs.getString("loc"));
                vaga.setDescricao(rs.getString("descricao"));     
                vaga.setTitulo(rs.getString("titulo"));
                vaga.setContato(rs.getString("contato"));
                vaga.setCargahoraria(rs.getString("cargahoraria"));
                vaga.setValor(rs.getString("valor"));
                vaga.setCursorelacionado(rs.getString("cursorelacionado"));
                vaga.setCargo(rs.getString("cargo"));
                vaga.setArea(rs.getString("area")); 
                vaga.setCursorelacionado1(rs.getString("cursorelacionado1"));  
                vaga.setBeneficios(rs.getString("beneficios"));
                vaga.setTipo(rs.getString("tipo"));
               estagiospesquisa.add(vaga);
            }
 
        } catch (Exception e) {
            e.printStackTrace();
        } finally {  
            conexao.fecharConexao();
            }
           }
           else if (teste2==0){
        try {
            ResultSet rs = stmt.executeQuery("SELECT * FROM vaga where tipo ='Estagio' and  (descricao  LIKE '%"+teste+"%' or (cursorelacionado like '%"+teste1+"%' or cursorelacionado1 like '%"+teste1+"%') ) order by id");
            while (rs.next()) {
              Vaga vaga = new Vaga();
                 vaga.setId(rs.getInt("id"));
                vaga.setLoc(rs.getString("loc"));
                vaga.setDescricao(rs.getString("descricao"));     
                vaga.setTitulo(rs.getString("titulo"));
                vaga.setContato(rs.getString("contato"));
                vaga.setCargahoraria(rs.getString("cargahoraria"));
                vaga.setValor(rs.getString("valor"));
                vaga.setCursorelacionado1(rs.getString("cursorelacionado1"));
                vaga.setCursorelacionado(rs.getString("cursorelacionado"));
                vaga.setCargo(rs.getString("cargo"));
                vaga.setArea(rs.getString("area")); 
                 vaga.setBeneficios(rs.getString("beneficios"));            
                 vaga.setTipo(rs.getString("tipo"));
                estagiospesquisa.add(vaga);
            }
 
        } catch (Exception e) {
            e.printStackTrace();
        } finally 
            {
            conexao.fecharConexao();
        }
                    }
           
           
           
           
           
            else {
        try {
            ResultSet rs = stmt.executeQuery("SELECT * FROM vaga where tipo ='Estagio' and  (descricao  LIKE '%"+teste+"%' and id = '"+teste2+"' and (cursorelacionado like '%"+teste1+"%' or cursorelacionado1 like '%"+teste1+"%') ) order by id");
            while (rs.next()) {
              Vaga vaga = new Vaga();
                 vaga.setId(rs.getInt("id"));
                vaga.setLoc(rs.getString("loc"));
                vaga.setDescricao(rs.getString("descricao"));     
                vaga.setTitulo(rs.getString("titulo"));
                vaga.setContato(rs.getString("contato"));
                vaga.setCargahoraria(rs.getString("cargahoraria"));
                vaga.setValor(rs.getString("valor"));
                vaga.setCursorelacionado1(rs.getString("cursorelacionado1"));
                vaga.setCursorelacionado(rs.getString("cursorelacionado"));
                vaga.setCargo(rs.getString("cargo"));
                vaga.setArea(rs.getString("area")); 
                vaga.setBeneficios(rs.getString("beneficios"));
                 vaga.setTipo(rs.getString("tipo"));            
 
        estagiospesquisa.add(vaga);
            }
 
        } catch (Exception e) {
            e.printStackTrace();
        } finally 
            {
            conexao.fecharConexao();
        }
                    }
        return estagiospesquisa;
    }  
       public List<Vaga> localizarMonitorias(String teste, String teste1, int teste2) {
        List<Vaga> monitoriaspesquisa = new ArrayList<>();
       monitoriaspesquisa.clear();
           //System.out.println(teste );
            System.out.println(teste );
               System.out.println(teste1 );
               System.out.print(teste2);
           if(teste==null & teste1==null & teste2==0 )
           {
            try {
            ResultSet rs = stmt.executeQuery("SELECT * FROM vaga where tipo ='Monitoria' order by id");
            while (rs.next()) {
              Vaga vaga = new Vaga();
                   vaga.setId(rs.getInt("id"));
                vaga.setLoc(rs.getString("loc"));
                vaga.setDescricao(rs.getString("descricao"));     
                vaga.setTitulo(rs.getString("titulo"));
                vaga.setContato(rs.getString("contato"));
                vaga.setCargahoraria(rs.getString("cargahoraria"));
                vaga.setValor(rs.getString("valor"));
                vaga.setNomeorientador(rs.getString("nomeorientador"));
                vaga.setDuracao(rs.getString("duracao"));
                vaga.setCursorelacionado(rs.getString("cursorelacionado"));
                vaga.setDisciplina(rs.getString("disciplina"));              
                vaga.setCargo(rs.getString("cargo"));
                vaga.setArea(rs.getString("area"));  
                vaga.setCursorelacionado1(rs.getString("cursorelacionado1"));
                vaga.setTipo(rs.getString("tipo"));
             monitoriaspesquisa.add(vaga);
            }
 
        } catch (Exception e) {
            e.printStackTrace();
        } finally {  
            conexao.fecharConexao();
            }
           }
           else if (teste2==0){
        try {
            ResultSet rs = stmt.executeQuery("SELECT * FROM vaga where tipo ='Monitoria' and  (descricao  LIKE '%"+teste+"%' or (cursorelacionado like '%"+teste1+"%' or cursorelacionado1 like '%"+teste1+"%') ) order by id");
            while (rs.next()) {
              Vaga vaga = new Vaga();
                   vaga.setId(rs.getInt("id"));
                vaga.setLoc(rs.getString("loc"));
                vaga.setDescricao(rs.getString("descricao"));     
                vaga.setTitulo(rs.getString("titulo"));
                vaga.setContato(rs.getString("contato"));
                vaga.setCargahoraria(rs.getString("cargahoraria"));
                vaga.setValor(rs.getString("valor"));
                vaga.setNomeorientador(rs.getString("nomeorientador"));
                vaga.setDuracao(rs.getString("duracao"));
                vaga.setCursorelacionado(rs.getString("cursorelacionado"));
                vaga.setDisciplina(rs.getString("disciplina"));              
                vaga.setCargo(rs.getString("cargo"));
                vaga.setArea(rs.getString("area"));  
                vaga.setCursorelacionado1(rs.getString("cursorelacionado1"));
                vaga.setTipo(rs.getString("tipo"));
                monitoriaspesquisa.add(vaga);
            }
 
        } catch (Exception e) {
            e.printStackTrace();
        } finally 
            {
            conexao.fecharConexao();
        }
                    }
           
           
           
           
           
            else {
        try {
            ResultSet rs = stmt.executeQuery("SELECT * FROM vaga where tipo ='Monitoria' and  (descricao  LIKE '%"+teste+"%' and id = '"+teste2+"' and (cursorelacionado like '%"+teste1+"%' or cursorelacionado1 like '%"+teste1+"%') ) order by id");
            while (rs.next()) {
              Vaga vaga = new Vaga();
                   vaga.setId(rs.getInt("id"));
                vaga.setLoc(rs.getString("loc"));
                vaga.setDescricao(rs.getString("descricao"));     
                vaga.setTitulo(rs.getString("titulo"));
                vaga.setContato(rs.getString("contato"));
                vaga.setCargahoraria(rs.getString("cargahoraria"));
                vaga.setValor(rs.getString("valor"));
                vaga.setNomeorientador(rs.getString("nomeorientador"));
                vaga.setDuracao(rs.getString("duracao"));
                vaga.setCursorelacionado(rs.getString("cursorelacionado"));
                vaga.setDisciplina(rs.getString("disciplina"));              
                vaga.setCargo(rs.getString("cargo"));
                vaga.setArea(rs.getString("area"));  
                vaga.setCursorelacionado1(rs.getString("cursorelacionado1"));
                 vaga.setTipo(rs.getString("tipo"));            
 
        monitoriaspesquisa.add(vaga);
            }
 
        } catch (Exception e) {
            e.printStackTrace();
        } finally 
            {
            conexao.fecharConexao();
        }
                    }
        return monitoriaspesquisa;
    }
      
    public List<Vaga> localizarProjetos(String teste, String teste1, int teste2) {
        List<Vaga> projetospesquisa = new ArrayList<>();
       projetospesquisa.clear();
           //System.out.println(teste );
            System.out.println(teste );
               System.out.println(teste1 );
               System.out.print(teste2);
           if(teste==null & teste1==null & teste2==0 )
           {
            try {
            ResultSet rs = stmt.executeQuery("SELECT * FROM vaga where tipo ='Projeto' order by id");
            while (rs.next()) {
              Vaga vaga = new Vaga();
                   vaga.setId(rs.getInt("id"));
                vaga.setLoc(rs.getString("loc"));
                vaga.setDescricao(rs.getString("descricao"));     
                vaga.setTitulo(rs.getString("titulo"));
                vaga.setContato(rs.getString("contato"));
                vaga.setCargahoraria(rs.getString("cargahoraria"));
                vaga.setValor(rs.getString("valor"));               
                  vaga.setNomeorientador(rs.getString("nomeorientador"));  
                    vaga.setTipoprojeto(rs.getString("tipoprojeto"));
                     vaga.setCursorelacionado(rs.getString("cursorelacionado"));
                     vaga.setCargo(rs.getString("cargo"));
                vaga.setArea(rs.getString("area")); 
                vaga.setCursorelacionado1(rs.getString("cursorelacionado1"));
 vaga.setTipo(rs.getString("tipo"));
             projetospesquisa.add(vaga);
            }
 
        } catch (Exception e) {
            e.printStackTrace();
        } finally {  
            conexao.fecharConexao();
            }
           }
           else if (teste2==0){
        try {
            ResultSet rs = stmt.executeQuery("SELECT * FROM vaga where tipo ='Projeto' and  (descricao  LIKE '%"+teste+"%' or (cursorelacionado like '%"+teste1+"%' or cursorelacionado1 like '%"+teste1+"%') ) order by id");
            while (rs.next()) {
              Vaga vaga = new Vaga();
                  vaga.setId(rs.getInt("id"));
                vaga.setLoc(rs.getString("loc"));
                vaga.setDescricao(rs.getString("descricao"));     
                vaga.setTitulo(rs.getString("titulo"));
                vaga.setContato(rs.getString("contato"));
                vaga.setCargahoraria(rs.getString("cargahoraria"));
                vaga.setValor(rs.getString("valor"));               
                  vaga.setNomeorientador(rs.getString("nomeorientador"));  
                    vaga.setTipoprojeto(rs.getString("tipoprojeto"));
                     vaga.setCursorelacionado(rs.getString("cursorelacionado"));
                     vaga.setCargo(rs.getString("cargo"));
                vaga.setArea(rs.getString("area")); 
                vaga.setCursorelacionado1(rs.getString("cursorelacionado1"));
                vaga.setTipo(rs.getString("tipo"));
                projetospesquisa.add(vaga);
            }
 
        } catch (Exception e) {
            e.printStackTrace();
        } finally 
            {
            conexao.fecharConexao();
        }
                    }
           
           
           
           
           
            else {
        try {
            ResultSet rs = stmt.executeQuery("SELECT * FROM vaga where tipo ='Projeto' and  (descricao  LIKE '%"+teste+"%' and id = '"+teste2+"' and (cursorelacionado like '%"+teste1+"%' or cursorelacionado1 like '%"+teste1+"%') ) order by id");
            while (rs.next()) {
              Vaga vaga = new Vaga();
                  vaga.setId(rs.getInt("id"));
                vaga.setLoc(rs.getString("loc"));
                vaga.setDescricao(rs.getString("descricao"));     
                vaga.setTitulo(rs.getString("titulo"));
                vaga.setContato(rs.getString("contato"));
                vaga.setCargahoraria(rs.getString("cargahoraria"));
                vaga.setValor(rs.getString("valor"));               
                  vaga.setNomeorientador(rs.getString("nomeorientador"));  
                    vaga.setTipoprojeto(rs.getString("tipoprojeto"));
                     vaga.setCursorelacionado(rs.getString("cursorelacionado"));
                     vaga.setCargo(rs.getString("cargo"));
                vaga.setArea(rs.getString("area")); 
                vaga.setCursorelacionado1(rs.getString("cursorelacionado1"));
                 vaga.setTipo(rs.getString("tipo"));            
 
        projetospesquisa.add(vaga);
            }
 
        } catch (Exception e) {
            e.printStackTrace();
        } finally 
            {
            conexao.fecharConexao();
        }
                    }
        return projetospesquisa;
    }  
    public List<Vaga> sugerirMonitorias(String cursoaluno, String cargo, String cargo2, String area, String area2, String experiencia, String experiencia2) {
        List<Vaga> monitoriassugeridas = new ArrayList<>();
        try {
            ResultSet rs = stmt.executeQuery("SELECT * FROM vaga where tipo ='Monitoria' and ((cursorelacionado = '"+cursoaluno+"' or cursorelacionado1='"+cursoaluno+"') or (cargo='"+cargo+"' or cargo='"+cargo2+"') or (area='"+area+"' or area='"+area2+"' ) or (cargo='"+experiencia+"' or cargo='"+experiencia2+"') )");
            while (rs.next()) {
                Vaga vaga = new Vaga();
                 vaga.setId(rs.getInt("id"));
                vaga.setLoc(rs.getString("loc"));
                vaga.setDescricao(rs.getString("descricao"));     
                vaga.setTitulo(rs.getString("titulo"));
                vaga.setContato(rs.getString("contato"));
                vaga.setCargahoraria(rs.getString("cargahoraria"));
                vaga.setValor(rs.getString("valor"));
                vaga.setNomeorientador(rs.getString("nomeorientador"));
                vaga.setDuracao(rs.getString("duracao"));
                vaga.setCursorelacionado(rs.getString("cursorelacionado"));
                vaga.setDisciplina(rs.getString("disciplina"));              
                vaga.setCargo(rs.getString("cargo"));
                vaga.setArea(rs.getString("area"));  
                vaga.setCursorelacionado1(rs.getString("cursorelacionado1"));
                vaga.setTipo(rs.getString("tipo"));
                monitoriassugeridas.add(vaga);
            }
 
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            conexao.fecharConexao();
        }
 
        return monitoriassugeridas;
    }
     public List<Vaga> sugerirEmpregos(String cursoaluno, String cargo, String cargo2, String area, String area2, String experiencia, String experiencia2) {
        List<Vaga> empregossugeridos = new ArrayList<>();
        try {
            ResultSet rs = stmt.executeQuery("SELECT * FROM vaga where tipo ='Emprego' and ((cursorelacionado = '"+cursoaluno+"' or cursorelacionado1='"+cursoaluno+"') or (cargo='"+cargo+"' or cargo='"+cargo2+"') or (area='"+area+"' or area='"+area2+"' ) or (cargo='"+experiencia+"' or cargo='"+experiencia2+"') )");
            while (rs.next()) {
                Vaga vaga = new Vaga();
                 vaga.setId(rs.getInt("id"));
                vaga.setLoc(rs.getString("loc"));
                vaga.setDescricao(rs.getString("descricao"));     
                vaga.setTitulo(rs.getString("titulo"));
                vaga.setContato(rs.getString("contato"));
                vaga.setCargahoraria(rs.getString("cargahoraria"));
                vaga.setValor(rs.getString("valor"));
                vaga.setCursorelacionado1(rs.getString("cursorelacionado1"));
                vaga.setCursorelacionado(rs.getString("cursorelacionado"));
                vaga.setCargo(rs.getString("cargo"));
                vaga.setArea(rs.getString("area")); 
                vaga.setBeneficios(rs.getString("beneficios"));
                vaga.setTipo(rs.getString("tipo"));
                empregossugeridos.add(vaga);
            }
 
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            conexao.fecharConexao();
        }
 
        return empregossugeridos;
    } 
     public List<Vaga> sugerirEstagios(String cursoaluno, String cargo, String cargo2, String area, String area2, String experiencia, String experiencia2) {
        List<Vaga> estagiossugeridos = new ArrayList<>();
        try {
            ResultSet rs = stmt.executeQuery("SELECT * FROM vaga where tipo ='Estagio' and ((cursorelacionado = '"+cursoaluno+"' or cursorelacionado1='"+cursoaluno+"') or (cargo='"+cargo+"' or cargo='"+cargo2+"') or (area='"+area+"' or area='"+area2+"' ) or (cargo='"+experiencia+"' or cargo='"+experiencia2+"') )");
            while (rs.next()) {
                Vaga vaga = new Vaga();
                 vaga.setId(rs.getInt("id"));
                vaga.setLoc(rs.getString("loc"));
                vaga.setDescricao(rs.getString("descricao"));     
                vaga.setTitulo(rs.getString("titulo"));
                vaga.setContato(rs.getString("contato"));
                vaga.setCargahoraria(rs.getString("cargahoraria"));
                vaga.setValor(rs.getString("valor"));
                vaga.setCursorelacionado1(rs.getString("cursorelacionado1"));
                vaga.setCursorelacionado(rs.getString("cursorelacionado"));
                vaga.setCargo(rs.getString("cargo"));
                vaga.setArea(rs.getString("area")); 
                vaga.setBeneficios(rs.getString("beneficios"));
                vaga.setTipo(rs.getString("tipo"));
                estagiossugeridos.add(vaga);
            }
 
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            conexao.fecharConexao();
        }
 
        return estagiossugeridos;
    } 
     public List<Vaga> sugerirBolsas(String cursoaluno, String cargo, String cargo2, String area, String area2, String experiencia, String experiencia2) {
        List<Vaga> bolsassugeridas = new ArrayList<>();
        try {
            ResultSet rs = stmt.executeQuery("SELECT * FROM vaga where tipo ='Bolsa' and ((cursorelacionado = '"+cursoaluno+"' or cursorelacionado1='"+cursoaluno+"') or (cargo='"+cargo+"' or cargo='"+cargo2+"') or (area='"+area+"' or area='"+area2+"' ) or (cargo='"+experiencia+"' or cargo='"+experiencia2+"') )");
            while (rs.next()) {
                Vaga vaga = new Vaga();
                vaga.setId(rs.getInt("id"));
                vaga.setLoc(rs.getString("loc"));
                vaga.setDescricao(rs.getString("descricao"));     
                vaga.setTitulo(rs.getString("titulo"));
                vaga.setContato(rs.getString("contato"));
                vaga.setCargahoraria(rs.getString("cargahoraria"));
                vaga.setValor(rs.getString("valor"));
                vaga.setCursorelacionado1(rs.getString("cursorelacionado1"));
                vaga.setCursorelacionado(rs.getString("cursorelacionado"));
                vaga.setCargo(rs.getString("cargo"));
                vaga.setArea(rs.getString("area")); 
                vaga.setTipo(rs.getString("tipo"));
                bolsassugeridas.add(vaga);
            }
 
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            conexao.fecharConexao();
        }
 
        return bolsassugeridas;
    } 
     public List<Vaga> sugerirProjetos(String cursoaluno, String cargo, String cargo2, String area, String area2, String experiencia, String experiencia2) {
        List<Vaga> projetossugeridos = new ArrayList<>();
        try {
            ResultSet rs = stmt.executeQuery("SELECT * FROM vaga where tipo ='Projeto' and ((cursorelacionado = '"+cursoaluno+"' or cursorelacionado1='"+cursoaluno+"') or (cargo='"+cargo+"' or cargo='"+cargo2+"') or (area='"+area+"' or area='"+area2+"' ) or (cargo='"+experiencia+"' or cargo='"+experiencia2+"') )");
            while (rs.next()) {
                Vaga vaga = new Vaga();
                vaga.setId(rs.getInt("id"));
                vaga.setLoc(rs.getString("loc"));
                vaga.setDescricao(rs.getString("descricao"));     
                vaga.setTitulo(rs.getString("titulo"));
                vaga.setContato(rs.getString("contato"));
                vaga.setCargahoraria(rs.getString("cargahoraria"));
                vaga.setValor(rs.getString("valor"));               
                  vaga.setNomeorientador(rs.getString("nomeorientador"));  
                    vaga.setTipoprojeto(rs.getString("tipoprojeto"));
                     vaga.setCursorelacionado(rs.getString("cursorelacionado"));
                     vaga.setCargo(rs.getString("cargo"));
                vaga.setArea(rs.getString("area")); 
                vaga.setCursorelacionado1(rs.getString("cursorelacionado1"));
                vaga.setTipo(rs.getString("tipo"));
                projetossugeridos.add(vaga);
            }
 
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            conexao.fecharConexao();
        }
 
        return projetossugeridos;
    } 
}
  

