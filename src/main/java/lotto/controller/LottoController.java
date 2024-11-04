package lotto.controller;

import lotto.domain.Lotto.Lotto;
import lotto.domain.Lotto.LottoFactory;
import lotto.domain.Lottos;
import lotto.domain.Number;
import lotto.domain.Price;
import lotto.domain.Stastistics;
import lotto.domain.WinningLotto;
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
        Price price = inputBuyLotto();

        Lottos lottos = new Lottos(price);
        outputRandomLottoNumber(lottos);

        Lotto WinningLottoNum = inputWinningLotto();

        WinningLotto winningLotto = inputBonusNumber(WinningLottoNum);

        outputView.printWinningStatistics();
        Stastistics stastistics = new Stastistics(lottos, winningLotto);
        outputResultStatistics(stastistics, lottos);

        inputView.closeConsole();
    }

    private Price inputBuyLotto() {
        while (true) {
            try {
                String rawPrice = inputView.readPriceInput();
                return new Price(InputParser.parseInt(rawPrice));
            } catch (IllegalArgumentException e) {
                outputView.printResult(e.getMessage());
            }
        }
    }

    private void outputRandomLottoNumber(Lottos lottos) {
        outputView.printLottoTicket(lottos.getTicketCount());
        String lottosNumber = lottos.getLottosToString();
        outputView.printResult(lottosNumber);
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
                return new WinningLotto(WinningLottoNum, new Number(rawBonusNum));
            } catch (IllegalArgumentException e) {
                outputView.printResult(e.getMessage());
            }
        }
    }

    private void outputResultStatistics(Stastistics stastistics, Lottos lottos) {
        String rankStastistics = stastistics.getStatisticsString();
        float profitRate = stastistics.calculateProfitRate(lottos.getTicketCount());
        outputView.printResult(rankStastistics);
        outputView.printProfitRate(profitRate);
    }
}
