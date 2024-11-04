package lotto.model.domain;

public class BonusNumber {

    private final LottoNumber bonusNumber;

    public LottoNumber getBonusNumber() {
        return bonusNumber;
    }

    public BonusNumber(String number) {
        bonusNumber = new LottoNumber(number);
    }
}
