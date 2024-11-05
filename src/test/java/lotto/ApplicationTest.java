package lotto;

import camp.nextstep.edu.missionutils.test.NsTest;
import java.util.NoSuchElementException;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static camp.nextstep.edu.missionutils.test.Assertions.assertRandomUniqueNumbersInRangeTest;
import static camp.nextstep.edu.missionutils.test.Assertions.assertSimpleTest;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class ApplicationTest extends NsTest {
    private static final String ERROR_MESSAGE = "[ERROR]";

    @DisplayName("통합 기능 테스트")
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

    @DisplayName("로또 구입금액이 1000원 단위로 나누어 떨어지지 않는 입력이 들어오면 예외가 발생한다.")
    @Test
    void 로또_구입금액이_1000원_단위로_나누어_떨어지지_않는_입력이_들어오면_예외가_발생한다() {
        assertSimpleTest(() -> {
            runException("1100");
            assertThat(output()).contains(ERROR_MESSAGE);
        });
    }

    @DisplayName("로또 구입 금액이 숫자가 아닌 입력이 들어오면 예외가 발생한다.")
    @Test
    void 로또_구입금액이_숫자가_아닌_입력이_들어오면_예외가_발생한다() {
        assertSimpleTest(() -> {
            runException("1000j");
            assertThat(output()).contains(ERROR_MESSAGE);
        });
    }

    @DisplayName("당첨 번호가 쉼표로 구분되지 않은 입력이 들어오면 예외가 발생한다.")
    @Test
    void 당첨_번호가_쉼표로_구분되지_않은_입력이_들어오면_예외가_발생한다() {
        assertSimpleTest(() -> {
            runException("1000", "1.2.3.4.5.6");
            assertThat(output()).contains(ERROR_MESSAGE);
        });
    }

    @DisplayName("당첨 번호가 숫자가 아닌 입력이 들어오면 예외가 발생한다.")
    @Test
    void 당첨_번호가_숫자가_아닌_입력이_들어오면_예외가_발생한다() {
        assertSimpleTest(() -> {
           runException("1000", "a,b,c,d,e,f");
           assertThat(output()).contains(ERROR_MESSAGE);
        });
    }

    @DisplayName("보너스 번호가 범위를 벗어난 입력이 들어오면 예외가 발생한다.")
    @Test
    void 보너스_번호가_범위를_벗어난_입력이_들어오면_예외가_발생한다() {
        assertSimpleTest(() -> {
            runException("1000", "1,2,3,4,5,6", "50");
            assertThat(output()).contains(ERROR_MESSAGE);
        });
    }

    @DisplayName("보너스 번호가 당첨 번호와 중복되는 입력이 들어오면 예외가 발생한다.")
    @Test
    void 보너스_번호가_당첨_번호와_중복되는_입력이_들어오면_예외가_발생한다() {
        assertSimpleTest(() -> {
            runException("1000", "1,2,3,4,5,6", "1");
            assertThat(output()).contains(ERROR_MESSAGE);
        });
    }

    @DisplayName("보너스 번호가 숫자가 아닌 입력이 들어오면 예외가 발생한다.")
    @Test
    void 보너스_번호가_숫자가_아닌_입력이_들어오면_예외가_발생한다() {
        assertSimpleTest(() -> {
           runException("1000", "1,2,3,4,5,6", "abc");
           assertThat(output()).contains(ERROR_MESSAGE);
        });
    }

    @Override
    public void runMain() {
        Application.main(new String[]{});
    }
}
