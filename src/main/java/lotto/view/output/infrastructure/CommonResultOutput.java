package lotto.view.output.infra;

import lotto.buyer.domain.Money;
import lotto.lotto.winning.domain.Benefit;
import lotto.lotto.winning.domain.BonusNumber;
import lotto.lotto.domain.LottoTickets;
import lotto.lotto.winning.domain.WinningLotto;
import lotto.lotto.winning.domain.WinningPlace;
import lotto.view.output.domain.ResultViewService;

public class CommonResultOutput implements ResultViewService {
    public void viewByInsertMoney(Money money) {
        System.out.println(money);
        nextLine();
    }

    public void viewByLottoTickets(LottoTickets lottoTickets) {
        System.out.println(lottoTickets);
    }

    public void viewByWinningLotto(WinningLotto winningLotto) {
        System.out.println(winningLotto);
        nextLine();
    }

    public void viewByBonusLotto(BonusNumber bonusLotto) {
        System.out.println(bonusLotto);
        nextLine();
    }

    public void viewByWinningStatistic(Benefit benefit, Money purchaseMoney) {
        System.out.println("당첨 통계\n" + "---");
        System.out.print(WinningPlace.print());
        System.out.printf("총 수익률은 %.1f%%입니다.", benefit.getRateOfReturn(purchaseMoney));
    }

    private void nextLine() {
        System.out.println();
    }
}
