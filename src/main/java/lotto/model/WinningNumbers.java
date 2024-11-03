package lotto.model;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class WinningNumbers {
    private List<Integer> winningNumbers;

    public WinningNumbers(String inputWinningNumbers) {
        validateSplitting(inputWinningNumbers);
        this.winningNumbers = splitWinningNumbers(inputWinningNumbers);
    }

    private void validateSplitting(String inputWinningNumbers) {
        try {
            this.winningNumbers = splitWinningNumbers(inputWinningNumbers);
        } catch (NumberFormatException e) {
            throw new NumberFormatException("[ERROR] 숫자만 입력하세요.");
        }
    }

    private List<Integer> splitWinningNumbers(String inputWinningNumbers) {
        List<Integer> winningNumbers = new ArrayList<>();

        for (String winningNumber : inputWinningNumbers.split(",")) {
            winningNumbers.add(Integer.valueOf(winningNumber)); //예외 확인 필요
        }
        Collections.sort(winningNumbers);

        return winningNumbers;
    }

}
