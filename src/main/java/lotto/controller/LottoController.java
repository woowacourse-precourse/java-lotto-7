package lotto.controller;

import java.util.Map;
import lotto.domain.Lotto;
import lotto.domain.Lottos;
import lotto.view.InputView;
import lotto.view.OutputView;

public class LottoController {
    public void run() {
        //내 로또
        int inpuMoney = InputView.readInputMoney();
        Lottos lottos = Lotto.buyAsMoney(inpuMoney);
        OutputView.printBoughtInfo(lottos);

        //당첨번호 설정
        Lotto winningLotto = new Lotto(InputView.readAndSplitNumber());
        int bonusNumber = InputView.readBonusNumber(winningLotto);

        //로또 결과
        Map<String, Integer> lottoResult = lottos.getResult(winningLotto, bonusNumber);
        OutputView.printLottosResult(lottoResult);

        //수익률 출력
        double returnsByLottos = lottos.calculateReturns(lottoResult, inpuMoney);
        OutputView.printLottosReturns(returnsByLottos);
    }
}
