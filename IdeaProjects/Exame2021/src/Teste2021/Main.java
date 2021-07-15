package Teste2021;

import Exceptions.PodcastNotFoundException;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args)  {

        List<Empregado> lemp = new ArrayList<>();
        lemp.add(new Funcionario());
        lemp.add(new AlunoTE());
        lemp.add(new Funcionario());
        lemp.add(new AlunoTE());
        lemp.add(new Funcionario());
        lemp.add(new AlunoTE());

        List<Aluno> lal = new ArrayList<>();
        lal.add(new AlunoTE());
        lal.add(new Aluno());
        lal.add(new AlunoTE());
        lal.add(new Aluno());
        lal.add(new AlunoTE());

        //System.out.println(lemp);
        //System.out.println(lal);


        /**
         * getStatus1()
         */
        UMinho u = new UMinho();
        System.out.println(u.getStatus1(lemp));
    }
}
