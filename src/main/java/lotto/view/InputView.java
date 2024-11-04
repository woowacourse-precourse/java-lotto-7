package lotto.view;

import static camp.nextstep.edu.missionutils.Console.readLine;

import java.util.ArrayList;
import java.util.List;

public class InputView {
    private static final String ASK_PURCHASE_AMOUNT = "구입 금액을 입력해 주세요.";
    private static final String ASK_WINNING_NUMBERS = "당첨 번호를 입력해 주세요.";
    private static final String ASK_BONUS_NUMBER = "보너스 번호를 입력해 주세요.";

    public static int getPurchaseAmount() {
        System.out.println(ASK_PURCHASE_AMOUNT);
        return Integer.parseInt(readLine());
    }

    public static List<Integer> getWinningNumbers() {
        System.out.println(ASK_WINNING_NUMBERS);
        return parseWinningNumber(readLine());
    }

    public static int getBonusNumber() {
        System.out.println(ASK_BONUS_NUMBER);
        return Integer.parseInt(readLine());
    }

    private static List<Integer> parseWinningNumber(String input) {
        List<String> splitInput = List.of(input.split(","));
        List<Integer> result = new ArrayList<>();
        for (String str : splitInput) {
            result.add(Integer.parseInt(str.trim()));
        }

        return result;
    }
}
