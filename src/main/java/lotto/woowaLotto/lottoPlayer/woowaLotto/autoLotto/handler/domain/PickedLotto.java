package lotto.woowaLotto.lottoPlayer.woowaLotto.autoLotto.handler.domain;

public class PickedLotto {

    private final Lotto pickedLotto;
    private final int bonusNumber;

    public PickedLotto(Lotto pickedLotto, int bonusNumber) {
        this.pickedLotto = pickedLotto;
        this.bonusNumber = bonusNumber;
    }

    public Lotto getPickedLotto() {
        return pickedLotto;
    }

    public int getBonusNumber() {
        return bonusNumber;
    }
}