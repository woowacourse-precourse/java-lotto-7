package lotto.util.calculator;

import lotto.domain.Lotto;

public class LottoMatchingCountCalculator {

    public int countMatchingNumbers(Lotto lotto1, Lotto lotto2) {
        return (int) lotto1.getNumbers().stream()
                .filter(lotto2::contains)
                .count();
    }

    public boolean isMatchingNumber(int lottoNumber, Lotto lotto) {
        return lotto.getNumbers().stream()
                .anyMatch(number -> number == lottoNumber);
    }
}
