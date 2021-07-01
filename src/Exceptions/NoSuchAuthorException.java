package Exceptions;

public class NoSuchAuthorException extends Exception {
    public NoSuchAuthorException(){
        super();
        System.out.println("There is no such author in the system.\n");
    }
    public NoSuchAuthorException(String s){
        super(s);
        System.out.println("The author "+ s + " does not exist in the system.\n");
    }
}
