package lotto.presentation;

import lotto.domain.Prize;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;

class LottoResultSummaryTest {

    @DisplayName("모든 등수가 0개여도 요약 형식이 포함된다.")
    @Test
    void generateSummary_AllPrizesIncludedWithZeroes() {
        // given
        List<Prize> winnings = List.of(Prize.NONE);
        LottoResultSummary resultFactory = new LottoResultSummary(winnings);

        // when
        String summary = resultFactory.generateSummary();

        // then
        String expectedSummary = String.join(System.lineSeparator(),
                "3개 일치 (5,000원) - 0개",
                "4개 일치 (50,000원) - 0개",
                "5개 일치 (1,500,000원) - 0개",
                "5개 일치, 보너스 볼 일치 (30,000,000원) - 0개",
                "6개 일치 (2,000,000,000원) - 0개"
        );

        assertThat(summary).isEqualTo(expectedSummary);
    }

    @DisplayName("여러 등수의 당첨 결과를 요약할 수 있다.")
    @Test
    void generateSummary_MultiplePrizes() {
        // given
        List<Prize> winnings = List.of(
                Prize.THREE, Prize.THREE, Prize.FIVE_BONUS,
                Prize.SIX
        );
        LottoResultSummary resultFactory = new LottoResultSummary(winnings);

        // when
        String summary = resultFactory.generateSummary();

        // then
        String expectedSummary = String.join(System.lineSeparator(),
                "3개 일치 (5,000원) - 2개",
                "4개 일치 (50,000원) - 0개",
                "5개 일치 (1,500,000원) - 0개",
                "5개 일치, 보너스 볼 일치 (30,000,000원) - 1개",
                "6개 일치 (2,000,000,000원) - 1개"
        );

        assertThat(summary).isEqualTo(expectedSummary);
    }

    @DisplayName("1개 등수에 여러 번 당첨된 결과를 요약할 수 있다.")
    @Test
    void generateSummary_SinglePrizeMultipleTimes() {
        // given
        List<Prize> winnings = List.of(Prize.FOUR, Prize.FOUR, Prize.FOUR);
        LottoResultSummary resultFactory = new LottoResultSummary(winnings);

        // when
        String summary = resultFactory.generateSummary();

        // then
        String expectedSummary = String.join(System.lineSeparator(),
                "3개 일치 (5,000원) - 0개",
                "4개 일치 (50,000원) - 3개",
                "5개 일치 (1,500,000원) - 0개",
                "5개 일치, 보너스 볼 일치 (30,000,000원) - 0개",
                "6개 일치 (2,000,000,000원) - 0개"
        );

        assertThat(summary).isEqualTo(expectedSummary);
    }
}
