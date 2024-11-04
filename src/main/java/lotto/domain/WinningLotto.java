package lotto.domain;

public class WinningLotto {
    private final Lotto lotto;
    private final LottoNumber bonusNumber;

    public WinningLotto(Lotto lotto, LottoNumber bonusNumber) {
        validate();
        this.lotto = lotto;
        this.bonusNumber = bonusNumber;
    }

    public void validate() {
        validateUnique();
    }

    public void validateUnique() {
        if (lotto.contains(bonusNumber)) {
            throw new IllegalArgumentException("[ERROR] 당첨 번호와 보너스 번호는 중복될 수 없습니다.");
        }
    }
}
