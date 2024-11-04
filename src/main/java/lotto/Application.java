package lotto;

import java.util.List;
import java.util.Map;

public class Application {

    public static void main(String[] args) {
        ConsoleHandler consoleHandler = new ConsoleHandler();
        int money = consoleHandler.inputMoney();

        Customer customer = new Customer(money);

        LottoStore lottoStore = new LottoStore();
        customer.purchaseLottoFrom(lottoStore);

        List<Lotto> purchasedLotto = customer.getLottos();
        consoleHandler.printLottoCount(purchasedLotto.size());
        consoleHandler.printPurchasedLotto(purchasedLotto);

        List<Integer> winningLottoNumbers = consoleHandler.inputWinningLottoNumbers();
        int bonusNumber = consoleHandler.inputWinningLottoBonusNumber();
        WinningLotto winningLotto = new WinningLotto(winningLottoNumbers, bonusNumber);

        WinningCalculator winningCalculator = new WinningCalculator();

        Map<LottoRank, Integer> winningCountsByRank = winningCalculator.calculateWinningCountsByRank(lottoStore, winningLotto, customer);
        consoleHandler.printWinningResult(winningCountsByRank, lottoStore.getRankInfo());

        double profitRate = winningCalculator.calculateProfitRate(lottoStore, winningCountsByRank, money);
        consoleHandler.printProfitRate(profitRate);
    }

}
