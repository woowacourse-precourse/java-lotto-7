package lotto.view;

import lotto.constants.ErrorCode;

import static camp.nextstep.edu.missionutils.Console.readLine;

public class InputView {
    private final InputValidator inputValidator;

    public InputView(InputValidator inputValidator) {
        this.inputValidator = inputValidator;
    }

    public Long inputMoney() {
        System.out.println("구입금액을 입력해 주세요.");
        String money = readLine();
        inputValidator.validMoney(parseMoney(money));
        return parseMoney(money);
    }

    public Long parseMoney(String money) {
        try {
            return Long.parseLong(money);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException(ErrorCode.MONEY_TYPE_ERROR.getMessage());
        }
    }
}
