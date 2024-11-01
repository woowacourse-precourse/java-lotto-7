package lotto.controller;
import lotto.model.Lotto;
import lotto.view.InputView;
import lotto.view.OutputView;

import java.util.List;

public class LottoController {
    public void run() {
        int purchaseAmount = InputView.inputPurchaseAmount(); // 로또 구입 금액 입력
        int lottoCount = purchaseAmount / 1000; // 구매할 로또 수량 계산
        List<Lotto> lottos = Lotto.generateLottos(lottoCount); // 로또 번호 생성

        OutputView.printLottos(lottoCount, lottos); // 로또 번호 출력

        List<Integer> winningNumbers = InputView.inputWinningNumbers(); // 당첨 번호 입력
        int bonusNumber = InputView.inputBonusNumber(winningNumbers); // 보너스 번호 입력
    }
}
