package lotto.view;

import java.util.List;

import static camp.nextstep.edu.missionutils.Console.readLine;

public class InputView {
    private static final String PURCHASE_AMOUNT_MESSAGE = "구입금액을 입력해 주세요.";
    private static final String WINNING_NUMBERS_MESSAGE = "당첨 번호를 입력해 주세요.";

    private static final int LOTTO_AMOUNT = 1000;

    public int readPurchaseAmount() {
        System.out.println(PURCHASE_AMOUNT_MESSAGE);
        String input = readLine();
        validateNumber(input, "구입금액");

        int amount = Integer.parseInt(input);
        validateDivisible(amount);
        return amount;
    }

    public void readWinningNumbers() {
        System.out.println(WINNING_NUMBERS_MESSAGE);
        String input = readLine();

    }

    private void validateNumber(String input, String fieldName) {
        try {
            Integer.parseInt(input);
        } catch (Exception e) {
            throw new IllegalArgumentException(String.format("[ERROR] %s은(는) 숫자여야 합니다.", fieldName));
        }
    }

    private void validateDivisible(int amount) {
        if (amount % LOTTO_AMOUNT != 0) {
            throw new IllegalArgumentException(String.format("[ERROR] 구입금액은 %d원 단위여야 합니다.", LOTTO_AMOUNT));
        }
    }
}
