package lotto;

import camp.nextstep.edu.missionutils.Console;
import java.util.List;
import lotto.util.Validator;

public class InputHandler {
    public static String handleAmountInput() {
        System.out.println("구입금액을 입력해 주세요.");
        String amountInput = Console.readLine().trim();
        try {
            Validator.validateAmountInput(amountInput);
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
            return handleAmountInput();
        }
        return amountInput;
    }

    public static List<Integer> handleWinningLottoInput() {
        System.out.println("당첨 번호를 입력해 주세요.");
        String[] winningLottoInput = Console.readLine()
                .trim()
                .split(",");

        Validator.validateWinningLottoInput(winningLottoInput);
        List<Integer> winningLotto = Validator.convertWinningLottoInputToIntArray(winningLottoInput);
        Validator.validateWinningLotto(winningLotto);

        return winningLotto;
    }

    public static int handleBonusNumberInput() {
        System.out.println("보너스 번호를 입력해 주세요.");
        String bonusNumberInput = Console.readLine().trim();
        return Validator.validateBonusNumberInput(bonusNumberInput);
    }
}
