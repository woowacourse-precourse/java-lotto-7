package lotto;

import camp.nextstep.edu.missionutils.test.NsTest;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

import java.util.List;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static camp.nextstep.edu.missionutils.test.Assertions.assertRandomUniqueNumbersInRangeTest;
import static camp.nextstep.edu.missionutils.test.Assertions.assertSimpleTest;
import static org.assertj.core.api.Assertions.assertThat;

@SuppressWarnings("NonAsciiCharacters")
class ApplicationTest extends NsTest {

    private static final String ERROR_MESSAGE = "[ERROR]";

    @Test
    void 정상적인_출력을_한다() {
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
    class 로또_구매_예외_테스트를_진행한다 {

        @Test
        void 금액이_공백인_경우_예외가_발생한다() {
            assertSimpleTest(() -> {
                runException(" ");
                assertThat(output()).contains(ERROR_MESSAGE);
            });
        }

        @ParameterizedTest
        @ValueSource(strings = {"a, aaaa, 1000j, ??//"})
        void 금액에_문자가_포함될_경우_예외가_발생한다(String money) {
            assertSimpleTest(() -> {
                runException(money);
                assertThat(output()).contains(ERROR_MESSAGE);
            });
        }

        @ParameterizedTest
        @ValueSource(strings = {"-9000, -1000, 0, 000"})
        void 금액이_음수이거나_0일_경우_예외가_발생한다(String money) {
            assertSimpleTest(() -> {
                runException(money);
                assertThat(output()).contains(ERROR_MESSAGE);
            });
        }

        @ParameterizedTest
        @ValueSource(strings = {"5, 950, 850"})
        void 금액이_천원_단위가_아닌_경우_예외가_발생한다(String money) {
            assertSimpleTest(() -> {
                runException(money);
                assertThat(output()).contains(ERROR_MESSAGE);
            });
        }
    }

    @Nested
    class 당첨_번호_예외_테스트를_진행한다 {

        @ParameterizedTest
        @ValueSource(strings = {"1,2,2,3,4,5", "1,1,2,3,4,5"})
        void 당첨_번호에_중복된_값이_있으면_예외가_발생한다(String winningNumber) {
            assertSimpleTest(() -> {
                runException("8000", winningNumber);
                assertThat(output()).contains(ERROR_MESSAGE);
            });
        }

        @ParameterizedTest
        @ValueSource(strings = {"1,2,3,4,5,a", "1a,2,3,4,5,6"})
        void 당첨_번호에_숫자가_아닌_값이_있으면_예외가_발생한다(String winningNumber) {
            assertSimpleTest(() -> {
                runException("8000", winningNumber);
                assertThat(output()).contains(ERROR_MESSAGE);
            });
        }

        @ParameterizedTest
        @ValueSource(strings = {"1,2,3,4,5", "2,3,4,5,6"})
        void 당첨_번호가_여섯_자리가_아니면_예외가_발생한다(String winningNumber) {
            assertSimpleTest(() -> {
                runException("8000", winningNumber);
                assertThat(output()).contains(ERROR_MESSAGE);
            });
        }

        @ParameterizedTest
        @ValueSource(strings = {"0,1,2,3,4,5", "2,3,4,5,6,46"})
        void 당첨_번호에_범위를_벗어난_숫자가_있으면_예외가_발생한다(String winningNumber) {
            assertSimpleTest(() -> {
                runException("8000", winningNumber);
                assertThat(output()).contains(ERROR_MESSAGE);
            });
        }
    }

    @Nested
    class 보너스_번호_예외_테스트를_진행한다 {

        @ParameterizedTest
        @ValueSource(strings = {"a", "?", "b"})
        void 보너스_번호가_숫자가_아닌_값이면_예외가_발생한다(String bonusNumber) {
            assertSimpleTest(() -> {
                runException("8000", "1,2,3,4,5,6", bonusNumber);
                assertThat(output()).contains(ERROR_MESSAGE);
            });
        }

        @ParameterizedTest
        @ValueSource(strings = {"0", "-1", "46"})
        void 보너스_번호가_범위를_벗어나면_예외가_발생한다(String bonusNumber) {
            assertSimpleTest(() -> {
                runException("8000", "1,2,3,4,5,6", bonusNumber);
                assertThat(output()).contains(ERROR_MESSAGE);
            });
        }

        @ParameterizedTest
        @ValueSource(strings = {"1", "2", "3"})
        void 보너스_번호가_당첨_번호와_중복되면_예외가_발생한다(String bonusNumber) {
            assertSimpleTest(() -> {
                runException("8000", "1,2,3,4,5,6", bonusNumber);
                assertThat(output()).contains(ERROR_MESSAGE);
            });
        }
    }

    @Override
    public void runMain() {
        Application.main(new String[]{});
    }
}
