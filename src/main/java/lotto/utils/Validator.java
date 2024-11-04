package lotto.utils;

public class Validator {

    public boolean isPositiveInteger(String purchaseInput){
        return purchaseInput.matches("^[1-9]\\d*$");
    }

    public boolean isDivisibleBy1000(int purchase){
        if(purchase%100 == 0){
            return true;
        }
        return false;
    }
}
