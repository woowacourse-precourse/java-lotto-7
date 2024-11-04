package lotto.view;

import camp.nextstep.edu.missionutils.Console;
import java.util.List;

public class InputView {

    final InputValidator inputValidator = new InputValidator();

    public int getPayment() {
        while (true) {
            try {
                System.out.println("구입금액을 입력해 주세요.");
                return inputValidator.getValidPurchasedLottoAmount(Console.readLine());
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }
    }

    public List<Integer> getWinningNumbers() {
        while (true) {
            try {
                System.out.println("당첨 번호를 입력해 주세요.");
                return inputValidator.getValidWinningNumbers(Console.readLine());
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }
    }

    public int getBonusNumber(List<Integer> winningNumber) {
        while (true) {
            try {
                System.out.println("보너스 번호를 입력해 주세요.");
                return inputValidator.getValidBonusNumber(Console.readLine(), winningNumber);
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }
    }
}
