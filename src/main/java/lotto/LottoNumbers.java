package lotto;

import camp.nextstep.edu.missionutils.Console;
import java.util.ArrayList;

import static constant.Message.INPUT_REQUEST_BONUS_NUMBER;
import static constant.Message.INPUT_REQUEST_WINNING_NUMBERS;

public class LottoNumbers {
    private static final String DELIMITER = ",";

    private ArrayList<Integer> winningNumbers;
    private int bonusNumber;

    public void init() {
        winningNumbers = initWinningNumbers();
        bonusNumber = initBonusNumber(winningNumbers);
    }

    private ArrayList<Integer> initWinningNumbers() {
        while (true) {
            String winningNumbersInput = getInputString(INPUT_REQUEST_WINNING_NUMBERS.getMessage());
            String[] winningNumbersInputSplits = winningNumbersInput.split(DELIMITER);
            try {
                return getValidatedWinningNumbers(winningNumbersInputSplits);
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }
    }

    private ArrayList<Integer> getValidatedWinningNumbers(String[] winningNumbersInputSplits) {
        validateWinningNumbers(winningNumbersInputSplits);
        return parseIntWinningNumbers(winningNumbersInputSplits);
    }

    private void validateWinningNumbers(String[] winningNumbersInputSplits) {
        Validator.validateWinningNumbersCount(winningNumbersInputSplits);
        Validator.validateNumericStrings(winningNumbersInputSplits);
        ArrayList<Integer> winningNumbers = parseIntWinningNumbers(winningNumbersInputSplits);
        Validator.validateLottoNumbersInRange(winningNumbers);
        Validator.validateUniqueNumbers(winningNumbers);
    }

    private ArrayList<Integer> parseIntWinningNumbers(String[] winningNumbersInputSplits) {
        ArrayList<Integer> winningNumbers = new ArrayList<>();
        for (String winningNumbersInputSplit : winningNumbersInputSplits) {
            winningNumbers.add(Integer.parseInt(winningNumbersInputSplit));
        }
        return winningNumbers;
    }

    private int initBonusNumber(ArrayList<Integer> winningNumbers) {
        while (true) {
            String bonusNumberInput = getInputString(INPUT_REQUEST_BONUS_NUMBER.getMessage());
            try {
                return getValidatedBonusNumber(winningNumbers, bonusNumberInput);
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }
    }

    private int getValidatedBonusNumber(ArrayList<Integer> winningNumbers, String bonusNumberInput) {
        validateBonusNumber(winningNumbers, bonusNumberInput);
        return Integer.parseInt(bonusNumberInput);
    }

    private void validateBonusNumber(ArrayList<Integer> winningNumbers, String bonusNumberInput) {
        Validator.validateNumericString(bonusNumberInput);
        int bonusNumber = Integer.parseInt(bonusNumberInput);
        Validator.validateLottoNumberInRange(bonusNumber);
        Validator.validateNewNumber(winningNumbers, bonusNumber);
    }

    private String getInputString(String message) {
        System.out.println("\n" + message);
        return Console.readLine();
    }

    public ArrayList<Integer> getWinningNumbers() {
        return winningNumbers;
    }

    public int getBonusNumber() {
        return bonusNumber;
    }
}
