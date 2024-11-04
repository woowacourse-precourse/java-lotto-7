package lotto.inputview;

import lotto.validator.BonusNumberValidator;
import camp.nextstep.edu.missionutils.Console;
public class BonusNumberInputView {
    public static int inputBonusNumber() {
        while (true) {
            try {
                System.out.println("보너스 번호를 입력해 주세요.");
                String input = Console.readLine();
                int validatedBonusNumber = BonusNumberValidator.getValidated(input);
                return validatedBonusNumber;
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }
    }
}
