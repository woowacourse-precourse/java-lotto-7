package lotto.view;

import static camp.nextstep.edu.missionutils.Console.readLine;
import static lotto.view.constant.Message.START;
import static lotto.view.constant.Message.WINNING_START;

import java.util.List;
import lotto.domain.CashRegister;
import lotto.domain.Parser;

public class InputView {
    private final Parser parser = new Parser();
    private final OutputView outputView = new OutputView();

    public String inputString() {
        return readLine();
    }

    public int inputCountFromCash() {
        try {
            outputView.printMessage(START);
            int cash = parser.parseToInt(inputString());
            return new CashRegister(cash).calculateLottoCount();
        } catch (IllegalArgumentException e) {
            outputView.printResult(e.getMessage());
            return inputCountFromCash();
        }
    }

    public List<Integer> inputWinningNumber() {
        try {
            outputView.printMessage(WINNING_START);
            return parser.parseToIntList(inputString());
        } catch (IllegalArgumentException e) {
            outputView.printResult(e.getMessage());
            return inputWinningNumber();
        }
    }

}
