package lotto.utils;

import static camp.nextstep.edu.missionutils.Console.readLine;

import java.util.List;
import java.util.regex.Pattern;

public class InputView {

    private static final Pattern validLottoPurchaseAmountPattern = Pattern.compile("^[1-9][0-9]*000$");


    public static int inputLottoPurchaseAmount() {
        String userInput = readLine();
        validateLottoPurchaseAmount(userInput);

        return Integer.parseInt(userInput);
    }

    private static void validateLottoPurchaseAmount(String userInput) {
        if (!validLottoPurchaseAmountPattern.matcher(userInput).matches()) {
            throw new IllegalArgumentException("[ERROR] 로또 구입 금액은 1000원 단위로 입력 해야합니다.");
        }
    }
}
