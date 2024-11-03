package lotto;

import camp.nextstep.edu.missionutils.test.NsTest;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.regex.Pattern;
import java.util.stream.Collectors;
import java.util.stream.Stream;
import lotto.enums.LottoConfig;
import lotto.enums.LottoError;
import org.junit.jupiter.api.Test;

import java.util.List;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.EmptySource;
import org.junit.jupiter.params.provider.ValueSource;

import static camp.nextstep.edu.missionutils.test.Assertions.assertRandomUniqueNumbersInRangeTest;
import static camp.nextstep.edu.missionutils.test.Assertions.assertSimpleTest;
import static org.assertj.core.api.Assertions.assertThat;

class ApplicationTest extends NsTest {
    private static final String LOTTO_PURCHASE_PRICE_REQUEST_MESSAGE = "구입금액을 입력해 주세요.";
    private static final String GENERATED_LOTTO_COUNT_MESSAGE = "%d개를 구매했습니다.";
    private static final String GENERATED_LOTTO_NUMBERS_MESSAGE = "[%s]";
    private static final String GENERATED_LOTTO_NUMBERS_DELIMITER = ", ";
    private static final String LOTTO_WINNING_NUMBERS_REQUEST_MESSAGE = "당첨 번호를 입력해 주세요.";
    private static final String LOTTO_BONUS_NUMBER_REQUEST_MESSAGE = "보너스 번호를 입력해 주세요.";
    private static final String LOTTO_RESULT_MESSAGE = "당첨 통계\n---";
    private static final String LOTTO_PROFIT_RATE_MESSAGE = "총 수익률은 %.1f%%입니다.";
    private static final String LOTTO_OUTPUT_BRAKET_LEFT = "[";
    private static final String LOTTO_OUTPUT_BRAKET_RIGHT = "]";
    private final LottoConfig CONFIG = LottoConfig.WOOWA_CONFIG;

    @Test
    void 기능_테스트() {
        assertRandomUniqueNumbersInRangeTest(
                () -> {
                    run("8000", "1,2,3,4,5,6", "7");
                    assertThat(output()).contains(
                            "8개를 구매했습니다.",
                            "[8, 21, 23, 41, 42, 43]",
                            "[3, 5, 11, 16, 32, 38]",
                            "[7, 11, 16, 35, 36, 44]",
                            "[1, 8, 11, 31, 41, 42]",
                            "[13, 14, 16, 38, 42, 45]",
                            "[7, 11, 30, 40, 42, 43]",
                            "[2, 13, 22, 32, 38, 45]",
                            "[1, 3, 5, 14, 22, 45]",
                            "3개 일치 (5,000원) - 1개",
                            "4개 일치 (50,000원) - 0개",
                            "5개 일치 (1,500,000원) - 0개",
                            "5개 일치, 보너스 볼 일치 (30,000,000원) - 0개",
                            "6개 일치 (2,000,000,000원) - 0개",
                            "총 수익률은 62.5%입니다."
                    );
                },
                List.of(8, 21, 23, 41, 42, 43),
                List.of(3, 5, 11, 16, 32, 38),
                List.of(7, 11, 16, 35, 36, 44),
                List.of(1, 8, 11, 31, 41, 42),
                List.of(13, 14, 16, 38, 42, 45),
                List.of(7, 11, 30, 40, 42, 43),
                List.of(2, 13, 22, 32, 38, 45),
                List.of(1, 3, 5, 14, 22, 45)
        );
    }

    @Test
    void 예외_테스트() {
        assertSimpleTest(() -> {
            runException("1000j");
            assertThat(output()).contains(LottoError.INPUT_NUMBER_INVALID.getMessage());
        });
    }

    @Test
    void 로또_게임_요청_출력_테스트() {
        int purchasePrice = 1000;
        int lottoCount = purchasePrice / CONFIG.getLottoPrice();
        List<Integer> randomNumbers = List.of(8, 9, 10, 11, 12, 13);
        String lottoState = numbersToString(randomNumbers);
        double profitRate = 0.0;

        assertRandomUniqueNumbersInRangeTest(() -> {
            run(String.valueOf(purchasePrice), "1,2,3,4,5,6", "7");

            assertThat(output())
                    .contains(LOTTO_PURCHASE_PRICE_REQUEST_MESSAGE)
                    .contains(String.format(GENERATED_LOTTO_COUNT_MESSAGE, lottoCount))
                    .contains(String.format(GENERATED_LOTTO_NUMBERS_MESSAGE, lottoState))
                    .contains(LOTTO_WINNING_NUMBERS_REQUEST_MESSAGE)
                    .contains(LOTTO_BONUS_NUMBER_REQUEST_MESSAGE)
                    .contains(LOTTO_RESULT_MESSAGE)
                    .contains(String.format(LOTTO_PROFIT_RATE_MESSAGE, profitRate));
        }, randomNumbers);
    }

    @ParameterizedTest
    @ValueSource(strings = {"0", "1000000000", "1001", "1000,", ",1000"})
    void 로또_구입_금액_입력_예외_테스트(String purchasePrice) {
        assertSimpleTest(() -> {
            runException(purchasePrice);
            assertThat(output()).containsPattern(LottoError.getErrorMessageFormat());
        });
    }

    @Test
    void 로또_구입_금액_입력_재시도_테스트() {
        String[] purchasePrices = new String[]{"10001", "12345", "10999", "9999", "5555"};
        int expectedCount = LottoError.LOTTO_PURCHASE_PRICE_NOT_DIVISIBLE.getMessage().length() * purchasePrices.length;

        assertSimpleTest(() -> {
            runException(purchasePrices);
            String output = output();
            String removeErrorMessage = output.replace(LottoError.LOTTO_PURCHASE_PRICE_NOT_DIVISIBLE.getMessage(), "");
            int actualCount = output.length() - removeErrorMessage.length();

            assertThat(actualCount).isEqualTo(expectedCount);
        });
    }

    @ParameterizedTest
    @ValueSource(strings = {"1000", "10000", "1000000", "10000000", "100000000"})
    void 로또_구입_금액_입력_테스트(String purchasePrice) {
        String winningNumbers = "1,2,3,4,5,6";
        String bonusNumber = "45";

        assertSimpleTest(() -> {
            run(purchasePrice, winningNumbers, bonusNumber);
        });
    }

    @ParameterizedTest
    @ValueSource(ints = {1000, 2000, 100000, 1000000, 10000000, 100000000})
    void 구입된_로또_개수_출력_테스트(int purchasePrice) {
        int expectedLottoCount = purchasePrice / CONFIG.getLottoPrice();

        assertSimpleTest(() -> {
            runException(String.valueOf(purchasePrice));

            assertThat(output())
                    .contains(String.format(GENERATED_LOTTO_COUNT_MESSAGE, expectedLottoCount));
        });
    }

    @ParameterizedTest
    @ValueSource(ints = {1000, 2000, 100000, 1000000, 10000000, 100000000})
    void 구입된_로또_출력_테스트(int purchasePrice) {
        int lottoCount = purchasePrice / CONFIG.getLottoPrice();
        int expectedCount = (LOTTO_OUTPUT_BRAKET_LEFT.length() + LOTTO_OUTPUT_BRAKET_RIGHT.length()) * lottoCount;

        assertSimpleTest(() -> {
            runException(String.valueOf(purchasePrice));

            String output = output();
            String removeBraket = output
                    .replace(LOTTO_OUTPUT_BRAKET_LEFT, "")
                    .replace(LOTTO_OUTPUT_BRAKET_RIGHT, "");
            int actualCount = (output.length() - removeBraket.length());
            System.out.println(removeBraket);

            assertThat(actualCount).isEqualTo(expectedCount);

        });
    }

    @ParameterizedTest
    @ValueSource(strings = {"1,2,3,4,5,6,7", "1,2,3,4,5,6,", ",1,2,3,4,5,6", ",1,2,3,4,5,6,", "1,1,2,3,4,5"})
    void 당첨_번호_입력_예외_테스트(String winningNumbers) {
        String purchasePrice = "1000";

        assertSimpleTest(() -> {
            runException(purchasePrice, winningNumbers);

            assertThat(output()).containsPattern(LottoError.getErrorMessageFormat());
        });
    }

    @Test
    void 당첨번호_입력_재시도_테스트() {
        String[] input = new String[]{"1000", "1,2,3,4,5,6,7", "1,2,3,4,5,6,7", "1,2,3,4,5,6,7"};
        int expectedCount = LottoError.LOTTO_NUMBERS_COUNT.getMessage().length() * (input.length - 1);

        assertSimpleTest(() -> {
            runException(input);
            String output = output();
            String removeErrorMessage = output.replace(LottoError.LOTTO_NUMBERS_COUNT.getMessage(), "");
            int actualCount = output.length() - removeErrorMessage.length();

            assertThat(actualCount).isEqualTo(expectedCount);
        });
    }

    @ParameterizedTest
    @ValueSource(strings = {"1,2,3,4,5,6", "7,8,9,10,11,12", "13,14,15,16,17,18", "19,20,21,22,23,24"})
    void 당첨번호_입력_테스트(String winningNumbers) {
        String purchasePrice = "1000";
        String bonusNumber = "45";

        assertSimpleTest(() -> {
            run(purchasePrice, winningNumbers, bonusNumber);
        });
    }

    @ParameterizedTest
    @ValueSource(strings = {"1,", ",1", ",1,", "0", "46", "2"})
    void 보너스번호_입력_예외_테스트(String bonusNumber) {
        String purchasePrice = "1000";
        String winningNumbers = "2,3,4,5,6,7";

        assertSimpleTest(() -> {
            runException(purchasePrice, winningNumbers, bonusNumber);

            assertThat(output()).containsPattern(LottoError.getErrorMessageFormat());
        });
    }

    @ParameterizedTest
    @ValueSource(strings = {"1", "2", "44", "45"})
    void 보너스번호_입력_테스트(String bonusNumber) {
        String purchasePrice = "1000";
        String winningNumbers = "3,4,5,6,7,8";

        assertSimpleTest(() -> {
            run(purchasePrice, winningNumbers, bonusNumber);
        });
    }

    private String numbersToString(List<Integer> numbers) {
        return numbers.stream()
                .map(String::valueOf).collect(Collectors.joining(GENERATED_LOTTO_NUMBERS_DELIMITER));
    }

    @Override
    public void runMain() {
        Application.main(new String[]{});
    }
}
