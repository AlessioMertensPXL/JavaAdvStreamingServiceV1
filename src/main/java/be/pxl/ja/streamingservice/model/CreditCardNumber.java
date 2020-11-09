package be.pxl.ja.streamingservice.model;

public class CreditCardNumber {
    private static final int LENGTH = 16;
    private static final int CVC_LENGTH = 3;
    private CreditCardType creditCardType;
    private String number;
    private String cvc;

    public CreditCardNumber(String number, String cvc) {
        number = number.replaceAll(" ","");
        cvc = cvc.replaceAll(" ","");
        if (!isNumeric(number) || number.length() != LENGTH) {
            throw new IllegalArgumentException("A card number must have " + LENGTH + " digits.");
        }
        creditCardType = getCreditCardType(number);
        if (!isNumeric(cvc) || cvc.length() != CVC_LENGTH){
            throw new IllegalArgumentException("CVC must be "+ CVC_LENGTH +" digits.");
        }
        if (creditCardType == null) {
            throw new IllegalArgumentException("This is not a valid credit card.");
        }
        this.number = number;
        this.cvc = cvc;
    }

    private boolean isNumeric(String text) {

        if (text == null || text.length() == 0) {
            return false;
        }
        try {
            Long.parseLong(text);
            return true;
        } catch (NumberFormatException e) {
            return false;
        }
    }

    private CreditCardType getCreditCardType(String number) {
        for (CreditCardType cardType : CreditCardType.values()) {
            if (cardType.getFirstNumber() == Integer.parseInt(number.substring(0, 1))) {
                return cardType;
            }
        }
        return null;
    }

    public CreditCardType getType(){
        return getCreditCardType(number);
    }

    public String getCvc(){
        return cvc;
    }

    public String getNumber(){
        return number;
    }
}
