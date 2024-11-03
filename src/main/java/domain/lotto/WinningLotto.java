package domain.lotto;

import domain.lotto.LottoNumber;

import java.util.List;
import java.util.stream.Collectors;

public class WinningLotto {
    private final List<LottoNumber> winningNumbers;
    private final LottoNumber bonusNumber;

    public WinningLotto(List<LottoNumber> winningNumbers, LottoNumber bonusNumber) {
        validate(winningNumbers, bonusNumber);
        this.winningNumbers = winningNumbers.stream().sorted().collect(Collectors.toList());
        this.bonusNumber = bonusNumber;
    }

    private void validate(List<LottoNumber> winningNumbers, LottoNumber bonusNumber) {
        if (winningNumbers.size() != 6) {
            throw new IllegalArgumentException("[ERROR] 당첨 번호는 6개여야 합니다.");
        }
        if (winningNumbers.stream().distinct().count() != 6) {
            throw new IllegalArgumentException("[ERROR] 당첨 번호는 중복될 수 없습니다.");
        }
        if (winningNumbers.contains(bonusNumber)) {
            throw new IllegalArgumentException("[ERROR] 보너스 번호는 당첨 번호와 중복될 수 없습니다.");
        }
    }

    public List<LottoNumber> getWinningNumbers() {
        return winningNumbers;
    }

    public LottoNumber getBonusNumber() {
        return bonusNumber;
    }

    public boolean contains(LottoNumber number) {
        return winningNumbers.contains(number);
    }
}
