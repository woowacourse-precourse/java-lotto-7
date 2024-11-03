package lotto.controller;

import camp.nextstep.edu.missionutils.test.NsTest;
import lotto.domain.LottoRank;
import lotto.service.ProfitCalculator;
import lotto.util.ErrorMessages;
import lotto.util.LottoValidator;
import org.junit.jupiter.api.Test;

import java.util.List;

import static camp.nextstep.edu.missionutils.test.Assertions.assertRandomUniqueNumbersInRangeTest;
import static camp.nextstep.edu.missionutils.test.Assertions.assertSimpleTest;
import static org.assertj.core.api.Assertions.*;

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
    void 로또_티켓_개수_계산() {
        run("8000", "8,21,23,41,42,43", "7");  // Example input: 구입금액, 당첨 번호, 보너스 번호
        assertThat(output()).contains("8개를 구매했습니다.");
    }

    @Test
    void 예외_테스트_구입금액_단위() {
        assertSimpleTest(() -> {
            runException("1500");
            assertThat(output()).contains(ERROR_MESSAGE);
        });
    }

    @Test
    void 당첨번호_중복_검사() {
        assertThatThrownBy(() -> LottoValidator.validateWinningNumbers(List.of(1, 2, 3, 4, 5, 6), 6))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(ErrorMessages.DUPLICATE_BONUS_NUMBER.getMessage());
    }

    @Test
    void 당첨번호_범위_검사() {
        assertThatThrownBy(() -> LottoValidator.validateWinningNumbers(List.of(1, 2, 3, 4, 5, 46), 7))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(ErrorMessages.INVALID_WINNING_NUMBER.getMessage());
    }

    @Test
    void 수익률_계산_테스트() {
        int[] matchCounts = new int[LottoRank.values().length];
        matchCounts[LottoRank.FIRST.ordinal()] = 1;
        matchCounts[LottoRank.FIFTH.ordinal()] = 2;

        int purchaseAmount = 5000;
        double profitRate = ProfitCalculator.calculateProfitRate(matchCounts, purchaseAmount);

        assertThat(profitRate).isCloseTo(40005000.00, within(5000.0));
    }

    @Override
    public void runMain() {
        Application.main(new String[]{});
    }
}