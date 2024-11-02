package lotto.service;

import lotto.domain.*;
import lotto.domain.constant.Ranking;
import lotto.domain.lottomachine.AutoNumberGenerator;
import lotto.domain.lottomachine.LottoMachine;
import lotto.dto.response.LottosResponse;

import java.util.EnumMap;
import java.util.List;

public class LottoService {

    private final LottoMachine lottoMachine;
    private PurchasedLottos purchasedLottos;

    public LottoService(LottoMachine lottoMachine) {
        this.lottoMachine = lottoMachine;
    }

    public LottosResponse purchaseLottos(Integer purchaseAmount) {
        Money money = Money.from(purchaseAmount);
        LottoStore lottoStore = new LottoStore();

        int quantity = lottoStore.calculateLottoQuantity(money);
        this.purchasedLottos = lottoMachine.issueTickets(new AutoNumberGenerator(), quantity);

        return LottosResponse.of(
                quantity,
                purchasedLottos
        );
    }

    public EnumMap<Ranking, Integer> drawResult(List<Integer> winningNumber, Integer bonusNumber) {
        WinningNumbers winningNumbers = WinningNumbers.from(winningNumber, bonusNumber);
        return lottoMachine.draw(purchasedLottos, winningNumbers);
    }
}
