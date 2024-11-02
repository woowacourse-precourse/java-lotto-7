package lotto.controller;

import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;
import lotto.domain.Lotto;
import lotto.domain.Money;
import lotto.domain.WinningNumbers;
import lotto.service.LottoService;
import lotto.view.InputView;
import lotto.view.OutputView;

public class LottoController {

    private final LottoService lottoService;

    public LottoController(LottoService lottoService) {
        this.lottoService = lottoService;
    }

    public void run(){
        int buyPrice = InputView.buyPrice();
        Money money = new Money(buyPrice);
        List<Lotto> lottos = lottoService.purchaseLotto(money);

        List<String> formattedLottos = lottos.stream()
            .map(lotto -> lotto.getNumbers().toString())
            .collect(Collectors.toList());

        OutputView.showBuyLottos(lottos.size(), formattedLottos);

        Set<Integer> winningNumbers = InputView.inputWinningNumbers();
        int bonusNumber = InputView.inputBonusNumber();

        WinningNumbers winningLotto = new WinningNumbers(winningNumbers, bonusNumber);
        

    }


}
