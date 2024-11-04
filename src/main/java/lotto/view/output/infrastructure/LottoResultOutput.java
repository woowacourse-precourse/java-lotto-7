package lotto.view.output.infrastructure;

import lotto.money.domain.Money;
import lotto.money.domain.Benefit;
import lotto.lotto.domain.BonusNumber;
import lotto.lotto.domain.LottoTickets;
import lotto.lotto.domain.WinningLotto;
import lotto.money.domain.WinningPlace;
import lotto.view.output.domain.Message;
import lotto.view.output.domain.ResultMessage;
import lotto.view.output.service.ResultViewService;

public class LottoResultOutput implements ResultViewService {
    @Override
    public void viewByInsertMoney(Money money) {
        ResultMessage.INSERT_MONEY.print(money);
        nextLine();
    }

    @Override
    public void viewByLottoTickets(LottoTickets lottoTickets) {
        ResultMessage.PURCHASE_TICKETS_INFO.print(lottoTickets);
    }

    @Override
    public void viewByWinningLotto(WinningLotto winningLotto) {
        ResultMessage.WINNING_LOTTO.print(winningLotto);
        nextLine();
    }

    @Override
    public void viewByBonusNumber(BonusNumber bonusNumber) {
        ResultMessage.BONUS_NUMBER.print(bonusNumber);
        nextLine();
    }

    @Override
    public void viewByWinningStatistic(Benefit benefit, Money purchaseMoney) {
        Message.WINNING_STATISTICS_HEADER.print();
        ResultMessage.WINNING_PLACE_INFO.print(WinningPlace.print());
        ResultMessage.TOTAL_PROFIT_RATE.print(benefit.getDecimalFormatByRateOfReturn(purchaseMoney));
    }

    private void nextLine() {
        System.out.println();
    }
}
