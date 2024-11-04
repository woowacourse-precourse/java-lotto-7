package lotto.view;

import camp.nextstep.edu.missionutils.Console;
import java.util.Arrays;
import java.util.List;
import lotto.util.RetryUtil;

public class InputView {
    public static final String LINE_SEPARATOR = System.lineSeparator();
    public static final String COMMA = ",";
    public static final Integer LOTTO_SIZE = 6;
    public static final Integer LOTTO_UNIT_PRICE = 1000;

    public static List<String> parseWithDelimiter(String userInput, String delimiter) {
        return Arrays.stream(userInput.split(delimiter, -1))
                .toList();
    }

    public Integer scanPrice() {
        return (Integer) RetryUtil.retryUntilSuccess(() -> {
            System.out.print("구입금액을 입력해 주세요." + LINE_SEPARATOR);
            String input = Console.readLine();
            validatePrice(input);
            return Integer.parseInt(input);
        });
    }

    private void validatePrice(String input) {
        validateInteger(input);
        Integer price = Integer.parseInt(input);
        validateUnit(price);
    }

    private void validateInteger(String input) {
        try {
            Integer.parseInt(input);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("정수를 입력해주세요.");
        }
    }

    private void validateUnit(Integer price) {
        if (price % LOTTO_UNIT_PRICE != 0) {
            throw new IllegalArgumentException("구입금액은 1000원 단위로 입력해주세요.");
        }
    }

    public List<Integer> scanWinningLotto() {
        return (List<Integer>) RetryUtil.retryUntilSuccess(() -> {
            System.out.print("당첨 번호를 입력해 주세요." + LINE_SEPARATOR);
            String input = Console.readLine();
            validateWinningLotto(input);
            return parseWithDelimiter(input, COMMA)
                    .stream().mapToInt(Integer::parseInt)
                    .boxed()
                    .toList();
        });
    }

    private void validateWinningLotto(String input) {
        List<String> parsed = parseWithDelimiter(input, COMMA);
        validateSize(parsed);
        validateInteger(parsed);
    }

    private void validateSize(List<String> target) {
        if (target.size() != InputView.LOTTO_SIZE) {
            throw new IllegalArgumentException("당첨 번호의 개수는 6개여야 합니다.");
        }
    }

    private void validateInteger(List<String> target) {
        try {
            for (String maybeInteger : target) {
                Integer.parseInt(maybeInteger);
            }
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("당첨 번호는 정수여야 합니다.");
        }
    }


}
