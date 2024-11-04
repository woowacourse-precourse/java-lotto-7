package lotto;

import java.util.Arrays;
import java.util.List;

import static camp.nextstep.edu.missionutils.Console.readLine;

public class Input {
    private static final String PURCHASE_AMOUNT_PROMPT = "구입금액을 입력해 주세요.";
    private static final String WINNING_NUMBERS_PROMPT = "\n당첨 번호를 입력해 주세요.";
    private static final String BONUS_NUMBER_PROMPT = "\n보너스 번호를 입력해 주세요.";
    private static final String INVALID_PURCHASE_AMOUNT_MESSAGE = "구입금액은 숫자로 입력해주세요";
    private static final String INVALID_WINNING_NUMBERS_MESSAGE = "1,2,3,4,5,6 형식으로 입력해주세요";
    private static final String INVALID_BONUS_NUMBER_MESSAGE = "보너스 번호는 숫자로 입력해주세요";

    public int askPurchaseAmount() {
        try {
            System.out.println(PURCHASE_AMOUNT_PROMPT);
            return Integer.parseInt(readLine());
        } catch (IllegalArgumentException e) {
            throw new IllegalArgumentException(INVALID_PURCHASE_AMOUNT_MESSAGE);
        }
    }

    public List<Integer> askWinningNumbers() {
        try {
            System.out.println(WINNING_NUMBERS_PROMPT);
            return Arrays.stream(readLine().split(","))
                    .map(Integer::parseInt).sorted().toList();
        } catch (IllegalArgumentException e) {
            throw new IllegalArgumentException(INVALID_WINNING_NUMBERS_MESSAGE);
        }
    }

    public int askBonusNumber() {
        try {
            System.out.println(BONUS_NUMBER_PROMPT);
            return Integer.parseInt(readLine());
        } catch (IllegalArgumentException e) {
            throw new IllegalArgumentException(INVALID_BONUS_NUMBER_MESSAGE);
        }
    }
}
