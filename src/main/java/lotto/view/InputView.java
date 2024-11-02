package lotto.view;

import camp.nextstep.edu.missionutils.Console;
import lotto.validator.CommonInputValidator;

public class InputView {

    private final CommonInputValidator commonInputValidator = new CommonInputValidator();

    public String getPurchasePrice() {
        System.out.println("구입 금액을 입력해주세요.");
        String inputPurchasePrice = Console.readLine();

        commonInputValidator.validateEmpty(inputPurchasePrice);

        return inputPurchasePrice;
    }

}
