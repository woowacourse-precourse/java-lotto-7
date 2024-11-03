package lotto.model;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;
import java.util.Map;
import lotto.model.lottowinningstrategy.LottoWinningStrategy;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class LottoWinningCalculatorTest {

    @DisplayName("당첨 결과를 계산할 수 있다.")
    @Test
    void calculateWinningResult() {
        //given
        Lottos lottos = new Lottos(List.of(
                Lotto.from(List.of(1, 2, 3, 4, 5, 6)),
                Lotto.from(List.of(7, 8, 9, 10, 11, 12))
        ));

        WinningNumbers winningNumbers = WinningNumbers.of(
                Lotto.from(List.of(1, 2, 3, 4, 5, 6)), 7
        );

        LottoWinningCalculator winningCalculator = new LottoWinningCalculator(new LottoWinningStrategy());

        //when
        LottoWinningResult lottoWinningResult = winningCalculator.calculateWinningResult(lottos, winningNumbers);

        //then
        Map<LottoRank, Integer> compareResult = Map.of(
                LottoRank.FIRST, 1,
                LottoRank.NO_LUCK, 1
        );

        assertThat(lottoWinningResult.getLottoWinningResult()).isEqualTo(compareResult);
    }
}
