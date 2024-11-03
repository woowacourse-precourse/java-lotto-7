package lotto.view;

import lotto.constants.ErrorCode;

import java.util.List;

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

    public List<Integer> inputWinningNumbers() {
        System.out.println("당첨 번호를 입력해 주세요.");
        String winningNumbers = readLine();
        List<Integer> winningNumber = inputValidator.parseNumbers(winningNumbers);
        inputValidator.validWinningNumber(winningNumber);
        return winningNumber;
    }
}
