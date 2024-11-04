package lotto.controller;

import lotto.model.Lotto;
import lotto.model.WinningNumber;
import lotto.service.ApplicationService;
import lotto.service.ProcessService;
import lotto.view.Result;

import java.util.List;

public class ApplicationController {
    private final ProcessController processController = new ProcessController(new ProcessService());
    private final ApplicationService appService;
    private List<Lotto> lottos;

    public ApplicationController(ApplicationService appService) {
        this.appService = appService;
    }

    public void createLottoTickets(int tickets) {
        this.lottos = appService.inputLottos(tickets);
    }

    public void start(List<Integer> winningNumbers, int bonusNumber) {
        WinningNumber winningNumber = appService.inputWinningNumber(winningNumbers, bonusNumber);

        Result.view(processController.checkWin(this.lottos, winningNumber));
    }
}
