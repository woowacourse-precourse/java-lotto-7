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

    public void run(){
        int buyPrice = InputView.buyPrice();
        Money money = new Money(buyPrice);
        LottoManager lottoManager = new LottoManager();
        lottoManager.buyLotto(money);
        List<Lotto> lottos = lottoManager.getLottoTickets();

        List<String> formattedLottos = lottos.stream()
            .map(lotto -> lotto.getNumbers().toString())
            .collect(Collectors.toList());

        OutputView.showBuyLottos(lottos.size(), formattedLottos);

        Set<Integer> winningNumbers = InputView.inputWinningNumbers();
        int bonusNumber = InputView.inputBonusNumber();

        WinningNumbers winningLotto = new WinningNumbers(winningNumbers, bonusNumber);

        LottoResult lottoResult = new LottoResult(lottos, winningLotto);

        double percent = money.getPercent(lottoResult.getTotalPrize());

        OutputView.showLottoResult(lottoResult.getMatch3Count(),lottoResult.getMatch4Count(),
            lottoResult.getMatch5Count(),lottoResult.getMatch5WithBonusCount(),
            lottoResult.getMatch6Count(),percent);

    }


}
