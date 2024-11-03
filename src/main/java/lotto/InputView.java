package lotto;

import camp.nextstep.edu.missionutils.Console;

public class InputView {

    private final InputValidator inputValidator;

    public InputView(InputValidator inputValidator) {
        this.inputValidator = inputValidator;
    }

    public int buyLotto() {
        System.out.println("구입금액을 입력해 주세요.");
        int amount = Integer.parseInt(Console.readLine());

        inputValidator.validateBuyLotto(amount);

        return amount;
    }

    public String enterWinningNumber() {
        System.out.println("당첨 번호를 입력해 주세요");
        String winningNumbers = Console.readLine();

        inputValidator.validateWinningNumber(winningNumbers);

        return winningNumbers;
    }

}
