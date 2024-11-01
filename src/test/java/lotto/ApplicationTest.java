package lotto;

import camp.nextstep.edu.missionutils.test.NsTest;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.List;

import static camp.nextstep.edu.missionutils.test.Assertions.assertRandomUniqueNumbersInRangeTest;
import static camp.nextstep.edu.missionutils.test.Assertions.assertSimpleTest;
import static org.assertj.core.api.Assertions.assertThat;

class ApplicationTest extends NsTest {
    private static final String ERROR_MESSAGE = "[ERROR]";

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

    @Nested
    class IsValidPurchaseAmountTest {

        @ParameterizedTest
        @ValueSource(strings = {"\n", "  "})
        void 구입_금액이_빈_값(String purchaseAmount) {
            assertThat(Application.isValidPurchaseAmount(purchaseAmount)).isFalse();
        }

        @ParameterizedTest
        @ValueSource(strings = {"-1000", "10.6", "1000*", "100+200", "$$$"})
        void 구입_금액에_양의_정수가_아닌_값_입력(String purchaseAmount) {
            assertThat(Application.isValidPurchaseAmount(purchaseAmount)).isFalse();
        }

        @ParameterizedTest
        @ValueSource(strings = {"300", "0"})
        void 구입_금액이_1000원_보다_작은_값(String purchaseAmount) {
            assertThat(Application.isValidPurchaseAmount(purchaseAmount)).isFalse();
        }

        @Test
        void 구입_금액이_1000원으로_나누어_떨어지지_않는_경우() {
            String purchaseAmount = "1300";
            assertThat(Application.isValidPurchaseAmount(purchaseAmount)).isFalse();
        }

        @ParameterizedTest
        @ValueSource(strings = {" 1000", " 10000 ", " 10000 ", "1000   ", "   1000"})
        void 구입_금액_앞뒤_공백_있는_경우(String purchaseAmount) {
            assertThat(Application.isValidPurchaseAmount(purchaseAmount)).isTrue();
        }

        @Test
        void 구입_금액_내_공백이_있는_경우() {
            String purchaseAmount = "100 0";
            assertThat(Application.isValidPurchaseAmount(purchaseAmount)).isFalse();
        }

        @Test
        void 예외_테스트_구입_금액이_빈_값() {
            assertSimpleTest(() -> {
                runException("\n");
                assertThat(output()).contains(ERROR_MESSAGE);
            });

            assertSimpleTest(() -> {
                runException("  ");
                assertThat(output()).contains(ERROR_MESSAGE);
            });
        }

        @Test
        void 예외_테스트_구입_금액이_유효하지_않은_경우() {
            assertSimpleTest(() -> {
                runException("1000j");
                assertThat(output()).contains(ERROR_MESSAGE);
            });

            assertSimpleTest(() -> {
                runException("-2000");
                assertThat(output()).contains(ERROR_MESSAGE);
            });

            assertSimpleTest(() -> {
                runException("##");
                assertThat(output()).contains(ERROR_MESSAGE);
            });
        }
    }

    @ParameterizedTest
    @ValueSource(strings = {"1,2,3,4,5,6,7", "1,2,3,4", "1", "1,2,3,4,5,6,7,8,9"})
    void 당첨_번호_6개_아닌_경우(String winningNumbers) {
        assertThat(Application.isValidwinningNumbers(winningNumbers)).isFalse();
    }

    @ParameterizedTest
    @ValueSource(strings = {"1,2,3,3,3,6", "11,12,11,13,41,45"})
    void 당첨_번호_내_중복된_값_존재(String winningNumbers) {
        assertThat(Application.isValidwinningNumbers(winningNumbers)).isFalse();
    }

    @ParameterizedTest
    @ValueSource(strings = {"0,2,3,11,31,45", "1,12,37,25,41,99", "1,12,1000,25,41,99"})
    void 당첨_번호_허용_범위_외_값이_존재(String winningNumbers) {
        assertThat(Application.isValidwinningNumbers(winningNumbers)).isFalse();
    }

    @ParameterizedTest
    @ValueSource(strings = {"1,2,3.11.31$45", "1*12*37*25**41*45"})
    void 당첨_번호_쉼표_외_구분자_사용(String winningNumbers) {
        assertThat(Application.isValidwinningNumbers(winningNumbers)).isFalse();
    }

    @ParameterizedTest
    @ValueSource(strings = {"1,2,,,3,4,5,6", "11,12,13,18,41,,45"})
    void 당첨_번호_내_쉼표_연속_존재(String winningNumbers) {
        assertThat(Application.isValidwinningNumbers(winningNumbers)).isFalse();
    }

    @ParameterizedTest
    @ValueSource(strings = {",11,12,13,18,41,45", "1,2,3,4,5,6,"})
    void 당첨_번호_쉼표로_시작하거나_끝나는_경우(String winningNumbers) {
        assertThat(Application.isValidwinningNumbers(winningNumbers)).isFalse();
    }

    @ParameterizedTest
    @ValueSource(strings = {"\n", "   "})
    void 당첨_번호가_빈_값_혹은_공백(String winningNumbers) {
        assertThat(Application.isValidwinningNumbers(winningNumbers)).isFalse();
    }

    @ParameterizedTest
    @ValueSource(strings = {"11,1   2,13,18,4   1,45", " 1, 2  2 ,3, 4  2,5,6"})
    void 당첨_번호_내_공백_존재(String winningNumbers) {
        assertThat(Application.isValidwinningNumbers(winningNumbers)).isFalse();
    }

    @ParameterizedTest
    @ValueSource(strings = {" 11,12 , 13 ,18,41 , 45", "   1,2,3,4   ,5,6   "})
    void 당첨_번호_앞뒤_공백_허용_검증(String winningNumbers) {
        assertThat(Application.isValidwinningNumbers(winningNumbers)).isTrue();
    }

    @Override
    public void runMain() {
        Application.main(new String[]{});
    }
}
