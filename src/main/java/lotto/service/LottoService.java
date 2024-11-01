package lotto.service;

import java.util.List;
import lotto.domain.Lotto;
import lotto.utility.Divider;
import lotto.utility.Parser;
import lotto.utility.RandomGenerator;
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

    private int parseStringToInt(String inputCost) {
        return Parser.parseStringToInt(inputCost);
    }

    private void isDivisibleByThousand(int parsedPurchaseAmount) {
        Validator.isDivisibleByThousand(parsedPurchaseAmount);
    }

    public int divideInputByLottoPrice(int parsedPurchaseAmount) {
        return Divider.divideInputByLottoPrice(parsedPurchaseAmount);
    }

    public void generateLottosObject(int purchasedLottoCount) {
        for (int i = 0; i < purchasedLottoCount; i++) {
            List<Integer> randomNumbers = generateOneSetRandomNumber();
            Lotto lotto = new Lotto(randomNumbers);
        }
    }

    public List<Integer> generateOneSetRandomNumber() {
        return RandomGenerator.makeRandomNumber();
    }

}
