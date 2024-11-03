package lotto.controller;

import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;
import lotto.domain.Lotto;
import lotto.domain.LottoManager;
import lotto.domain.LottoResult;
import lotto.domain.Money;
import lotto.domain.WinningNumbers;
import lotto.view.InputView;
import lotto.view.OutputView;

public class LottoController {

    public void run() {
        Money money = getValidMoney();
        List<Lotto> lottos = buyLottos(money);
        displayLottos(lottos);
        WinningNumbers winningLotto = getValidWinningNumbers();
        LottoResult lottoResult = new LottoResult(lottos, winningLotto);
        displayResult(money, lottoResult);
    }

    private Money getValidMoney() {
        while (true) {
            try {
                int buyPrice = InputView.buyPrice();
                return new Money(buyPrice);
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }
    }

    private List<Lotto> buyLottos(Money money) {
        LottoManager lottoManager = new LottoManager();
        lottoManager.buyLotto(money);
        return lottoManager.getLottoTickets();
    }

    private void displayLottos(List<Lotto> lottos) {
        List<String> formattedLottos = lottos.stream()
            .map(lotto -> lotto.getNumbers().stream().sorted().toList().toString())
            .collect(Collectors.toList());
        OutputView.showBuyLottos(lottos.size(), formattedLottos);
    }

    private WinningNumbers getValidWinningNumbers() {
        while (true) {
            try {
                Set<Integer> winningNumbers = InputView.inputWinningNumbers();
                int bonusNumber = InputView.inputBonusNumber();
                return new WinningNumbers(winningNumbers, bonusNumber);
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }
    }

    private void displayResult(Money money, LottoResult lottoResult) {
        double percent = money.getPercent(lottoResult.getTotalPrize());
        OutputView.showLottoResult(lottoResult.getMatch3Count(), lottoResult.getMatch4Count(),
            lottoResult.getMatch5Count(), lottoResult.getMatch5WithBonusCount(),
            lottoResult.getMatch6Count(), percent);
    }
}
