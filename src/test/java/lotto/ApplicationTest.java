package lotto;

import camp.nextstep.edu.missionutils.test.NsTest;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static camp.nextstep.edu.missionutils.test.Assertions.assertRandomUniqueNumbersInRangeTest;
import static camp.nextstep.edu.missionutils.test.Assertions.assertSimpleTest;
import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

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

    @Test
    void 총_당첨금_계산_테스트() {
        Map<Rank, Integer> results = new HashMap<>();
        results.put(Rank.FIRST, 1);    // 1등 1개
        results.put(Rank.SECOND, 2);   // 2등 2개
        results.put(Rank.THIRD, 0);    // 3등 없음
        results.put(Rank.FOURTH, 3);   // 4등 3개
        results.put(Rank.FIFTH, 5);    // 5등 5개

        int totalPrize = Application.calculateTotalPrize(results);
        assertEquals(2_000_000_000 + 2 * 30_000_000 + 3 * 50_000 + 5 * 5_000, totalPrize);
    }

    @Test
    void 수익률_계산_테스트() {
        int totalPrize = 1_500_000;  // 당첨금 1,500,000원
        int purchaseAmount = 5_000_000; // 구입 금액 5,000,000원

        double profitRate = Application.calculateProfitRate(totalPrize, purchaseAmount);
        assertEquals(30.0, profitRate, 0.1); // 예상 수익률 30.0%
    }

    @Test
    void 구입금액이_잘못된_케이스_테스트() {
        int invalidAmount = 1500; // 1000원 단위가 아님
        assertThrows(IllegalArgumentException.class, () -> Application.validateAmount(invalidAmount));
    }

    @Test
    void 잘못된_당첨번호_입력_테스트() {
        List<Integer> invalidWinningNumbers = Arrays.asList(1, 1, 2, 3, 4, 5); // 중복된 번호
        assertThrows(IllegalArgumentException.class, () -> Application.validateWinningNumbers(invalidWinningNumbers));
    }

    @Override
    public void runMain() {
        Application.main(new String[]{});
    }
}
