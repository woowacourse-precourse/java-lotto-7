package lotto.view;

import camp.nextstep.edu.missionutils.Console;
import lotto.model.Lotto;

import java.util.Arrays;
import java.util.stream.Collectors;

public class InputView {
    private static final String PROMPT_PURCHASE_AMOUNT = "구입금액을 입력해 주세요.";
    private static final String PROMPT_WINNING_NUMBERS = "당첨 번호를 입력해 주세요.";
    private static final String PROMPT_BONUS_NUMBER = "보너스 번호를 입력해 주세요.";
    private static final String ERROR_INVALID_NUMBER = "[ERROR] 유효한 숫자를 입력해 주세요.";

    public int inputPurchaseAmount() {
        System.out.println(PROMPT_PURCHASE_AMOUNT);

        try {
            return Integer.parseInt(Console.readLine());
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException(ERROR_INVALID_NUMBER);
        }
    }

    public Lotto inputWinningNumbers() {
        System.out.println(PROMPT_WINNING_NUMBERS);

        try {
            return new Lotto(
                    Arrays.stream(Console.readLine().split(","))
                            .map(String::trim)
                            .map(Integer::parseInt)
                            .collect(Collectors.toList())
            );
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException(ERROR_INVALID_NUMBER);
        }
    }

    public int inputBonusNumber() {
        System.out.println(PROMPT_BONUS_NUMBER);
        try {
            return Integer.parseInt(Console.readLine());
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException(ERROR_INVALID_NUMBER);
        }
    }
}
