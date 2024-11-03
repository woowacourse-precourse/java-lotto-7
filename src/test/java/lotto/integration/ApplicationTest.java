package lotto.integration;

import static camp.nextstep.edu.missionutils.test.Assertions.assertRandomUniqueNumbersInRangeTest;
import static org.assertj.core.api.Assertions.assertThat;

import camp.nextstep.edu.missionutils.test.NsTest;
import java.util.List;
import lotto.Application;
import org.junit.jupiter.api.Test;

class ApplicationTest extends NsTest {
    @Test
    void 통합_테스트_새로운_숫자들() {
        assertRandomUniqueNumbersInRangeTest(
                () -> {
                    run("5000", "10,20,30,40,41,42", "43");
                    assertThat(output()).contains(
                            "5개를 구매했습니다.",
                            "[4, 15, 23, 35, 36, 44]",
                            "[7, 11, 16, 28, 37, 45]",
                            "[1, 8, 14, 20, 25, 39]",
                            "[10, 20, 30, 40, 41, 42]",
                            "[5, 18, 27, 33, 38, 43]",
                            "당첨 통계",
                            "---",
                            "3개 일치 (5,000원) - 0개",
                            "4개 일치 (50,000원) - 0개",
                            "5개 일치 (1,500,000원) - 0개",
                            "5개 일치, 보너스 볼 일치 (30,000,000원) - 0개",
                            "6개 일치 (2,000,000,000원) - 1개",
                            "총 수익률은 40000000.0%입니다."
                    );
                },
                List.of(4, 15, 23, 35, 36, 44),
                List.of(7, 11, 16, 28, 37, 45),
                List.of(1, 8, 14, 20, 25, 39),
                List.of(10, 20, 30, 40, 41, 42),
                List.of(5, 18, 27, 33, 38, 43)
        );
    }

    @Override
    public void runMain() {
        Application.main(new String[]{});
    }
}
