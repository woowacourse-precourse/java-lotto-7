package lotto.domain;

import static lotto.exception.ErrorMessages.COST_POSITIVE_INTEGER_ERROR_MESSAGE;

public class Cost {
    int value;

    public Cost(String value) {
        validate(value);
        this.value = Integer.parseInt(value);
    }

    private void validate(String value){
        if(!isInteger(value) || !isPositive(value)){
            throw new IllegalArgumentException(COST_POSITIVE_INTEGER_ERROR_MESSAGE);
        }
    }

    public boolean isInteger(String value){
        try{
            Integer.parseInt(value);
            return true;
        } catch (NumberFormatException e){
            return false;
        }
    }

    public boolean isPositive(String value){
        int castedValue = Integer.parseInt(value);
        return castedValue > 0;
    }
}
