package lotto;

import static camp.nextstep.edu.missionutils.test.Assertions.assertRandomUniqueNumbersInRangeTest;
import static camp.nextstep.edu.missionutils.test.Assertions.assertSimpleTest;
import static org.assertj.core.api.Assertions.assertThat;

import camp.nextstep.edu.missionutils.test.NsTest;
import java.util.List;
import org.junit.jupiter.api.Test;

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

    @Test
    void 예외_테스트() {
        assertSimpleTest(() -> {
            runException("1000j");
            assertThat(output()).contains(ERROR_MESSAGE);
        });
    }

    //구매 금액 예외 테스트
    @Test
    void 구매금액_숫자아닌_예외_테스트() {
        assertSimpleTest(() -> {
            runException("1000ㅁ");
            assertThat(output()).contains(ERROR_MESSAGE);
        });
    }

    @Test
    void 구매금액_1000으로_나누어지지_않는_예외_테스트() {
        assertSimpleTest(() -> {
            runException("1500");
            assertThat(output()).contains(ERROR_MESSAGE);
        });
    }

    //당첨 번호 및 보너스 번호 예외 테스트
    @Test
    void 당첨번호_중복_예외_테스트() {
        assertSimpleTest(() -> {
            runException("2000", "1,2,3,4,6,6");
            assertThat(output()).contains(ERROR_MESSAGE);
        });
    }

    @Test
    void 당첨번호_길이_긴_예외_테스트() {
        assertSimpleTest(() -> {
            runException("2000", "1,2,3,4,5,6,6");
            assertThat(output()).contains(ERROR_MESSAGE);
        });
    }

    @Test
    void 당첨번호_길이_짧은_예외_테스트() {
        assertSimpleTest(() -> {
            runException("2000", "1,2,3,4,5");
            assertThat(output()).contains(ERROR_MESSAGE);
        });
    }

    @Test
    void 당첨번호_보너스번호_중복_예외_테스트() {
        assertSimpleTest(() -> {
            runException("2000", "1,2,3,4,5,6", "6");
            assertThat(output()).contains(ERROR_MESSAGE);
        });
    }

    @Test
    void 당첨번호_보너스번호_문자_예외_테스트1() {
        assertSimpleTest(() -> {
            runException("2000", "1,2,3,4,5,a", "6");
            assertThat(output()).contains(ERROR_MESSAGE);
        });
    }

    @Test
    void 당첨번호_보너스번호_문자_예외_테스트2() {
        assertSimpleTest(() -> {
            runException("2000", "1,2,3,4,5,6", "a");
            assertThat(output()).contains(ERROR_MESSAGE);
        });
    }

    @Test
    void 당첨번호_숫자범위초과_예외_테스트1() {
        assertSimpleTest(() -> {
            runException("2000", "1,2,3,4,5,-1");
            assertThat(output()).contains(ERROR_MESSAGE);
        });
    }

    @Test
    void 당첨번호_숫자범위초과_예외_테스트2() {
        assertSimpleTest(() -> {
            runException("2000", "1,2,3,4,5,50");
            assertThat(output()).contains(ERROR_MESSAGE);
        });
    }

    @Test
    void 보너스번호_숫자범위초과_예외_테스트1() {
        assertSimpleTest(() -> {
            runException("2000", "1,2,3,4,5,6", "-3");
            assertThat(output()).contains(ERROR_MESSAGE);
        });
    }

    @Test
    void 보너스번호_숫자범위초과_예외_테스트2() {
        assertSimpleTest(() -> {
            runException("2000", "1,2,3,4,5,6", "50");
            assertThat(output()).contains(ERROR_MESSAGE);
        });
    }

    //전체 실행 결과 테스트
    @Test
    void 수익률_큰경우_기능_테스트() {
        assertRandomUniqueNumbersInRangeTest(
                () -> {
                    run("8000", "1,2,3,4,5,6", "7");
                    assertThat(output()).contains(
                            "8개를 구매했습니다.",
                            "[1, 2, 3, 4, 5, 6]",
                            "[1, 2, 3, 4, 5, 7]",
                            "[7, 11, 16, 35, 36, 44]",
                            "[1, 8, 11, 31, 41, 42]",
                            "[13, 14, 16, 38, 42, 45]",
                            "[7, 11, 30, 40, 42, 43]",
                            "[2, 13, 22, 32, 38, 45]",
                            "[1, 3, 5, 14, 22, 45]",
                            "3개 일치 (5,000원) - 1개",
                            "4개 일치 (50,000원) - 0개",
                            "5개 일치 (1,500,000원) - 0개",
                            "5개 일치, 보너스 볼 일치 (30,000,000원) - 1개",
                            "6개 일치 (2,000,000,000원) - 1개",
                            "총 수익률은 25,375,062.5%입니다."
                    );
                },
                List.of(1, 2, 3, 4, 5, 6),
                List.of(1, 2, 3, 4, 5, 7),
                List.of(7, 11, 16, 35, 36, 44),
                List.of(1, 8, 11, 31, 41, 42),
                List.of(13, 14, 16, 38, 42, 45),
                List.of(7, 11, 30, 40, 42, 43),
                List.of(2, 13, 22, 32, 38, 45),
                List.of(1, 3, 5, 14, 22, 45)
        );
    }

    @Test
    void 수익률_작은경우_기능_테스트() {
        assertRandomUniqueNumbersInRangeTest(
                () -> {
                    run("8000", "1,2,3,4,5,6", "7");
                    assertThat(output()).contains(
                            "8개를 구매했습니다.",
                            "[1, 2, 3, 4, 8, 9]",
                            "[1, 2, 3, 8, 9, 10]",
                            "[7, 11, 16, 35, 36, 44]",
                            "[1, 8, 11, 31, 41, 42]",
                            "[13, 14, 16, 38, 42, 45]",
                            "[7, 11, 30, 40, 42, 43]",
                            "[2, 13, 22, 32, 38, 45]",
                            "[1, 3, 5, 14, 22, 45]",
                            "3개 일치 (5,000원) - 2개",
                            "4개 일치 (50,000원) - 1개",
                            "5개 일치 (1,500,000원) - 0개",
                            "5개 일치, 보너스 볼 일치 (30,000,000원) - 0개",
                            "6개 일치 (2,000,000,000원) - 0개",
                            "총 수익률은 750.0%입니다."
                    );
                },
                List.of(1, 2, 3, 4, 8, 9),
                List.of(1, 2, 3, 8, 9, 10),
                List.of(7, 11, 16, 35, 36, 44),
                List.of(1, 8, 11, 31, 41, 42),
                List.of(13, 14, 16, 38, 42, 45),
                List.of(7, 11, 30, 40, 42, 43),
                List.of(2, 13, 22, 32, 38, 45),
                List.of(1, 3, 5, 14, 22, 45)
        );
    }

    @Test
    void 수익률_반올림_기능_테스트() {
        assertRandomUniqueNumbersInRangeTest(
                () -> {
                    run("6000", "1,2,3,4,5,6", "7");
                    assertThat(output()).contains(
                            "6개를 구매했습니다.",
                            "[1, 2, 3, 10, 11, 12]",
                            "[1, 2, 3, 8, 9, 10]",
                            "[7, 11, 16, 35, 36, 44]",
                            "[1, 8, 11, 31, 41, 42]",
                            "[13, 14, 16, 38, 42, 45]",
                            "[7, 11, 30, 40, 42, 43]",
                            "3개 일치 (5,000원) - 2개",
                            "4개 일치 (50,000원) - 0개",
                            "5개 일치 (1,500,000원) - 0개",
                            "5개 일치, 보너스 볼 일치 (30,000,000원) - 0개",
                            "6개 일치 (2,000,000,000원) - 0개",
                            "총 수익률은 166.7%입니다."
                    );
                },
                List.of(1, 2, 3, 10, 11, 12),
                List.of(1, 2, 3, 8, 9, 10),
                List.of(7, 11, 16, 35, 36, 44),
                List.of(1, 8, 11, 31, 41, 42),
                List.of(13, 14, 16, 38, 42, 45),
                List.of(7, 11, 30, 40, 42, 43)
        );
    }

    @Test
    void 수익률_0퍼센트_기능_테스트() {
        assertRandomUniqueNumbersInRangeTest(
                () -> {
                    run("80 00", "1,2,3,4,5,6", "7");
                    assertThat(output()).contains(
                            "8개를 구매했습니다.",
                            "[8, 9, 10, 11, 12, 13]",
                            "[8, 9, 10, 11, 12, 14]",
                            "[8, 9, 10, 11, 12, 15]",
                            "[8, 9, 10, 11, 12, 16]",
                            "[8, 9, 10, 11, 12, 17]",
                            "[8, 9, 10, 11, 12, 18]",
                            "[8, 9, 10, 11, 12, 19]",
                            "[8, 9, 10, 11, 12, 20]",
                            "3개 일치 (5,000원) - 0개",
                            "4개 일치 (50,000원) - 0개",
                            "5개 일치 (1,500,000원) - 0개",
                            "5개 일치, 보너스 볼 일치 (30,000,000원) - 0개",
                            "6개 일치 (2,000,000,000원) - 0개",
                            "총 수익률은 0.0%입니다."
                    );
                },
                List.of(8, 9, 10, 11, 12, 13),
                List.of(8, 9, 10, 11, 12, 14),
                List.of(8, 9, 10, 11, 12, 15),
                List.of(8, 9, 10, 11, 12, 16),
                List.of(8, 9, 10, 11, 12, 17),
                List.of(8, 9, 10, 11, 12, 18),
                List.of(8, 9, 10, 11, 12, 19),
                List.of(8, 9, 10, 11, 12, 20)
        );
    }

    @Test
    void 당첨번호_및_보너스번호_띄어쓰기_포함_기능_테스트() {
        assertRandomUniqueNumbersInRangeTest(
                () -> {
                    run("8000", "1, 2, 3, 4, 5, 6", "7 ");
                    assertThat(output()).contains(
                            "8개를 구매했습니다.",
                            "[1, 2, 3, 4, 8, 9]",
                            "[1, 2, 3, 8, 9, 10]",
                            "[7, 11, 16, 35, 36, 44]",
                            "[1, 8, 11, 31, 41, 42]",
                            "[13, 14, 16, 38, 42, 45]",
                            "[7, 11, 30, 40, 42, 43]",
                            "[2, 13, 22, 32, 38, 45]",
                            "[1, 3, 5, 14, 22, 45]",
                            "3개 일치 (5,000원) - 2개",
                            "4개 일치 (50,000원) - 1개",
                            "5개 일치 (1,500,000원) - 0개",
                            "5개 일치, 보너스 볼 일치 (30,000,000원) - 0개",
                            "6개 일치 (2,000,000,000원) - 0개",
                            "총 수익률은 750.0%입니다."
                    );
                },
                List.of(1, 2, 3, 4, 8, 9),
                List.of(1, 2, 3, 8, 9, 10),
                List.of(7, 11, 16, 35, 36, 44),
                List.of(1, 8, 11, 31, 41, 42),
                List.of(13, 14, 16, 38, 42, 45),
                List.of(7, 11, 30, 40, 42, 43),
                List.of(2, 13, 22, 32, 38, 45),
                List.of(1, 3, 5, 14, 22, 45)
        );
    }

    @Test
    void 구입금액_띄어쓰기_포함_기능_테스트() {
        assertRandomUniqueNumbersInRangeTest(
                () -> {
                    run("80 00", "1,2,3,4,5,6", "7");
                    assertThat(output()).contains(
                            "8개를 구매했습니다.",
                            "[1, 2, 3, 4, 8, 9]",
                            "[1, 2, 3, 8, 9, 10]",
                            "[7, 11, 16, 35, 36, 44]",
                            "[1, 8, 11, 31, 41, 42]",
                            "[13, 14, 16, 38, 42, 45]",
                            "[7, 11, 30, 40, 42, 43]",
                            "[2, 13, 22, 32, 38, 45]",
                            "[1, 3, 5, 14, 22, 45]",
                            "3개 일치 (5,000원) - 2개",
                            "4개 일치 (50,000원) - 1개",
                            "5개 일치 (1,500,000원) - 0개",
                            "5개 일치, 보너스 볼 일치 (30,000,000원) - 0개",
                            "6개 일치 (2,000,000,000원) - 0개",
                            "총 수익률은 750.0%입니다."
                    );
                },
                List.of(1, 2, 3, 4, 8, 9),
                List.of(1, 2, 3, 8, 9, 10),
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
