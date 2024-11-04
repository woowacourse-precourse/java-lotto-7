package lotto;

import camp.nextstep.edu.missionutils.Console;

import java.util.ArrayList;
import java.util.List;

public class LottoWinningNumbers {
    private final List<Integer> winningNumbers = new ArrayList<>();
    private int bonusNumber;

    public void inputWinningNumbers() {
        winningNumbers.clear();
        System.out.println(Constants.INPUT_WINNING_NUMBERS);
        String winningNumbersInput = Console.readLine();
        System.out.println();
        try {
            validateWinningNumbersInput(winningNumbersInput);
            makeWinningNumbers(winningNumbersInput);
        } catch (IllegalArgumentException e) {
            inputWinningNumbers();
        }
    }

    public void makeWinningNumbers(String inputNumbers) {
        try {
            for (final String inputNumber : inputNumbers.split(",")) {
                validateInputNumber(inputNumber);
                final int number = Integer.parseInt(inputNumber);
                winningNumbers.add(number);
            }
            validateWinningNumbers(winningNumbers);
        } catch (IllegalArgumentException e) {
            inputWinningNumbers();
        }
    }

    public void inputBonusNumber() {
        System.out.println(Constants.INPUT_BONUS_NUMBERS);
        String bonusNumberInput = Console.readLine();
        System.out.println();
        try {
            validateBonusNumberInput(bonusNumberInput);
            bonusNumber = Integer.parseInt(bonusNumberInput);
        } catch (IllegalArgumentException e) {
            inputBonusNumber();
        }
    }

    public int getBonusNumber() {
        return bonusNumber;
    }

    public List<Integer> getWinningNumbers() {
        return winningNumbers;
    }

    public void validateWinningNumbersInput(String str) {
        if (!str.contains(",")) {
            System.out.println(Constants.NOT_INPUT_COMMA);
            throw new IllegalArgumentException(Constants.NOT_INPUT_COMMA);
        }
    }

    public void validateInputNumber(String winningNumbersInput) {
        if (!winningNumbersInput.matches("^([1-9]|[1-3][0-9]|4[0-5])$")) {
            System.out.println(Constants.WRONG_RANGE);
            throw new IllegalArgumentException(Constants.WRONG_RANGE);
        }
    }

    public void validateWinningNumbers(List<Integer> winningNumbers) {
        if (winningNumbers.size() != 6) {
            System.out.println(Constants.WRONG_LENGTH);
            throw new IllegalArgumentException(Constants.WRONG_LENGTH);
        }
        if (winningNumbers.size() != winningNumbers.stream().distinct().count()){
            System.out.println(Constants.DUPLICATE_NUMBER);
            throw new IllegalArgumentException(Constants.DUPLICATE_NUMBER);
        }
    }

    public void validateBonusNumberInput(String bonusNumberInput) {
        if (!bonusNumberInput.matches("^([1-9]|[1-3][0-9]|4[0-5])$")) {
            System.out.println(Constants.WRONG_RANGE);
            throw new IllegalArgumentException(Constants.WRONG_RANGE);
        }
        if (winningNumbers.contains(Integer.parseInt(bonusNumberInput))) {
            System.out.println(Constants.DUPLICATE_BONUS_NUMBER);
            throw new IllegalArgumentException(Constants.DUPLICATE_BONUS_NUMBER);
        }
    }
}
