package lotto;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.*;

class ResultTest {
    @Test
    @DisplayName("로또 티켓과 당첨 번호를 비교하여 올바른 당첨 내역이 계산된다.")
    void 로또_티켓과_당첨_번호를_비교하여_올바른_당첨_내역이_계산된다() {
        List<Lotto> tickets = List.of(
                new Lotto(List.of(8, 21, 23, 41, 42, 43)),
                new Lotto(List.of(3, 5, 11, 16, 32, 38)),
                new Lotto(List.of(7, 11, 16, 35, 36, 44)),
                new Lotto(List.of(1, 8, 11, 31, 41, 42)),
                new Lotto(List.of(13, 14, 16, 38, 42, 45)),
                new Lotto(List.of(7, 11, 30, 40, 42, 43)),
                new Lotto(List.of(2, 13, 22, 32, 38, 45)),
                new Lotto(List.of(1, 3, 5, 14, 22, 45))
        );

        Lotto winningLotto = new Lotto(List.of(1, 2, 3, 4, 5, 6));
        int bonus = 7;
        WinningNumbers winningNumbers = new WinningNumbers(winningLotto, bonus);

        Result result = Result.calculateResult(tickets, winningNumbers);

        assertThat(result.getRankCountMap()).containsEntry(Rank.FIFTH, 1)
                .containsEntry(Rank.NONE, 7);

        assertThat(result.getYield(8000)).isEqualTo(62.5);
    }

    @Test
    @DisplayName("수익률이 정확하게 계산된다.")
    void 수익률이_정확하게_계산된다() {
        List<Lotto> tickets = List.of(
                new Lotto(List.of(1, 2, 3, 4, 5, 6)), // 6개 일치
                new Lotto(List.of(1, 2, 3, 4, 5, 7)), // 5개 + 보너스
                new Lotto(List.of(1, 2, 3, 4, 5, 8)), // 5개
                new Lotto(List.of(1, 2, 3, 4, 9, 10)), // 4개
                new Lotto(List.of(1, 2, 3, 11, 12, 13))  // 3개
        );

        Lotto winningLotto = new Lotto(List.of(1, 2, 3, 4, 5, 6));
        int bonus = 7;
        WinningNumbers winningNumbers = new WinningNumbers(winningLotto, bonus);

        Result result = Result.calculateResult(tickets, winningNumbers);

        assertThat(result.getRankCountMap()).containsEntry(Rank.FIRST, 1)
                .containsEntry(Rank.SECOND, 1)
                .containsEntry(Rank.THIRD, 1)
                .containsEntry(Rank.FOURTH, 1)
                .containsEntry(Rank.FIFTH, 1)
                .containsEntry(Rank.NONE, 0);

        long expectedTotalPrize = 2000000000L + 30000000L + 1500000L + 50000L + 5000L;
        assertThat(result.getYield(5000)).isEqualTo(((double) expectedTotalPrize / 5000) * 100);
    }
}