package lotto.service;

import lotto.util.NumberUtil;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class WinningNumberService {

    public List<Integer> generateWinningNumbers(String inputWinningNumbers) {
        String[] splitInputs = splitWinningNumbers(inputWinningNumbers);
        return parseWinningNumbers(splitInputs);
    }

    private String[] splitWinningNumbers(String inputWinningNumbers) {
        return inputWinningNumbers.split(",");
    }

    private List<Integer> parseWinningNumbers(String[] splitInputs) {
        List<Integer> winningNumbers = new ArrayList<>();
        for (String splitInput : splitInputs) {
            int winningNumber = parseWinningNumber(splitInput);
            winningNumbers.add(winningNumber);
        }
        if (winningNumbers.size() != 6) {
            throw new IllegalArgumentException("[ERROR] 번호는 6개여야 합니다.");
        }
        return winningNumbers;
    }

    private int parseWinningNumber(String input) {
        input = input.trim();
        int number = NumberUtil.parsePositiveNumber(input);
        validateWinningNumber(number);
        return number;
    }

    private void validateWinningNumber(int number) {
        if (number < 1 || number > 45) {
            throw new IllegalArgumentException("[ERROR] 번호는 1부터 45 사이의 숫자여야 합니다.");
        }
    }
}
