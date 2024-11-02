package lotto.domain;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class WinningLotto {
    private final Lotto winningLotto;
    private final Integer bonusNumber;

    public WinningLotto(List<Integer> winningNumber, Integer bonusNumber) {
        this.winningLotto = new Lotto(winningNumber);
        validateDuplicate(winningNumber, bonusNumber);
        validateBonusNumberInRange(bonusNumber);
        this.bonusNumber = bonusNumber;
    }

    private void validateBonusNumberInRange(Integer bonusNumber) {
        if (bonusNumber <= 0 || bonusNumber > 45) {
            throw new IllegalArgumentException("[ERROR] 보너스 번호는 1~45 사이의 정수여야 합니다.");
        }
    }

    private void validateDuplicate(List<Integer> winningNumber, Integer bonusNumber) {
        Set<Integer> lottoNumbers = new HashSet<>(winningNumber);
        lottoNumbers.add(bonusNumber);
        if (lottoNumbers.size() != 7) {
            throw new IllegalArgumentException("[ERROR] 보너스 번호가 당첨 번호와 중복됩니다");
        }
    }
}
