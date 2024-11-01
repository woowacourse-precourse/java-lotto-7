package lotto.controller;

import static lotto.util.inputParser.parseInt;

import lotto.model.Lotto;
import lotto.model.Lottos;
import lotto.model.Number;
import lotto.model.Price;
import lotto.model.Stastistics;
import lotto.model.WinningLotto;
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

        int ticketCount = price.convertToTicket();
        Lottos lottos = new Lottos(ticketCount);
        outputRandomLottoNumber(ticketCount, lottos);

        Lotto WinningLottoNum = inputWinningLotto();

        WinningLotto winningLotto = inputBonusNumber(WinningLottoNum);

        outputView.printWinningStatistics();
        Stastistics stastistics = new Stastistics(lottos, winningLotto);
        outputResultStatistics(stastistics, ticketCount);

        inputView.closeConsole();
    }

    private Price inputBuyLotto() {
        while (true) {
            try {
                String rawPrice = inputView.readPriceInput();
                return new Price(parseInt(rawPrice));
            } catch (IllegalArgumentException e) {
                outputView.printResult(e.getMessage());
            }
        }
    }

    private void outputRandomLottoNumber(int ticketCount, Lottos lottos) {
        outputView.printLottoTicket(ticketCount);
        String lottosNumber = lottos.getLottosToString();
        outputView.printResult(lottosNumber);
    }

    private Lotto inputWinningLotto() {
        while (true) {
            try {
                String rawWinningLotto = inputView.readWinningLottoNumber();
                return new Lotto(rawWinningLotto);
            } catch (IllegalArgumentException e) {
                outputView.printResult(e.getMessage());
            }
        }
    }

    private WinningLotto inputBonusNumber(Lotto WinningLottoNum) {
        while (true) {
            try {
                String rawBonusNum = inputView.readBonusNumber();
                Number bonusNum = new Number(rawBonusNum);
                return new WinningLotto(WinningLottoNum, bonusNum);
            } catch (IllegalArgumentException e) {
                outputView.printResult(e.getMessage());
            }
        }
    }

    private void outputResultStatistics(Stastistics stastistics, int ticketCount) {
        String rankStastistics = stastistics.getStatisticsString();
        float profitRate = stastistics.calculateProfitRate(ticketCount);
        outputView.printResult(rankStastistics);
        outputView.printProfitRate(profitRate);
    }
}
