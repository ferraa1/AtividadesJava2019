package exercicioagregacao1;

import java.util.ArrayList;
import java.util.List;

public class Turma {

    private int codigo;
    private String curso;
    private int anoIngresso;
    private Professor professor;
    private List<Aluno> alunos = new ArrayList<>();

    public Turma() {
    }

    public Turma(int codigo, String curso, int anoIngresso, Professor professor) {
        this.codigo = codigo;
        this.curso = curso;
        this.anoIngresso = anoIngresso;
        this.professor = professor;
    }

    public int getCodigo() {
        return codigo;
    }

    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }

    public String getCurso() {
        return curso;
    }

    public void setCurso(String curso) {
        this.curso = curso;
    }

    public int getAnoIngresso() {
        return anoIngresso;
    }

    public void setAnoIngresso(int anoIngresso) {
        this.anoIngresso = anoIngresso;
    }

    public Professor getProfessor() {
        return professor;
    }

    public void setProfessor(Professor professor) {
        this.professor = professor;
    }

    public List<Aluno> getAlunos() {
        return alunos;
    }

    public void setAlunos(List<Aluno> alunos) {
        this.alunos = alunos;
    }

    @Override
    public String toString() {
        return "Turma{" + "codigo=" + codigo + ", curso=" + curso + ", anoIngresso=" + anoIngresso + ", professor=" + professor.toString() + '}';
    }
    
    public void addAluno (Aluno a) {
        alunos.add(a);
    }
    
}
