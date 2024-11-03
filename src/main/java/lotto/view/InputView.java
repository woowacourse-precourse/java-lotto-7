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
        Long convertMoney = inputValidator.parseMoney(money);
        inputValidator.validMoney(convertMoney);
        return convertMoney;
    }
}
