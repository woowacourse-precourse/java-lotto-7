package lotto.application.prize.view.input;

import static camp.nextstep.edu.missionutils.Console.readLine;
import static lotto.application.prize.exception.Message.INPUT_PRIZE_NUMBER;
import static lotto.application.util.StringConverter.split;
import static lotto.application.util.StringConverter.toInts;
import static lotto.application.util.StringConverter.trim;

import java.util.List;
import lotto.application.common.OutputPrinter;
import lotto.application.prize.view.input.request.WinnerViewRequest;

public class WinnerInputView {
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
