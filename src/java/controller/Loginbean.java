package controller;

import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Element;
import com.itextpdf.text.Font;
import com.itextpdf.text.Font.FontFamily;
import com.itextpdf.text.Image;
import com.itextpdf.text.PageSize;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.pdf.PdfWriter;
import dao.AlunoDAO;
import dao.Conexao;
import dao.VagaDAO;
import java.io.FileOutputStream;
import java.io.IOException;
import model.Aluno;
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
import model.Admin;
import model.Vaga;
import javax.mail.*;
import org.apache.commons.mail.DefaultAuthenticator;
import org.apache.commons.mail.EmailAttachment;
import org.apache.commons.mail.EmailException;
import org.apache.commons.mail.HtmlEmail;



//@Named("logar")
@SessionScoped
@ManagedBean (name="logar")
public class Loginbean implements Serializable{
   
   
    public Aluno aluno = new Aluno();
   private Admin admin = new Admin();
   private AlunoDAO alunoDAO = new AlunoDAO();
   private VagaDAO vagaDAO = new VagaDAO();
   private Vaga vaga = new Vaga();
   private DataModel<Vaga> empregossugeridos;
       private DataModel<Vaga> estagiossugeridos;
        private DataModel<Vaga> monitoriassugeridas; 
        private DataModel<Vaga> projetossugeridos; 
           private DataModel<Vaga> bolsassugeridas;
           
           public Vaga getVaga() {
        return vaga;
    }
 
    public void setVaga(Vaga vaga) {
        this.vaga = vaga;
    }
   
         private Conexao conexao;
         private Statement stmt;
         private boolean sucesso = false;
   
  public void selecionarEmpregoSugerido(){
        vaga = empregossugeridos.getRowData();
    }
 public void selecionarEstagioSugerido(){
        vaga = estagiossugeridos.getRowData();
    }
 public void selecionarMonitoriaSugerida(){
        vaga = monitoriassugeridas.getRowData();
    }
 public void selecionarProjetoSugerido(){
        vaga = projetossugeridos.getRowData();
    }
 public void selecionarBolsaSugerida(){
        vaga = bolsassugeridas.getRowData();
    }
 
        public String login() throws SQLException{
             conexao = new Conexao();
             try {
                 System.out.print("logado");
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
              
                
                if(aluno.getMatricula() == loginBanco & aluno.getSenha().equals(senhaBanco)){
                    return "principalAluno";
                      
                    }                
                
                }                
            rs.close();
            
            rs = stmt.executeQuery("SELECT matricula, senha FROM admin");

            while(rs.next()){
                int loginBanco = rs.getInt("matricula");
                String senhaBanco = rs.getString("senha");
                
                if(aluno.getMatricula() == loginBanco & aluno.getSenha().equals(senhaBanco)){
                    
                    return "principalAdmin";
                      
                    }
                 else {
      /* Cria uma mensagem. */
      FacesMessage msg = new FacesMessage("Usuário e/ou senha inválidos!");
      /* Obtém a instancia atual do FacesContext e adiciona a mensagem de erro nele. */
      FacesContext.getCurrentInstance().addMessage("erro", msg);
      return null;
    }
                }                
               rs.close();
               conexao.fecharConexao();
            }catch(SQLException e){
                e.printStackTrace();
                
            }
              
                
            return null;
        }
         public String alterarPerfil(){
        
        String resultado = "falha";
        alunoDAO = new AlunoDAO();
        boolean retorno = alunoDAO.alterarPerfil(aluno);
 int teste = aluno.getMatricula();
 System.out.print(teste);
        
       
        
        if(retorno){
            FacesMessage msg = new FacesMessage("O seu Perfil foi alterado com sucesso");
      /* Obtém a instancia atual do FacesContext e adiciona a mensagem de erro nele. */
            FacesContext.getCurrentInstance().addMessage("editou", msg);
            resultado = "editarperfil";
        }
  //limpardados();
        return resultado;
    }
        
         public String alterarSenha(){
        
        String resultado = "falha";
        alunoDAO = new AlunoDAO();
        boolean retorno = alunoDAO.alterarSenha(aluno);
 //int teste = aluno.getMatricula();
 //System.out.print(teste);
        
       
        
        if(retorno){
            FacesMessage msg = new FacesMessage("A sua senha foi alterada com sucesso");
      /* Obtém a instancia atual do FacesContext e adiciona a mensagem de erro nele. */
            FacesContext.getCurrentInstance().addMessage("editou", msg);
            resultado = "alterarsenha";
        }
       
            else {
              FacesMessage msg = new FacesMessage("Os dados não conferem, por favor tente novamente!");
      /* Obtém a instancia atual do FacesContext e adiciona a mensagem de erro nele. */
            FacesContext.getCurrentInstance().addMessage("editou", msg);
            
              resultado="alterarsenha";
          }
            
        
  //limpardados();
        return resultado;
    }
        
        
        
        
        public Aluno getAluno() {
		return aluno; 
	}
        public void setAluno(Aluno aluno) {
		this.aluno = aluno;
	}
public DataModel<Vaga> getEmpregossugeridos() {
    vagaDAO = new VagaDAO();
        
        String cursoaluno = aluno.getCurso();
        aluno.setCurso(cursoaluno);
        System.out.print(cursoaluno);
        String cargo = aluno.getCargopretendido();
        aluno.setCargopretendido(cargo);
        String cargo2 = aluno.getCargopretendido1();
        aluno.setCargopretendido1(cargo2);
        String area = aluno.getAreadeinteresse();
        aluno.setAreadeinteresse(area);
        String area2 = aluno.getAreadeinteresse1();
        aluno.setAreadeinteresse1(area2);
        String experiencia = aluno.getExperienciaanteriorcargo();
        aluno.setExperienciaanteriorcargo(experiencia);
        String experiencia2 = aluno.getExperienciaanteriorcargo1();
        aluno.setExperienciaanteriorcargo1(experiencia2);
        
        
        List<Vaga> empList = vagaDAO.sugerirEmpregos(cursoaluno, cargo, cargo2,area, area2, experiencia, experiencia2);
        empregossugeridos = new ListDataModel<>(empList);
    
    
    
    
        return empregossugeridos;
    }

    public void setEmpregossugeridos(DataModel<Vaga> empregossugeridos) {
        this.empregossugeridos = empregossugeridos;
    }

    public DataModel<Vaga> getEstagiossugeridos() {
        vagaDAO = new VagaDAO();
        
        String cursoaluno = aluno.getCurso();
        aluno.setCurso(cursoaluno);
        System.out.print(cursoaluno);
        String cargo = aluno.getCargopretendido();
        aluno.setCargopretendido(cargo);
        String cargo2 = aluno.getCargopretendido1();
        aluno.setCargopretendido1(cargo2);
        String area = aluno.getAreadeinteresse();
        aluno.setAreadeinteresse(area);
        String area2 = aluno.getAreadeinteresse1();
        aluno.setAreadeinteresse1(area2);
        String experiencia = aluno.getExperienciaanteriorcargo();
        aluno.setExperienciaanteriorcargo(experiencia);
        String experiencia2 = aluno.getExperienciaanteriorcargo1();
        aluno.setExperienciaanteriorcargo1(experiencia2);
        
        
        List<Vaga> estList = vagaDAO.sugerirEstagios(cursoaluno, cargo, cargo2,area, area2, experiencia, experiencia2);
        estagiossugeridos = new ListDataModel<>(estList);
        return estagiossugeridos;
    }

    public void setEstagiossugeridos(DataModel<Vaga> estagiossugeridos) {
        this.estagiossugeridos = estagiossugeridos;
    }

    public DataModel<Vaga> getMonitoriassugeridas() {
         vagaDAO = new VagaDAO();
        
        String cursoaluno = aluno.getCurso();
        aluno.setCurso(cursoaluno);
        System.out.print(cursoaluno);
        String cargo = aluno.getCargopretendido();
        aluno.setCargopretendido(cargo);
        String cargo2 = aluno.getCargopretendido1();
        aluno.setCargopretendido1(cargo2);
        String area = aluno.getAreadeinteresse();
        aluno.setAreadeinteresse(area);
        String area2 = aluno.getAreadeinteresse1();
        aluno.setAreadeinteresse1(area2);
        String experiencia = aluno.getExperienciaanteriorcargo();
        aluno.setExperienciaanteriorcargo(experiencia);
        String experiencia2 = aluno.getExperienciaanteriorcargo1();
        aluno.setExperienciaanteriorcargo1(experiencia2);
        
        
        List<Vaga> projList = vagaDAO.sugerirMonitorias(cursoaluno, cargo, cargo2,area, area2, experiencia, experiencia2);
        monitoriassugeridas = new ListDataModel<>(projList);
        
        
        return monitoriassugeridas;
    }

    public void setMonitoriassugeridas(DataModel<Vaga> monitoriassugeridas) {
        this.monitoriassugeridas = monitoriassugeridas;
    }

    public DataModel<Vaga> getProjetossugeridos() {
        vagaDAO = new VagaDAO();
        
        String cursoaluno = aluno.getCurso();
        aluno.setCurso(cursoaluno);
        System.out.print(cursoaluno);
        String cargo = aluno.getCargopretendido();
        aluno.setCargopretendido(cargo);
        String cargo2 = aluno.getCargopretendido1();
        aluno.setCargopretendido1(cargo2);
        String area = aluno.getAreadeinteresse();
        aluno.setAreadeinteresse(area);
        String area2 = aluno.getAreadeinteresse1();
        aluno.setAreadeinteresse1(area2);
        String experiencia = aluno.getExperienciaanteriorcargo();
        aluno.setExperienciaanteriorcargo(experiencia);
        String experiencia2 = aluno.getExperienciaanteriorcargo1();
        aluno.setExperienciaanteriorcargo1(experiencia2);
        
        
        List<Vaga> projList = vagaDAO.sugerirProjetos(cursoaluno, cargo, cargo2,area, area2, experiencia, experiencia2);
        projetossugeridos = new ListDataModel<>(projList);
        
        return projetossugeridos;
    }

    public void setProjetossugeridos(DataModel<Vaga> projetossugeridos) {
        this.projetossugeridos = projetossugeridos;
    }

    public DataModel<Vaga> getBolsassugeridas() {
        vagaDAO = new VagaDAO();
        
        String cursoaluno = aluno.getCurso();
        aluno.setCurso(cursoaluno);
        System.out.print(cursoaluno);
        String cargo = aluno.getCargopretendido();
        aluno.setCargopretendido(cargo);
        String cargo2 = aluno.getCargopretendido1();
        aluno.setCargopretendido1(cargo2);
        String area = aluno.getAreadeinteresse();
        aluno.setAreadeinteresse(area);
        String area2 = aluno.getAreadeinteresse1();
        aluno.setAreadeinteresse1(area2);
        String experiencia = aluno.getExperienciaanteriorcargo();
        aluno.setExperienciaanteriorcargo(experiencia);
        String experiencia2 = aluno.getExperienciaanteriorcargo1();
        aluno.setExperienciaanteriorcargo1(experiencia2);
        
        
        List<Vaga> bolList = vagaDAO.sugerirBolsas(cursoaluno, cargo, cargo2,area, area2, experiencia, experiencia2);
        bolsassugeridas = new ListDataModel<>(bolList);
        return bolsassugeridas;
    }

    public void setBolsassugeridas(DataModel<Vaga> bolsassugeridas) {
        this.bolsassugeridas = bolsassugeridas;
    }
    public void geracurriculo(){
        Document document = new Document (PageSize.A4, 50, 50, 50, 50);
        try { 
            PdfWriter.getInstance(document, new FileOutputStream("C:\\Users\\tiago.silva\\Favorites\\Downloads\\Curriculo.pdf"));
        document.open(); 
        Image img = Image.getInstance("C:\\Users\\tiago.silva\\Favorites\\Downloads\\button.png");

img.setAlignment(Element.ALIGN_RIGHT);
document.add(img);
        Font f = new Font(FontFamily.COURIER, 32, Font.BOLD);
Paragraph p1 = new Paragraph("Curriculum Vitae", f);
p1.setAlignment(Element.ALIGN_CENTER);
p1.setSpacingAfter(30);
 document.add(p1);
 Font g = new Font(FontFamily.TIMES_ROMAN, 16, Font.BOLD);
 Paragraph p2 = new Paragraph("DADOS PESSOAIS:", g);
 p2.setAlignment(Element.ALIGN_LEFT);
 p2.setSpacingAfter(20);
document.add(p2);
 Font h = new Font(FontFamily.TIMES_ROMAN, 14, Font.BOLD);
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
        
        
        
    
    public void candidatar() {
    HtmlEmail email = new HtmlEmail();
email.setSSLOnConnect(true);
email.setHostName( "smtp.gmail.com" );
email.setSslSmtpPort( "465" );
email.setStartTLSRequired(true);
email.setSSLOnConnect(true);
email.setAuthenticator( new DefaultAuthenticator( "oportaldeoportunidades@gmail.com" ,  "*************************" ) );
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
 public void candidato() {
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
    email.setHtmlMsg( "Você se candidatou a vaga de " +vaga.getTipo()+ " código: "  + vaga.getId());
    email.addTo( aluno.getContato() );
    email.send();
} catch (EmailException e) {
    e.printStackTrace();
}
}   
}
