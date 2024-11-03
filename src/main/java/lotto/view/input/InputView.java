package lotto.view.input;

import camp.nextstep.edu.missionutils.Console;

public class InputView {
    public String inputPurchaseAmount() {
        System.out.println(System.lineSeparator()
                + "구입금액을 입력해 주세요.");
        String purchaseAmount = Console.readLine();
        InputValidator.validateInputInteger(purchaseAmount);
        return purchaseAmount;
    }

    public String inputMainNumber() {
        System.out.println(System.lineSeparator()
                + "당첨 번호를 입력해 주세요.");
        String mainNumbersInput = Console.readLine();
        InputValidator.validateGeneralValueInput(mainNumbersInput);
        return mainNumbersInput;
    }

    public String inputBonusNumber() {
        System.out.println(System.lineSeparator()
                + "보너스 번호를 입력해 주세요.");
        String bonusNumberInput = Console.readLine();
        InputValidator.validateInputInteger(bonusNumberInput);
        return bonusNumberInput;
    }
}
