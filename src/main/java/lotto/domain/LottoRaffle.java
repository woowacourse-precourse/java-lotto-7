package lotto.domain;

import java.util.List;

public class LottoRaffle {
    private final Lotto winningLotto;
    private final int bonusNumber;

    public LottoRaffle(Lotto winningLotto, int bonusNumber) {
        this.winningLotto = winningLotto;
        validateBonusNumber(bonusNumber);
        this.bonusNumber = bonusNumber;
    }

    public int getBonusNumber() {
        return bonusNumber;
    }

    public List<Integer> getWinningNumbers() {
        return winningLotto.getNumbers();
    }

    public void validateBonusNumber(int bonusNumber) {
        validateLottoNumberRange(bonusNumber);
        validateDuplicateWithLottoNumber(bonusNumber);
    }

    private void validateDuplicateWithLottoNumber(int bonusNumber) {
        boolean isDuplicate = getWinningNumbers().stream().anyMatch(i -> i == bonusNumber);
        if (isDuplicate) {
            throw new IllegalArgumentException("[ERROR]당첨번호와 중복되지 않는 번호를 입력해주세요.");
        }
    }

    private void validateLottoNumberRange(int number) {
        if (number < 1 || number > 45) {
            throw new IllegalArgumentException("[ERROR] 1-45 사이의 값을 입력해주세요. ");
        }
    }
}
