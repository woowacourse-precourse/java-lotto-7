package lotto.application.prize.view.input;

import static camp.nextstep.edu.missionutils.Console.readLine;
import static lotto.application.prize.message.Message.INPUT_BONUS_NUMBER;
import static lotto.application.util.StringConverter.toInt;
import static lotto.application.util.StringConverter.trim;

import lotto.application.common.OutputPrinter;
import lotto.application.prize.view.input.request.BonusViewRequest;

public class BonusInputView {
    private final OutputPrinter printer;

    public BonusInputView() {
        this.printer = new OutputPrinter();
    }

    public BonusViewRequest initialize() {
        int bonusNumber = inputBonusNumber();

        return new BonusViewRequest(bonusNumber);
    }


    private int inputBonusNumber() {
        while (true) {
            try {
                printer.appendWithLine(INPUT_BONUS_NUMBER);
                printer.execute();
                return toInt(trim(readLine()));
            } catch (IllegalArgumentException e) {
                printer.appendWithLine(e.getMessage());
                printer.execute();
            }
        }
    }
}
