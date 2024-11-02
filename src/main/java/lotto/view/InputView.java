package lotto.view;

import camp.nextstep.edu.missionutils.Console;
import java.util.List;
import lotto.Lotto;
import lotto.LottoGame;
import lotto.Validator;

public class InputView {
    public static int scanPurchasePrice() {
        while (true) {
            System.out.println("구입금액을 입력해 주세요.");
            try {
                String purchasePriceInput = Console.readLine();
                return Validator.validatePurchasePrice(purchasePriceInput);
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }
    }

    public static Lotto scanWinningNumbers() {
        while (true) {
            System.out.println("\n당첨 번호를 입력해 주세요.");
            try{
                String[] winningNumbersInput = Console.readLine().split(",");
                Validator.validateWinningNumber(winningNumbersInput);
                List<Integer> winningNumbers = LottoGame.getWinningNumbers(winningNumbersInput);

                return new Lotto(winningNumbers);
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }
    }

    public static int scanBonusNumber(Lotto winningNumbers) {
        while (true) {
            System.out.println("\n보너스 번호를 입력해 주세요.");
            try{
                String bonusNumberInput = Console.readLine();
                return Validator.validateBonusNumber(bonusNumberInput, winningNumbers);
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }
    }
}
