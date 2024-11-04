package lotto.ui;

import camp.nextstep.edu.missionutils.Console;
import lotto.domain.LottoPurchaseMoney;
import lotto.domain.WinningLotto;

public class InputHandler {

    public static LottoPurchaseMoney getPurchaseAmount() {
        try {
            System.out.println("구입 금액을 입력해 주세요.");
            String input = Console.readLine();
            validateInputIsNotEmpty(input);
            validateInputIsNumeric(input);
            return new LottoPurchaseMoney(input);
        } catch (IllegalArgumentException e) {
            return getPurchaseAmount();  // 잘못된 입력일 경우 재입력 받기
        }
    }

    public static WinningLotto getWinningLotto() {
        try {
            System.out.println("당첨 번호를 입력해 주세요.");
            String winningNumbersInput = Console.readLine();
            validateInputIsNotEmpty(winningNumbersInput);

            System.out.println("보너스 번호를 입력해 주세요.");
            String bonusNumberInput = Console.readLine();
            validateInputIsNotEmpty(bonusNumberInput);
            validateInputIsNumeric(bonusNumberInput);

            return new WinningLotto(winningNumbersInput, bonusNumberInput);
        } catch (IllegalArgumentException e) {
            return getWinningLotto();
        }
    }

    private static void validateInputIsNotEmpty(String input) {
        if (input == null || input.trim().isEmpty()) {
            throw new IllegalArgumentException("[ERROR] 입력값은 공백일 수 없습니다.");
        }
    }

    private static void validateInputIsNumeric(String input) {
        try {
            Long.parseLong(input);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("[ERROR] 입력값은 숫자여야 합니다.");
        }
    }
}
