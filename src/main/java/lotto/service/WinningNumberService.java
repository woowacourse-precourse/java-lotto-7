package lotto.service;

import lotto.util.NumberUtil;

import java.util.ArrayList;
import java.util.List;

public class WinningNumberService {

    public List<Integer> generateWinningNumbers(String inputWinningNumbers) {
        String[] splitInputs = splitWinningNumbers(inputWinningNumbers);
        return setWinningNumbers(splitInputs);
    }

    private String[] splitWinningNumbers(String inputWinningNumbers) {
        return inputWinningNumbers.split(",");
    }

    private List<Integer> setWinningNumbers(String[] splitInputs) {
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
        int number = NumberUtil.parseLottoNumber(input);
        return number;
    }
}
