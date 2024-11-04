package lotto;

import static camp.nextstep.edu.missionutils.test.Assertions.assertRandomUniqueNumbersInRangeTest;
import static camp.nextstep.edu.missionutils.test.Assertions.assertSimpleTest;
import static lotto.constant.ExceptionMessage.AMOUNT_MUST_BE_NON_NEGATIVE;
import static lotto.constant.ExceptionMessage.DUPLICATE_BONUS;
import static lotto.constant.ExceptionMessage.DUPLICATE_NUMBER;
import static lotto.constant.ExceptionMessage.INVALID_PAYMENT_AMOUNT;
import static lotto.constant.ExceptionMessage.INVALID_SIZE;
import static lotto.constant.ExceptionMessage.NUMBER_OUT_OF_RANGE;
import static org.assertj.core.api.Assertions.assertThat;

import camp.nextstep.edu.missionutils.test.NsTest;
import java.util.List;
import java.util.stream.Collectors;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

class ApplicationTest extends NsTest {
    private static final String ERROR_MESSAGE = "[ERROR]";
    private static final String MOCKITO_WARNING = "Mockito is currently self-attaching";

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

    @Nested
    class 구매_금액_입력_테스트 {
        @Test
        void 잘못된_금액_입력_후_정상_금액을_입력한다() {
            assertSimpleTest(() -> {
                run("1000j", "1000", "1,2,3,4,5,6", "7");
                assertThat(output())
                        .contains(ERROR_MESSAGE)
                        .contains("1개를 구매했습니다.");
            });
        }

        @Test
        void 천원_단위가_아닌_금액_입력_후_정상_금액을_입력한다() {
            assertSimpleTest(() -> {
                run("1500", "2000", "1,2,3,4,5,6", "7");
                assertThat(output())
                        .contains(ERROR_MESSAGE)
                        .contains(INVALID_PAYMENT_AMOUNT.format(1000))
                        .contains("2개를 구매했습니다.");
            });
        }

        @Test
        void 음수_입력_후_정상_금액을_입력한다() {
            assertSimpleTest(() -> {
                run("-1000", "2000", "1,2,3,4,5,6", "7");
                assertThat(output())
                        .contains(ERROR_MESSAGE)
                        .contains(AMOUNT_MUST_BE_NON_NEGATIVE.message())
                        .contains("2개를 구매했습니다.");
            });
        }
    }

    @Nested
    class 당첨_번호_입력_테스트 {
        @Test
        void 범위_초과_번호_입력_후_정상_번호를_입력한다() {
            assertSimpleTest(() -> {
                run("1000", "1,2,3,4,5,46", "1,2,3,4,5,6", "7");
                assertThat(output())
                        .contains(ERROR_MESSAGE)
                        .contains(NUMBER_OUT_OF_RANGE.format(1, 45));
            });
        }

        @Test
        void 중복_번호_입력_후_정상_번호를_입력한다() {
            assertSimpleTest(() -> {
                run("1000", "1,1,2,3,4,5", "1,2,3,4,5,6", "7");
                assertThat(output())
                        .contains(ERROR_MESSAGE)
                        .contains(DUPLICATE_NUMBER.message());
            });
        }

        @Test
        void 잘못된_개수의_번호_입력_후_정상_번호를_입력한다() {
            assertSimpleTest(() -> {
                run("1000", "1,2,3,4,5", "1,2,3,4,5,6", "7");
                assertThat(output())
                        .contains(ERROR_MESSAGE)
                        .contains(INVALID_SIZE.format(6));
            });
        }
    }

    @Nested
    class 보너스_번호_입력_테스트 {
        @Test
        void 중복된_보너스_번호_입력_후_정상_번호를_입력한다() {
            assertSimpleTest(() -> {
                run("1000", "1,2,3,4,5,6", "1", "7");
                assertThat(output())
                        .contains(ERROR_MESSAGE)
                        .contains(DUPLICATE_BONUS.message());
            });
        }

        @Test
        void 범위_초과_보너스_번호_입력_후_정상_번호를_입력한다() {
            assertSimpleTest(() -> {
                run("1000", "1,2,3,4,5,6", "46", "7");
                assertThat(output())
                        .contains(ERROR_MESSAGE)
                        .contains(NUMBER_OUT_OF_RANGE.format(1, 45));
            });
        }
    }


    @Nested
    class 통합_시나리오_테스트 {
        @Test
        void 예제와_정확히_일치하는_시나리오를_통과한다() {
            assertRandomUniqueNumbersInRangeTest(
                    () -> {
                        run("8000", "1,2,3,4,5,6", "7");
                        assertThat(removeWarningMessage(output())).isEqualTo("""
                                구입금액을 입력해 주세요.
                                
                                8개를 구매했습니다.
                                [8, 21, 23, 41, 42, 43]
                                [3, 5, 11, 16, 32, 38]
                                [7, 11, 16, 35, 36, 44]
                                [1, 8, 11, 31, 41, 42]
                                [13, 14, 16, 38, 42, 45]
                                [7, 11, 30, 40, 42, 43]
                                [2, 13, 22, 32, 38, 45]
                                [1, 3, 5, 14, 22, 45]
                                
                                당첨 번호를 입력해 주세요.
                                
                                보너스 번호를 입력해 주세요.
                                
                                당첨 통계
                                ---
                                3개 일치 (5,000원) - 1개
                                4개 일치 (50,000원) - 0개
                                5개 일치 (1,500,000원) - 0개
                                5개 일치, 보너스 볼 일치 (30,000,000원) - 0개
                                6개 일치 (2,000,000,000원) - 0개
                                총 수익률은 62.5%입니다.""");
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
        void 여러_번의_재시도_후_정상_완료된다() {
            assertRandomUniqueNumbersInRangeTest(
                    () -> {
                        run(
                                "1000j",                // 잘못된 금액
                                "1500",                 // 천원 단위 아님
                                "3000",                 // 정상 금액
                                "1,2,3,4,5",           // 번호 부족
                                "1,2,3,4,5,46",        // 범위 초과
                                "1,2,3,4,5,6",         // 정상 번호
                                "1",                    // 중복된 보너스
                                "46",                   // 범위 초과 보너스
                                "7"                     // 정상 보너스
                        );
                        assertThat(removeWarningMessage(output())).isEqualTo("""
                                구입금액을 입력해 주세요.
                                [ERROR] 숫자만 입력 가능합니다.
                                구입금액을 입력해 주세요.
                                [ERROR] 입력된 금액은 로또 티켓 가격(1000원) 단위어야 합니다.
                                구입금액을 입력해 주세요.
                                
                                3개를 구매했습니다.
                                [1, 2, 3, 4, 5, 6]
                                [7, 8, 9, 10, 11, 12]
                                [13, 14, 15, 16, 17, 18]
                                
                                당첨 번호를 입력해 주세요.
                                [ERROR] 로또 번호는 6개여야 합니다.
                                당첨 번호를 입력해 주세요.
                                [ERROR] 로또 번호는 1부터 45까지어야 합니다.
                                당첨 번호를 입력해 주세요.
                                
                                보너스 번호를 입력해 주세요.
                                [ERROR] 보너스 번호는 당첨 번호와 중복될 수 없습니다.
                                
                                보너스 번호를 입력해 주세요.
                                [ERROR] 로또 번호는 1부터 45까지어야 합니다.
                                
                                보너스 번호를 입력해 주세요.
                                
                                당첨 통계
                                ---
                                3개 일치 (5,000원) - 0개
                                4개 일치 (50,000원) - 0개
                                5개 일치 (1,500,000원) - 0개
                                5개 일치, 보너스 볼 일치 (30,000,000원) - 0개
                                6개 일치 (2,000,000,000원) - 1개
                                총 수익률은 66,666,666.7%입니다.""");
                    },
                    List.of(1, 2, 3, 4, 5, 6),
                    List.of(7, 8, 9, 10, 11, 12),
                    List.of(13, 14, 15, 16, 17, 18)
            );
        }

        @Test
        void 전체_플로우가_정상적으로_동작한다() {
            assertRandomUniqueNumbersInRangeTest(
                    () -> {
                        run("8000", "1,2,3,4,5,6", "7");
                        assertThat(removeWarningMessage(output())).isEqualTo("""
                                구입금액을 입력해 주세요.
                                
                                8개를 구매했습니다.
                                [8, 21, 23, 41, 42, 43]
                                [3, 5, 11, 16, 32, 38]
                                [7, 11, 16, 35, 36, 44]
                                [1, 8, 11, 31, 41, 42]
                                [13, 14, 16, 38, 42, 45]
                                [7, 11, 30, 40, 42, 43]
                                [2, 13, 22, 32, 38, 45]
                                [1, 3, 5, 14, 22, 45]
                                
                                당첨 번호를 입력해 주세요.
                                
                                보너스 번호를 입력해 주세요.
                                
                                당첨 통계
                                ---
                                3개 일치 (5,000원) - 1개
                                4개 일치 (50,000원) - 0개
                                5개 일치 (1,500,000원) - 0개
                                5개 일치, 보너스 볼 일치 (30,000,000원) - 0개
                                6개 일치 (2,000,000,000원) - 0개
                                총 수익률은 62.5%입니다.""");
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
        void 최소_금액으로_구매한다() {
            assertRandomUniqueNumbersInRangeTest(
                    () -> {
                        run("1000", "1,2,3,4,5,6", "7");
                        assertThat(removeWarningMessage(output())).isEqualTo("""
                                구입금액을 입력해 주세요.
                                
                                1개를 구매했습니다.
                                [1, 2, 3, 4, 5, 6]
                                
                                당첨 번호를 입력해 주세요.
                                
                                보너스 번호를 입력해 주세요.
                                
                                당첨 통계
                                ---
                                3개 일치 (5,000원) - 0개
                                4개 일치 (50,000원) - 0개
                                5개 일치 (1,500,000원) - 0개
                                5개 일치, 보너스 볼 일치 (30,000,000원) - 0개
                                6개 일치 (2,000,000,000원) - 1개
                                총 수익률은 200,000,000.0%입니다.""");
                    },
                    List.of(1, 2, 3, 4, 5, 6)
            );
        }

        @Test
        void 많은_당첨이_정상적으로_이루어진다_부럽다() {
            assertRandomUniqueNumbersInRangeTest(
                    () -> {
                        run("5000", "1,2,3,4,5,6", "7");
                        assertThat(removeWarningMessage(output())).isEqualTo("""
                                구입금액을 입력해 주세요.
                                
                                5개를 구매했습니다.
                                [1, 2, 3, 4, 5, 6]
                                [1, 2, 3, 4, 5, 7]
                                [1, 2, 3, 4, 5, 8]
                                [1, 2, 3, 4, 5, 9]
                                [1, 2, 3, 4, 5, 10]
                                
                                당첨 번호를 입력해 주세요.
                                
                                보너스 번호를 입력해 주세요.
                                
                                당첨 통계
                                ---
                                3개 일치 (5,000원) - 0개
                                4개 일치 (50,000원) - 0개
                                5개 일치 (1,500,000원) - 3개
                                5개 일치, 보너스 볼 일치 (30,000,000원) - 1개
                                6개 일치 (2,000,000,000원) - 1개
                                총 수익률은 40,690,000.0%입니다.""");
                    },
                    List.of(1, 2, 3, 4, 5, 6),
                    List.of(1, 2, 3, 4, 5, 7),
                    List.of(1, 2, 3, 4, 5, 8),
                    List.of(1, 2, 3, 4, 5, 9),
                    List.of(1, 2, 3, 4, 5, 10)
            );
        }

        @Test
        void 정상적으로_낙첨된다() {
            assertRandomUniqueNumbersInRangeTest(
                    () -> {
                        run("3000", "1,2,3,4,5,6", "7");
                        assertThat(removeWarningMessage(output())).isEqualTo("""
                                구입금액을 입력해 주세요.
                                
                                3개를 구매했습니다.
                                [7, 8, 9, 10, 11, 12]
                                [13, 14, 15, 16, 17, 18]
                                [19, 20, 21, 22, 23, 24]
                                
                                당첨 번호를 입력해 주세요.
                                
                                보너스 번호를 입력해 주세요.
                                
                                당첨 통계
                                ---
                                3개 일치 (5,000원) - 0개
                                4개 일치 (50,000원) - 0개
                                5개 일치 (1,500,000원) - 0개
                                5개 일치, 보너스 볼 일치 (30,000,000원) - 0개
                                6개 일치 (2,000,000,000원) - 0개
                                총 수익률은 0.0%입니다.""");
                    },
                    List.of(7, 8, 9, 10, 11, 12),
                    List.of(13, 14, 15, 16, 17, 18),
                    List.of(19, 20, 21, 22, 23, 24)
            );
        }
    }

    private String removeWarningMessage(String output) {
        return output.lines()
                .filter(line -> !line.contains(MOCKITO_WARNING))
                .collect(Collectors.joining("\n"));
    }

    @Override
    public void runMain() {
        Application.main(new String[]{});
    }
}
