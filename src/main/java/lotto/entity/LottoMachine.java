package lotto.entity;

import java.util.ArrayList;
import java.util.List;

public class LottoMachine {
    private final Purchase purchase;
    private final WinningNumbers winningNumbers;
    private final List<Lotto> purchasedLottos;

    public LottoMachine(int paymentAmount, List<Integer> winningMainNumbers, int winningBonusNumber) {
        this.purchase = new Purchase(paymentAmount);
        this.winningNumbers = new WinningNumbers(winningMainNumbers, winningBonusNumber);
        this.purchasedLottos = createLottos();
    }

    public int getPurchaseCount() {
        return purchase.calculateTicketCount();
    }

    public int getPurchasedAmount() {
        return purchase.getPaymentAmount();
    }

    public List<Lotto> getPurchasedLottos() {
        return purchasedLottos;
    }

    public WinningNumbers getWinningNumbers() {
        return winningNumbers;
    }

    private List<Lotto> createLottos() {
        List<Lotto> lottos = new ArrayList<>();
        for (int i = 0; i < purchase.calculateTicketCount(); i++) {
            lottos.add(Lotto.createRandomLotto());
        }
        return lottos;
    }

}
