package lotto.service;

import lotto.domain.BonusNumber;
import lotto.domain.LottoTicket;
import lotto.domain.PurchaseAmount;
import lotto.domain.Result;
import lotto.domain.WinningNumbers;

public class LottoService {
    public PurchaseAmount createPurchaseAmount(String input) {
        return new PurchaseAmount(input);
    }

    public WinningNumbers createWinningNumbers(String input) {
        return new WinningNumbers(input);
    }

    public BonusNumber createBonusNumber(String input, WinningNumbers winningNumbers) {
        return new BonusNumber(input, winningNumbers.getWinningNumbers());
    }

    public LottoTicket generateLottoTickets(int ticketCount) {
        return LottoTicket.from(ticketCount);
    }

    public Result calculateResult(LottoTicket lottoTicket, WinningNumbers winningNumbers, BonusNumber bonusNumber) {
        return Result.from(lottoTicket, winningNumbers, bonusNumber);
    }

    public String calculateYield(PurchaseAmount purchaseAmount, Result result) {
        return purchaseAmount.calculateYield(result.getTotalPrize());
    }
}
