package lotto.controller;

import lotto.domain.Lotto.Lotto;
import lotto.domain.Lotto.LottoFactory;
import lotto.domain.Lotto.Lottos;
import lotto.domain.Lotto.LottoNumber;
import lotto.domain.TicketPrice;
import lotto.domain.Stastistics;
import lotto.domain.Lotto.WinningLotto;
import lotto.dto.LottosDto;
import lotto.dto.StatisticsDto;
import lotto.util.InputParser;
import lotto.view.InputView;
import lotto.view.OutputView;

public class LottoController {
    private final InputView inputView;
    private final OutputView outputView;

    public LottoController(InputView inputView, OutputView outputView) {
        this.inputView = inputView;
        this.outputView = outputView;
    }

    public void run() {
        TicketPrice ticketPrice = inputBuyLotto();

        Lottos randomLottos = new Lottos(ticketPrice);
        LottosDto lottosDto = randomLottos.toDto();
        outputRandomLottoNumber(lottosDto);

        Lotto WinningLottoNum = inputWinningLotto();

        WinningLotto winningLotto = inputBonusNumber(WinningLottoNum);

        outputView.printWinningStatistics();
        Stastistics stastistics = new Stastistics(randomLottos, winningLotto, lottosDto.ticketCount());
        StatisticsDto statisticsDto = stastistics.toDto();
        outputResultStatistics(statisticsDto);

        inputView.closeConsole();
    }

    private TicketPrice inputBuyLotto() {
        while (true) {
            try {
                String rawPrice = inputView.readPriceInput();
                return new TicketPrice(InputParser.parseInt(rawPrice));
            } catch (IllegalArgumentException e) {
                outputView.printResult(e.getMessage());
            }
        }
    }

    private void outputRandomLottoNumber(LottosDto lottosDto) {
        outputView.printLottoTicket(lottosDto.getTicketCount());
        outputView.printResult(lottosDto.getLottosAsString());
    }

    private Lotto inputWinningLotto() {
        while (true) {
            try {
                String rawWinningLotto = inputView.readWinningLottoNumber();
                return LottoFactory.createManualLotto(rawWinningLotto);
            } catch (IllegalArgumentException e) {
                outputView.printResult(e.getMessage());
            }
        }
    }

    private WinningLotto inputBonusNumber(Lotto WinningLottoNum) {
        while (true) {
            try {
                String rawBonusNum = inputView.readBonusNumber();
                return new WinningLotto(WinningLottoNum, new LottoNumber(rawBonusNum));
            } catch (IllegalArgumentException e) {
                outputView.printResult(e.getMessage());
            }
        }
    }

    private void outputResultStatistics(StatisticsDto statisticsDto) {
        outputView.printResult(statisticsDto.getStatisticsAsString());
        outputView.printProfitRate(statisticsDto.getProfitRate());
    }
}
