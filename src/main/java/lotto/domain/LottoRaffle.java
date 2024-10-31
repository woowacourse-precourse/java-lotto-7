package lotto.domain;

import java.util.List;

public class LottoRaffle {
    private final Lotto winningLotto;
    private final int bonusNumber;

    public LottoRaffle(Lotto winningLotto, int bonusNumber) {
        validate(winningLotto.getNumbers(), bonusNumber);
        this.winningLotto = winningLotto;
        this.bonusNumber = bonusNumber;
        validateDuplicateWithLottoNumber(bonusNumber);
    }

    public List<Integer> getWinningNumbers() {
        return winningLotto.getNumbers();
    }

    private void validateDuplicateWithLottoNumber(int bonusNumber) {
        boolean isDuplicate = getWinningNumbers().stream().anyMatch(i -> i == bonusNumber);
        if (isDuplicate) {
            throw new IllegalArgumentException("[ ERROR ]당첨번호와 중복되지 않는 번호를 입력해주세요.");
        }
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
