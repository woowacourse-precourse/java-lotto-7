package lotto;

import camp.nextstep.edu.missionutils.test.NsTest;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static camp.nextstep.edu.missionutils.test.Assertions.assertRandomUniqueNumbersInRangeTest;
import static camp.nextstep.edu.missionutils.test.Assertions.assertSimpleTest;
import static org.assertj.core.api.Assertions.assertThat;

class RankTest extends NsTest {
    private static final String ERROR_MESSAGE = "[ERROR]";

    @DisplayName("1등 테스트")
    @Test
    void 등수_테스트1() {
        assertRandomUniqueNumbersInRangeTest(
                () -> {
                    run("5000","13,14,16,38,42,45","43");
                    assertThat(output()).contains(
                            "5개를 구매했습니다.",
                            "[13, 14, 16, 38, 42, 45]",
                            "[13, 14, 16, 38, 42, 45]",
                            "[13, 14, 16, 38, 42, 45]",
                            "[13, 14, 16, 38, 42, 45]",
                            "[13, 14, 16, 38, 42, 45]",
                            "3개 일치 (5,000원) - 0개",
                            "4개 일치 (50,000원) - 0개",
                            "5개 일치 (1,500,000원) - 0개",
                            "5개 일치, 보너스 볼 일치 (30,000,000원) - 0개",
                            "6개 일치 (2,000,000,000원) - 5개",
                            "총 수익률은 28201308.2%입니다."
                    );
                },
                List.of(13, 14, 16, 38, 42, 45),
                List.of(13, 14, 16, 38, 42, 45),
                List.of(13, 14, 16, 38, 42, 45),
                List.of(13, 14, 16, 38, 42, 45),
                List.of(13, 14, 16, 38, 42, 45)
        );
    }

    @DisplayName("2등 테스트")
    @Test
    void 등수_테스트2() {
        assertRandomUniqueNumbersInRangeTest(
                () -> {
                    run("5000","13,14,16,38,42,43","45");
                    assertThat(output()).contains(
                            "5개를 구매했습니다.",
                            "[8, 21, 23, 41, 42, 43]",
                            "[3, 5, 11, 16, 32, 38]",
                            "[7, 11, 16, 35, 36, 44]",
                            "[1, 8, 11, 31, 41, 42]",
                            "[13, 14, 16, 38, 42, 45]",
                            "3개 일치 (5,000원) - 0개",
                            "4개 일치 (50,000원) - 0개",
                            "5개 일치 (1,500,000원) - 0개",
                            "5개 일치, 보너스 볼 일치 (30,000,000원) - 1개",
                            "6개 일치 (2,000,000,000원) - 0개",
                            "총 수익률은 600000.0%입니다."
                    );
                },
                List.of(8, 21, 23, 41, 42, 43),
                List.of(3, 5, 11, 16, 32, 38),
                List.of(7, 11, 16, 35, 36, 44),
                List.of(1, 8, 11, 31, 41, 42),
                List.of(13, 14, 16, 38, 42, 45)
        );
    }

    @DisplayName("3등 테스트")
    @Test
    void 등수_테스트3() {
        assertRandomUniqueNumbersInRangeTest(
                () -> {
                    run("3000","3,5,11,16,32,42","45");
                    assertThat(output()).contains(
                            "3개를 구매했습니다.",
                            "[8, 21, 23, 41, 42, 43]",
                            "[3, 5, 11, 16, 32, 38]",
                            "[7, 11, 16, 35, 36, 44]",
                            "3개 일치 (5,000원) - 0개",
                            "4개 일치 (50,000원) - 0개",
                            "5개 일치 (1,500,000원) - 1개",
                            "5개 일치, 보너스 볼 일치 (30,000,000원) - 0개",
                            "6개 일치 (2,000,000,000원) - 0개"
                    );
                },
                List.of(8, 21, 23, 41, 42, 43),
                List.of(3, 5, 11, 16, 32, 38),
                List.of(7, 11, 16, 35, 36, 44)
        );
    }

    @DisplayName("4등 테스트")
    @Test
    void 등수_테스트4() {
        assertRandomUniqueNumbersInRangeTest(
                () -> {
                    run("3000","3,5,11,16,41,42","38");
                    assertThat(output()).contains(
                            "3개를 구매했습니다.",
                            "[8, 21, 23, 41, 42, 43]",
                            "[3, 5, 11, 16, 32, 38]",
                            "[7, 11, 16, 35, 36, 44]",
                            "3개 일치 (5,000원) - 0개",
                            "4개 일치 (50,000원) - 1개",
                            "5개 일치 (1,500,000원) - 0개",
                            "5개 일치, 보너스 볼 일치 (30,000,000원) - 0개",
                            "6개 일치 (2,000,000,000원) - 0개"
                    );
                },
                List.of(8, 21, 23, 41, 42, 43),
                List.of(3, 5, 11, 16, 32, 38),
                List.of(7, 11, 16, 35, 36, 44)
        );
    }

    @DisplayName("5등 테스트")
    @Test
    void 등수_테스트5() {
        assertRandomUniqueNumbersInRangeTest(
                () -> {
                    run("3000","3,5,11,17,41,42","38");
                    assertThat(output()).contains(
                            "3개를 구매했습니다.",
                            "[8, 21, 23, 41, 42, 43]",
                            "[3, 5, 11, 16, 32, 38]",
                            "[7, 11, 16, 35, 36, 44]",
                            "3개 일치 (5,000원) - 1개",
                            "4개 일치 (50,000원) - 0개",
                            "5개 일치 (1,500,000원) - 0개",
                            "5개 일치, 보너스 볼 일치 (30,000,000원) - 0개",
                            "6개 일치 (2,000,000,000원) - 0개"
                    );
                },
                List.of(8, 21, 23, 41, 42, 43),
                List.of(3, 5, 11, 16, 32, 38),
                List.of(7, 11, 16, 35, 36, 44)
        );
    }

    @DisplayName("다중 등수 테스트")
    @Test
    void 등수_테스트Mixed() {
        assertRandomUniqueNumbersInRangeTest(
                () -> {
                    run("5000","10,20,30,40,5,6","38");
                    assertThat(output()).contains(
                            "5개를 구매했습니다.",
                            "[5, 6, 10, 20, 30, 40]",
                            "[5, 6, 10, 20, 30, 38]",
                            "[5, 6, 10, 20, 30, 44]",
                            "[5, 6, 10, 20, 31, 41]",
                            "[5, 6, 10, 21, 31, 41]",
                            "3개 일치 (5,000원) - 1개",
                            "4개 일치 (50,000원) - 1개",
                            "5개 일치 (1,500,000원) - 1개",
                            "5개 일치, 보너스 볼 일치 (30,000,000원) - 1개",
                            "6개 일치 (2,000,000,000원) - 1개"
                    );
                },
                List.of(5, 6, 10, 20, 30, 40),
                List.of(5, 6, 10, 20, 30, 38),
                List.of(5, 6, 10, 20, 30, 44),
                List.of(5, 6, 10, 20, 31, 41),
                List.of(5, 6, 10, 21, 31, 41)
        );
    }


    @Override
    public void runMain() {
        Application.main(new String[]{});
    }
}
