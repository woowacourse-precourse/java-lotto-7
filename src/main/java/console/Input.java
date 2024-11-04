package console;

import static exception.Exception.BONUS_INPUT;
import static exception.Exception.BONUS_NOT_EXIST_WINNING_NUMBER;
import static exception.Exception.ERROR_PREFIX;
import static exception.Exception.INPUT_UNITS;
import static lotto.Lotto.LOTTO_PRICE;

import camp.nextstep.edu.missionutils.Console;
import exception.Exception;
import java.util.Arrays;
import java.util.List;
import java.util.function.Supplier;
import java.util.stream.Collectors;
import lotto.Lotto;

public class Input {
    public static final String BUY_MSG = "개를 구매했습니다.";
    public static final String INPUT_WINNING_NUMBER = "당첨 번호를 입력해 주세요(콤마로 구분하여 공백없이 작성해주세요)";
    public static final String WINNING_NUMBER_RULE = "1~45사이의 당첨번호를 콤마로 구분하여 입력해주세요.";
    public static final String MATCH = "개 일치";
    public static final String MATCH_BONUS_BALL = ", 보너스 볼 일치";
    public static final String WON = "원";
    public static final String NUMBER = "개";
    private final Exception exception = new Exception();
    private List<Integer> winningNumber;

    public void makeEmptyLine(String message) {
        if (message == null || message.isBlank()) {
            System.out.println();
            return;
        }
        System.out.println(message);
    }

    private <T> T handleRetryOnError(Supplier<T> method) {
        try {
            return method.get();
        } catch (IllegalArgumentException e) {
            makeEmptyLine(e.getMessage());
            makeEmptyLine(null);
            return handleRetryOnError(method);
        }
    }

    private String promptInput(String message) {
        makeEmptyLine(message);
        String input = Console.readLine().trim();
        makeEmptyLine(null);
        return input;
    }

    public long returnLottoCount() {
        return handleRetryOnError(() -> {
            String buyPriceInput = promptInput(INPUT_UNITS);
            long buyPrice = exception.verifyBuyPrice(buyPriceInput);
            long lottoCount = buyPrice / LOTTO_PRICE;
            makeEmptyLine(lottoCount + BUY_MSG);
            return lottoCount;
        });
    }

    public Lotto receiveWiningNumber() {
        return handleRetryOnError(() -> {
            String winingNumberInput = promptInput(INPUT_WINNING_NUMBER);
            List<Integer> winningNumber = changeStrToIntList(winingNumberInput);
            Lotto winningLotto = new Lotto(winningNumber);
            this.winningNumber = winningNumber;
            return winningLotto;
        });
    }

    public int receiveBonusNumber() {
        return handleRetryOnError(() -> {
            String bonusNumberInput = promptInput(BONUS_INPUT);
            int bonusNumber = exception.verifyBonusNumber(bonusNumberInput);
            if (winningNumber.contains(bonusNumber)) {
                exception.throwException(BONUS_NOT_EXIST_WINNING_NUMBER);
            }
            return bonusNumber;
        });
    }

    public List<Integer> changeStrToIntList(String string) {
        try {
            return Arrays.stream(string.split(","))
                    .map(Integer::parseInt)
                    .sorted()
                    .collect(Collectors.toList());
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException(ERROR_PREFIX + WINNING_NUMBER_RULE, e);
        }
    }

}
