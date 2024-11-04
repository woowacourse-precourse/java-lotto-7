package lotto.controller;
import lotto.dto.WinningResultDto;
import lotto.model.draw.Bonus;
import lotto.model.draw.LottoDraw;
import lotto.model.lotto.Lotto;
import lotto.model.lotto.LottoTickets;
import lotto.model.result.WinningStatistics;
import lotto.util.RetryTemplate;
import lotto.view.InputView;
import lotto.view.OutputView;

public class WinningController {
    private final InputView inputView;
    private final OutputView outputView;
    private final RetryTemplate retryTemplate;

    public WinningController(InputView inputView, OutputView outputView, RetryTemplate retryTemplate) {
        this.inputView = inputView;
        this.outputView = outputView;
        this.retryTemplate = retryTemplate;
    }

    public void processWinningResult(LottoTickets tickets) {
        Lotto winningNumber = retryTemplate.execute(this::readValidWinningNumber);
        Bonus bonusNumber = retryTemplate.execute(() -> new Bonus(inputView.readBonusNumber()));

        LottoDraw lottoDraw = LottoDraw.by(winningNumber, bonusNumber);
        WinningStatistics statistics = WinningStatistics.from(lottoDraw, tickets);

        WinningResultDto resultDto = new WinningResultDto(statistics);
        outputView.printWinningResult(resultDto);
    }

    private Lotto readValidWinningNumber() {
        return new Lotto(inputView.readWinningNumber());
    }
}