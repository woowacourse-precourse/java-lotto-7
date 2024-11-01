package lotto.service;

import lotto.domain.Divider;
import lotto.domain.Parser;
import lotto.validation.Validator;

public class LottoService {
    public int isValidNumber(String inputCost) {
        isBlank(inputCost);
        isPositiveNumber(inputCost);
        int parsedCost = parseStringToInt(inputCost);
        isDivisibleByThousand(parsedCost);

        return parsedCost;
    }

    private void isBlank(String inputCost) {
        Validator.isBlank(inputCost);
    }

    private void isPositiveNumber(String inputCost) {
        Validator.isPositiveNumber(inputCost);
    }

    public int parseStringToInt(String inputCost) {
        return Parser.parseStringToInt(inputCost);
    }

    private void isDivisibleByThousand(int parsedPurchaseAmount) {
        Validator.isDivisibleByThousand(parsedPurchaseAmount);
    }

    public int divideInputByLottoPrice(int parsedPurchaseAmount) {
        return Divider.divideInputByLottoPrice(parsedPurchaseAmount);
    }

}
