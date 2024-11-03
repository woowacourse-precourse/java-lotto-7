package lotto.controller;

import lotto.util.InputParser;
import lotto.view.InputView;
import lotto.domain.Lotto;
import lotto.view.OutputView;
import lotto.service.LottoService;
import lotto.service.LottoServiceImpl;

import java.util.List;

public class LottoController {

    private final LottoService lottoService;

    public LottoController() {
        this.lottoService = new LottoServiceImpl();
    }

    public void startLotto() {
        int purchaseAmount = InputParser.parsePurchaseAmount(InputView.getLottoPurchaseAmount());
        List<Lotto> lottos = lottoService.generateLottos(purchaseAmount);

        OutputView.printLottoNumbers(lottos); // 확인차 만든 메서드 - 삭제 예정

        List<Integer> winningNumbers = InputParser.parseWinningNumbers(InputView.getWinningNumbers());
        int bonusNumber = InputParser.parseBonusNumber(InputView.getBonusNumber());

        int[] winningCounts = lottoService.getWinningCount(lottos, winningNumbers, bonusNumber);
    }
}
