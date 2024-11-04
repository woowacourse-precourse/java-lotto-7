package lotto.controller;

import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.test.NsTest;
import lotto.Application;
import lotto.domain.PurchaseAmount;
import lotto.domain.WinRecord;
import lotto.domain.WinningLotto;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.List;

import static camp.nextstep.edu.missionutils.test.Assertions.assertRandomUniqueNumbersInRangeTest;
import static camp.nextstep.edu.missionutils.test.Assertions.assertSimpleTest;
import static org.assertj.core.api.Assertions.assertThat;

public class ApplicationControllerTest extends NsTest {
    private static final String ERROR_MESSAGE = "[ERROR]";

    @BeforeEach
    void setupTestEnvironment() {
        System.setProperty("IS_TEST_ENV", "true");
    }

    @BeforeEach
    void resetSingletone() {
        PurchaseAmount.resetInstance();
        WinningLotto.resetInstance();
        WinRecord.resetInstance();
    }

    @AfterEach
    void closeConsole() {
        Console.close();
    }

    @AfterEach
    void resetTestEnvironment() {
        System.clearProperty("IS_TEST_ENV");
    }

    @DisplayName("전체 동작 테스트 1등 당첨 시")
    @Test
    void checkApplication_1Rank() {
        assertRandomUniqueNumbersInRangeTest(
                () -> {
                    run("4000", "1,2,3,4,5,6", "7");
                    assertThat(output()).contains(
                            "4개를 구매했습니다.",
                            "[1, 2, 3, 4, 5, 6]",
                            "[3, 5, 11, 16, 32, 38]",
                            "[7, 11, 16, 35, 36, 44]",
                            "[1, 8, 11, 31, 41, 42]",
                            "3개 일치 (5,000원) - 0개",
                            "4개 일치 (50,000원) - 0개",
                            "5개 일치 (1,500,000원) - 0개",
                            "5개 일치, 보너스 볼 일치 (30,000,000원) - 0개",
                            "6개 일치 (2,000,000,000원) - 1개",
                            "총 수익률은 50000000.0%입니다."
                    );
                },
                List.of(1, 2, 3, 4, 5, 6),
                List.of(3, 5, 11, 16, 32, 38),
                List.of(7, 11, 16, 35, 36, 44),
                List.of(1, 8, 11, 31, 41, 42)
        );
    }

    @DisplayName("전체 동작 테스트 2등 당첨 시")
    @Test
    void checkApplication_2Rank() {
        assertRandomUniqueNumbersInRangeTest(
                () -> {
                    run("4000", "1,2,3,4,5,6", "7");
                    assertThat(output()).contains(
                            "4개를 구매했습니다.",
                            "[1, 2, 3, 4, 5, 7]",
                            "[3, 5, 11, 16, 32, 38]",
                            "[7, 11, 16, 35, 36, 44]",
                            "[1, 8, 11, 31, 41, 42]",
                            "3개 일치 (5,000원) - 0개",
                            "4개 일치 (50,000원) - 0개",
                            "5개 일치 (1,500,000원) - 0개",
                            "5개 일치, 보너스 볼 일치 (30,000,000원) - 1개",
                            "6개 일치 (2,000,000,000원) - 0개",
                            "총 수익률은 750000.0%입니다."
                    );
                },
                List.of(1, 2, 3, 4, 5, 7),
                List.of(3, 5, 11, 16, 32, 38),
                List.of(7, 11, 16, 35, 36, 44),
                List.of(1, 8, 11, 31, 41, 42)
        );
    }

    @DisplayName("전체 동작 테스트 3등 당첨 시")
    @Test
    void checkApplication_3Rank() {
        assertRandomUniqueNumbersInRangeTest(
                () -> {
                    run("4000", "1,2,3,4,5,6", "7");
                    assertThat(output()).contains(
                            "4개를 구매했습니다.",
                            "[1, 2, 3, 4, 5, 9]",
                            "[3, 5, 11, 16, 32, 38]",
                            "[7, 11, 16, 35, 36, 44]",
                            "[1, 8, 11, 31, 41, 42]",
                            "3개 일치 (5,000원) - 0개",
                            "4개 일치 (50,000원) - 0개",
                            "5개 일치 (1,500,000원) - 1개",
                            "5개 일치, 보너스 볼 일치 (30,000,000원) - 0개",
                            "6개 일치 (2,000,000,000원) - 0개",
                            "총 수익률은 37500.0%입니다."
                    );
                },
                List.of(1, 2, 3, 4, 5, 9),
                List.of(3, 5, 11, 16, 32, 38),
                List.of(7, 11, 16, 35, 36, 44),
                List.of(1, 8, 11, 31, 41, 42)
        );
    }

    @DisplayName("전체 동작 테스트 4등 당첨 시")
    @Test
    void checkApplication_4Rank() {
        assertRandomUniqueNumbersInRangeTest(
                () -> {
                    run("4000", "1,2,3,4,5,6", "7");
                    assertThat(output()).contains(
                            "4개를 구매했습니다.",
                            "[1, 2, 3, 4, 7, 10]",
                            "[3, 5, 11, 16, 32, 38]",
                            "[7, 11, 16, 35, 36, 44]",
                            "[1, 8, 11, 31, 41, 42]",
                            "3개 일치 (5,000원) - 0개",
                            "4개 일치 (50,000원) - 1개",
                            "5개 일치 (1,500,000원) - 0개",
                            "5개 일치, 보너스 볼 일치 (30,000,000원) - 0개",
                            "6개 일치 (2,000,000,000원) - 0개",
                            "총 수익률은 1250.0%입니다."
                    );
                },
                List.of(1, 2, 3, 4, 7, 10),
                List.of(3, 5, 11, 16, 32, 38),
                List.of(7, 11, 16, 35, 36, 44),
                List.of(1, 8, 11, 31, 41, 42)
        );
    }

    @DisplayName("전체 동작 테스트 5등 당첨 시")
    @Test
    void checkApplication_5Rank() {
        assertRandomUniqueNumbersInRangeTest(
                () -> {
                    run("4000", "1,2,3,4,5,6", "7");
                    assertThat(output()).contains(
                            "4개를 구매했습니다.",
                            "[1, 2, 3, 7, 8, 9]",
                            "[3, 5, 11, 16, 32, 38]",
                            "[7, 11, 16, 35, 36, 44]",
                            "[1, 8, 11, 31, 41, 42]",
                            "3개 일치 (5,000원) - 1개",
                            "4개 일치 (50,000원) - 0개",
                            "5개 일치 (1,500,000원) - 0개",
                            "5개 일치, 보너스 볼 일치 (30,000,000원) - 0개",
                            "6개 일치 (2,000,000,000원) - 0개",
                            "총 수익률은 125.0%입니다."
                    );
                },
                List.of(1, 2, 3, 7, 8, 9),
                List.of(3, 5, 11, 16, 32, 38),
                List.of(7, 11, 16, 35, 36, 44),
                List.of(1, 8, 11, 31, 41, 42)
        );
    }

    @DisplayName("전체 동작 테스트 미 당첨 시")
    @Test
    void checkApplication_NoRank() {
        assertRandomUniqueNumbersInRangeTest(
                () -> {
                    run("4000", "1,2,3,4,5,6", "7");
                    assertThat(output()).contains(
                            "4개를 구매했습니다.",
                            "[1, 2, 7, 9, 10, 12]",
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
                List.of(1, 2, 7, 9, 10, 12),
                List.of(3, 5, 11, 16, 32, 38),
                List.of(7, 11, 16, 35, 36, 44),
                List.of(1, 8, 11, 31, 41, 42)
        );
    }


    @DisplayName("구입 금액 1000에 배수가 아닐 경우")
    @Test
    void purchaseAmountNotMultipleOfThousandError() {
        assertSimpleTest(() -> {
            runException("1200");
            assertThat(output()).contains(ERROR_MESSAGE);
        });
    }

    @ParameterizedTest
    @DisplayName("구입 금액 범위를 벗어나는 경우")
    @ValueSource(strings = {"0", "101000", "200000"})
    void purchaseAmountBoundaryOverError(String test) {
        assertSimpleTest(() -> {
            runException(test);
            assertThat(output()).contains(ERROR_MESSAGE);
        });
    }

    @ParameterizedTest
    @DisplayName("딩첨 번호 범위를 벗어나는 경우")
    @ValueSource(strings = {"0", "46"})
    void winningNumberBoundaryOverError(String test) {
        String winningNumber = "1,2,3,4,5," + test;
        assertSimpleTest(() -> {
            runException("1000", winningNumber, "7");
            assertThat(output()).contains(ERROR_MESSAGE);
        });
    }

    @ParameterizedTest
    @DisplayName("딩첨 번호가 정수가 아닌 경우")
    @ValueSource(strings = {"0.1", "칠"})
    void winningNumberNotIntegerOverError(String test) {
        String winningNumber = "1,2,3,4,5," + test;
        assertSimpleTest(() -> {
            runException("1000", winningNumber, "7");
            assertThat(output()).contains(ERROR_MESSAGE);
        });
    }

    @DisplayName("딩첨 번호가 정수가 아닌 경우")
    @Test
    void winningNumberNot6Error() {
        String winningNumber = "1,2,3,4,5";
        assertSimpleTest(() -> {
            runException("1000", winningNumber, "7");
            assertThat(output()).contains(ERROR_MESSAGE);
        });
    }

    @ParameterizedTest
    @DisplayName("보너스 번호 범위를 벗어나는 경우")
    @ValueSource(strings = {"0", "46"})
    void bonusNumberBoundaryOverError(String test) {
        assertSimpleTest(() -> {
            runException("1000", "1,2,3,4,5,6", test);
            assertThat(output()).contains(ERROR_MESSAGE);
        });
    }

    @ParameterizedTest
    @DisplayName("보너스 번호가 정수값이 아닌 경우")
    @ValueSource(strings = {"0.1", "칠"})
    void bonusNumberNotIntegerError(String test) {
        assertSimpleTest(() -> {
            runException("1000", "1,2,3,4,5,6", test);
            assertThat(output()).contains(ERROR_MESSAGE);
        });
    }

    @Override
    protected void runMain() {
        Application.main(new String[]{});
    }
}
