package lotto.controller;

import static lotto.view.constant.Message.BONUS_START;
import static lotto.view.constant.Message.START;
import static lotto.view.constant.Message.STATISTICS;
import static lotto.view.constant.Message.WINNING_START;

import java.util.List;
import lotto.Lotto;
import lotto.domain.CashRegister;
import lotto.domain.LottoMachine;
import lotto.domain.Parser;
import lotto.view.InputView;
import lotto.view.OutputView;

public class Controller {
    private final OutputView outputView = new OutputView();
    private final InputView inputView = new InputView();
    private final Parser parser = new Parser();
    private final LottoMachine lottoMachine = new LottoMachine();

    public void start() {
        outputView.printResult(START.getMessage());
        List<Lotto> lottos = pickLotto();
        outputView.printLottos(lottos);

        outputView.printResult(WINNING_START.getMessage());

        outputView.printResult(BONUS_START.getMessage());
        outputView.printResult(STATISTICS.getMessage());
    }

    private List<Lotto> pickLotto() {
        int money = getIntValue();
        int count = getCount(money);
        return lottoMachine.generateLottos(count);
    }

    private int getCount(int money) {
        CashRegister cashRegister = new CashRegister(money);
        return cashRegister.calculateLottoCount();
    }

    private int getIntValue() {
        return parser.parseToInt(inputView.inputString());
    }
}
