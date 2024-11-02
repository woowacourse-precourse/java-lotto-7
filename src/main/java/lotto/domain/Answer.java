package lotto.domain;

import java.util.List;
import lotto.domain.exception.InvalidBonusNumberException;

public class Answer {
    private final Lotto lottoNumbers;
    private final LottoNumber bonusNumber;

    public Answer(List<Integer> numbers, int bonus) {
        validate(numbers, bonus);
        this.lottoNumbers = new Lotto(numbers);
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
