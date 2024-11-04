package lotto.controller;

import lotto.model.Lotto;
import lotto.model.Result;
import lotto.model.WinningLotto;
import lotto.service.ResultService;
import lotto.view.OutputView;

import java.util.List;

public class ResultController {
    private final ResultService resultService;

    public ResultController(ResultService resultService) {
        this.resultService = resultService;
    }

    public void displayResult(List<Lotto> userLottos, WinningLotto winningLotto) {
        Result result = resultService.calculateResult(userLottos, winningLotto);
        OutputView.printResult(result);
    }
}
