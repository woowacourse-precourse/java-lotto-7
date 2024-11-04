package lotto;

import static camp.nextstep.edu.missionutils.test.Assertions.assertRandomUniqueNumbersInRangeTest;
import static camp.nextstep.edu.missionutils.test.Assertions.assertSimpleTest;
import static org.assertj.core.api.Assertions.assertThat;

import camp.nextstep.edu.missionutils.test.NsTest;
import java.util.List;
import org.junit.jupiter.api.DisplayName;
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
    @DisplayName("기능 테스트 - 다양한 당첨 조합")
    void 기능_테스트_1() {
        assertRandomUniqueNumbersInRangeTest(
                () -> {
                    run("5000", "10,20,30,40,41,42", "43"); // 구입 금액: 5000원, 티켓 5장 구매
                    assertThat(output()).contains(
                            "5개를 구매했습니다.",
                            "[4, 12, 22, 30, 40, 41]",     // 3개 일치
                            "[10, 20, 30, 40, 41, 45]",    // 5개 일치
                            "[10, 11, 12, 30, 40, 41]",    // 4개 일치
                            "[5, 10, 15, 20, 30, 45]",     // 3개 일치
                            "[10, 20, 30, 40, 41, 43]",    // 5개 일치, 보너스 일치
                            "3개 일치 (5,000원) - 2개",
                            "4개 일치 (50,000원) - 1개",
                            "5개 일치 (1,500,000원) - 1개",
                            "5개 일치, 보너스 볼 일치 (30,000,000원) - 1개",
                            "6개 일치 (2,000,000,000원) - 0개",
                            "총 수익률은 631200.0%입니다."
                    );
                },
                List.of(4, 12, 22, 30, 40, 41),
                List.of(10, 20, 30, 40, 41, 45),
                List.of(10, 11, 12, 30, 40, 41),
                List.of(5, 10, 15, 20, 30, 45),
                List.of(10, 20, 30, 40, 41, 43)
        );
    }

    @Test
    @DisplayName("기능 테스트 - 3개 일치 수익률 500%")
    void 기능_테스트_3개_일치() {
        assertRandomUniqueNumbersInRangeTest(
                () -> {
                    run("1000", "1,2,3,8,9,10", "7"); // 구입 금액: 1000원, 티켓 1장 구매
                    assertThat(output()).contains(
                            "1개를 구매했습니다.",
                            "[1, 2, 3, 19, 20, 30]", // 1, 2, 3이 당첨 번호와 일치
                            "3개 일치 (5,000원) - 1개",
                            "4개 일치 (50,000원) - 0개",
                            "5개 일치 (1,500,000원) - 0개",
                            "5개 일치, 보너스 볼 일치 (30,000,000원) - 0개",
                            "6개 일치 (2,000,000,000원) - 0개",
                            "총 수익률은 500.0%입니다."
                    );
                },
                List.of(1, 2, 3, 19, 20, 30) // 당첨 번호와 3개가 일치
        );
    }

    @Test
    @DisplayName("기능 테스트 - 4개 일치 수익률 5000%")
    void 기능_테스트_4개_일치() {
        assertRandomUniqueNumbersInRangeTest(
                () -> {
                    run("1000", "1,2,3,4,8,9", "7"); // 구입 금액: 1000원, 티켓 1장 구매
                    assertThat(output()).contains(
                            "1개를 구매했습니다.",
                            "[1, 2, 3, 4, 20, 30]", // 1, 2, 3, 4가 당첨 번호와 일치
                            "3개 일치 (5,000원) - 0개",
                            "4개 일치 (50,000원) - 1개",
                            "5개 일치 (1,500,000원) - 0개",
                            "5개 일치, 보너스 볼 일치 (30,000,000원) - 0개",
                            "6개 일치 (2,000,000,000원) - 0개",
                            "총 수익률은 5000.0%입니다."
                    );
                },
                List.of(1, 2, 3, 4, 20, 30) // 당첨 번호와 4개가 일치
        );
    }

    @Test
    @DisplayName("기능 테스트 - 5개 일치 수익률 150000%")
    void 기능_테스트_5개_일치() {
        assertRandomUniqueNumbersInRangeTest(
                () -> {
                    run("1000", "1,2,3,4,5,9", "7"); // 구입 금액: 1000원, 티켓 1장 구매
                    assertThat(output()).contains(
                            "1개를 구매했습니다.",
                            "[1, 2, 3, 4, 5, 30]", // 1, 2, 3, 4, 5가 당첨 번호와 일치
                            "3개 일치 (5,000원) - 0개",
                            "4개 일치 (50,000원) - 0개",
                            "5개 일치 (1,500,000원) - 1개",
                            "5개 일치, 보너스 볼 일치 (30,000,000원) - 0개",
                            "6개 일치 (2,000,000,000원) - 0개",
                            "총 수익률은 150000.0%입니다."
                    );
                },
                List.of(1, 2, 3, 4, 5, 30) // 당첨 번호와 5개가 일치
        );
    }

    @Test
    @DisplayName("기능 테스트 - 5개 일치 + 보너스 볼 일치 수익률 3000000%")
    void 기능_테스트_5개_일치_보너스() {
        assertRandomUniqueNumbersInRangeTest(
                () -> {
                    run("1000", "1,2,3,4,5,8", "6"); // 구입 금액: 1000원, 티켓 1장 구매
                    assertThat(output()).contains(
                            "1개를 구매했습니다.",
                            "[1, 2, 3, 4, 5, 6]", // 1, 2, 3, 4, 5가 당첨 번호와 일치, 보너스 번호도 일치
                            "3개 일치 (5,000원) - 0개",
                            "4개 일치 (50,000원) - 0개",
                            "5개 일치 (1,500,000원) - 0개",
                            "5개 일치, 보너스 볼 일치 (30,000,000원) - 1개",
                            "6개 일치 (2,000,000,000원) - 0개",
                            "총 수익률은 3000000.0%입니다."
                    );
                },
                List.of(1, 2, 3, 4, 5, 6) // 당첨 번호와 5개 일치 + 보너스 볼 일치
        );
    }

    @Test
    @DisplayName("기능 테스트 - 6개 일치 수익률 200000000%")
    void 기능_테스트_6개_일치() {
        assertRandomUniqueNumbersInRangeTest(
                () -> {
                    run("1000", "1,2,3,4,5,6", "7"); // 구입 금액: 1000원, 티켓 1장 구매
                    assertThat(output()).contains(
                            "1개를 구매했습니다.",
                            "[1, 2, 3, 4, 5, 6]", // 1, 2, 3, 4, 5, 6이 당첨 번호와 일치
                            "3개 일치 (5,000원) - 0개",
                            "4개 일치 (50,000원) - 0개",
                            "5개 일치 (1,500,000원) - 0개",
                            "5개 일치, 보너스 볼 일치 (30,000,000원) - 0개",
                            "6개 일치 (2,000,000,000원) - 1개",
                            "총 수익률은 200000000.0%입니다."
                    );
                },
                List.of(1, 2, 3, 4, 5, 6) // 당첨 번호와 6개가 일치
        );
    }


    @Test
    void 예외_테스트() {
        assertSimpleTest(() -> {
            runException("1000j");
            assertThat(output()).contains(ERROR_MESSAGE);
        });
    }

    @Override
    public void runMain() {
        Application.main(new String[]{});
    }
}
