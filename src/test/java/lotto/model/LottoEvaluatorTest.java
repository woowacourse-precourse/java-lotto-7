package lotto.model;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Collections;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

class LottoEvaluatorTest {
    LottoEvaluator lottoEvaluator;

    @BeforeEach
    void set_up() {
        Money money = new Money(8000);
        List<Lotto> lottos = List.of(
                new Lotto(List.of(8, 21, 23, 41, 42, 43)),
                new Lotto(List.of(3, 5, 11, 16, 32, 38)),
                new Lotto(List.of(7, 11, 16, 35, 36, 44)),
                new Lotto(List.of(1, 8, 11, 31, 41, 42)),
                new Lotto(List.of(13, 14, 16, 38, 42, 45)),
                new Lotto(List.of(7, 11, 30, 40, 42, 43)),
                new Lotto(List.of(2, 13, 22, 32, 38, 45)),
                new Lotto(List.of(1, 3, 5, 14, 22, 45))
        );

        WinningLotto winningLotto = new WinningLotto(
                new Lotto(List.of(1, 2, 3, 4, 5, 6)),
                new BonusNumber(7)
        );

        lottoEvaluator = new LottoEvaluator(money, lottos, winningLotto);
    }

    @Test
    @DisplayName("로또 결과 확인 가능 테스트")
    void 로또_결과_확인_기능() {
        //when
        List<LottoRank> lottoRanks = lottoEvaluator.evaluateTicketsRank();

        //then
        assertThat(Collections.frequency(lottoRanks, LottoRank.FIFTH)).isEqualTo(1);
        assertThat(Collections.frequency(lottoRanks, LottoRank.NONE)).isEqualTo(7);
    }

    @Test
    @DisplayName("수익률을 계산 할 수 있다.")
    void 수익률_계산_기능() {
        Double rate = lottoEvaluator.calculateRateOfReturn(5000);

        assertThat(rate).isEqualTo(62.5);
    }

}