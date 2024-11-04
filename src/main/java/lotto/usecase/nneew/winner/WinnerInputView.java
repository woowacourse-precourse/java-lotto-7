package lotto.usecase.nneew.winner;

import static camp.nextstep.edu.missionutils.Console.readLine;
import static lotto.application.util.StringConverter.split;
import static lotto.application.util.StringConverter.toInts;
import static lotto.application.util.StringConverter.trim;

import java.util.List;
import lotto.application.common.OutputPrinter;

public class WinnerInputView {
    private final String INPUT_PRIZE_NUMBER = "당첨 번호를 입력해 주세요.";
    private final OutputPrinter printer;

    public WinnerInputView() {
        this.printer = new OutputPrinter();
    }

    public WinnerViewRequest initialize() {
        List<Integer> prizeNumber = inputPrizeNumber();

        return new WinnerViewRequest(prizeNumber);
    }

    private List<Integer> inputPrizeNumber() {
        while (true) {
            try {
                printer.appendWithLine(INPUT_PRIZE_NUMBER);
                printer.execute();
                return toInts(split(trim(readLine())));
            } catch (IllegalArgumentException e) {
                printer.appendWithLine(e.getMessage());
                printer.execute();
            }
        }
    }

}
