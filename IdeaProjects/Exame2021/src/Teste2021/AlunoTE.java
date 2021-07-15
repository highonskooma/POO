package Teste2021;

public class AlunoTE extends Aluno implements Empregado {
    public AlunoTE() {  }
    public boolean epocaEspecial() { return true; }
    public String getEmpregador() { return "Externo"; }
}