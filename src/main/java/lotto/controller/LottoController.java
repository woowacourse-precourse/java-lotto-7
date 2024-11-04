package lotto.controller;

import lotto.model.Lotto;
import lotto.model.LottoDomain;
import lotto.model.LottoService;
import lotto.status.LottoConstants;
import lotto.validator.Amount;
import lotto.validator.BonusNumber;
import lotto.validator.LuckyNumbers;
import lotto.view.Output;

import java.util.List;

public class LottoController {
    LottoService lottoService;
    List<Lotto> lottoTickets;
    private List<Integer> luckyNumbers;
    private int bonusNumber;
    private int amount;

    public LottoController(LottoService lottoService) {
        this.lottoService = lottoService;
    }

    public void run() {
        lottoTickets = purchaseLotto();
        Output.printLottoTickets(lottoTickets);

        inputValidate();

        new Output(ticketRank(), profitRate());
    }


    private double profitRate() {
        return lottoService.calculateProfitRate(sumPrize(), amount);
    }

    private long sumPrize() {
        return lottoService.sumPrize(ticketRank());
    }

    private int[] ticketRank() {
        return lottoService.calculateTicketRank(lottoTickets, luckyNumbers, bonusNumber);
    }

    private List<Lotto> purchaseLotto() {
        amount = new Amount().processSetAmount().getAmount();
        LottoDomain lotto = new LottoDomain();

        return lotto.createLottoBundle(amount / LottoConstants.LOTTO_UNIT_PRICE);
    }

    private void inputValidate() {
        luckyNumbers = new LuckyNumbers().processSetWinningNumbers().getLuckyNumbers();
        bonusNumber = new BonusNumber(luckyNumbers).processSetBonusNumber().getBonusNumber();
    }

}
