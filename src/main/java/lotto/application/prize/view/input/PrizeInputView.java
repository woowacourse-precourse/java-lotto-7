package lotto.application.prize.view.input;

import static camp.nextstep.edu.missionutils.Console.readLine;
import static lotto.application.util.StringConverter.split;
import static lotto.application.util.StringConverter.toInt;
import static lotto.application.util.StringConverter.toInts;
import static lotto.application.util.StringConverter.trim;

import java.util.List;
import lotto.application.common.OutputPrinter;

public class PrizeInputView {

    private final String INPUT_PRIZE_NUMBER = "당첨 번호를 입력해 주세요.";
    private final String INPUT_BONUS_NUMBER = "보너스 번호를 입력해 주세요.";
    private final OutputPrinter printer;

    public PrizeInputView() {
        this.printer = new OutputPrinter();
    }

    public PrizeViewRequest initialize() {
        List<Integer> prizeNumber = inputPrizeNumber();
        int bonusNumber = inputBonusNumber();

        return new PrizeViewRequest(prizeNumber, bonusNumber);
    }

    private List<Integer> inputPrizeNumber() {
        printer.appendWithLine(INPUT_PRIZE_NUMBER);
        printer.execute();

        return toInts(split(trim(readLine())));
    }

    private int inputBonusNumber() {
        printer.appendWithLine(INPUT_BONUS_NUMBER);
        printer.execute();

        return toInt(trim(readLine()));
    }

}
