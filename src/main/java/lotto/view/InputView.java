package lotto.view;

import static camp.nextstep.edu.missionutils.Console.readLine;

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
            int cash = parser.parseToInt(inputString());
            return new CashRegister(cash).calculateLottoCount();
        } catch (IllegalArgumentException e) {
            outputView.printResult(e.getMessage());
            return inputCountFromCash();
        }
    }

}
