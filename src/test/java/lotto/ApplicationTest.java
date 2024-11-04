package lotto;

import camp.nextstep.edu.missionutils.test.NsTest;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

import java.util.List;

import static camp.nextstep.edu.missionutils.test.Assertions.assertRandomUniqueNumbersInRangeTest;
import static camp.nextstep.edu.missionutils.test.Assertions.assertSimpleTest;
import static org.assertj.core.api.Assertions.assertThat;

class ApplicationTest extends NsTest {
    private static final String ERROR_MESSAGE = "[ERROR] ";
    private static final int LOTTO_PRICE = 1000;
    public static final int LOTTO_NUMBER_SIZE = 6;
    public static final int LOTTO_MAX_RANGE = 45;
    public static final int LOTTO_MIN_RANGE = 1;

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
            assertThat(output()).contains(ERROR_MESSAGE);
        });
    }

    @DisplayName("로또 구매 가격 관련 예외")
    @Nested
    class testPurchasePrice {
        @DisplayName("로또 구매 가격이 빈 값이면 예외 발생")
        @Test
        void emptyException() {
            assertSimpleTest(() -> {
                runException("\n");
                assertThat(output()).contains(ERROR_MESSAGE + "입력 값이 공백 혹은 빈 문자열입니다.");
            });
        }

        @DisplayName("로또 구매 가격이 공백이면 예외 발생")
        @Test
        void blankException() {
            assertSimpleTest(() -> {
                runException(" ");
                assertThat(output()).contains(ERROR_MESSAGE + "입력 값이 공백 혹은 빈 문자열입니다.");
            });
        }

        @DisplayName("로또 구매 가격이 음수이면 예외 발생")
        @Test
        void negativeNumberException() {
            assertSimpleTest(() -> {
                runException("-1000");
                assertThat(output()).contains(ERROR_MESSAGE + "입력 값이 음수이면 안됩니다.");
            });
        }

        @DisplayName("로또 구매 가격이 1000단위가 아니면 예외 발생")
        @Test
        void multiplierExeption() {
            assertSimpleTest(() -> {
                runException("300");
                assertThat(output()).contains(ERROR_MESSAGE + "입력 값은 " + LOTTO_PRICE + " 단위여야 합니다.");
            });
        }

        @DisplayName("로또 구매 가격이 숫자가 아니면 예외 발생")
        @Test
        void nonNumberExeption() {
            assertSimpleTest(() -> {
                runException("somin");
                assertThat(output()).contains(ERROR_MESSAGE + "입력 값이 숫자여야 합니다.");
            });
        }
    }

    @DisplayName("당첨 번호 관련 예외")
    @Nested
    class testWinningNumbers {
        @DisplayName("당첨 번호가 빈 값이면 예외 발생")
        @Test
        void emptyException() {
            assertSimpleTest(() -> {
                runException("8000", "\n");
                assertThat(output()).contains(ERROR_MESSAGE + "입력 값이 공백 혹은 빈 문자열입니다.");
            });
        }

        @DisplayName("당첨 번호가 공백이면 예외 발생")
        @Test
        void blankException() {
            assertSimpleTest(() -> {
                runException("8000", " ");
                assertThat(output()).contains(ERROR_MESSAGE + "입력 값이 공백 혹은 빈 문자열입니다.");
            });
        }
        @DisplayName("당첨 번호가 중복되면 예외 발생")
        @Test
        void duplicateException() {
            assertSimpleTest(() -> {
                runException("8000", "1,2,3,4,5,5");
                assertThat(output()).contains(ERROR_MESSAGE + "중복되는 번호가 있습니다.");
            });
        }

        @DisplayName("당첨 번호가 6개가 아니면 예외 발생")
        @Test
        void countException() {
            assertSimpleTest(() -> {
                runException("8000", "1,2,3,4,5");
                assertThat(output()).contains(ERROR_MESSAGE + "당첨 번호의 개수는 " + LOTTO_NUMBER_SIZE + "개여야 합니다.");
            });
        }

        @DisplayName("당첨 번호가 숫자가 아니면 예외 발생")
        @Test
        void nonNumberExeption() {
            assertSimpleTest(() -> {
                runException("8000", "1,2,d,3,4,5");
                assertThat(output()).contains(ERROR_MESSAGE + "당첨 번호는 숫자여야 합니다.");
            });
        }

        @DisplayName("당첨 번호가 음수이면 예외 발생")
        @Test
        void negativeNumberException() {
            assertSimpleTest(() -> {
                runException("8000", "1,2,-2,3,4,5");
                assertThat(output()).contains(ERROR_MESSAGE + "입력 값이 음수이면 안됩니다.");
            });
        }

        @DisplayName("당첨 번호가 1~45 사이의 숫자가 아니면 예외 발생")
        @Test
        void notInRangeException_max_range() {
            assertSimpleTest(() -> {
                runException("8000", "1,2,3,4,5,46");
                assertThat(output()).contains(ERROR_MESSAGE + "당첨 번호는 " + LOTTO_MIN_RANGE + "~" + LOTTO_MAX_RANGE + " 사이의 숫자여야 합니다.");
            });
        }

        @DisplayName("당첨 번호가 1~45 사이의 숫자가 아니면 예외 발생")
        @Test
        void notInRangeException_min_range() {
            assertSimpleTest(() -> {
                runException("8000", "0,2,3,4,5,6");
                assertThat(output()).contains(ERROR_MESSAGE + "당첨 번호는 " + LOTTO_MIN_RANGE + "~" + LOTTO_MAX_RANGE + " 사이의 숫자여야 합니다.");
            });
        }
    }

    @DisplayName("보너스 번호 관련 예외")
    @Nested
    class testBonusNumber {
        @DisplayName("보너스 번호가 빈 값이면 예외 발생")
        @Test
        void emptyException() {
            assertSimpleTest(() -> {
                runException("8000", "1,2,3,4,5,6", "\n");
                assertThat(output()).contains(ERROR_MESSAGE + "입력 값이 공백 혹은 빈 문자열입니다.");
            });
        }

        @DisplayName("보너스 번호가 공백이면 예외 발생")
        @Test
        void blankException() {
            assertSimpleTest(() -> {
                runException("8000", "1,2,3,4,5,6", " ");
                assertThat(output()).contains(ERROR_MESSAGE + "입력 값이 공백 혹은 빈 문자열입니다.");
            });
        }

        @DisplayName("보너스 번호가 당첨 번호와 중복이면 예외 발생")
        @Test
        void duplicateException() {
            assertSimpleTest(() -> {
                runException("8000", "1,2,3,4,5,6", "1");
                assertThat(output()).contains(ERROR_MESSAGE + "보너스 번호와 중복되는 당첨 번호가 있습니다.");
            });
        }

        @DisplayName("보너스 번호가 음수면 예외 발생")
        @Test
        void negativeNumberException() {
            assertSimpleTest(() -> {
                runException("8000", "1,2,3,4,5,6", "-1");
                assertThat(output()).contains(ERROR_MESSAGE, "입력 값이 음수이면 안됩니다.");
            });
        }

        @DisplayName("보너스 번호가 숫자가 아니면 예외 발생")
        @Test
        void nonNumberExeption() {
            assertSimpleTest(() -> {
                runException("8000", "1,2,3,4,5,6", "d");
                assertThat(output()).contains(ERROR_MESSAGE, "입력 값이 숫자여야 합니다.");
            });
        }

        @DisplayName("보너스 번호가 1~45 사이의 숫자가 아니면 예외 발생")
        @Test
        void notInRangeException_max_range() {
            assertSimpleTest(() -> {
                runException("8000", "1,2,3,4,5,6", "46");
                assertThat(output()).contains(ERROR_MESSAGE + "당첨 번호는 " + LOTTO_MIN_RANGE + "~" + LOTTO_MAX_RANGE + " 사이의 숫자여야 합니다.");
            });
        }

        @DisplayName("보너스 번호가 1~45 사이의 숫자가 아니면 예외 발생")
        @Test
        void notInRangeException_min_range() {
            assertSimpleTest(() -> {
                runException("8000", "1,2,3,4,5,6", "0");
                assertThat(output()).contains(ERROR_MESSAGE + "당첨 번호는 " + LOTTO_MIN_RANGE + "~" + LOTTO_MAX_RANGE + " 사이의 숫자여야 합니다.");
            });
        }
    }

    @Override
    public void runMain() {
        Application.main(new String[]{});
    }
}
