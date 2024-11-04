package lotto.input;

import camp.nextstep.edu.missionutils.Console;
import lotto.input.validator.BonusNumberValidator;

public class BonusNumberInput {

    private final BonusNumberValidator bonusNumberValidator;

    public BonusNumberInput(BonusNumberValidator bonusNumberValidator) {
        this.bonusNumberValidator = bonusNumberValidator;
    }

    public Integer run() {
        System.out.println("보너스 번호를 입력해 주세요.");
        String bonusNumberInput = Console.readLine();
        bonusNumberValidator.validate(bonusNumberInput);
        return Integer.parseInt(bonusNumberInput);
    }
}
