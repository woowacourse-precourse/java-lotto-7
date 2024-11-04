package lotto.model.domain;

public class BonusNumber {

    private final LottoNumber bonusNumber;

    public BonusNumber(String number) {
        bonusNumber = new LottoNumber(number);
    }

    public LottoNumber getBonusNumber() {
        return bonusNumber;
    }
}
