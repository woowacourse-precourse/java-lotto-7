package lotto.view;

import camp.nextstep.edu.missionutils.Console;
import lotto.validator.CommonInputValidator;

public class InputView {

    private final CommonInputValidator commonInputValidator = new CommonInputValidator();

    public String getPurchasePrice() {
        System.out.println("구입 금액을 입력해주세요.");
        return getInput();
    }

    public String getWinningNum() {
        showDivider();
        System.out.println("당첨 번호를 입력해주세요.");
        return getInput();
    }

    public String getBonusNum() {
        showDivider();
        System.out.println("보너스 번호를 입력해주세요.");
        return getInput();
    }

    private String getInput() {
        String inputPurchasePrice = Console.readLine();
        commonInputValidator.validateEmpty(inputPurchasePrice);
        return inputPurchasePrice;
    }

    private void showDivider() {
        System.out.println();
    }

}
