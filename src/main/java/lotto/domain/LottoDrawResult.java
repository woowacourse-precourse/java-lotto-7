package lotto.domain;


import java.util.stream.Collectors;

public class LottoDrawResult {

    private final Lotto drewLotto;
    private final Integer bonusNumber;

    public LottoDrawResult(Lotto drewLotto, int bonusNumber) {
        validate(drewLotto, bonusNumber);
        this.drewLotto = drewLotto;
        this.bonusNumber = bonusNumber;
    }

    public Lotto getDrewLotto() {
        return drewLotto;
    }

    public Integer getBonusNumber() {
        return bonusNumber;
    }

    private void validate(Lotto drewLotto, int bonusNumber) {
        if (drewLotto.getNumbers().contains(bonusNumber)) {
            throw new IllegalArgumentException("[ERROR] 보너스 번호가 당첨 번호와 중복되었습니다");
        }

    }

}