package lotto.model.domain;

import lotto.dto.LottoWinningNumbersDto;

import static lotto.Constants.MAXIMUM_LOTTO_NUMBER;
import static lotto.Constants.MINIMUM_LOTTO_NUMBER;

public class LottoWinningNumbers {
    private final Lotto winningNumbers;
    private final int bonusNumber;

    public LottoWinningNumbers(LottoWinningNumbersDto dto) {
        this.winningNumbers = new Lotto(dto.winningNumbers().numbers());
        this.bonusNumber = dto.bonusNumber();
        validateBonusNumber();
    }

    private void validateBonusNumber() {
        if (bonusNumber < MINIMUM_LOTTO_NUMBER || bonusNumber > MAXIMUM_LOTTO_NUMBER) {
            throw new IllegalArgumentException("[ERROR] 보너스 번호는 " + MINIMUM_LOTTO_NUMBER + "부터 " + MAXIMUM_LOTTO_NUMBER + " 사이여야 합니다.");
        }
        if (containsNumber(bonusNumber)) {
            throw new IllegalArgumentException("[ERROR] 보너스 번호는 당첨 번호와 중복될 수 없습니다.");
        }
    }

    private boolean containsNumber(int number) {
        return winningNumbers.getNumbers().contains(number);
    }

    public Lotto getWinningNumbers() {
        return winningNumbers;
    }

    public int getBonusNumber() {
        return bonusNumber;
    }
}