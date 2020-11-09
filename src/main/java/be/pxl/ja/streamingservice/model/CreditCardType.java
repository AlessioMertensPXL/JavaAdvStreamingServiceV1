package be.pxl.ja.streamingservice.model;

public enum CreditCardType {
    VISA,
    MASTERCARD;

    public int getFirstNumber() {
        if (this == VISA){
            return 4;
        }
        return 5;
    }
}