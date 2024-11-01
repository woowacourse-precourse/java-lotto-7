package lotto.domain;

import java.util.List;

public class Answer {
    private final LottoNumbers lottoNumbers;
    private final LottoNumber bonusNumber;

    Answer(List<Integer> numbers, int bonus) {
        LottoNumbers lottoNumbers = new LottoNumbers(numbers);
        LottoNumber bonusNumber = new LottoNumber(bonus);
        validate(lottoNumbers, bonusNumber);
        this.lottoNumbers = lottoNumbers;
        this.bonusNumber = bonusNumber;
    }

    LottoResult getResult(List<Lotto> lottos) {
        List<LottoPrize> prizes = lottos.stream().map(this::match).toList();
        return new LottoResult(prizes);
    }

    LottoPrize match(Lotto lotto) {
        int matches = lotto.getFilteredCount(this.lottoNumbers::contains);
        int bonus = lotto.getFilteredCount(bonusNumber::equals);
        return LottoPrize.getPrize(matches, bonus);
    }

    private void validate(LottoNumbers lottoNumbers, LottoNumber bonusNumber) {
        if (lottoNumbers.contains(bonusNumber)) {
            throw new IllegalArgumentException("[ERROR] 보너스 번호는 정답 번호와 중복될 수 없습니다.");
        }
    }
}
