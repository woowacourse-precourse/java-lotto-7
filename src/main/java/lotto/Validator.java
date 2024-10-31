package lotto;

import lotto.exception.lottoPrice.InvalidThousandUnitException;
import lotto.exception.lottoPrice.MinimumPriceException;
import lotto.exception.lottoPrice.NullPriceException;


public class Validator {

    public void isValidPrice(String input){
        if(input.isEmpty()){
            throw new NullPriceException();
        }
        try{
            int price = Integer.parseInt(input);
            checkMinimumPrice(price);
            checkIsDivisibleByThousand(price);
        } catch (NumberFormatException e){
            System.out.println("[ERROR] "+ e.getMessage());
        }
    }

    private void checkIsDivisibleByThousand(int price) {
        if(price % 1000 !=0){
            throw new InvalidThousandUnitException();
        }
    }

    private void checkMinimumPrice(int price) {
        if(price < 1000){
            throw new MinimumPriceException();
        }
    }

}
