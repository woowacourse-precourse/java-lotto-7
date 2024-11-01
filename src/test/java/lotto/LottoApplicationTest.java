package lotto;

import static camp.nextstep.edu.missionutils.test.Assertions.assertRandomUniqueNumbersInRangeTest;
import static camp.nextstep.edu.missionutils.test.Assertions.assertSimpleTest;
import static org.assertj.core.api.Assertions.assertThat;

import camp.nextstep.edu.missionutils.test.NsTest;
import java.util.List;
import org.junit.jupiter.api.Test;

class LottoApplicationTest extends NsTest {
    private static final String ERROR_MESSAGE = "[ERROR]";

    @Test
    void 문자_포함_구매금액_입력시_예외_메시지_출력() {
        assertSimpleTest(() -> {
            runException("1000.0");
            assertThat(output()).contains(ERROR_MESSAGE);
        });
    }

    @Test
    void 정수_형태_아닌_구매금액_입력시_예외_메시지_출력() {
        assertSimpleTest(() -> {
            runException("1234312432154325435");
            assertThat(output()).contains(ERROR_MESSAGE);
        });
    }

    @Test
    void 구매금액_0원_입력시_예외_메시지_출력() {
        assertSimpleTest(() -> {
            runException("0");
            assertThat(output()).contains(ERROR_MESSAGE);
        });
    }

    @Test
    void 구매금액_1000원단위_아닐시_예외_메시지_출력() {
        assertSimpleTest(() -> {
            runException("1200");
            assertThat(output()).contains(ERROR_MESSAGE);
        });
    }

    @Test
    void 구매금액_입력시_생성된_로또_출력() {
        assertRandomUniqueNumbersInRangeTest(
                () -> {
                    run("8000");
                    assertThat(output()).contains(
                            "8개를 구매했습니다.",
                            "[8, 21, 23, 41, 42, 43]",
                            "[3, 5, 11, 16, 32, 38]",
                            "[7, 11, 16, 35, 36, 44]",
                            "[1, 8, 11, 31, 41, 42]",
                            "[13, 14, 16, 38, 42, 45]",
                            "[7, 11, 30, 40, 42, 43]",
                            "[2, 13, 22, 32, 38, 45]",
                            "[1, 3, 5, 14, 22, 45]"
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

    @Override
    public void runMain() {
        Application.main(new String[]{});
    }
}