package lotto.domain;

import static lotto.config.ErrorMessageConstant.DUPLICATED_BONUS_NUMBER_MESSAGE;
import static lotto.config.ErrorMessageConstant.DUPLICATED_WINNING_NUMBER_MESSAGE;
import static lotto.config.ErrorMessageConstant.EMPTY_WINNGING_NUMBER_MESSAGE;
import static lotto.config.ErrorMessageConstant.INSUFFICIENT_WINNING_NUMBERS_MESSAGE;
import static lotto.config.ErrorMessageConstant.INVALID_RANGE_NUMBER_MESSAGE;
import static lotto.config.GameConstant.LOWER_BOUND_WINNING_NUMBER;
import static lotto.config.GameConstant.NUMBER_OF_WINNING_NUMBER;
import static lotto.config.GameConstant.UPPER_BOUND_WINNING_NUMBER;
import static lotto.util.Parser.parseToInteger;
import static lotto.util.Parser.parseToIntegerList;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

public class LottoMachine {
    private List<Integer> winningNumbers;
    private int bonusNumber;

    public LottoMachine() {
        winningNumbers = new ArrayList<>();
    }

    public LottoMachine assignWinningNumbers(List<String> winningNumbers) {
        validateWinningNumbers(winningNumbers);

        this.winningNumbers = parseToIntegerList(winningNumbers);
        return this;
    }

    public LottoMachine assignBonusNumber(String bonusNumber) {
        validateBonusNumber(bonusNumber);

        this.bonusNumber = parseToInteger(bonusNumber);
        return this;
    }

    public List<Integer> getWinningNumbers() {
        return winningNumbers;
    }

    public int getBonusNumber() {
        return bonusNumber;
    }

    private void validateWinningNumbers(List<String> winningNumbers) {
        List<Integer> parsedWinningNumbers = parseToIntegerList(winningNumbers);

        if (winningNumbers.size() != NUMBER_OF_WINNING_NUMBER) {
            throw new IllegalArgumentException(INSUFFICIENT_WINNING_NUMBERS_MESSAGE);
        }

        if (new HashSet<>(winningNumbers).size() != NUMBER_OF_WINNING_NUMBER) {
            throw new IllegalArgumentException(DUPLICATED_WINNING_NUMBER_MESSAGE);
        }

        for (int winningNumber : parsedWinningNumbers) {
            validateRangeNumber(winningNumber);
        }
    }

    private void validateBonusNumber(String bonusNumber) {
        int parsedBonusNumber = parseToInteger(bonusNumber);

        if (winningNumbers.isEmpty()) {
            throw new IllegalArgumentException(EMPTY_WINNGING_NUMBER_MESSAGE);
        }

        validateRangeNumber(parsedBonusNumber);

        if (winningNumbers.contains(parsedBonusNumber)) {
            throw new IllegalArgumentException(DUPLICATED_BONUS_NUMBER_MESSAGE);
        }
    }

    private void validateRangeNumber(int number) {
        if (number < LOWER_BOUND_WINNING_NUMBER || number > UPPER_BOUND_WINNING_NUMBER) {
            throw new IllegalArgumentException(INVALID_RANGE_NUMBER_MESSAGE);
        }
    }
}
