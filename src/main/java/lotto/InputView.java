package lotto;

import camp.nextstep.edu.missionutils.Console;

public class InputView {

    private final InputValidator inputValidator;

    public InputView(InputValidator inputValidator) {
        this.inputValidator = inputValidator;
    }

    public int buyLotto() {
        System.out.println("구입금액을 입력해 주세요.");
        String amount = Console.readLine();

        inputValidator.validateBuyLotto(amount);

        return Integer.parseInt(amount);
    }

    public String enterWinningNumbers() {
        System.out.println("당첨 번호를 입력해 주세요");
        String winningNumbers = Console.readLine();

        inputValidator.validateWinningNumber(winningNumbers);

        return winningNumbers;
    }

    public int enterBonusNumber() {
        System.out.println();
        System.out.println("보너스 번호를 입력해 주세요.");
        String bonusNumber = Console.readLine();

        inputValidator.validateBonusNumber(bonusNumber);

        return Integer.parseInt(bonusNumber);
    }

}
