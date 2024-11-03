package lotto;

import camp.nextstep.edu.missionutils.test.NsTest;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static camp.nextstep.edu.missionutils.test.Assertions.assertRandomUniqueNumbersInRangeTest;
import static camp.nextstep.edu.missionutils.test.Assertions.assertSimpleTest;
import static org.assertj.core.api.Assertions.assertThat;

class ApplicationTest extends NsTest {
    private static final String ERROR_MESSAGE = "[ERROR]";

    @Test
    @DisplayName("기능_테스트_기본")
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
    @DisplayName("예외_테스트_로또_구입_금액_문자열")
    void 예외_테스트() {
        assertSimpleTest(() -> {
            runException("1000j");
            assertThat(output()).contains(ERROR_MESSAGE);
        });
    }

    @Test
    void 기능_테스트_전부_당첨() {
        assertRandomUniqueNumbersInRangeTest(
                () -> {
                    run(" 5000", " 1, 2, 3, 4, 5, 6", " 7");
                    assertThat(output()).contains(
                            "5개를 구매했습니다.",
                            "[1, 2, 3, 4, 5, 6]",
                            "[1, 2, 3, 4, 5, 7]",
                            "[1, 2, 3, 4, 5, 8]",
                            "[1, 2, 3, 4, 8, 9]",
                            "[1, 2, 3, 8, 9, 10]",
                            "3개 일치 (5,000원) - 1개",
                            "4개 일치 (50,000원) - 1개",
                            "5개 일치 (1,500,000원) - 1개",
                            "5개 일치, 보너스 볼 일치 (30,000,000원) - 1개",
                            "6개 일치 (2,000,000,000원) - 1개",
                            "총 수익률은 40631100.0%입니다."
                    );
                },
                List.of(1, 2, 3, 4, 5, 6),
                List.of(1, 2, 3, 4, 5, 7),
                List.of(1, 2, 3, 4, 5, 8),
                List.of(1, 2, 3, 4, 8, 9),
                List.of(1, 2, 3, 8, 9, 10)
        );
    }

    @Test
    void 기능_테스트_왼쪽_공백_제거() {
        assertRandomUniqueNumbersInRangeTest(
                () -> {
                    run(" 4000", " 1, 2, 3, 4, 5, 6", " 7");
                    assertThat(output()).contains(
                            "4개를 구매했습니다.",
                            "[13, 14, 16, 38, 42, 45]",
                            "[7, 11, 30, 40, 42, 43]",
                            "[2, 13, 22, 32, 38, 45]",
                            "[1, 3, 5, 14, 22, 45]",
                            "3개 일치 (5,000원) - 1개",
                            "4개 일치 (50,000원) - 0개",
                            "5개 일치 (1,500,000원) - 0개",
                            "5개 일치, 보너스 볼 일치 (30,000,000원) - 0개",
                            "6개 일치 (2,000,000,000원) - 0개",
                            "총 수익률은 125.0%입니다."
                    );
                },
                List.of(13, 14, 16, 38, 42, 45),
                List.of(7, 11, 30, 40, 42, 43),
                List.of(2, 13, 22, 32, 38, 45),
                List.of(1, 3, 5, 14, 22, 45)
        );
    }

    @Test
    void 기능_테스트_오른쪽_공백_제거() {
        assertRandomUniqueNumbersInRangeTest(
                () -> {
                    run("4000 ", "1 ,2 ,3 ,4 ,5 ,6 ", "7 ");
                    assertThat(output()).contains(
                            "4개를 구매했습니다.",
                            "[13, 14, 16, 38, 42, 45]",
                            "[7, 11, 30, 40, 42, 43]",
                            "[2, 13, 22, 32, 38, 45]",
                            "[1, 3, 5, 14, 22, 45]",
                            "3개 일치 (5,000원) - 1개",
                            "4개 일치 (50,000원) - 0개",
                            "5개 일치 (1,500,000원) - 0개",
                            "5개 일치, 보너스 볼 일치 (30,000,000원) - 0개",
                            "6개 일치 (2,000,000,000원) - 0개",
                            "총 수익률은 125.0%입니다."
                    );
                },
                List.of(13, 14, 16, 38, 42, 45),
                List.of(7, 11, 30, 40, 42, 43),
                List.of(2, 13, 22, 32, 38, 45),
                List.of(1, 3, 5, 14, 22, 45)
        );
    }

    @Test
    void 기능_테스트_양쪽_공백_제거() {
        assertRandomUniqueNumbersInRangeTest(
                () -> {
                    run(" 4000 ", " 1 , 2 , 3 , 4 , 5 , 6 ", " 7 ");
                    assertThat(output()).contains(
                            "4개를 구매했습니다.",
                            "[13, 14, 16, 38, 42, 45]",
                            "[7, 11, 30, 40, 42, 43]",
                            "[2, 13, 22, 32, 38, 45]",
                            "[1, 3, 5, 14, 22, 45]",
                            "3개 일치 (5,000원) - 1개",
                            "4개 일치 (50,000원) - 0개",
                            "5개 일치 (1,500,000원) - 0개",
                            "5개 일치, 보너스 볼 일치 (30,000,000원) - 0개",
                            "6개 일치 (2,000,000,000원) - 0개",
                            "총 수익률은 125.0%입니다."
                    );
                },
                List.of(13, 14, 16, 38, 42, 45),
                List.of(7, 11, 30, 40, 42, 43),
                List.of(2, 13, 22, 32, 38, 45),
                List.of(1, 3, 5, 14, 22, 45)
        );
    }

    @Test
    void 기능_테스트_당첨_없음() {
        assertRandomUniqueNumbersInRangeTest(
                () -> {
                    run("4000", "1,2,3,4,5,6", "7");
                    assertThat(output()).contains(
                            "4개를 구매했습니다.",
                            "[8, 21, 23, 41, 42, 43]",
                            "[3, 5, 11, 16, 32, 38]",
                            "[7, 11, 16, 35, 36, 44]",
                            "[1, 8, 11, 31, 41, 42]",
                            "3개 일치 (5,000원) - 0개",
                            "4개 일치 (50,000원) - 0개",
                            "5개 일치 (1,500,000원) - 0개",
                            "5개 일치, 보너스 볼 일치 (30,000,000원) - 0개",
                            "6개 일치 (2,000,000,000원) - 0개",
                            "총 수익률은 0.0%입니다."
                    );
                },
                List.of(8, 21, 23, 41, 42, 43),
                List.of(3, 5, 11, 16, 32, 38),
                List.of(7, 11, 16, 35, 36, 44),
                List.of(1, 8, 11, 31, 41, 42)
        );
    }

    @Test
    void 기능_테스트_오름차순_정렬_확인() {
        assertRandomUniqueNumbersInRangeTest(
                () -> {
                    run("4000", "1,2,3,4,5,6", "7");
                    assertThat(output()).contains(
                            "4개를 구매했습니다.",
                            "[13, 14, 16, 38, 42, 45]",
                            "[7, 11, 30, 40, 42, 43]",
                            "[2, 13, 22, 32, 38, 45]",
                            "[1, 3, 5, 14, 22, 45]",
                            "3개 일치 (5,000원) - 1개",
                            "4개 일치 (50,000원) - 0개",
                            "5개 일치 (1,500,000원) - 0개",
                            "5개 일치, 보너스 볼 일치 (30,000,000원) - 0개",
                            "6개 일치 (2,000,000,000원) - 0개",
                            "총 수익률은 125.0%입니다."
                    );
                },
                List.of(45, 42, 38, 16, 14, 13),
                List.of(43, 42, 40, 30, 11, 7),
                List.of(45, 38, 32, 22, 13, 2),
                List.of(45, 22, 14, 5, 3, 1)
        );
    }

    @Test
    void 예외_테스트_로또_구입_금액_문자() {
        assertSimpleTest(() -> {
            runException("a", "1,2,3,4,5,6", "7");
            assertThat(output()).contains(ERROR_MESSAGE);
        });
    }

    @Test
    void 예외_테스트_로또_구입_금액_특수_문자() {
        assertSimpleTest(() -> {
            runException("$", "1,2,3,4,5,6", "7");
            assertThat(output()).contains(ERROR_MESSAGE);
        });
    }

    @Test
    void 예외_테스트_로또_구입_금액_빈_값() {
        assertSimpleTest(() -> {
            runException("", "1,2,3,4,5,6", "7");
            assertThat(output()).contains(ERROR_MESSAGE);
        });
    }

    @Test
    void 예외_테스트_로또_구입_금액_공백() {
        assertSimpleTest(() -> {
            runException(" ", "1,2,3,4,5,6", "7");
            assertThat(output()).contains(ERROR_MESSAGE);
        });
    }

    @Test
    void 예외_테스트_로또_구입_금액_중간에_공백() {
        assertSimpleTest(() -> {
            runException("1 000", "1,2,3,4,5,6", "7");
            assertThat(output()).contains(ERROR_MESSAGE);
        });
    }

    @Test
    void 예외_테스트_로또_구입_금액_개행_문자() {
        assertSimpleTest(() -> {
            runException("\n", "1,2,3,4,5,6", "7");
            assertThat(output()).contains(ERROR_MESSAGE);
        });
    }

    @Test
    void 예외_테스트_로또_구입_금액_음수() {
        assertSimpleTest(() -> {
            runException("-4000", "1,2,3,4,5,6", "7");
            assertThat(output()).contains(ERROR_MESSAGE);
        });
    }

    @Test
    void 예외_테스트_로또_구입_금액_배수_아님() {
        assertSimpleTest(() -> {
            runException("2500", "1,2,3,4,5,6", "7");
            assertThat(output()).contains(ERROR_MESSAGE);
        });
    }

    @Test
    void 예외_테스트_당첨_번호_리스트_아님() {
        assertSimpleTest(() -> {
            runException("4000", "12", "7");
            assertThat(output()).contains(ERROR_MESSAGE);
        });
    }

    @Test
    void 예외_테스트_당첨_번호_문자_포함() {
        assertSimpleTest(() -> {
            runException("4000", "1,2,a,4,5,6", "7");
            assertThat(output()).contains(ERROR_MESSAGE);
        });
    }

    @Test
    void 예외_테스트_당첨_번호_특수_문자_포함() {
        assertSimpleTest(() -> {
            runException("4000", "1,2,$,4,5,6", "7");
            assertThat(output()).contains(ERROR_MESSAGE);
        });
    }

    @Test
    void 예외_테스트_당첨_번호_빈_값_포함() {
        assertSimpleTest(() -> {
            runException("4000", "1,2,,4,5,6", "7");
            assertThat(output()).contains(ERROR_MESSAGE);
        });
    }

    @Test
    void 예외_테스트_당첨_번호_공백_포함() {
        assertSimpleTest(() -> {
            runException("4000", "1,2, ,4,5,6", "7");
            assertThat(output()).contains(ERROR_MESSAGE);
        });
    }

    @Test
    void 예외_테스트_당첨_번호_중간에_공백_포함() {
        assertSimpleTest(() -> {
            runException("4000", "1,2,3 3,4,5,6", "7");
            assertThat(output()).contains(ERROR_MESSAGE);
        });
    }

    @Test
    void 예외_테스트_당첨_번호_개행_문자_포함() {
        assertSimpleTest(() -> {
            runException("4000", "1,2,\n,4,5,6", "7");
            assertThat(output()).contains(ERROR_MESSAGE);
        });
    }

    @Test
    void 예외_테스트_당첨_번호_음수_포함() {
        assertSimpleTest(() -> {
            runException("4000", "1,2,-3,4,5,6", "7");
            assertThat(output()).contains(ERROR_MESSAGE);
        });
    }

    @Test
    void 예외_테스트_당첨_번호_중복된_번호_포함() {
        assertSimpleTest(() -> {
            runException("4000", "1,2,3,4,6,6", "7");
            assertThat(output()).contains(ERROR_MESSAGE);
        });
    }

    @Test
    void 예외_테스트_당첨_번호_범위_초과() {
        assertSimpleTest(() -> {
            runException("4000", "1,2,3,4,5,46", "7");
            assertThat(output()).contains(ERROR_MESSAGE);
        });
    }

    @Test
    void 예외_테스트_당첨_번호_범위_미달() {
        assertSimpleTest(() -> {
            runException("4000", "0,2,3,4,5,6", "7");
            assertThat(output()).contains(ERROR_MESSAGE);
        });
    }

    @Test
    void 예외_테스트_당첨_번호_개수_초과() {
        assertSimpleTest(() -> {
            runException("4000", "1,2,3,4,5,6,7", "8");
            assertThat(output()).contains(ERROR_MESSAGE);
        });
    }

    @Test
    void 예외_테스트_당첨_번호_개수_미달() {
        assertSimpleTest(() -> {
            runException("4000", "1,2,3,4,5", "7");
            assertThat(output()).contains(ERROR_MESSAGE);
        });
    }

    @Test
    void 예외_테스트_보너스_번호_문자() {
        assertSimpleTest(() -> {
            runException("4000", "1,2,3,4,5,6", "a");
            assertThat(output()).contains(ERROR_MESSAGE);
        });
    }

    @Test
    void 예외_테스트_보너스_번호_특수_문자() {
        assertSimpleTest(() -> {
            runException("4000", "1,2,3,4,5,6", "$");
            assertThat(output()).contains(ERROR_MESSAGE);
        });
    }

    @Test
    void 예외_테스트_보너스_번호_공백() {
        assertSimpleTest(() -> {
            runException("4000", "1,2,3,4,5,6", " ");
            assertThat(output()).contains(ERROR_MESSAGE);
        });
    }

    @Test
    void 예외_테스트_보너스_번호_중간에_공백() {
        assertSimpleTest(() -> {
            runException("4000", "1,2,3,4,5,6", "7 8");
            assertThat(output()).contains(ERROR_MESSAGE);
        });
    }

    @Test
    void 예외_테스트_보너스_번호_개행_문자() {
        assertSimpleTest(() -> {
            runException("4000", "1,2,3,4,5,6", "\n");
            assertThat(output()).contains(ERROR_MESSAGE);
        });
    }

    @Test
    void 예외_테스트_보너스_번호_음수() {
        assertSimpleTest(() -> {
            runException("4000", "1,2,3,4,5,6", "-7");
            assertThat(output()).contains(ERROR_MESSAGE);
        });
    }

    @Test
    void 예외_테스트_보너스_번호_당첨_번호와_중복() {
        assertSimpleTest(() -> {
            runException("4000", "1,2,3,4,5,6", "6");
            assertThat(output()).contains(ERROR_MESSAGE);
        });
    }

    @Test
    void 예외_테스트_보너스_번호_범위_초과() {
        assertSimpleTest(() -> {
            runException("4000", "1,2,3,4,5,6", "46");
            assertThat(output()).contains(ERROR_MESSAGE);
        });
    }

    @Test
    void 예외_테스트_보너스_번호_범위_미달() {
        assertSimpleTest(() -> {
            runException("4000", "1,2,3,4,5,6", "0");
            assertThat(output()).contains(ERROR_MESSAGE);
        });
    }

    @Override
    public void runMain() {
        Application.main(new String[]{});
    }
}
