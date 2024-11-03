package lotto.domain;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class WinningLotto {
    private static final int MIN_NUMBER = 1;
    private static final int MAX_NUMBER = 45;
    private static final int WINNING_LOTTO_SIZE = 7;
    private final Lotto winningLotto;
    private final Integer bonusNumber;

    public WinningLotto(List<Integer> winningLotto, Integer bonusNumber) {
        this.winningLotto = new Lotto(winningLotto);

        validate(winningLotto, bonusNumber);
        this.bonusNumber = bonusNumber;
    }

    private void validate(List<Integer> winningLotto, Integer bonusNumber) {
        validateNumberRange(bonusNumber);
        validateDuplicate(winningLotto, bonusNumber);
    }

    private void validateDuplicate(List<Integer> winningLotto, Integer bonusNumber) {
        Set<Integer> uniqueNumbers = new HashSet<>(winningLotto);
        uniqueNumbers.add(bonusNumber);
        if (uniqueNumbers.size() != WINNING_LOTTO_SIZE) {
            throw new IllegalArgumentException("[ERROR] 로또 번호는 중복되지 않아야 합니다.");
        }
    }

    private void validateNumberRange(Integer bonusNumber) {
        if (bonusNumber < MIN_NUMBER || bonusNumber > MAX_NUMBER) {
                throw new IllegalArgumentException("[ERROR] 보너스 번호는 1부터 45 사이의 숫자여야 합니다.");
        }
    }

    public int getBonusNumber() {
        return bonusNumber;
    }

    public boolean isContain(int number) {
        return winningLotto.isContain(number);
    }

}
