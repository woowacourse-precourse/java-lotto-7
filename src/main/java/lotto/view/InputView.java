package lotto.view;

import camp.nextstep.edu.missionutils.Console;
import lotto.util.ValidationUtil;
import lotto.service.WinningNumberInput;

import java.util.List;


public class InputView {
    public static int getPurchaseAmount() {
        while (true) {
            System.out.println("구입금액을 입력해 주세요.");
            final String input = Console.readLine().trim();

            try {
                return ValidationUtil.validateAmount(input);
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }
    }

    public static List<Integer> getWinningNumbers() {
        while (true) {
            System.out.println("당첨 번호를 입력해 주세요.");
            final String input = Console.readLine().trim();

            try {
                return WinningNumberInput.getWinningNumbers(input);
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }
    }

    public static int getBonusNumber(final List<Integer> winningNumbers) {
        while (true) {
            System.out.println("보너스 번호를 입력해 주세요:");
            final String input = Console.readLine().trim();

            try {
                return WinningNumberInput.getBonusNumber(input, winningNumbers);
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }
    }
}
