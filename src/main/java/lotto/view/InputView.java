package lotto.view;

import camp.nextstep.edu.missionutils.Console;
import lotto.common.validator.InputValidator;

public class InputView {
    private static final String REQUEST_PURCHASE_COST_MESSAGE = "구입금액을 입력해 주세요.";
    private static final String REQUEST_WINNING_NUMBER_MESSAGE = "당첨 번호를 입력해 주세요.";
    private static final String REQUEST_BONUS_NUMBER_MESSAGE = "\n보너스 번호를 입력해 주세요.";

    public void requestPurchaseAmount() {
        System.out.println(REQUEST_PURCHASE_COST_MESSAGE);
    }

    public void requestWinningNumber() {
        System.out.println(REQUEST_WINNING_NUMBER_MESSAGE);
    }

    public void requestBonusNumber() {
        System.out.println(REQUEST_BONUS_NUMBER_MESSAGE);
    }

    public String getInput() {
        String input = Console.readLine();
        InputValidator.validate(input);
        return input;
    }
}
