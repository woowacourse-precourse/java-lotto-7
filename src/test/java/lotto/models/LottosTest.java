package lotto.models;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;
import java.util.Map;
import lotto.Lotto;
import lotto.dto.BonusNumberRequestDTO;
import lotto.dto.WinningNumberRequestDTO;
import lotto.model.BonusNumber;
import lotto.model.LottoDraw;
import lotto.model.constant.LottoRank;
import lotto.model.Lottos;
import lotto.model.WinningNumbers;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class LottosTest {

    @Test
    @DisplayName("당첨 통계를 계산한다.")
    public void lottoDraw() {
        // GIVEN
        LottoDraw lottoDraw = new LottoDraw(new WinningNumbers(new WinningNumberRequestDTO("1,2,3,4,5,6")),
                new BonusNumber(new BonusNumberRequestDTO("7")));
        Lotto first = new Lotto(List.of(1, 2, 3, 4, 5, 6));
        Lotto second = new Lotto(List.of(1, 2, 3, 4, 5, 7));
        Lotto third = new Lotto(List.of(1, 2, 3, 4, 5, 45));
        Lotto fourth = new Lotto(List.of(1, 2, 3, 4, 44, 45));
        Lotto fifth = new Lotto(List.of(1, 2, 3, 43, 44, 45));
        Lotto none = new Lotto(List.of(11,12,13,14,15,16));
        Lottos lottos = new Lottos(List.of(first, second, third, fourth, fifth, none));

        // WHEN
        Map<LottoRank, Integer> results = lottos.getLottoResults(lottoDraw);

        // THEN
        assertThat(results.get(LottoRank.FIRST)).isEqualTo(1);
        assertThat(results.get(LottoRank.SECOND)).isEqualTo(1);
        assertThat(results.get(LottoRank.THIRD)).isEqualTo(1);
        assertThat(results.get(LottoRank.FOURTH)).isEqualTo(1);
        assertThat(results.get(LottoRank.FIFTH)).isEqualTo(1);
        assertThat(results.get(LottoRank.NONE)).isEqualTo(1);
    }
}
