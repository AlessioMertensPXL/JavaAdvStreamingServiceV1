package be.pxl.ja.streamingservice.model;

public class DuplicateEmailException extends RuntimeException{
    public DuplicateEmailException(){
        super("email is already in use");
    }
}
