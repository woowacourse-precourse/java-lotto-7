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
    private static final String ERROR_MESSAGE = "[ERROR]";

    // 출력
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

    // 입력
    @Nested
    @DisplayName("로또 구매 예외 처리")
    class BuyLottosErrorTest {

        @DisplayName("로또 구매 금액에 숫자가 아닌 값")
        @Test
        void alphabetInInput() {
            assertSimpleTest(() -> {
                runException("1000j");
                assertThat(output()).contains(ERROR_MESSAGE);
            });
        }

        @DisplayName("로또 구매 금액이 음수")
        @Test
        void minusInInput() {
            assertSimpleTest(() -> {
                runException("-1000");
                assertThat(output()).contains(ERROR_MESSAGE);
            });
        }

        @DisplayName("로또 구매 금액 너무 큰 경우1")
        @Test
        void inputTooBig1() {
            assertSimpleTest(() -> {
                runException("30000000000");
                assertThat(output()).contains(ERROR_MESSAGE);
            });
        }

        @DisplayName("로또 구매 금액 너무 큰 경우2")
        @Test
        void inputTooBig2() {
            assertSimpleTest(() -> {
                runException("100000000000");
                assertThat(output()).contains(ERROR_MESSAGE);
            });
        }

        @DisplayName("로또 구매 금액이 1000원 단위가 아닌 경우")
        @Test
        void invalidInput() {
            assertSimpleTest(() -> {
                runException("1234");
                assertThat(output()).contains(ERROR_MESSAGE);
            });
        }
    }

    @Nested
    @DisplayName("로또 당첨 번호 예외 처리")
    class WinningNumberErrorTest {

        @DisplayName("로또 당첨 번호가 중복")
        @Test
        void duplicationOfInput() {
            assertSimpleTest(() -> {
                runException("1000", "1,1,2,3,4,5");
                assertThat(output()).contains(ERROR_MESSAGE);
            });
        }

        @DisplayName("로또 당첨 번호가 너무 큰 값")
        @Test
        void inputIsTooBig() {
            assertSimpleTest(() -> {
                runException("1000", "10000000000,1,2,3,4,5");
                assertThat(output()).contains(ERROR_MESSAGE);
            });
        }

        @DisplayName("로또 당첨 번호에 알파벳")
        @Test
        void invalidInput1() {
            assertSimpleTest(() -> {
                runException("1000", "1,2,a,3,4,5");
                assertThat(output()).contains(ERROR_MESSAGE);
            });
        }

        @DisplayName("로또 당첨 번호에 특수문자")
        @Test
        void invalidInput2() {
            assertSimpleTest(() -> {
                runException("1000", "1,2,(,3,4,5");
                assertThat(output()).contains(ERROR_MESSAGE);
            });
        }

        @DisplayName("로또 당첨 번호에 공백")
        @Test
        void invalidInput3() {
            assertSimpleTest(() -> {
                runException("1000", "1,2,,3,4,5");
                assertThat(output()).contains(ERROR_MESSAGE);
            });
        }

        @DisplayName("로또 당첨 번호에 공백")
        @Test
        void invalidInput4() {
            assertSimpleTest(() -> {
                runException("1000", "1,2,7,3,4,");
                assertThat(output()).contains(ERROR_MESSAGE);
            });
        }


        @DisplayName("로또 당첨 번호가 범위를 벗어남")
        @Test
        void inputOutOfRange1() {
            assertSimpleTest(() -> {
                runException("1000", "1,2,7,3,4,56");
                assertThat(output()).contains(ERROR_MESSAGE);
            });
        }

        @DisplayName("로또 당첨 번호가 범위를 벗어남")
        @Test
        void inputOutOfRange2() {
            assertSimpleTest(() -> {
                runException("1000", "1,2,7,3,4,0");
                assertThat(output()).contains(ERROR_MESSAGE);
            });
        }
    }

    @Nested
    @DisplayName("보너스 번호 예외 처리")
    class BonusNumberErrorTest {

        @DisplayName("보너스 번호가 중복")
        @Test
        void duplicationOfInput() {
            assertSimpleTest(() -> {
                runException("1000", "1,2,3,4,5,6", "1");
                assertThat(output()).contains(ERROR_MESSAGE);
            });
        }

        @DisplayName("보너스 번호가 범위를 벗어남")
        @Test
        void inputOutOfRange1() {
            assertSimpleTest(() -> {
                runException("1000", "1,2,3,4,5,6", "0");
                assertThat(output()).contains(ERROR_MESSAGE);
            });
        }

        @DisplayName("보너스 번호가 범위를 벗어남")
        @Test
        void inputOutOfRange2() {
            assertSimpleTest(() -> {
                runException("1000", "1,2,3,4,5,6", "55");
                assertThat(output()).contains(ERROR_MESSAGE);
            });
        }

        @DisplayName("보너스 번호가 너무 큼")
        @Test
        void inputIsTooBig() {
            assertSimpleTest(() -> {
                runException("1000", "1,2,3,4,5,6", "55000000000000000");
                assertThat(output()).contains(ERROR_MESSAGE);
            });
        }

        @DisplayName("보너스 번호가 숫자가 아님")
        @Test
        void invalidInput1() {
            assertSimpleTest(() -> {
                runException("1000", "1,2,3,4,5,6", "asdf");
                assertThat(output()).contains(ERROR_MESSAGE);
            });
        }

        @DisplayName("보너스 번호가 숫자가 아님")
        @Test
        void invalidInput2() {
            assertSimpleTest(() -> {
                runException("1000", "1,2,3,4,5,6", "10asdf");
                assertThat(output()).contains(ERROR_MESSAGE);
            });
        }
    }

    @Override
    public void runMain() {
        Application.main(new String[]{});
    }
}
