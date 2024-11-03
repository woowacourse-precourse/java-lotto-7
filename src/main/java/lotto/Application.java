package lotto;

import java.util.List;
import lotto.customer.LottoCustomer;
import lotto.item.Lotto;
import lotto.item.WinningLotto;
import lotto.shop.LottoShop;

public class Application {
    public static void main(String[] args) {
        LottoReader lottoReader = new LottoReader();
        LottoCustomer lottoCustomer = new LottoCustomer();

        int money = lottoReader.readMoney();
        money = money - money % LottoShop.LOTTO_PRICE;
        List<Lotto> lottoTickets = lottoCustomer.buy(Lotto.class, money);

        List<Integer> winningLottoNumbers = lottoReader.readLottoNumbers();
        int bonusNumber = lottoReader.readBonusNumber(winningLottoNumbers);
        WinningLotto winningLotto = lottoCustomer.setWinningLotto(winningLottoNumbers, bonusNumber);

        lottoCustomer.showStatistics(lottoTickets, winningLotto);

        long totalLottoPrize = lottoCustomer.getTotalLottoPrize(lottoTickets, winningLotto);
        lottoCustomer.viewTotalProfit(money, totalLottoPrize);

    }
}
