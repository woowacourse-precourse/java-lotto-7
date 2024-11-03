package lotto.domain;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.withPrecision;

import java.util.List;
import lotto.Lotto;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class LottoResultTest {

    private WinningLotto winningLotto;
    private LottoTickets lottoTickets;

    @BeforeEach
    void setUp() {
        Lotto winningNumbers = new Lotto(List.of(1, 2, 3, 4, 5, 6));
        int bonusNumber = 7;
        winningLotto = new WinningLotto(winningNumbers, bonusNumber);

        lottoTickets = new LottoTickets(List.of(
                new Lotto(List.of(1, 2, 3, 4, 5, 6)),
                new Lotto(List.of(1, 2, 3, 4, 5, 7)),
                new Lotto(List.of(1, 2, 3, 4, 5, 40)),
                new Lotto(List.of(1, 2, 3, 4, 40, 41)),
                new Lotto(List.of(1, 2, 3, 40, 41, 42)),
                new Lotto(List.of(1, 2, 40, 41, 42, 43))
        ));
    }

    @Test
    @DisplayName("로또 결과가 정상적으로 계산되는지 테스트")
    void 로또_결과_계산_테스트() {
        LottoResult lottoResult = new LottoResult(lottoTickets, winningLotto);

        assertThat(lottoResult.get(Rank.FIRST_PLACE)).isEqualTo(1);
        assertThat(lottoResult.get(Rank.SECOND_PLACE)).isEqualTo(1);
        assertThat(lottoResult.get(Rank.THIRD_PLACE)).isEqualTo(1);
        assertThat(lottoResult.get(Rank.FOURTH_PLACE)).isEqualTo(1);
        assertThat(lottoResult.get(Rank.FIFTH_PLACE)).isEqualTo(1);
        assertThat(lottoResult.get(Rank.MISS)).isEqualTo(1);
    }

    @Test
    @DisplayName("수익률 계산 테스트")
    void 수익률_계산_테스트() {
        LottoResult lottoResult = new LottoResult(lottoTickets, winningLotto);
        double profitRate = lottoResult.calculateProfitRate(new PurchaseAmount(6_000));
        double expectedProfitRate = ((double)2_031_555_000/6_000) * 100;
        assertThat(profitRate).isCloseTo(expectedProfitRate, withPrecision(1e-5));
    }
}