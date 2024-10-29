package lotto.util;

import static lotto.constant.ErrorMessage.PRICE_TYPE_ERROR;

public class Validator {

    public boolean validatePrice(String price) {
        try{
            checkNumberType(price);
        } catch (IllegalArgumentException e) {
            System.out.println(PRICE_TYPE_ERROR.getMessage());
            return false;
        }
        return true;
    }

    private void checkNumberType(String price) {
        try{
            Integer.parseInt(price);
        } catch(NumberFormatException e){
            throw new IllegalArgumentException();
        }
    }

}
