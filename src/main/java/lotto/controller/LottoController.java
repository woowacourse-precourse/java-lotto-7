package lotto.controller;

import lotto.domain.Lotto;
import lotto.enums.Prize;
import lotto.service.InputService;
import lotto.service.LottoService;
import lotto.service.OutputService;

import java.util.List;
import java.util.Map;

public class LottoController {
    private final InputService inputService = new InputService();
    private final OutputService outputService = new OutputService();
    private final LottoService lottoService = new LottoService();

    public void run() {
        int purchaseAmount = inputService.getPurchaseAmount();
        outputService.showPurchaseAmount(purchaseAmount);

        List<Lotto> generatedLotto = lottoService.generateLottoNumbers(purchaseAmount);
        outputService.showGeneratedLottoNumbers(generatedLotto);

        int[] winningNumbers = inputService.getWinningNumbers();
        int bonusNumber = inputService.getBonusNumber(winningNumbers);
        Map<Prize, Integer> prizeCount = lottoService.calculateMathLotto(winningNumbers, bonusNumber, generatedLotto);
        outputService.showWinnerStatistic(prizeCount);

        long prizeMoney = lottoService.calculatePrizeMoney(prizeCount);
        outputService.showProfitRate(prizeMoney, purchaseAmount);
    }
}
