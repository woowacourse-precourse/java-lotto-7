package lotto.model;

import lotto.Message.ErrorMessage;

public class BonusNumber {

    private final int bonusNumber;

    public BonusNumber(String input){
        this.bonusNumber = validateNumber(input);
    }

    private int validateNumber(String input) {
        try {
            return Integer.parseInt(input);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException(ErrorMessage.INVALID_NUMBER.toString());
        }
    }

    public int getNumber(){
        return bonusNumber;
    }
}
