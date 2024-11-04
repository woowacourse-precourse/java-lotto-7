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
    void 정상_입력시_생성된_로또와_결과_출력() {
        assertRandomUniqueNumbersInRangeTest(
                () -> {
                    run("10000", "1,2,3,4,5,6", "7");
                    assertThat(output()).contains(
                            "10개를 구매했습니다.",
                            "[8, 21, 23, 41, 42, 43]",
                            "[3, 5, 11, 16, 32, 38]",
                            "[7, 11, 16, 35, 36, 44]",
                            "[1, 8, 11, 31, 41, 42]",
                            "[13, 14, 16, 38, 42, 45]",
                            "[7, 11, 30, 40, 42, 43]",
                            "[1, 2, 3, 4, 22, 38]",
                            "[1, 3, 5, 14, 22, 45]",
                            "[1, 3, 6, 7, 8, 10]",
                            "[1, 2, 3, 4, 6, 7]",
                            "3개 일치 (5,000원) - 2개",
                            "4개 일치 (50,000원) - 1개",
                            "5개 일치 (1,500,000원) - 0개",
                            "5개 일치, 보너스 볼 일치 (30,000,000원) - 1개",
                            "6개 일치 (2,000,000,000원) - 0개",
                            "총 수익률은 300,600.0%입니다."
                    );
                },
                List.of(8, 21, 23, 41, 42, 43),
                List.of(3, 5, 11, 16, 32, 38),
                List.of(7, 11, 16, 35, 36, 44),
                List.of(42, 1, 8, 11, 31, 41),
                List.of(13, 14, 16, 38, 42, 45),
                List.of(7, 11, 40, 30, 42, 43),
                List.of(2, 1, 22, 3, 38, 4), // 4등
                List.of(1, 3, 5, 14, 22, 45), // 5등
                List.of(1, 3, 6, 7, 8, 10), // 5등
                List.of(1, 3, 6, 7, 2, 4) // 2등
        );
    }

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
    void 정상_입력시_생성된_로또_출력() {
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

    @Test
    void 우승번호_중복_입력시_예외_출력() {
        assertSimpleTest(() -> {
            runException("2000", "1,2,3,4,6,6");
            assertThat(output()).contains(ERROR_MESSAGE);
        });
    }

    @Test
    void 우승번호_범위_초과시_예외_출력() {
        assertSimpleTest(() -> {
            runException("2000", "1,2,3,4,6,46");
            assertThat(output()).contains(ERROR_MESSAGE);
        });
    }

    @Test
    void 우승번호_범위_미만시_예외_출력() {
        assertSimpleTest(() -> {
            runException("2000", "0,2,3,4,6,45");
            assertThat(output()).contains(ERROR_MESSAGE);
        });
    }

    @Test
    void 우승번호_개수_불일치시_예외_출력() {
        assertSimpleTest(() -> {
            runException("2000", "1,2,3,4,5,6,7");
            assertThat(output()).contains(ERROR_MESSAGE);
        });
    }

    @Test
    void 우승번호_형식_이상시_예외_출력() {
        assertSimpleTest(() -> {
            runException("2000", "hello,world");
            assertThat(output()).contains(ERROR_MESSAGE);
        });
    }

    @Test
    void 보너스_번호_중복_입력시_예외_출력() {
        assertSimpleTest(() -> {
            runException("2000", "1,2,3,4,5,6", "6");
            assertThat(output()).contains(ERROR_MESSAGE);
        });
    }

    @Test
    void 보너스_번호_범위_초과시_예외_출력() {
        assertSimpleTest(() -> {
            runException("2000", "1,2,3,4,5,6", "46");
            assertThat(output()).contains(ERROR_MESSAGE);
        });
    }

    @Test
    void 보너스_번호_범위_미만시_예외_출력() {
        assertSimpleTest(() -> {
            runException("2000", "1,2,3,4,5,6", "0");
            assertThat(output()).contains(ERROR_MESSAGE);
        });
    }

    @Test
    void 보너스_번호_정수_형식_아닐시_예외_출력() {
        assertSimpleTest(() -> {
            runException("2000", "1,2,3,4,5,6", "he");
            assertThat(output()).contains(ERROR_MESSAGE);
        });
    }

    @Override
    public void runMain() {
        Application.main(new String[]{});
    }
}
