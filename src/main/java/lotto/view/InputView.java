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

    // 구입금액 입력
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

    // 당청 번호 입력
    public LottoDto scanWinningLotto() {
        return (LottoDto) RetryUtil.retryUntilSuccess(() -> {
            System.out.print("당첨 번호를 입력해 주세요." + LINE_SEPARATOR);
            String input = Console.readLine();
            validateWinningLotto(input);
            return new LottoDto(parseWithDelimiter(input, COMMA).stream()
                    .mapToInt(Integer::parseInt)
                    .boxed()
                    .toList());
        });
    }

    private void validateWinningLotto(String input) {
        List<String> parsed = parseWithDelimiter(input, COMMA);
        validateSize(parsed);
        validateInteger(parsed);
        validateRange(parsed.stream()
                .mapToInt(Integer::parseInt)
                .boxed()
                .toList());
    }

    private void validateRange(List<Integer> parsed) {
        for (Integer i : parsed) {
            validateRange(i);
        }
    }

    private void validateRange(Integer target) {
        if (!(1 <= target && target <= 45)) {
            throw new IllegalArgumentException("로또 번호의 범위는 1~45여야 합니다.");
        }
    }

    private void validateSize(List<String> target) {
        if (target.size() != LOTTO_SIZE) {
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

    // 보너스 번호 입력
    public Integer scanBonusNumber(LottoDto winningLotto) {
        return (Integer) RetryUtil.retryUntilSuccess(() -> {
            System.out.print("보너스 번호를 입력해 주세요." + LINE_SEPARATOR);
            String input = Console.readLine();
            validateBonusNumber(input, winningLotto);
            return Integer.parseInt(input);
        });
    }

    private void validateBonusNumber(String target, LottoDto winningLotto) {
        validateInteger(target);
        int bonusNumber = Integer.parseInt(target);
        validateRange(bonusNumber);
        validateDuplication(bonusNumber, winningLotto);
    }

    private void validateDuplication(int bonusNumber, LottoDto winningLotto) {
        if (winningLotto.getNumbers().contains(bonusNumber)) {
            throw new IllegalArgumentException("당첨 번호에 이미 포함된 번호입니다. 중복되지 않게 입력해주세요.");
        }
    }
}
