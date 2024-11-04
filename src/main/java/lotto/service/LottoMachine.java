package lotto.service;

import static lotto.input.Input.getBonusNumber;
import static lotto.input.Input.getPurchaseAmount;
import static lotto.input.Input.getWinningNumbers;

import java.util.List;
import lotto.domain.Lotto;
import lotto.domain.LottoNumbers;
import lotto.domain.LottoTicket;
import lotto.domain.PurchaseAmount;

public class LottoMachine {
    public static final int PRICE_OF_ONE_LOTTERY_TICKET = 1000;

    public LottoTicket generateLottoTicket(PurchaseAmount purchaseAmount) {
        int lottoCount = calculateLottoCount(purchaseAmount);
        List<Lotto> lottos = LottoGenerator.generateLottos(lottoCount);
        return new LottoTicket(lottos);
    }

    private int calculateLottoCount(PurchaseAmount purchaseAmount) {
        return purchaseAmount.getAmount() / PRICE_OF_ONE_LOTTERY_TICKET;
    }

    public void run() {
        try {
            PurchaseAmount purchaseAmount = new PurchaseAmount(getPurchaseAmount());

            LottoTicket lottoTicket = generateLottoTicket(purchaseAmount);
            lottoTicket.showLottoTicket();

            LottoNumbers lottoNumbers = new LottoNumbers(getWinningNumbers(), getBonusNumber());

            LottoResult lottoResult = new LottoResult();
            lottoResult.evaluateLottoResults(lottoTicket, lottoNumbers);
            lottoResult.displayWinningStatistics();

            lottoResult.displayRateOfReturn(lottoResult.calculateRateOfReturn(purchaseAmount));
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
        }
    }
}
