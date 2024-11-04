package lotto.service;

import lotto.domain.Lotto;
import lotto.domain.Rank;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;
import java.util.Map;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class LottoServiceTest {

    private LottoService lottoService;

    @BeforeEach
    void setUp() {
        lottoService = new LottoService();
    }

    @DisplayName("구매 금액이 1000원 단위가 아니면 예외가 발생한다")
    @Test
    void 구매_금액이_1000원_단위가_아니면_예외가_발생한다() {
        assertThatThrownBy(() -> lottoService.purchaseLotto(1500))
            .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("올바른 구매 금액으로 로또를 구매하면 해당 개수의 로또가 발행된다")
    @Test
    void 올바른_구매_금액으로_로또를_구매하면_해당_개수의_로또가_발행된다() {
        List<Lotto> lottos = lottoService.purchaseLotto(5000);
        assertThat(lottos).hasSize(5);
    }

    @DisplayName("로또 결과를 계산하여 당첨 횟수를 반환한다")
    @Test
    void 로또_결과를_계산하여_당첨_횟수를_반환한다() {
        List<Lotto> lottos = List.of(
            new Lotto(List.of(1, 2, 3, 4, 5, 6)),
            new Lotto(List.of(1, 2, 3, 4, 5, 7)),
            new Lotto(List.of(1, 2, 3, 4, 5, 9)),
            new Lotto(List.of(1, 2, 3, 4, 7, 9)),
            new Lotto(List.of(1, 2, 3, 4, 8, 9)),
            new Lotto(List.of(8, 10, 3, 4, 5, 9))
        );
        List<Integer> winningNumbers = List.of(1, 2, 3, 4, 5, 6);
        int bonusNumber = 7;

        Map<Rank, Integer> result = lottoService.calculateResult(lottos, winningNumbers, bonusNumber);

        assertThat(result.get(Rank.FIRST)).isEqualTo(1);
        assertThat(result.get(Rank.SECOND)).isEqualTo(1);
        assertThat(result.get(Rank.THIRD)).isEqualTo(1);
        assertThat(result.get(Rank.FOURTH)).isEqualTo(1);
        assertThat(result.get(Rank.FIFTH)).isEqualTo(1);
        assertThat(result.get(Rank.NONE)).isEqualTo(1);
    }

    @DisplayName("투자 금액과 당첨 결과로 수익률을 계산한다")
    @Test
    void 투자_금액과_당첨_결과로_수익률을_계산한다() {
        Map<Rank, Integer> result = Map.of(
            Rank.FIFTH, 1
        );
        int investmentMoney = 10000;

        int expectedProfit = Rank.FIFTH.getPrize() * 1;
        double expectedProfitRate = ((double) expectedProfit / investmentMoney) * 100; // 50%

        double profitRate = lottoService.calculateProfitRate(result, investmentMoney);

        assertThat(profitRate).isEqualTo(expectedProfitRate);
    }
}
