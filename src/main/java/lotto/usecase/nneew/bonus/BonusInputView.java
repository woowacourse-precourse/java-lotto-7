package lotto.usecase.nneew.bonus;

import static camp.nextstep.edu.missionutils.Console.readLine;
import static lotto.application.util.StringConverter.toInt;
import static lotto.application.util.StringConverter.trim;

import lotto.application.common.OutputPrinter;

public class BonusInputView {
    private final String INPUT_BONUS_NUMBER = "보너스 번호를 입력해 주세요.";
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
