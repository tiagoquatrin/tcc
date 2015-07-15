/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Element;
import com.itextpdf.text.Font;
import com.itextpdf.text.Image;
import com.itextpdf.text.PageSize;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.pdf.PdfWriter;
import dao.Conexao;
import dao.VagaDAO;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.Serializable;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;

import javax.faces.model.DataModel;
import javax.faces.model.ListDataModel;
import javax.inject.Named;
import model.Aluno;
import model.Vaga;
import org.apache.commons.mail.DefaultAuthenticator;
import org.apache.commons.mail.EmailAttachment;
import org.apache.commons.mail.EmailException;
import org.apache.commons.mail.HtmlEmail;

/**
 *
 * @author tiago.silva
 */

@ManagedBean (name="vagaBean")
@SessionScoped
public class VagaBean implements Serializable{
 
    private VagaDAO vagaDAO;
    private Vaga vaga = new Vaga();
    private DataModel<Vaga> vagas;
    private DataModel<Vaga> monitorias;
    private DataModel<Vaga> bolsas;
    private DataModel<Vaga> pesquisabolsas;
     private DataModel<Vaga> empregos;
    private DataModel<Vaga> estagios;
   private DataModel<Vaga> projetos;
       private DataModel<Vaga> pesquisaempregos;
       private DataModel<Vaga> pesquisaestagios;
        private DataModel<Vaga> pesquisamonitorias; 
        private DataModel<Vaga> pesquisaprojetos; 
  
        
        public Aluno aluno = new Aluno();
        
        

    public Aluno getAluno() {
        return aluno;
    }

    public void setAluno(Aluno aluno) {
        this.aluno = aluno;
    }
        
     
           
           
           
    public void novo(){
        vaga = new Vaga();
        
       
    }
    
    public void limpardados(){
        
    vaga.setLoc("");
    vaga.setDescricao("");
    vaga.setTitulo("");
    vaga.setContato("");
    vaga.setCargahoraria("");
    vaga.setValor("");
    vaga.setNomeorientador("");
    vaga.setBeneficios("");
    vaga.setDuracao("");
    vaga.setCursorelacionado("");
    vaga.setDisciplina("");
    vaga.setTitulo("");
    vaga.setTipoprojeto("");
    vaga.setArea("");
    vaga.setCargo("");
    vaga.setCursorelacionado1("");
    
        
    }
 
    public String inserir(){
        String resultado = "falha";
        vagaDAO = new VagaDAO();
        boolean retorno = vagaDAO.inserirMonitoria(vaga);
 
        if(retorno){
            resultado = "vagas";
        }
 
        return resultado;
    }
    public String inserirMonitoria(){
        String resultado = "falha";
        vagaDAO = new VagaDAO();
        boolean retorno = vagaDAO.inserirMonitoria(vaga);
 
        if(retorno){
            
            resultado = "monitoriasAdminNovo";
            FacesMessage msg = new FacesMessage("Monitoria cadastrada com sucesso");
      /* Obtém a instancia atual do FacesContext e adiciona a mensagem de erro nele. */
            FacesContext.getCurrentInstance().addMessage("inseriu", msg);
        }
 limpardados();
        return resultado;
    }
     public String inserirProjeto(){
        String resultado = "falha";
        vagaDAO = new VagaDAO();
        boolean retorno = vagaDAO.inserirProjeto(vaga);
 
        if(retorno){
            
            resultado = "projetosAdminNovo";
            FacesMessage msg = new FacesMessage("Projeto cadastrado com sucesso");
      /* Obtém a instancia atual do FacesContext e adiciona a mensagem de erro nele. */
            FacesContext.getCurrentInstance().addMessage("inseriu", msg);
        }
 limpardados();
        return resultado;
    }
    public String inserirEstagio(){
        String resultado = "falha";
        vagaDAO = new VagaDAO();
        boolean retorno = vagaDAO.inserirEstagio(vaga);
 
        if(retorno){
            
            resultado = "estagiosAdminNovo";
            FacesMessage msg = new FacesMessage("Estagio cadastrado com sucesso");
      /* Obtém a instancia atual do FacesContext e adiciona a mensagem de erro nele. */
            FacesContext.getCurrentInstance().addMessage("inseriu", msg);
        }
 limpardados();
        return resultado;
    }
     public String inserirEmprego(){
        String resultado = "falha";
        vagaDAO = new VagaDAO();
        boolean retorno = vagaDAO.inserirEmprego(vaga);
 
        if(retorno){
            
            resultado = "empregosAdminNovo";
            FacesMessage msg = new FacesMessage("Emprego cadastrado com sucesso");
      /* Obtém a instancia atual do FacesContext e adiciona a mensagem de erro nele. */
            FacesContext.getCurrentInstance().addMessage("inseriu", msg);
        }
 limpardados();
        return resultado;
    }
    
     public String inserirBolsa(){
        String resultado = "falha";
        vagaDAO = new VagaDAO();
        boolean retorno = vagaDAO.inserirBolsa(vaga);
 
        if(retorno){
            FacesMessage msg = new FacesMessage("Bolsa cadastrada com sucesso");
      /* Obtém a instancia atual do FacesContext e adiciona a mensagem de erro nele. */
            FacesContext.getCurrentInstance().addMessage("inseriu", msg);
            
            resultado = "bolsasAdminNovo";
        }
 limpardados();
        return resultado;
    }
 
    public void selecionar(){
        vaga = vagas.getRowData();
    }
    public void selecionarMonitoria(){
        vaga = monitorias.getRowData();
    }
 public void selecionarBolsa(){
        vaga = bolsas.getRowData();
    }
   
 public void selecionarEmprego(){
        vaga = empregos.getRowData();
    }
 public void selecionarEmpregoPesquisa(){
        vaga = pesquisaempregos.getRowData();
    }
 public void selecionarEstagioPesquisa(){
        vaga = pesquisaestagios.getRowData();
    }
 public void selecionarMonitoriaPesquisa(){
        vaga = pesquisamonitorias.getRowData();
    }
 public void selecionarProjetoPesquisa(){
        vaga = pesquisaprojetos.getRowData();
    }
 public void selecionarBolsaPesq(){
        vaga = pesquisabolsas.getRowData();
    }
 
  
 
 
 
 
 
 
  public void selecionarEstagio(){
        vaga = estagios.getRowData();
    }
   public void selecionarProjeto(){
        vaga = projetos.getRowData();
    }
    public String alterar(){
        String resultado = "falha";
        vagaDAO = new VagaDAO();
        boolean retorno = vagaDAO.alterar(vaga);
 
        if(retorno){
            resultado = "vagas";
        }
 
        return resultado;
    }
    public String alterarMonitoria(){
        String resultado = "falha";
        vagaDAO = new VagaDAO();
        boolean retorno = vagaDAO.alterar(vaga);
 
        if(retorno){
            FacesMessage msg = new FacesMessage("Monitoria código= "+vaga.getId()+" editada com sucesso");
      /* Obtém a instancia atual do FacesContext e adiciona a mensagem de erro nele. */
            FacesContext.getCurrentInstance().addMessage("editou", msg);
            resultado = "monitoriasAdminEditar";
        }
  limpardados();
        return resultado;
    }
    public String alterarProjeto(){
        String resultado = "falha";
        vagaDAO = new VagaDAO();
        boolean retorno = vagaDAO.alterar(vaga);
 
        if(retorno){
            FacesMessage msg = new FacesMessage("Projeto código= "+vaga.getId()+" editado com sucesso");
      /* Obtém a instancia atual do FacesContext e adiciona a mensagem de erro nele. */
            FacesContext.getCurrentInstance().addMessage("editou", msg);
            resultado = "projetosAdminEditar";
        }
  limpardados();
        return resultado;
    }
    public String alterarEstagio(){
        String resultado = "falha";
        vagaDAO = new VagaDAO();
        boolean retorno = vagaDAO.alterar(vaga);
 
        if(retorno){
            FacesMessage msg = new FacesMessage("Estágio código= "+vaga.getId()+" editado com sucesso");
      /* Obtém a instancia atual do FacesContext e adiciona a mensagem de erro nele. */
            FacesContext.getCurrentInstance().addMessage("editou", msg);
            resultado = "estagiosAdminEditar";
        }
  limpardados();
        return resultado;
    }
     public String alterarEmprego(){
        String resultado = "falha";
        vagaDAO = new VagaDAO();
        boolean retorno = vagaDAO.alterar(vaga);
 
        if(retorno){
            FacesMessage msg = new FacesMessage("Emprego código= "+vaga.getId()+" editado com sucesso");
      /* Obtém a instancia atual do FacesContext e adiciona a mensagem de erro nele. */
            FacesContext.getCurrentInstance().addMessage("editou", msg);
            resultado = "empregosAdminEditar";
        }
  limpardados();
        return resultado;
    }
    public String alterarBolsa(){
        String resultado = "falha";
        vagaDAO = new VagaDAO();
        boolean retorno = vagaDAO.alterar(vaga);
 
        if(retorno){
            FacesMessage msg = new FacesMessage("Bolsa código= "+vaga.getId()+" editada com sucesso");
      /* Obtém a instancia atual do FacesContext e adiciona a mensagem de erro nele. */
            FacesContext.getCurrentInstance().addMessage("editou", msg);
            resultado = "bolsasAdminEditar";
        }
 limpardados();
        return resultado;
    }
 
    public String remover(){
        String resultado = "falha";
        vagaDAO = new VagaDAO();
        boolean retorno = vagaDAO.remover(vaga);
 
        if(retorno){
            System.out.print("deletando2");
            resultado = "vagas";
        }
  System.out.print("deletando3");
        return resultado;
    }
     public String removerBolsa(){
        String resultado = "falha";
        vagaDAO = new VagaDAO();
        boolean retorno = vagaDAO.remover(vaga);
 
        if(retorno){
         FacesMessage msg = new FacesMessage("Bolsa código= "+vaga.getId()+" excluída com sucesso");
      /* Obtém a instancia atual do FacesContext e adiciona a mensagem de erro nele. */
            FacesContext.getCurrentInstance().addMessage("excluiu", msg);
            resultado = "bolsapesquisa";
        }
        limpardados();
  System.out.print("deletando3");
        return resultado;
    }
      public String removerProjeto(){
        String resultado = "falha";
        vagaDAO = new VagaDAO();
        boolean retorno = vagaDAO.remover(vaga);
 
        if(retorno){
         FacesMessage msg = new FacesMessage("Projeto código= "+vaga.getId()+" excluído com sucesso");
      /* Obtém a instancia atual do FacesContext e adiciona a mensagem de erro nele. */
            FacesContext.getCurrentInstance().addMessage("excluiu", msg);
            resultado = "projetopesquisa";
        }
        limpardados();
  System.out.print("deletando3");
        return resultado;
    }
      public String removerEstagio(){
        String resultado = "falha";
        vagaDAO = new VagaDAO();
        boolean retorno = vagaDAO.remover(vaga);
 
        if(retorno){
         FacesMessage msg = new FacesMessage("Estágio código= "+vaga.getId()+" excluído com sucesso");
      /* Obtém a instancia atual do FacesContext e adiciona a mensagem de erro nele. */
            FacesContext.getCurrentInstance().addMessage("excluiu", msg);
            resultado = "estagiopesquisa";
        }
        limpardados();
  System.out.print("deletando3");
        return resultado;
    }
    public String pesqBolsa(){
        String resultado = "falha";
        String teste = vaga.getDescricao();
        String teste1 = vaga.getCursorelacionado();
        int teste2 = vaga.getId();
             //System.out.println(teste );
              // System.out.println(teste1 );
              // System.out.print(teste2);
        vagaDAO = new VagaDAO();
        boolean   retorno = vagaDAO.pesquisaBolsas(vaga);
 
        if(retorno){
        
            resultado = "bolsapesquisa";
        }
        
        
  System.out.print("deletando3");
        return resultado;
    }
     public String localizarBolsas(){
        String resultado = "falha";
        String teste = vaga.getDescricao();
        String teste1 = vaga.getCursorelacionado();
        int teste2 = vaga.getId();
            
        vagaDAO = new VagaDAO();
        boolean   retorno = vagaDAO.pesquisaBolsas(vaga);
 
        if(retorno){
        
            resultado = "localizarBolsas";
        }
        
        
  System.out.print("deletando3");
        return resultado;
    }
     public String localizarProjetos(){
        String resultado = "falha";
        String teste = vaga.getDescricao();
        String teste1 = vaga.getCursorelacionado();
        int teste2 = vaga.getId();
            
        vagaDAO = new VagaDAO();
        boolean   retorno = vagaDAO.pesquisaProjetos(vaga);
 
        if(retorno){
        
            resultado = "localizarProjetos";
        }
        
        
  System.out.print("deletando3");
        return resultado;
    }
     public String localizarMonitorias(){
        String resultado = "falha";
        String teste = vaga.getDescricao();
        String teste1 = vaga.getCursorelacionado();
        int teste2 = vaga.getId();
            
        vagaDAO = new VagaDAO();
        boolean   retorno = vagaDAO.pesquisaMonitorias(vaga);
 
        if(retorno){
        
            resultado = "localizarMonitorias";
        }
        
        
  System.out.print("deletando3");
        return resultado;
    }
     
      public String localizarEmpregos(){
        String resultado = "falha";
        String teste = vaga.getDescricao();
        String teste1 = vaga.getCursorelacionado();
        int teste2 = vaga.getId();
            
        vagaDAO = new VagaDAO();
        boolean   retorno = vagaDAO.pesquisaEmpregos(vaga);
 
        if(retorno){
        
            resultado = "localizarEmpregos";
        }
        
        
  System.out.print("deletando3");
        return resultado;
    }
       public String localizarEstagios(){
        String resultado = "falha";
        String teste = vaga.getDescricao();
        String teste1 = vaga.getCursorelacionado();
        int teste2 = vaga.getId();
            
        vagaDAO = new VagaDAO();
        boolean   retorno = vagaDAO.pesquisaEstagios(vaga);
 
        if(retorno){
        
            resultado = "localizarEstagios";
        }
        
        

        return resultado;
    }
    public String pesqProjeto(){
        String resultado = "falha";
        String teste = vaga.getDescricao();
             System.out.println(teste );
        vagaDAO = new VagaDAO();
        boolean   retorno = vagaDAO.pesquisaProjetos(vaga);
 
        if(retorno){
        
            resultado = "projetopesquisa";
        }
        
        
  System.out.print("deletando3");
        return resultado;
    }
     public String pesqEmprego(){
        String resultado = "falha";
        String teste = vaga.getDescricao();
             System.out.println(teste );
        vagaDAO = new VagaDAO();
        boolean   retorno = vagaDAO.pesquisaEmpregos(vaga);
 
        if(retorno){
        
            resultado = "empregopesquisa";
        }
        
        
  System.out.print("deletando3");
        return resultado;
    }
     public String pesqEstagio(){
        String resultado = "falha";
        String teste = vaga.getDescricao();
             System.out.println(teste );
        vagaDAO = new VagaDAO();
        boolean   retorno = vagaDAO.pesquisaEstagios(vaga);
 
        if(retorno){
        
            resultado = "estagiopesquisa";
        }
        
        
  System.out.print("deletando3");
        return resultado;
    }
    public String pesqMonitoria(){
        String resultado = "falha";
        String teste = vaga.getDescricao();
             System.out.println(teste );
        vagaDAO = new VagaDAO();
        boolean   retorno = vagaDAO.pesquisaMonitorias(vaga);
 
        if(retorno){
        
            resultado = "monitoriapesquisa";
        }
        
        
  System.out.print("deletando3");
        return resultado;
    }
    
    
    
    public String removerMonitoria(){
        String resultado = "falha";
        vagaDAO = new VagaDAO();
        boolean retorno = vagaDAO.remover(vaga);
 
        if(retorno){
             FacesMessage msg = new FacesMessage("Monitoria código= "+vaga.getId()+" excluída com sucesso");
      /* Obtém a instancia atual do FacesContext e adiciona a mensagem de erro nele. */
            FacesContext.getCurrentInstance().addMessage("excluiu", msg);
            resultado = "monitoriapesquisa";
        }
  System.out.print("deletando3");
  limpardados();
        return resultado;
    }
 public String removerEmprego(){
        String resultado = "falha";
        vagaDAO = new VagaDAO();
        boolean retorno = vagaDAO.remover(vaga);
 
        if(retorno){
             FacesMessage msg = new FacesMessage("Emprego código= "+vaga.getId()+" excluído com sucesso");
      /* Obtém a instancia atual do FacesContext e adiciona a mensagem de erro nele. */
            FacesContext.getCurrentInstance().addMessage("excluiu", msg);
            resultado = "empregopesquisa";
        }
  System.out.print("deletando3");
  limpardados();
        return resultado;
    }
    public Vaga getVaga() {
        return vaga;
    }
 
    public void setVaga(Vaga vaga) {
        this.vaga = vaga;
    }
 
    public DataModel<Vaga> getVagas() {
        vagaDAO = new VagaDAO();
        List<Vaga> vagaList = vagaDAO.listar();
        vagas = new ListDataModel<>(vagaList);
        return vagas;
    }
    public void setVagas(DataModel<Vaga> vagas) {
        this.vagas = vagas;
    }
    public DataModel<Vaga> getMonitorias() {
        vagaDAO = new VagaDAO();
         String teste = vaga.getDescricao();
        List<Vaga> monitoriaList = vagaDAO.listarMonitorias(teste);
        monitorias = new ListDataModel<>(monitoriaList);
        return monitorias;
    }
    public void setMonitorias(DataModel<Vaga> monitorias) {
        this.monitorias = monitorias;
    }
  public DataModel<Vaga> getBolsas() {
        vagaDAO = new VagaDAO();
        String teste = vaga.getDescricao();
        String teste1 = vaga.getCursorelacionado();
        int teste2 = vaga.getId();
        List<Vaga> bolsaList = vagaDAO.localizarBolsas(teste,teste1,teste2);
        bolsas = new ListDataModel<>(bolsaList);
        return bolsas;
    }
    public void setBolsas(DataModel<Vaga> bolsas) {
        this.bolsas = bolsas;
    }
    
 public DataModel<Vaga> getPesquisabolsas() {
        vagaDAO = new VagaDAO();
           String teste = vaga.getDescricao();
        String teste1 = vaga.getCursorelacionado();
        int teste2 = vaga.getId();
         
        List<Vaga> pesquisabolsaList = vagaDAO.pesquisarBolsas(teste);
        pesquisabolsas = new ListDataModel<>(pesquisabolsaList);
        return pesquisabolsas;
    }
    public void setPesquisabolsas(DataModel<Vaga> pesquisabolsas) {
        this.pesquisabolsas = pesquisabolsas;
    }
     public DataModel<Vaga> getEmpregos() {
        vagaDAO = new VagaDAO();
           String teste = vaga.getDescricao();
         
        List<Vaga> empregosList = vagaDAO.pesquisarEmpregos(teste);
        empregos = new ListDataModel<>(empregosList);
        return empregos;
    }
    public void setEmpregos(DataModel<Vaga> empregos) {
        this.empregos = empregos;
    }
    public DataModel<Vaga> getEstagios() {
        vagaDAO = new VagaDAO();
           String teste = vaga.getDescricao();
         
        List<Vaga> estagiosList = vagaDAO.pesquisarEstagios(teste);
        estagios = new ListDataModel<>(estagiosList);
        return estagios;
    }
    public void setEstagios(DataModel<Vaga> estagios) {
        this.estagios = estagios;
    }
    public DataModel<Vaga> getProjetos() {
        vagaDAO = new VagaDAO();
           String teste = vaga.getDescricao();
         
        List<Vaga> projetosList = vagaDAO.pesquisarProjetos(teste);
        projetos = new ListDataModel<>(projetosList);
        return projetos;
    }
    public void setProjetos(DataModel<Vaga> projetos) {
        this.projetos = projetos;
    }
       public DataModel<Vaga> getPesquisaempregos() {
           vagaDAO = new VagaDAO();
        String teste = vaga.getDescricao();
        String teste1 = vaga.getCursorelacionado();
        int teste2 = vaga.getId();
        List<Vaga> empList = vagaDAO.localizarEmpregos(teste,teste1,teste2);
        pesquisaempregos = new ListDataModel<>(empList);
        return pesquisaempregos;
    }

    public void setPesquisaempregos(DataModel<Vaga> pesquisaempregos) {
        this.pesquisaempregos = pesquisaempregos;
    }

    public DataModel<Vaga> getPesquisaestagios() {
        vagaDAO = new VagaDAO();
        String teste = vaga.getDescricao();
        String teste1 = vaga.getCursorelacionado();
        int teste2 = vaga.getId();
        List<Vaga> estList = vagaDAO.localizarEstagios(teste,teste1,teste2);
        pesquisaestagios = new ListDataModel<>(estList);
        return pesquisaestagios;
    }

    public void setPesquisaestagios(DataModel<Vaga> pesquisaestagios) {
        this.pesquisaestagios = pesquisaestagios;
    }

    public DataModel<Vaga> getPesquisamonitorias() {
        vagaDAO = new VagaDAO();
        String teste = vaga.getDescricao();
        String teste1 = vaga.getCursorelacionado();
        int teste2 = vaga.getId();
        List<Vaga> monList = vagaDAO.localizarMonitorias(teste,teste1,teste2);
        pesquisamonitorias = new ListDataModel<>(monList);
        return pesquisamonitorias;
    }

    public void setPesquisamonitorias(DataModel<Vaga> pesquisamonitorias) {
        this.pesquisamonitorias = pesquisamonitorias;
    }

    public DataModel<Vaga> getPesquisaprojetos() {
        vagaDAO = new VagaDAO();
        String teste = vaga.getDescricao();
        String teste1 = vaga.getCursorelacionado();
        int teste2 = vaga.getId();
        List<Vaga> projList = vagaDAO.localizarProjetos(teste,teste1,teste2);
        pesquisaprojetos = new ListDataModel<>(projList);
        return pesquisaprojetos;
    }

    public void setPesquisaprojetos(DataModel<Vaga> pesquisaprojetos) {
        this.pesquisaprojetos = pesquisaprojetos;
    }

    public void geracurriculo() throws SQLException{
        Document document = new Document (PageSize.A4, 50, 50, 50, 50);
        selecionaaluno();
        try { 
            PdfWriter.getInstance(document, new FileOutputStream("C:\\Users\\tiago.silva\\Favorites\\Downloads\\Curriculo.pdf"));
        document.open(); 
        Image img = Image.getInstance("C:\\Users\\tiago.silva\\Favorites\\Downloads\\button.png");

img.setAlignment(Element.ALIGN_RIGHT);
document.add(img);
        Font f = new Font(Font.FontFamily.COURIER, 32, Font.BOLD);
Paragraph p1 = new Paragraph("Curriculum Vitae", f);
p1.setAlignment(Element.ALIGN_CENTER);
p1.setSpacingAfter(30);
 document.add(p1);
 Font g = new Font(Font.FontFamily.TIMES_ROMAN, 16, Font.BOLD);
 Paragraph p2 = new Paragraph("DADOS PESSOAIS:", g);
 p2.setAlignment(Element.ALIGN_LEFT);
 p2.setSpacingAfter(20);
document.add(p2);
 Font h = new Font(Font.FontFamily.TIMES_ROMAN, 14, Font.BOLD);
 Paragraph p3 = new Paragraph("Nome: "+aluno.getNome()     +"        Data de nascimento: "+aluno.getDatadenasc(), h);
 p3.setAlignment(Element.ALIGN_LEFT);
 p3.setSpacingAfter(20);
document.add(p3);
Paragraph p4 = new Paragraph("Email: "+aluno.getContato()+ "         Telefone: "+aluno.getTelefone(),h);
p4.setAlignment(Element.ALIGN_LEFT);
 p4.setSpacingAfter(20);
document.add(p4);
Paragraph p5 = new Paragraph("Curso: "+aluno.getCurso()+ "         Semestre atual: "+aluno.getSemestre(),h);
p5.setAlignment(Element.ALIGN_LEFT);
 p5.setSpacingAfter(40);
document.add(p5);
Paragraph p6 = new Paragraph("EXPERIÊNCIAS PROFISSIONAIS:", g);
 p6.setAlignment(Element.ALIGN_LEFT);
 p6.setSpacingAfter(20);
document.add(p6);
Paragraph p7 = new Paragraph("Empresa anterior: "+aluno.getExperienciaanteriorempresa()+ "         Cargo exercido: "+aluno.getExperienciaanteriorcargo(),h);
p7.setAlignment(Element.ALIGN_LEFT);
 p7.setSpacingAfter(20);
document.add(p7);
Paragraph p8 = new Paragraph("Descrição : "+aluno.getExperienciaanteriordescricao(),h);
p8.setAlignment(Element.ALIGN_LEFT);
 p8.setSpacingAfter(20);
document.add(p8);
Paragraph p9 = new Paragraph("Empresa anterior: "+aluno.getExperienciaanteriorempresa1()+ "         Cargo exercido: "+aluno.getExperienciaanteriorcargo1(),h);
p9.setAlignment(Element.ALIGN_LEFT);
 p9.setSpacingAfter(20);
document.add(p9);
Paragraph p10 = new Paragraph("Descrição : "+aluno.getExperienciaanteriordescricao1(),h);
p10.setAlignment(Element.ALIGN_LEFT);
 p10.setSpacingAfter(20);
document.add(p10);
Paragraph p11 = new Paragraph("Informações adicionais : "+aluno.getInfoadicionais(),h);
p11.setAlignment(Element.ALIGN_LEFT);
 p11.setSpacingAfter(20);
document.add(p11);
    } catch(DocumentException de) { 
    System.err.println(de.getMessage()); 
} catch(IOException ioe) {
    System.err.println(ioe.getMessage()); 
}
document.close();	


}
    private Conexao conexao;
         private Statement stmt;
         private boolean sucesso = false;
public void selecionaaluno() throws SQLException{
             conexao = new Conexao();
             try {
                
            stmt = (Statement) conexao.getConn().createStatement();
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
                
                
            try{
             ResultSet rs =   stmt.executeQuery("SELECT * FROM aluno");
               
            while(rs.next()){
                int loginBanco = rs.getInt("matricula");
                String senhaBanco = rs.getString("senha");
                String NomeAluno = rs.getString("nome");
                aluno.setNome(NomeAluno);
                aluno.setCurso(rs.getString("curso"));
                aluno.setId(rs.getInt("id"));
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
                         aluno.setNovasenha(rs.getString("novasenha"));
                          aluno.setNovasenha1(rs.getString("novasenha1"));
              
                
                              
                
                }                
            rs.close();
            
            
                              
            }catch(SQLException e){
                e.printStackTrace();
                
            }
              conexao.fecharConexao();  
                
         
        }        
        
        
    
    public void candidatar() throws SQLException {
    HtmlEmail email = new HtmlEmail();
email.setSSLOnConnect(true);
email.setHostName( "smtp.gmail.com" );
email.setSslSmtpPort( "465" );
email.setStartTLSRequired(true);
email.setSSLOnConnect(true);
email.setAuthenticator( new DefaultAuthenticator( "oportaldeoportunidades@gmail.com" ,  "*******" ) );
try {
    email.setFrom( "oportaldeoportunidades@gmail.com" , "Portal de Oportunidades");
    email.setDebug(true); 
    email.setSubject( "Candidato" );
 geracurriculo();
    EmailAttachment anexo = new EmailAttachment();
    anexo.setPath("C:\\Users\\tiago.silva\\Favorites\\Downloads\\Curriculo.pdf");
    anexo.setDisposition(EmailAttachment.ATTACHMENT);
    anexo.setName("curriculo.pdf");
 
        email.attach(anexo);
        selecionaaluno();
    //String emaildaempresa = vaga.getContato();
    //vaga.setContato(emaildaempresa);
    //System.out.print(emaildaempresa);
    email.setHtmlMsg( "Segue em anexo o currículo do candidato "+ aluno.getNome()+ " para vaga de " +vaga.getTipo()+ " código "+vaga.getId()+ "\n Cargo: "+vaga.getCargo()+ "\n Descrição da vaga: "+vaga.getDescricao() );
    email.addTo( vaga.getContato() );
    email.send();
    candidato();
     FacesMessage msg = new FacesMessage("Candidatura registrada com sucesso!! Você receberá um email de confirmação!");
      /* Obtém a instancia atual do FacesContext e adiciona a mensagem de erro nele. */
            FacesContext.getCurrentInstance().addMessage("candidatou", msg);
} catch (EmailException e) {
    e.printStackTrace();
}
}
 public void candidato() throws SQLException {
    HtmlEmail email = new HtmlEmail();
email.setSSLOnConnect(true);
email.setHostName( "smtp.gmail.com" );
email.setSslSmtpPort( "465" );
email.setStartTLSRequired(true);
email.setSSLOnConnect(true);
email.setAuthenticator( new DefaultAuthenticator( "oportaldeoportunidades@gmail.com" ,  "*********" ) );
try {
    email.setFrom( "oportaldeoportunidades@gmail.com" , "Portal de Oportunidades");
    email.setDebug(true); 
    email.setSubject( "Candidatura" );
 geracurriculo();
    EmailAttachment anexo = new EmailAttachment();
    //anexo.setPath("C:\\Users\\tiago.silva\\Favorites\\Downloads\\LinhaCodigo.pdf");
    //anexo.setDisposition(EmailAttachment.ATTACHMENT);
    //anexo.setName("curriculo.pdf");
 
        //email.attach(anexo);
    //String emaildaempresa = vaga.getContato();
    //vaga.setContato(emaildaempresa);
    //System.out.print(emaildaempresa);
    selecionaaluno();
    email.setHtmlMsg( "Você se candidatou a vaga de " +vaga.getTipo()+ " código: "  + vaga.getId());
    email.addTo( aluno.getContato() );
    email.send();
} catch (EmailException e) {
    e.printStackTrace();
}
}   
    
}
