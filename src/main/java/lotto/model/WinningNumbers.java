package lotto.model;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class WinningNumbers {
    private List<Integer> winningNumbers;
    private int bonusNumber;

    public WinningNumbers(String winningNumbersInput, String bonusNumberInput) {
        this.winningNumbers = parseStringToIntegerList(winningNumbersInput);
        this.bonusNumber = parseStringToInt(bonusNumberInput);
    }

    private List<Integer> parseStringToIntegerList(String winningNumbers) {
        return Arrays.stream(winningNumbers.split(","))
                .map(Integer::parseInt)
                .collect(Collectors.toList());

        // 중복으로 들어가는 숫자 예외 처리
    }

    private int parseStringToInt(String bonusNumberInput){
        return Integer.parseInt(bonusNumberInput);
    }

    public List<Integer> getWinningNumbers() {
        return winningNumbers;
    }

    public int getBonusNumber() {
        return bonusNumber;
    }
}

