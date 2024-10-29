package lotto.view;

import static camp.nextstep.edu.missionutils.Console.readLine;

import java.util.Arrays;
import java.util.List;
import java.util.regex.Pattern;

public class InputView {

    private static final Pattern validLottoPurchaseAmountPattern = Pattern.compile("^[1-9][0-9]*000$");
    private static final Pattern validWonLottoNumbersPattern = Pattern.compile(
            "^([1-9]|[1-3][0-9]|4[0-5])(,([1-9]|[1-3][0-9]|4[0-5])){5}$");

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

    public static String inputWonLottoNumbers() {
        String userInput = readLine();
        validateWonLottoNumbers(userInput);

        return userInput;
    }

    public static List<Integer> parseWonLottoNumbers(String userInput) {
        return Arrays.stream(userInput.split(",")).map(Integer::parseInt).toList();
    }

    private static void validateWonLottoNumbers(String userInput) {
        if (!validWonLottoNumbersPattern.matcher(userInput).matches()) {
            throw new IllegalArgumentException("[ERROR] 로또 번호는 1-45까지 숫자 6개가 쉼표(,)로 구분되어야 합니다.");
        }
    }
}
