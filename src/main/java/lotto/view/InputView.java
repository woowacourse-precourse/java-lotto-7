package lotto.view;

import java.util.regex.Pattern;

import static camp.nextstep.edu.missionutils.Console.readLine;

public class InputView {

    private static final Pattern NUMERIC_PATTERN = Pattern.compile("\\d+");

    public static int inputPurchaseAmount() {
        System.out.println("구입금액을 입력해 주세요.");
        String amount = readLine();
        addBlankLine();
        validate(amount);
        return Integer.parseInt(amount);
    }

    static void validate(String amount) {
        if (!NUMERIC_PATTERN.matcher(amount).matches()) {
            throw new IllegalArgumentException("[ERROR] 구입금액은 숫자로 입력해야 합니다.");
        }
        if (Integer.parseInt(amount) % 1000 != 0) {
            throw new IllegalArgumentException("[ERROR] 구입금액은 1000원 단위로 입력해야 합니다.");
        }
    }

    private static void addBlankLine() {
        System.out.println();
    }
}
