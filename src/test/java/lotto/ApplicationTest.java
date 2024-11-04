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
    @DisplayName("기능 테스트 1: 정상적인 로또 구매 및 당첨 결과 확인")
    void 기능_테스트_1() {
        assertRandomUniqueNumbersInRangeTest(
                () -> {
                    run("5000", "1,2,3,4,5,6", "7");
                    assertThat(output()).contains(
                            "5개를 구매했습니다.",
                            "당첨 통계",
                            "총 수익률은"
                    );
                },
                List.of(8, 21, 23, 41, 42, 43),
                List.of(3, 5, 11, 16, 32, 38),
                List.of(7, 11, 16, 35, 36, 44),
                List.of(1, 8, 11, 31, 41, 42),
                List.of(13, 14, 16, 38, 42, 45)
        );
    }


    @Test
    @DisplayName("기능 테스트 2: 최소 금액으로 로또 구매")
    void 기능_테스트_2() {
        assertRandomUniqueNumbersInRangeTest(
                () -> {
                    run("1000", "1,2,3,4,5,6", "7");
                    assertThat(output()).contains(
                            "1개를 구매했습니다.",
                            "당첨 통계",
                            "총 수익률은"
                    );
                },
                List.of(8, 21, 23, 41, 42, 43)
        );
    }

    @Test
    @DisplayName("기능 테스트 3: 당첨 번호와 보너스 번호로 1등 당첨")
    void 기능_테스트_3() {
        assertRandomUniqueNumbersInRangeTest(
                () -> {
                    run("1000", "1,2,3,4,5,6", "7");
                    assertThat(output()).contains(
                            "6개 일치 (2,000,000,000원) - 1개",
                            "총 수익률은 200000000.0%입니다."
                    );
                },
                List.of(1, 2, 3, 4, 5, 6)
        );
    }

    @Test
    @DisplayName("기능 테스트 4: 당첨 번호와 보너스 번호로 2등 당첨")
    void 기능_테스트_4() {
        assertRandomUniqueNumbersInRangeTest(
                () -> {
                    run("1000", "1,2,3,4,5,7", "6");
                    assertThat(output()).contains(
                            "5개 일치, 보너스 볼 일치 (30,000,000원) - 1개",
                            "총 수익률은 3000000.0%입니다."
                    );
                },
                List.of(1, 2, 3, 4, 5, 6)
        );
    }

    @Test
    @DisplayName("기능 테스트 5: 당첨 번호와 보너스 번호로 3등 당첨")
    void 기능_테스트_5() {
        assertRandomUniqueNumbersInRangeTest(
                () -> {
                    run("1000", "1,2,3,4,5,7", "8");
                    assertThat(output()).contains(
                            "5개 일치 (1,500,000원) - 1개",
                            "총 수익률은 150000.0%입니다."
                    );
                },
                List.of(1, 2, 3, 4, 5, 6)
        );
    }

    @Test
    @DisplayName("기능 테스트 6: 당첨 번호와 보너스 번호로 4등 당첨")
    void 기능_테스트_6() {
        assertRandomUniqueNumbersInRangeTest(
                () -> {
                    run("1000", "1,2,3,4,7,8", "9");
                    assertThat(output()).contains(
                            "4개 일치 (50,000원) - 1개",
                            "총 수익률은 5000.0%입니다."
                    );
                },
                List.of(1, 2, 3, 4, 5, 6)
        );
    }

    @Test
    @DisplayName("기능 테스트 7: 당첨 번호와 보너스 번호로 5등 당첨")
    void 기능_테스트_7() {
        assertRandomUniqueNumbersInRangeTest(
                () -> {
                    run("1000", "1,2,3,7,8,9", "10");
                    assertThat(output()).contains(
                            "3개 일치 (5,000원) - 1개",
                            "총 수익률은 500.0%입니다."
                    );
                },
                List.of(1, 2, 3, 4, 5, 6)
        );
    }

    @Test
    @DisplayName("기능 테스트 8: 당첨 번호와 보너스 번호로 당첨되지 않음")
    void 기능_테스트_8() {
        assertRandomUniqueNumbersInRangeTest(
                () -> {
                    run("1000", "11,12,13,14,15,16", "17");
                    assertThat(output()).contains(
                            "총 수익률은 0.0%입니다."
                    );
                },
                List.of(1, 2, 3, 4, 5, 6)
        );
    }

    @Test
    void 예외_테스트() {
        assertSimpleTest(() -> {
            runException("1000j");
            assertThat(output()).contains(ERROR_MESSAGE);
        });
    }
    @Test
    @DisplayName("예외 테스트 1: 구입 금액에 숫자가 아닌 값 입력")
    void 예외_테스트_1() {
        assertSimpleTest(() -> {
            runException("만원");
            assertThat(output()).contains(ERROR_MESSAGE);
        });
    }

    @Test
    @DisplayName("예외 테스트 2: 구입 금액에 음수 입력")
    void 예외_테스트_2() {
        assertSimpleTest(() -> {
            runException("-5000");
            assertThat(output()).contains(ERROR_MESSAGE);
        });
    }

    @Test
    @DisplayName("예외 테스트 3: 구입 금액에 1000원 미만 입력")
    void 예외_테스트_3() {
        assertSimpleTest(() -> {
            runException("500");
            assertThat(output()).contains(ERROR_MESSAGE);
        });
    }

    @Test
    @DisplayName("예외 테스트 4: 구입 금액이 1000원 단위가 아님")
    void 예외_테스트_4() {
        assertSimpleTest(() -> {
            runException("5500");
            assertThat(output()).contains(ERROR_MESSAGE);
        });
    }

    @Test
    @DisplayName("예외 테스트 5: 당첨 번호에 숫자가 아닌 값 입력")
    void 예외_테스트_5() {
        assertSimpleTest(() -> {
            runException("5000", "1,2,3,4,5,육", "7");
            assertThat(output()).contains(ERROR_MESSAGE);
        });
    }

    @Test
    @DisplayName("예외 테스트 6: 당첨 번호에 중복된 숫자 입력")
    void 예외_테스트_6() {
        assertSimpleTest(() -> {
            runException("5000", "1,2,3,4,5,5", "7");
            assertThat(output()).contains(ERROR_MESSAGE);
        });
    }

    @Test
    @DisplayName("예외 테스트 7: 당첨 번호에 범위를 벗어난 숫자 입력")
    void 예외_테스트_7() {
        assertSimpleTest(() -> {
            runException("5000", "1,2,3,4,5,46", "7");
            assertThat(output()).contains(ERROR_MESSAGE);
        });
    }

    @Test
    @DisplayName("예외 테스트 8: 보너스 번호에 숫자가 아닌 값 입력")
    void 예외_테스트_8() {
        assertSimpleTest(() -> {
            runException("5000", "1,2,3,4,5,6", "칠");
            assertThat(output()).contains(ERROR_MESSAGE);
        });
    }

    @Test
    @DisplayName("예외 테스트 9: 보너스 번호가 당첨 번호와 중복")
    void 예외_테스트_9() {
        assertSimpleTest(() -> {
            runException("5000", "1,2,3,4,5,6", "6");
            assertThat(output()).contains(ERROR_MESSAGE);
        });
    }

    @Test
    @DisplayName("예외 테스트 10: 보너스 번호에 범위를 벗어난 숫자 입력")
    void 예외_테스트_10() {
        assertSimpleTest(() -> {
            runException("5000", "1,2,3,4,5,6", "0");
            assertThat(output()).contains(ERROR_MESSAGE);
        });
    }

    @Test
    @DisplayName("예외 테스트 11: 로또 번호 생성 시 중복된 번호 발생")
    void 예외_테스트_11() {
        assertRandomUniqueNumbersInRangeTest(
                () -> {
                    runException("5000", "1,2,3,4,5,6", "7");
                    assertThat(output()).contains(ERROR_MESSAGE);
                },
                // 중복된 번호를 반환하도록 설정합니다.
                List.of(1, 2, 3, 4, 5, 5), // 첫 번째 로또 번호: 중복된 숫자 5
                List.of(8, 21, 23, 41, 42, 43),
                List.of(3, 5, 11, 16, 32, 38),
                List.of(7, 11, 16, 35, 36, 44),
                List.of(1, 8, 11, 31, 41, 42)
        );
    }

    @Override
    public void runMain() {
        Application.main(new String[]{});
    }
}
