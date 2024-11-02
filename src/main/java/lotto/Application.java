package lotto;

import java.util.List;
import lotto.customer.LottoCustomer;
import lotto.item.Lotto;
import lotto.item.WinningLotto;

public class Application {
    public static void main(String[] args) {
        // TODO: 프로그램 구현
        Reader reader = new Reader();
        LottoCustomer lottoCustomer = new LottoCustomer();

        int money = reader.readMoney();
        List<Lotto> lottoTickets = lottoCustomer.buy(Lotto.class, money);

        List<Integer> winningLottoNumbers = reader.readLottoNumbers();
        int bonusNumber = reader.readBonusNumber(winningLottoNumbers);
        WinningLotto winningLotto = lottoCustomer.setWinningLotto(winningLottoNumbers, bonusNumber);

        lottoCustomer.showStatistics(lottoTickets, winningLotto);

        long totalLottoPrize = lottoCustomer.getTotalLottoPrize(lottoTickets, winningLotto);
        lottoCustomer.viewExpenditureSummary(money, totalLottoPrize);

    }
}
