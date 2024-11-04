package lotto.controller;

import java.util.List;
import lotto.domain.WinnerResult;
import lotto.service.LottoCalculator;
import lotto.service.RandomLotteryGenerator;
import lotto.domain.LottoGroup;
import lotto.domain.Player;
import lotto.domain.WinningLotto;
import lotto.view.InputView;
import lotto.view.OutputView;

public class Controller {

    private static final Integer THOUSAND_VALUE = 1000;
    private final InputView inputView;
    private final OutputView outputView;

    public Controller(InputView inputView, OutputView outputView) {
        this.inputView = inputView;
        this.outputView = outputView;
    }

    public void run() {
        Player player = buyLottoTickets();
    }

    private Player buyLottoTickets() {
        int money = inputView.inputMoneyAmount();
        int quantity = money / THOUSAND_VALUE;
        outputView.printBoughtAmount(quantity);

        return new Player(money, quantity);
    }
}
