package lotto.view;

import camp.nextstep.edu.missionutils.Console;

import java.util.List;

public class InputView {
    public Integer inputAmount() {
        Integer amount;

        System.out.println("구입금액을 입력해 주세요.");

        while (true) {
            try {
                String raw = Console.readLine();
                amount = InputValidator.parseAmount(raw);
                break;
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }

        return amount;
    }

    public List<Integer> inputWinningNumbers() {
        List<Integer> winningNumbers;

        System.out.println("당첨 번호를 입력해 주세요.");

        while (true) {
            try {
                String raw = Console.readLine();
                winningNumbers = InputValidator.parseWinningNumbers(raw);
                break;
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }

        return winningNumbers;
    }

    public Integer inputBonusNUmber() {
        Integer bonusNumber;

        System.out.println("\n보너스 번호를 입력해 주세요.");

        while (true) {
            try {
                String raw = Console.readLine();
                bonusNumber = InputValidator.parseNumber(raw);
                break;
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }

        return bonusNumber;
    }
}
