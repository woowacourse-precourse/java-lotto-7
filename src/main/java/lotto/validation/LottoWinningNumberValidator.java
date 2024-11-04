package lotto.validation;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class LottoWinningNumberValidator {
    int MAX_SIZE_OF_LOTTO = 6;

    public void validateLengthWinningNumber(List<Integer> lottoWinningNumbers) {
        if (lottoWinningNumbers.size() != MAX_SIZE_OF_LOTTO) {
            throw new IllegalArgumentException("[Error] 당첨 번호는 6개의 숫자로 이루어져야 합니다.");
        }
    }

    public void validateDuplicationWinningNumber(List<Integer> lottoWinningNumbers) {
        Set<Integer> uniqueNumbers = new HashSet<>(lottoWinningNumbers);
        if (uniqueNumbers.size() != lottoWinningNumbers.size()) {
            throw new IllegalArgumentException("[Error] 당첨 번호는 중복될 수 없습니다.");
        }
    }

    public void validateWinningNumber(List<Integer> lottoWinningNumbers) {
        for (int lottoWinningNumber : lottoWinningNumbers) {
            if (lottoWinningNumber < 1 || lottoWinningNumber > 45) {
                throw new IllegalArgumentException("[Error] 당첨 번호는 1부터 45 사이의 숫자여야 합니다.");
            }
        }
    }
}
