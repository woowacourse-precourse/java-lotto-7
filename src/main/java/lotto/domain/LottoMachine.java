package lotto.domain;

import java.util.List;

public class LottoMachine {
    private static final LottoMachine instance = new LottoMachine();
    private Lotto winningLotto;
    private int purchaseAmount;
    private int bonusNumber;

    private LottoMachine() {

    }

    public static LottoMachine getInstance() {
        return instance;
    }

    public void saveWinningNumbers(List<Integer> numbers) {
        winningLotto = new Lotto(numbers);
    }

    public void savePurchaseAmount(int purchaseAmount) {
        this.purchaseAmount = purchaseAmount;
    }

    public void saveBonusNumber(int bonusNumber) {
        this.bonusNumber = bonusNumber;
    }

    public Lotto getWinningLotto() {
        return winningLotto;
    }

    public int getBonusNumber() {
        return bonusNumber;
    }

    public int getPurchaseAmount() {
        return purchaseAmount;
    }
}
