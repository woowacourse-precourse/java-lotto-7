package lotto.domain;

public class Answer {
    private final LottoNumbers lottoNumbers;
    private final LottoNumber bonusNumber;

    Answer(LottoNumbers lottoNumbers, LottoNumber bonusNumber) {
        validate(lottoNumbers, bonusNumber);
        this.lottoNumbers = lottoNumbers;
        this.bonusNumber = bonusNumber;
    }

    int getMatches(Lotto lotto) {
        return lotto.getFilteredCount(this.lottoNumbers::contains);
    }

    int getBonus(Lotto lotto) {
        return lotto.getFilteredCount(bonusNumber::equals);
    }

    private void validate(LottoNumbers lottoNumbers, LottoNumber bonusNumber) {
        if (lottoNumbers.contains(bonusNumber)) {
            throw new IllegalArgumentException("[ERROR] 보너스 번호는 정답 번호와 중복될 수 없습니다.");
        }
    }
}
