package lotto.controller;

import lotto.model.LottoGame;
import lotto.model.LottoResult;
import lotto.model.LottoTickets;
import lotto.validator.Validator;
import lotto.view.InputView;
import lotto.view.OutputView;

public final class LottoGameController {

    private LottoGame lottoGame;
    private final InputView inputView;
    private final OutputView outputView;

    public LottoGameController(InputView inputView, OutputView outputView) {
        this.inputView = inputView;
        this.outputView = outputView;
    }

    public void run() {
        while (true) {
            try {
                playLottoGame();
                break;
            } catch (IllegalArgumentException e) {
                outputView.print(e.getMessage());
            }
        }
    }

    private void playLottoGame() {
        setupLottoGame();
    }

    private void setupLottoGame() {
        int money = readMoney();

        LottoTickets lottoTickets = new LottoTickets(money);
        LottoResult lottoResult;
        LottoGame lottoGame = LottoGame(lottoTickets, lottoResult, money);
    }

    private int readMoney() {
        String moneyInput = inputView.getMoneyInput();

        Validator.validateMoneyInput(moneyInput);

        return Integer.parseInt(moneyInput);
    }
}
