package lotto.view;

import static lotto.constants.Constants.LOTTO_NUMBER_COUNT;
import static lotto.validator.LottoNumberValidator.validateRange;

import lotto.validator.PurchaseAmountValidator;

import camp.nextstep.edu.missionutils.Console;
import java.util.ArrayList;
import java.util.List;

public class InputView {
    public static int inputPurchaseAmount() {
        while (true) {
            try {
                System.out.println("구입금액을 입력해 주세요.");
                String input = Console.readLine();
                int amount = Integer.parseInt(input);
                PurchaseAmountValidator.validate(amount);

                return amount;
            } catch (NumberFormatException e) {
                System.out.println("[ERROR] 금액은 숫자로 입력해 주세요.");
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }
    }

    public static List<Integer> inputWinningNumbers() {
        while (true) {
            try {
                System.out.println("당첨 번호를 입력해 주세요.");
                String input = Console.readLine();
                String[] inputs = input.split(",");
                if (inputs.length != LOTTO_NUMBER_COUNT) {
                    throw new IllegalArgumentException("[ERROR] 당첨 번호는 6개여야 합니다.");
                }
                List<Integer> winningNumbers = new ArrayList<>();
                for (String number : inputs) {
                    int num = Integer.parseInt(number.trim());
                    validateRange(num);
                    if (winningNumbers.contains(num)) {
                        throw new IllegalArgumentException("[ERROR] 중복된 번호는 입력할 수 없습니다.");
                    }
                    winningNumbers.add(num);
                }
                return winningNumbers;
            } catch (Exception e) {
                System.out.println(e.getMessage());
            }
        }
    }

    public static int inputBonusNumber() {
        while (true) {
            try {
                System.out.println("보너스 번호를 입력해 주세요.");
                String input = Console.readLine();
                int bonusNumber = Integer.parseInt(input);
                validateRange(bonusNumber);
                return bonusNumber;
            } catch (Exception e) {
                System.out.println(e.getMessage());
            }
        }
    }
}