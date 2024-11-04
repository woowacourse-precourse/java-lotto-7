package lotto.model.lottowinningstrategy;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;
import lotto.model.Lotto;
import lotto.model.LottoRank;
import lotto.model.WinningNumbers;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class LottoWinningStrategyTest {

    @DisplayName("로또 당첨 순위를 계산할 수 있다.")
    @Test
    void calculateRank() {
        //given
        Lotto lotto = Lotto.from(List.of(1, 2, 3, 4, 5, 6));
        Lotto winningLottoNumbers = Lotto.from(List.of(1, 2, 3, 4, 5, 6));

        WinningNumbers winningNumbers = WinningNumbers.of(winningLottoNumbers, 7);

        LottoWinningStrategy lottoWinningStrategy = new LottoWinningStrategy();

        //when
        LottoRank lottoRank = lottoWinningStrategy.calculateRank(lotto, winningNumbers);

        //then
        assertThat(lottoRank).isEqualTo(LottoRank.FIRST);
    }
}
