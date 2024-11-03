package lotto.domain;

import java.util.List;
import lotto.domain.exception.InvalidBonusNumberException;

public class Answer {
    private Lotto lottoNumbers;
    private LottoNumber bonusNumber;

    public Answer() {
    }

    public Answer(List<Integer> numbers, int bonus) {
        setNumbers(numbers);
        setBonusNumber(bonus);
    }

    public void setNumbers(List<Integer> numbers) {
        this.lottoNumbers = new Lotto(numbers);
    }

    public void setBonusNumber(int bonus) {
        validate(this.lottoNumbers.getNumbers(), bonus);
        this.bonusNumber = new LottoNumber(bonus);
    }

    public WinningResult getResult(List<Lotto> lottos) {
        List<WinningPrize> prizes = lottos.stream().map(this::match).toList();
        return new WinningResult(prizes);
    }

    WinningPrize match(Lotto lotto) {
        int matches = lotto.getFilteredCount(this.lottoNumbers::contains);
        int bonus = lotto.getFilteredCount(bonusNumber::equals);
        return WinningPrize.getPrize(matches, bonus);
    }

    private void validate(List<Integer> numbers, int bonus) {
        if (numbers.contains(bonus)) {
            throw new InvalidBonusNumberException("보너스 번호는 정답 번호와 중복될 수 없습니다.");
        }
    }
}
