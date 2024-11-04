package lotto;

import java.util.Collections;
import lotto.domain.BonusNumber;
import lotto.domain.Lotto;
import lotto.domain.Purchase;
import lotto.domain.Rank;
import lotto.domain.Statistics;
import lotto.domain.WinningNumbers;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;
import java.util.Map;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.AssertionsForClassTypes.assertThatThrownBy;

class StatisticsTest {
    @DisplayName("로또 통계 결과를 올바르게 계산한다.")
    @Test
    void 로또_통계_결과를_올바르게_계산한다() {
        Purchase purchase = new Purchase(14000);
        WinningNumbers winningNumbers = new WinningNumbers("1,2,3,4,5,7");
        BonusNumber bonusNumber = new BonusNumber(6, winningNumbers);
        List<Lotto> lottos = List.of(
                new Lotto(List.of(1, 2, 3, 4, 5, 6)), // 1등
                new Lotto(List.of(1, 2, 3, 4, 5, 7)), // 2등
                new Lotto(List.of(1, 2, 3, 4, 5, 8)), // 3등
                new Lotto(List.of(1, 2, 3, 4, 8, 9))  // 4등
        );

        Statistics statistics = new Statistics(lottos, winningNumbers, bonusNumber, purchase);
        Map<Rank, Integer> results = statistics.getResults();

        assertThat(results.get(Rank.FIRST)).isEqualTo(1);
        assertThat(results.get(Rank.SECOND)).isEqualTo(1);
        assertThat(results.get(Rank.THIRD)).isEqualTo(1);
        assertThat(results.get(Rank.FOURTH)).isEqualTo(1);
    }

    @DisplayName("로또 수익률을 올바르게 계산한다.")
    @Test
    void 로또_수익률을_올바르게_계산한다() {
        Purchase purchase = new Purchase(14000);
        WinningNumbers winningNumbers = new WinningNumbers("1,2,3,4,5,7");
        BonusNumber bonusNumber = new BonusNumber(6, winningNumbers);
        List<Lotto> lottos = List.of(
                new Lotto(List.of(1, 2, 3, 4, 5, 6)), // 1등
                new Lotto(List.of(1, 2, 3, 4, 5, 7)), // 2등
                new Lotto(List.of(1, 2, 3, 4, 5, 8)), // 3등
                new Lotto(List.of(1, 2, 3, 4, 8, 9))  // 4등
        );

        Statistics statistics = new Statistics(lottos, winningNumbers, bonusNumber, purchase);
        double yield = statistics.calculateYield();

        assertThat(yield).isEqualTo(14511071.4); //수익률
    }

    @DisplayName("당첨 결과가 없거나 구매 금액이 설정되지 않은 상태에서 수익률 계산 시 예외가 발생한다.")
    @Test
    void 당첨_결과가_없거나_구매_금액이_설정되지_않은_상태에서_수익률_계산_시_예외가_발생한다() {
        List<Lotto> emptyLottos = Collections.emptyList();
        WinningNumbers winningNumbers = new WinningNumbers("1,2,3,4,5,6");
        BonusNumber bonusNumber = new BonusNumber(7, winningNumbers);
        Purchase purchase = new Purchase(0);

        Statistics statistics = new Statistics(emptyLottos, winningNumbers, bonusNumber, purchase);

        assertThatThrownBy(statistics::calculateYield)
                .isInstanceOf(IllegalStateException.class)
                .hasMessageContaining("[ERROR] 당첨 결과가 없거나 유효한 구매 금액이 설정되지 않았습니다.");
    }

}
