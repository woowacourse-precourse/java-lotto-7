package lotto.controller;

import static lotto.util.inputParser.parseInt;

import lotto.model.Lottos;
import lotto.model.Price;
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

        inputWinningLotto();

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
        String lottosNumber = lottos.getLottos();
        outputView.printResult(lottosNumber);
    }

    private void inputWinningLotto() {
        while (true) {
            try {
                inputView.readWinningLottoNumber();
                return;
            } catch (IllegalArgumentException e) {
                outputView.printResult(e.getMessage());
            }
        }
    }
}
