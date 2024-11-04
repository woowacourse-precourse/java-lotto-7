package lotto;

import java.util.Arrays;
import java.util.List;

import static camp.nextstep.edu.missionutils.Console.readLine;

public class Input {
    private static final String PURCHASE_AMOUNT_PROMPT = "구입금액을 입력해 주세요.";
    private static final String INVALID_PURCHASE_AMOUNT_MESSAGE = "구입금액은 숫자로 입력해주세요";

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
            System.out.println("\n당첨 번호를 입력해 주세요.");
            return Arrays.stream(readLine().split(","))
                    .map(Integer::parseInt).sorted().toList();
        } catch (IllegalArgumentException e) {
            throw new IllegalArgumentException("1,2,3,4,5,6 형식으로 입력해주세요");
        }
    }

    public int askBonusNumber() {
        try {
            System.out.println("\n보너스 번호를 입력해 주세요.");
            return Integer.parseInt(readLine());
        } catch (IllegalArgumentException e) {
            throw new IllegalArgumentException("보너스 번호는 숫자로 입력해주세요");
        }
    }
}
