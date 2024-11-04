package lotto.view;

import static lotto.constant.Constant.DELIMITER;

import camp.nextstep.edu.missionutils.Console;
import java.util.Arrays;
import java.util.List;
import lotto.exception.ExceptionCode;
import lotto.exception.LottoException;

public class InputView {

    private static final String MONEY_INPUT_VIEW = "구입금액을 입력해 주세요.";

    private static final String WINNING_NUMBERS_INPUT_VIEW = "당첨 번호를 입력해 주세요.";

    private static final String BONUS_NUMBER_INPUT_VIEW = "보너스 번호를 입력해 주세요.";

    public static int readMoney() {
        System.out.println(MONEY_INPUT_VIEW);
        try {
            int input = Integer.parseInt(Console.readLine().trim());
            return input;
        } catch (IllegalArgumentException e) {
            throw new LottoException(ExceptionCode.INVALID_NUMBER_FORMAT);
        }
    }

    public static List<Integer> readWinningNumbers() {
        System.out.println(WINNING_NUMBERS_INPUT_VIEW);
        String input = Console.readLine().trim();
        List<String> inputInString = Arrays.stream(input.split(DELIMITER))
                .map(String::trim)
                .filter(s -> !s.isEmpty())
                .toList();

        try {
          List<Integer> winningNumbers = inputInString.stream()
                  .map(Integer::parseInt)
                  .toList();
          return winningNumbers;
        } catch (IllegalArgumentException e) {
            throw new LottoException(ExceptionCode.INVALID_NUMBER_FORMAT);
        }
    }

    public static int readBonusNumber() {
        System.out.println(BONUS_NUMBER_INPUT_VIEW);
        try {
            int input = Integer.parseInt(Console.readLine().trim());
            return input;
        } catch (IllegalArgumentException e) {
            throw new LottoException(ExceptionCode.INVALID_NUMBER_FORMAT);
        }
    }
}
