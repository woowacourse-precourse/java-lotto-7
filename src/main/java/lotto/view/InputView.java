package lotto.view;

import camp.nextstep.edu.missionutils.Console;
import lotto.validator.InputValidator;
import lotto.validator.Validator;

public class InputView {

    public String readAmount() {
        System.out.println("구입금액을 입력해 주세요.");
        return getInput();
    }

    public String readWinningNumbers() {
        System.out.println("당첨 번호를 입력해 주세요.");
        return getInput();
    }

    public String readBonusNumber() {
        System.out.println("보너스 번호를 입력해 주세요.");
        return getInput();
    }

    private static String getInput() {
        Validator validator = new InputValidator();

        String input = Console.readLine();
        validator.validator(input);
        return input;
    }
}
