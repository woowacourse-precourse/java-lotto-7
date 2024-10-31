package lotto.service;

import lotto.domain.Parser;
import lotto.validation.Validator;

public class LottoService {
    public boolean isValidNumber(String inputCost) {
        if (isBlank(inputCost) == true || !isPositiveNumber(inputCost) == true) {
            return false;
        }
        return true;
    }

    private boolean isBlank(String inputCost) {
        return Validator.isBlank(inputCost);
    }

    private boolean isPositiveNumber(String inputCost) {
        return Validator.isPositiveNumber(inputCost);
    }

    public int parseStringToInt(String inputCost) {
        return Parser.parseStringToInt(inputCost);
    }

    public boolean isDivisibleByThousand(int parsedPurchaseAmount) {
        return Validator.isDivisibleByThousand(parsedPurchaseAmount);
    }
}
