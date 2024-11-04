package lotto.controller;

import lotto.domain.Lotto;
import lotto.domain.Lottos;
import lotto.domain.LottosResult;
import lotto.message.ExceptionMessage;
import lotto.view.InputView;
import lotto.view.OutputView;

public class LottoController {
    public void run() {
        Lottos lottos = buyLottos();
        OutputView.printLottosInfo(lottos);

        Lotto winningLotto = new Lotto(InputView.readNumbers());
        int bonusNumber = InputView.readBonusNumber(winningLotto);
        LottosResult lottoResult = lottos.getResult(winningLotto, bonusNumber);

        OutputView.printLottosResult(lottoResult);
        OutputView.printLottosReturns(lottoResult.calculateReturns());
    }

    private static Lottos buyLottos() {
        try {
            int inputMoney = InputView.readInputMoney();
            return Lotto.buyAsMoney(inputMoney);
        } catch (IllegalArgumentException e) {
            System.out.println(ExceptionMessage.AMOUNT_NOT_IN_THOUSANDS.getMessage());
            return buyLottos();
        }
    }

}
