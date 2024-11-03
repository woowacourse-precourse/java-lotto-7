package lotto.controller;

import lotto.model.*;
import lotto.view.NumberInputView;
import lotto.view.OutputView;

import java.util.ArrayList;
import java.util.List;

public class Controller {

    private final LottoService lottoService = new LottoService();

    public void run() {
        Money money = lottoService.getMoney();

        Lottos lottos = purchaseLottos(money);
        OutputView.printLottoNumbers(lottos);

        WinningLotto winningLotto = createWinningLotto();
        Result result = lottos.matchWinningLotto(winningLotto);
        OutputView.printResult(result);
    }

    private Lottos purchaseLottos(Money money) {
        List<Lotto> lottos = new ArrayList<>();

        for (int i = 0; i < money.getLottoTicket(); i++) {
            Lotto lotto = LottoGenerator.createLotto();
            lottos.add(lotto);
        }

        return new Lottos(lottos);
    }

    private WinningLotto createWinningLotto() {
        Lotto winningNumbers = LottoGenerator.createLotto(getWinningNumbers());
        BonusNumber bonusNumber = getBonusNumber();
        return new WinningLotto(winningNumbers, bonusNumber);
    }

    private List<Integer> getWinningNumbers() {
        return NumberInputView.getWinningNumbers();
    }

    private BonusNumber getBonusNumber() {
        int bonusNumber = NumberInputView.getBonusNumber();
        return new BonusNumber(bonusNumber);
    }
}
