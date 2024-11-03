package lotto.view;

import static camp.nextstep.edu.missionutils.Console.readLine;
import static lotto.view.constant.Message.BONUS_START;
import static lotto.view.constant.Message.START;
import static lotto.view.constant.Message.WINNING_START;

import java.util.List;
import lotto.domain.CashRegister;
import lotto.domain.Parser;
import lotto.domain.Winning;

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

    public Winning inputWinningNumbers() {
        try {
            outputView.printMessage(WINNING_START);
            List<Integer> winningNumbers = parser.parseToIntList(inputString());
            return new Winning(winningNumbers);
        } catch (IllegalArgumentException e) {
            outputView.printResult(e.getMessage());
            return inputWinningNumbers();
        }
    }

    public Winning inputBonusNumber(Winning winning) {
        try {
            outputView.printMessage(BONUS_START);
            return winning.validateBonusNumber(parser.parseToInt(inputString()));
        } catch (IllegalArgumentException e) {
            outputView.printResult(e.getMessage());
            return inputBonusNumber(winning);
        }
    }

}
