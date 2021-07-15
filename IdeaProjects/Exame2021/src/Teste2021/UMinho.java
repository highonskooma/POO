package Teste2021;


import java.util.List;
import java.util.stream.Collectors;

public class UMinho {
    public UMinho() { }

    public List<String> getStatus1(List<Empregado> l) {
        return l.stream().filter(e -> e instanceof Aluno).map(e -> e.getEmpregador()).collect(Collectors.toList());
    }
/*
    public List<String> getEstatus2(List<Aluno> l) {
        return l.stream().filter(a -> a instanceof Empregado).map(e -> e.getEmpregador()).collect(Collectors.toList());
    }

    public List<String> getEstatus3(List<Empregado> l) {
        return l.stream().map(e -> (Aluno) e).map(a -> a.getEmpregador()).collect(Collectors.toList());
    }

 */
}
