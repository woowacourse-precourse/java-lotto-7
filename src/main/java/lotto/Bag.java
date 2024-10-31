package lotto;

import java.util.ArrayList;
import java.util.List;

import static lotto.Validator.*;

public class Bag {
    private final int purchaseAmount;
    private int numberOfLottoTickets;
    private final List<Lotto> purchasedLotto;

    public Bag(int purchaseAmount) {
        validatePositiveNumber(purchaseAmount);
        this.purchaseAmount = purchaseAmount;
        purchasedLotto = new ArrayList<>();
    }

    public void buyLotto(Lotto lotto) {
        purchasedLotto.add(lotto);
        numberOfLottoTickets++;
    }

    public int getPurchaseAmount() {
        return purchaseAmount;
    }

    public List<Lotto> getPurchasedLotto() {
        validateNumberOfLottoTickets();
        return purchasedLotto;
    }
    public int getNumberOfLottoTickets() {
        validateNumberOfLottoTickets();
        return numberOfLottoTickets;
    }
    private void validateNumberOfLottoTickets() {
        if(numberOfLottoTickets !=purchasedLotto.size()) {
            throw new RuntimeException("[ERROR] 구매횟수와 저장된 로또 리스트의 크기가 상이합니다.");
        }
    }
}
