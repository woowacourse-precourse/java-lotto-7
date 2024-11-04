package lotto;

import camp.nextstep.edu.missionutils.Console;
import java.util.Arrays;
import java.util.List;
import java.util.regex.Pattern;

public class InputView {

    private final static Pattern NUMBER_ONLY_PATTERN = Pattern.compile("\\d+");
    private final static Pattern LOTTO_NUMBERS_FORMAT = Pattern.compile("\\d+,\\d+,\\d+,\\d+,\\d+,\\d+");
    private final static String LOTTO_NUMBERS_DELIMITER = ",";
    private final static String PROMPT_PURCHASE_AMOUNT = "구입 금액을 입력해 주세요.";
    private final static String PROMPT_WINNING_NUMBERS = "당첨 번호를 입력해 주세요.";
    private final static String PROMPT_BONUS_NUMBER = "보너스 번호를 입력해 주세요.";
    private final static String NUMBER_INPUT_EXCEPTION_MESSAGE = "숫자를 입력하셔야 합니다";
    private final static String LOTTO_FORMAT_EXCEPTION_MESSAGE = "로또 입력 형식과 맞지 않습니다";

    public long readPurchaseAmount() {
        System.out.println(PROMPT_PURCHASE_AMOUNT);
        String input = Console.readLine();
        validateNumber(input);
        return Long.parseLong(input);
    }

    public List<Integer> readWinningNumbers() {
        System.out.println(PROMPT_WINNING_NUMBERS);
        String input = Console.readLine();
        validateLottoNumbersFormat(input);
        return Arrays.stream(input.split(LOTTO_NUMBERS_DELIMITER))
                .map(Integer::parseInt)
                .toList();
    }

    public int readBonusNumber() {
        System.out.println(PROMPT_BONUS_NUMBER);
        String input = Console.readLine();
        validateNumber(input);
        return Integer.parseInt(input);
    }

    private void validateNumber(String input) {
        if (!NUMBER_ONLY_PATTERN.matcher(input).matches()) {
            throw new IllegalArgumentException(NUMBER_INPUT_EXCEPTION_MESSAGE);
        }
    }

    private void validateLottoNumbersFormat(String input) {
        if (!LOTTO_NUMBERS_FORMAT.matcher(input).matches()) {
            throw new IllegalArgumentException(LOTTO_FORMAT_EXCEPTION_MESSAGE);
        }
    }
}
