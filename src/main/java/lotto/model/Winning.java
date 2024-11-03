package lotto.model;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Winning {
    private List<Integer> winningNumbers;

    public Winning(String inputWinningNumbers) {
        //1~45 숫자 유효성 검사 추가
        validateSplitting(inputWinningNumbers);
        this.winningNumbers = splitWinningNumbers(inputWinningNumbers);
    }

    public List<Integer> getWinningNumbers() {
        return winningNumbers;
    }

    private void validateSplitting(String inputWinningNumbers) {
        //구조 이게 최선인가?
        try {
            this.winningNumbers = splitWinningNumbers(inputWinningNumbers);
        } catch (NumberFormatException e) {
            throw new NumberFormatException("[ERROR] 숫자만 입력하세요.");
        }
    }

    // service로 분리할지 고민해봐
    private List<Integer> splitWinningNumbers(String inputWinningNumbers) {
        List<Integer> winningNumbers = new ArrayList<>();

        for (String winningNumber : inputWinningNumbers.split(",")) {
            winningNumbers.add(Integer.valueOf(winningNumber)); //예외 확인 필요
        }
        Collections.sort(winningNumbers);

        return winningNumbers;
    }

}
