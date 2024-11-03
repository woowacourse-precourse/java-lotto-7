package lotto.controller;

import java.util.List;
import lotto.model.lotto.LottoResult;
import lotto.model.lotto.Lottos;
import lotto.model.winning.WinningNumbersAndBonusNumber;
import lotto.model.rank.RankResult;
import lotto.service.LottoService;
import lotto.view.InputView;
import lotto.view.OutputView;

public class LottoController {

    private final LottoService lottoService;

    public LottoController(LottoService lottoService) {
        this.lottoService = lottoService;
    }

    public void run() {
        int count = getPurchaseCount();
        Lottos lottos = lottoService.generateLottos(count);
        OutputView.printLottos(count, lottos);

        List<Integer> winningNumbers = getWinningNumbersInput();
        int bonusNumber = getBonusNumberInput(winningNumbers);

        WinningNumbersAndBonusNumber winningNumbersAndBonusNumber = new WinningNumbersAndBonusNumber(winningNumbers, bonusNumber);
        List<LottoResult> lottoResults = lottoService.createResultChecker(winningNumbersAndBonusNumber).check(lottos);

        RankResult rankResult = lottoService.checkRanks(lottoResults);
        OutputView.printRankResult(rankResult);

        double totalPrize = lottoService.calculateTotalPrize(rankResult);
        double profitRate = lottoService.calculateRateOfReturn(count, totalPrize);
        OutputView.printRateOfReturn(profitRate);
    }

    private int getPurchaseCount() {
        while (true) {
            try {
                String amount = InputView.readAmount();
                return lottoService.getPurchaseCount(amount);
            } catch (IllegalArgumentException e) {
                OutputView.printErrorMessage(e.getMessage());
            }
        }
    }

    private List<Integer> getWinningNumbersInput() {
        while (true) {
            try {
                List<String> lottoInput = InputView.readLottoNumbers();
                return lottoService.getWinningNumbers(lottoInput);
            } catch (IllegalArgumentException e) {
                OutputView.printErrorMessage(e.getMessage());
            }
        }
    }

    private int getBonusNumberInput(List<Integer> winningNumbers) {
        while (true) {
            try {
                String bonusInput = InputView.readBonusNumber();
                return lottoService.getBonusNumber(bonusInput, winningNumbers);
            } catch (IllegalArgumentException e) {
                OutputView.printErrorMessage(e.getMessage());
            }
        }
    }

}
