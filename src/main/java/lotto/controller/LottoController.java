package lotto.controller;

import lotto.entity.Lottos;
import lotto.entity.WinningNumbers;
import lotto.enums.Prize;
import lotto.service.LottoService;
import lotto.view.InputView;
import lotto.view.OutputView;

import java.util.List;

public class LottoController {
    private final LottoService lottoService = new LottoService();

    public void run() {
        // 1. 로또 구입 금액 입력
        int purchaseAmount = InputView.getPurchaseAmount();

        // 2. 로또 생성 및 출력
        Lottos lottos = lottoService.generateLottos(purchaseAmount);
        OutputView.printLottos(lottos);

        // 3. 당첨 번호 및 보너스 번호 입력
        WinningNumbers winningNumbers = InputView.getWinningNumbers();

        // 4. 당첨 결과 계산 및 출력
        List<Prize> results = lottoService.calculateResults(lottos, winningNumbers);
        OutputView.printResults(results, purchaseAmount);
    }
}
