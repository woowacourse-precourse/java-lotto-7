package lotto.controller;

import lotto.enumValue.ResultMessage;
import lotto.model.Lotto;
import lotto.model.Result;
import lotto.model.WinningNumber;
import lotto.service.ProcessService;

import java.util.List;

public class ProcessController {
    private final ProcessService lottoService;

    public ProcessController(ProcessService lottoService) {
        this.lottoService = lottoService;
    }

    public String checkWin(List<Lotto> lottos, WinningNumber winningNumber) {
        Result result = lottoService.matchNumber(lottos, winningNumber);

        return result.toString()
                + ResultMessage.RESULT1.getDescription()
                + lottoService.calculateRate(lottos.size(), result)
                + ResultMessage.RESULT2.getDescription();
    }
}
