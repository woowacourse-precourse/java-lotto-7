package lotto.domain;

import java.util.List;

public class LottoRaffle {
    private final Lotto winningLotto;
    private final int bonusNumber;

    public LottoRaffle(Lotto winningLotto, int bonusNumber) {
        validate(winningLotto.getNumbers(), bonusNumber);
        this.winningLotto = winningLotto;
        this.bonusNumber = bonusNumber;
    }

    private void validate(List<Integer> numbers, int bonusNumber) {
        numbers.forEach(this::validateLottoNumberRange);
        validateLottoNumberRange(bonusNumber);
    }

    private void validateLottoNumberRange(int number) {
        if (number < 1 || number > 45) {
            throw new IllegalArgumentException("[ ERROR ] 1-45 사이의 값을 입력해주세요. ");
        }
    }
}
