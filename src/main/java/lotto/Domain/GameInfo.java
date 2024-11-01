package lotto.Domain;

import java.util.ArrayList;
import lotto.Constants.Error;
import lotto.Lotto;

public class GameInfo {
    public static final int LOTTO_PRICE = 1000;
    private final int purchaseAmount;
    private Lotto winningLotto;
    private ArrayList<Lotto> purchasedLottos = new ArrayList<>();
    private int remainingAmount;
    private int bonusNumber;

    public GameInfo(int purchaseAmount) {
        this.purchaseAmount = purchaseAmount;
        this.remainingAmount = purchaseAmount / 1000;
    }

    public static void validatePurchaseAmount(int amount) {
        if (amount < LOTTO_PRICE) {
            throw new IllegalArgumentException(lotto.Constants.Error.PURCHASE_AMOUNT_LT_MINIMUM.getText());
        }
        if (amount % LOTTO_PRICE != 0) {
            throw new IllegalArgumentException(Error.PURCHASE_AMOUNT_NOT_MULTIPLE_OF_1000.getText());
        }
    }

    public void addPurchasedLotto(Lotto lotto) {
        purchasedLottos.add(lotto);
    }

    public void setWinningLotto(Lotto winningLotto) {
        this.winningLotto = winningLotto;
    }

    public void setBonusNumber(int bonusNumber) {
        this.bonusNumber = bonusNumber;
    }

    public int getPurchaseAmount() {
        return purchaseAmount;
    }

    public int getBonusNumber() {
        return bonusNumber;
    }

    public Lotto getWinningLotto() {
        return winningLotto;
    }

    public ArrayList<Lotto> getPurchasedLottos() {
        return purchasedLottos;
    }

}
