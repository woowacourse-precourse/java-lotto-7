package lotto.service;

import lotto.domain.*;
import lotto.domain.constant.Ranking;
import lotto.domain.lottomachine.AutoNumberGenerator;
import lotto.domain.lottomachine.LottoMachine;

import java.util.EnumMap;
import java.util.Map;

public class LottoService {

    private final LottoMachine lottoMachine;

    public LottoService(LottoMachine lottoMachine) {
        this.lottoMachine = lottoMachine;
    }

    public PurchasedLottos purchaseLottos(Integer purchaseAmount) {
        Money money = Money.from(purchaseAmount);
        LottoStore lottoStore = new LottoStore();

        int quantity = lottoStore.calculateLottoQuantity(money);
        return lottoMachine.issueTickets(new AutoNumberGenerator(), quantity);
    }

    public EnumMap<Ranking, Integer> drawResult(PurchasedLottos purchasedLottos, WinningNumbers winningNumbers) {
        return lottoMachine.draw(purchasedLottos, winningNumbers);
    }

    public double calculateEarningRate(PurchasedLottos purchasedLottos, EnumMap<Ranking, Integer> statistics) {
        Money totalPrize = Money.ZERO;
        for (Map.Entry<Ranking, Integer> rank : statistics.entrySet()) {
            int amount = rank.getKey().getPrize() * rank.getValue();
            Money prize = Money.from(amount);
            totalPrize = totalPrize.plus(prize);
        }
        Money purchasedAmount = Money.from(purchasedLottos.getLottos().size() * 1000);
        Money divide = totalPrize.divideWithRoundHalfUp(purchasedAmount);
        return divide.doubleValue() * 100;
    }
}
