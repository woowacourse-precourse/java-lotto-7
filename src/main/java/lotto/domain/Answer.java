package lotto.domain;

import java.util.List;

public class Answer {
    private final Lotto lottoNumbers;
    private final LottoNumber bonusNumber;

    public Answer(List<Integer> numbers, int bonus) {
        Lotto lottoNumbers = new Lotto(numbers);
        LottoNumber bonusNumber = new LottoNumber(bonus);
        validate(lottoNumbers, bonusNumber);
        this.lottoNumbers = lottoNumbers;
        this.bonusNumber = bonusNumber;
    }

    public LottoResult getResult(List<Lotto> lottos) {
        List<LottoPrize> prizes = lottos.stream().map(this::match).toList();
        return new LottoResult(prizes);
    }

    LottoPrize match(Lotto lotto) {
        int matches = lotto.getFilteredCount(this.lottoNumbers::contains);
        int bonus = lotto.getFilteredCount(bonusNumber::equals);
        return LottoPrize.getPrize(matches, bonus);
    }

    private void validate(Lotto lottoNumbers, LottoNumber bonusNumber) {
        if (lottoNumbers.contains(bonusNumber)) {
            throw new IllegalArgumentException("[ERROR] 보너스 번호는 정답 번호와 중복될 수 없습니다.");
        }
    }
}
