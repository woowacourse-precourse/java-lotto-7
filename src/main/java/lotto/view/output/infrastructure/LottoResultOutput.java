package lotto.view.output.infrastructure;

import lotto.money.domain.Money;
import lotto.money.domain.Benefit;
import lotto.lotto.domain.BonusNumber;
import lotto.lotto.domain.LottoTickets;
import lotto.lotto.domain.WinningLotto;
import lotto.lotto.domain.WinningPlace;
import lotto.view.output.service.ResultViewService;

public class CommonResultOutput implements ResultViewService {
    @Override
    public void viewByInsertMoney(Money money) {
        System.out.println(money);
        nextLine();
    }

    @Override
    public void viewByLottoTickets(LottoTickets lottoTickets) {
        System.out.println(lottoTickets);
    }

    @Override
    public void viewByWinningLotto(WinningLotto winningLotto) {
        System.out.println(winningLotto);
        nextLine();
    }

    @Override
    public void viewByBonusNumber(BonusNumber bonusNumber) {
        System.out.println(bonusNumber);
        nextLine();
    }

    @Override
    public void viewByWinningStatistic(Benefit benefit, Money purchaseMoney) {
        System.out.println("당첨 통계\n" + "---");
        System.out.print(WinningPlace.print());
        System.out.printf("총 수익률은 %s%%입니다.", benefit.getDecimalFormatByRateOfReturn(purchaseMoney));
    }

    private void nextLine() {
        System.out.println();
    }
}
