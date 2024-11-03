package lotto.domain;

import static lotto.exception.ErrorMessages.*;
import static lotto.util.Validator.isInteger;
import static lotto.util.Validator.isPositive;

public class Cost {
    int value;

    public Cost(String value) {
        validate(value);
        this.value = Integer.parseInt(value);
    }

    public int getValue(){
        return value;
    }

    private void validate(String value){
        if(!isInteger(value) || !isPositive(value)){
            throw new IllegalArgumentException(COST_POSITIVE_INTEGER_ERROR);
        }

        if(!isDividedThousand(value)){
            throw new IllegalArgumentException(DIVISIBLE_BY_THOUSAND_COST_ERROR);
        }
    }

    public boolean isDividedThousand(String value){
        int castedValue = Integer.parseInt(value);
        return castedValue % 1000 == 0;
    }
}
