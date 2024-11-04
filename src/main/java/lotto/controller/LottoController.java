package lotto.controller;

import java.util.Map;
import lotto.domain.Lotto;
import lotto.domain.Lottos;
import lotto.message.ExceptionMessage;
import lotto.view.InputView;
import lotto.view.OutputView;

public class LottoController {
    public void run() {
        //내 로또
        Lottos lottos = createLottos();
        OutputView.printBoughtInfo(lottos);

        //당첨번호 설정
        Lotto winningLotto = new Lotto(InputView.readAndSplitNumber());
        int bonusNumber = InputView.readBonusNumber(winningLotto);

        //로또 결과
        Map<String, Integer> lottoResult = lottos.getResult(winningLotto, bonusNumber);
        OutputView.printLottosResult(lottoResult);

        //수익률 출력
        double returnsByLottos = lottos.calculateReturns(lottoResult);
        OutputView.printLottosReturns(returnsByLottos);
    }
    private static Lottos createLottos() {
        try {
            int inputMoney = InputView.readInputMoney();
            return Lotto.buyAsMoney(inputMoney);
        } catch (IllegalArgumentException e) {
            System.out.println(ExceptionMessage.AMOUNT_NOT_IN_THOUSANDS.getMessage());
            return createLottos();
        }
    }

}
