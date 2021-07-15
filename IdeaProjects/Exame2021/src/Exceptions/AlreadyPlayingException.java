package Exceptions;

public class AlreadyPlayingException extends Exception {
    public AlreadyPlayingException() {
        super();
        System.out.println("Exame2021.Utilizador já se encontra a reproduzir media\n");
    }
}
