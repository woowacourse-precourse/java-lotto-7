package lotto.errors;

import java.util.List;

public class WinningNumbersErrors {

    public void errorCheck(List<Integer> winningNumbers) {
        validateWinningNumberRange(winningNumbers);
        validateWinningNumberUniqueness(winningNumbers);
        validateNumericWinningNumbers(winningNumbers.toString());
    }

    // 45초과의 값을 입력했을 경우
    public void validateWinningNumberRange(List<Integer> winningNumbers) {

    }
    // 중복된 번호를 입력했을 경우
    public void validateWinningNumberUniqueness(List<Integer> winningNumbers) {

    }
    // 숫자 이외의 값을 입력했을 경우
    public void validateNumericWinningNumbers(String input) {

    }
}
