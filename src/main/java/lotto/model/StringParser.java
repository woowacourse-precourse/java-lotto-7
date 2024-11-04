package lotto.model;

import java.util.Arrays;
import java.util.List;


public class StringParser {
    protected static final int UNIT_AMOUNT = 1000;
    protected static final int MIN_NUMBER = 1;
    protected static final int MAX_NUMBER = 45;
    protected static final int NUMBER_COUNT = 6;
    private final Validation validation;

    public StringParser(Validation validation) {
        this.validation = validation;
    }

    public Integer findLottoCount(String rawAmount) {
        int amount = validation.validateInteger(rawAmount);
        validation.isPositive(amount);
        return validation.validateAmount(amount);
    }

    public List<Integer> findMyNumbers(String rawNumbers) {
        List<String> splitNumbers = Arrays.stream(rawNumbers.split(","))
            .map(String::trim)
            .toList();

        List<Integer> myNumbers = validateMyNumbers(splitNumbers);

        return myNumbers;
    }

    public Integer findBonusNumber(List<Integer> myNumbers, String rawBonusNumber) {
        int bonusNumber = validation.validateInteger(rawBonusNumber);
        validation.isPositive(bonusNumber);
        validation.validateRange(bonusNumber);
        validation.isUnique(myNumbers, bonusNumber);
        return bonusNumber;
    }

    private List<Integer> validateMyNumbers(List<String> splitNumbers) {
        List<Integer> myNumbers = splitNumbers.stream().map(validation::validateInteger)
            .filter(validation::isPositive)
            .filter(validation::validateRange)
            .toList();

        validation.isUnique(myNumbers);
        validation.validateSize(myNumbers);

        return myNumbers;
    }


}
