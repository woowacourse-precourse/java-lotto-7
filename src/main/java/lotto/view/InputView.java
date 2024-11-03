package lotto.view;

import java.util.List;

import static camp.nextstep.edu.missionutils.Console.readLine;

public class InputView {
    private final InputValidator inputValidator;

    public InputView(InputValidator inputValidator) {
        this.inputValidator = inputValidator;
    }

    public Long inputMoney() {
        System.out.println("구입금액을 입력해 주세요.");
        String inputMoney = readLine();
        Long money = inputValidator.parseMoney(inputMoney);
        inputValidator.validMoney(money);
        return money;
    }

    public List<Integer> inputWinningNumbers() {
        System.out.println();
        System.out.println("당첨 번호를 입력해 주세요.");
        String input = readLine();
        List<Integer> winningNumber = inputValidator.parseNumbers(input);
        inputValidator.validWinningNumber(winningNumber);
        return winningNumber;
    }

    public Integer inputBonusNumber() {
        System.out.println();
        System.out.println("보너스 번호를 입력해 주세요.");
        String input = readLine();
        Integer bonusNumber = inputValidator.parseBonusNumber(input);
        inputValidator.validBonusNumber(bonusNumber);
        return bonusNumber;
    }
}
