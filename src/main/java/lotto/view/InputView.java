package lotto.view;

import camp.nextstep.edu.missionutils.Console;
import lotto.validator.InputValidator;

public class InputView {
    private final InputValidator inputValidator;

    public InputView(InputValidator inputValidator) {
        this.inputValidator = inputValidator;
    }

    public String inputWinLottoNumbers() {
        String input = Console.readLine();
        try {
            inputValidator.validateWinLottoNumbers(input);
        }catch (Exception e) {
            this.inputWinLottoNumbers();
        }

        return input;
    }

    public String inputWinBonusNumber() {
        String input = Console.readLine();
        try {
            inputValidator.validateWinBonusNumber(input);
        } catch (Exception e) {
            this.inputWinBonusNumber();
        }
        return input;
    }

    public String inputPayMoney() {
        String input = Console.readLine();
        inputValidator.validatePayMoney(input);
        return input;
    }

}
