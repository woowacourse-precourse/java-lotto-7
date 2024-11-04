package lotto.view;

import camp.nextstep.edu.missionutils.Console;
import java.util.Arrays;
import java.util.List;
import lotto.validator.LottoValidator;
import lotto.validator.MoneyValidator;

public class InputView {

    public static int getPurchaseAmount() {
        while (true) {
            try {
                System.out.println("구입 금액을 입력해 주세요.");
                String input = Console.readLine();
                MoneyValidator.validate(input);
                return Integer.parseInt(input);
            } catch (IllegalArgumentException e) {
                // 에러 메시지 출력은 이미 Validator에서 처리
            }
        }
    }

    public static List<Integer> getWinningNumbers() {
        while (true) {
            try {
                System.out.println("당첨 번호를 입력해 주세요.");
                String input = Console.readLine();
                List<Integer> winningNumbers = Arrays.stream(input.split(","))
                        .map(String::trim)
                        .map(Integer::parseInt)
                        .toList();
                LottoValidator.validateWinningNumbers(winningNumbers);
                return winningNumbers;
            } catch (IllegalArgumentException e) {
                // 에러 메시지 출력은 이미 Validator에서 처리
            }
        }
    }

    public static int getBonusNumber() {
        while (true) {
            try {
                System.out.println("보너스 번호를 입력해 주세요.");
                int bonusNumber = Integer.parseInt(Console.readLine().trim());
                return bonusNumber;
            } catch (IllegalArgumentException e) {
                System.out.println("[ERROR] 유효한 숫자를 입력해 주세요."); // 예외 발생 시 재입력 유도
            }
        }
    }
}
