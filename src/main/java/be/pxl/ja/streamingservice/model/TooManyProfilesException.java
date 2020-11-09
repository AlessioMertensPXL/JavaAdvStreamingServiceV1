package be.pxl.ja.streamingservice.model;

public class TooManyProfilesException extends RuntimeException{
    public TooManyProfilesException(){
        super("Attempted to add more profiles than your streamingplan allows ");
    }
}