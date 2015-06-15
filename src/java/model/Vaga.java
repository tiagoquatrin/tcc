/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

/**
 *
 * @author tiago.silva
 */
public class Vaga {
 


	private int id;
        private String loc;
        private String tipo;
        private String descricao;
        private String titulo;
        private String contato;
        private String cargahoraria;
        private String valor;
        private String nomeorientador;
        private String duracao;
        private String tipoprojeto;
        private String cursorelacionado;
        private String beneficios;
        private String disciplina;
        private String cargo;
        private String area;
          private String cursorelacionado1;
          
          public String getCursorelacionado1() {
        return cursorelacionado1;
    }

    public void setCursorelacionado1(String cursorelacionado1) {
        this.cursorelacionado1 = cursorelacionado1;
    }

    public String getCargo() {
        return cargo;
    }

    public void setCargo(String cargo) {
        this.cargo = cargo;
    }

    public String getArea() {
        return area;
    }

    public void setArea(String area) {
        this.area = area;
    }
      
        
        
        
        public int getId(){
            return id;
        }
        public void setId (int id){
            this.id = id;
        }
        
        
        public String getLoc(){
            return loc;
        }
        public void setLoc (String loc){
            this.loc = loc;
        }
        
        
        public String getTipo(){
            return tipo;
        }
        public void setTipo (String tipo){
            this.tipo = tipo;
        }
        
        
        public String getDescricao(){
            return descricao;
        }
        public void setDescricao (String descricao){
            this.descricao = descricao;
        }
        
        
        public String getTitulo(){
            return titulo;
        }
        public void setTitulo (String titulo){
            this.titulo = titulo;
        }
        
        
        public String getContato(){
            return contato;
        }
        public void setContato (String contato){
            this.contato = contato;
        }
        
        
        public String getCargahoraria(){
            return cargahoraria;
        }
        public void setCargahoraria (String cargahoraria){
            this.cargahoraria = cargahoraria;
        }
        
        
        public String getValor(){
            return valor;
        }
        public void setValor (String valor){
            this.valor = valor;
        }
        public String getNomeorientador() {
        return nomeorientador;
    }

    public void setNomeorientador(String nomeorientador) {
        this.nomeorientador = nomeorientador;
    }

    public String getDuracao() {
        return duracao;
    }

    public void setDuracao(String duracao) {
        this.duracao = duracao;
    }

    public String getTipoprojeto() {
        return tipoprojeto;
    }

    public void setTipoprojeto(String tipoprojeto) {
        this.tipoprojeto = tipoprojeto;
    }

    public String getCursorelacionado() {
        return cursorelacionado;
    }

    public void setCursorelacionado(String cursorelacionado) {
        this.cursorelacionado = cursorelacionado;
    }

    public String getBeneficios() {
        return beneficios;
    }

    public void setBeneficios(String beneficios) {
        this.beneficios = beneficios;
    }

    public String getDisciplina() {
        return disciplina;
    }

    public void setDisciplina(String disciplina) {
        this.disciplina = disciplina;
    }

}
