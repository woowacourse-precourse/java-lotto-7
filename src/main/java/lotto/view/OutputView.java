package lotto.view;

import lotto.domain.Lotto;
import lotto.service.LottoService;

import java.util.List;

public class OutputView {
    private LottoService lottoService;

    public OutputView(LottoService lottoService) {
        this.lottoService = lottoService;
    }

    public void printLottos() {
        lottoService.generateLotto();
    }

    public void printResult(List<Integer> winningNumbers) {
        lottoService.printWinningStatistics(winningNumbers);
    }

    public void printRateOfReturn() {
        lottoService.printRateOfReturn();
    }
}