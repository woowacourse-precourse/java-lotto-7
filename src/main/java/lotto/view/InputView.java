package lotto.view;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class InputView {

    private static final String PURCHASE_AMOUNT_MESSAGE = "구입금액을 입력해 주세요.";
    private static final String WINNING_NUMBER_MESSAGE = "\n당첨 번호를 입력해 주세요.";
    private static final String BONUS_NUMBER_MESSAGE = "\n보너스 번호를 입력해 주세요.";

    private static final Scanner scanner = new Scanner(System.in);

    public long enterPurchaseAmount() {
        System.out.println(PURCHASE_AMOUNT_MESSAGE);
        return Long.parseLong(scanner.nextLine());
    }

    public List<Integer> enterWinningNumber() {
        System.out.println(WINNING_NUMBER_MESSAGE);
        return Arrays.stream(scanner.nextLine().split(","))
                .map(String::trim)
                .map(Integer::parseInt)
                .toList();
    }

    public int enterBonusNumber() {
        System.out.println(BONUS_NUMBER_MESSAGE);
        return Integer.parseInt(scanner.nextLine());
    }
}
