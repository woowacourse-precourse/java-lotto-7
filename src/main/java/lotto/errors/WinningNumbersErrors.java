package lotto.errors;

import lotto.model.Lotto;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class WinningNumbersErrors {

    public void errorCheck(List<Integer> winningNumbers) {
        validateWinningNumberSize(winningNumbers);
        validateWinningNumberRange(winningNumbers);
        validateWinningNumberUniqueness(winningNumbers);
    }

    // 번호를 6개 입력하지 않았을 때
    public void validateWinningNumberSize(List<Integer> winningNumbers) {
        try {
            Lotto lotto = new Lotto(winningNumbers);
        } catch (IllegalArgumentException e) {
            throw new IllegalArgumentException("[ERROR] 로또 번호는 6개여야 합니다.");
        }
    }

    // 45초과의 값을 입력했을 경우
    public void validateWinningNumberRange(List<Integer> winningNumbers) {
        for (Integer number : winningNumbers) {
            if (number < 1 || number > 45) {
                throw new IllegalArgumentException("[ERROR] 로또 번호는 1부터 45 사이의 숫자여야 합니다.");
            }
        }
    }

    // 중복된 번호를 입력했을 경우
    public void validateWinningNumberUniqueness(List<Integer> winningNumbers) {
        Set<Integer> uniqueNumbers = new HashSet<>(winningNumbers);
        if (uniqueNumbers.size() != winningNumbers.size()) {
            throw new IllegalArgumentException("[ERROR] 로또 번호는 중복될 수 없습니다.");
        }
    }
}
