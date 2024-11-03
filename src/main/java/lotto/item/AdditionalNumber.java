package lotto.item;

import lotto.constant.ErrorName;

public class AdditionalNumber {
    private final int number;
    public AdditionalNumber(String additionalMoneyforValid) {
        validation(additionalMoneyforValid);
        this.number = Integer.parseInt(additionalMoneyforValid);
    }

    public int getNumber() {
        return number;
    }

    private void validation(String additionalMoneyforValid) {
        try{
            Integer.parseInt(additionalMoneyforValid);
        }catch(NumberFormatException e){
            throw new IllegalArgumentException(ErrorName.ErrorNotNumber.getErrorMessage());
        }

        if (!((Integer.parseInt(additionalMoneyforValid) >= 1) &&
                (Integer.parseInt(additionalMoneyforValid) <= 45))) {
            throw new IllegalArgumentException(ErrorName.ErrorRange.getErrorMessage());
        }
    }
}
