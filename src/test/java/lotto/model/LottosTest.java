package lotto.model;

import static lotto.lottoapp.model.value.WinningResult.FIFTH;
import static lotto.lottoapp.model.value.WinningResult.FIRST;
import static lotto.lottoapp.model.value.WinningResult.FOURTH;
import static lotto.lottoapp.model.value.WinningResult.SECOND;
import static lotto.lottoapp.model.value.WinningResult.THIRD;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatCode;

import java.math.BigDecimal;
import java.util.List;
import lotto.lottoapp.model.AutomaticLottoNumbersGenerator;
import lotto.lottoapp.model.Lottos;
import lotto.lottoapp.model.WinningLotto;
import lotto.lottoapp.model.value.BonusNumber;
import lotto.lottoapp.model.value.LottoNumbers;
import lotto.lottoapp.model.value.WinningStatistics;
import lotto.lottoapp.model.value.Won;
import org.junit.jupiter.api.Test;

class LottosTest {

    public static final Class<IllegalArgumentException> COMMON_EXCEPTION = IllegalArgumentException.class;

    @Test
    void 생성방법을_지정하여_로또들을_생성할수있다() {
        assertThatCode(() -> Lottos.by(new AutomaticLottoNumbersGenerator()))
                .doesNotThrowAnyException();

        assertThatCode(() -> Lottos.by(null))
                .isInstanceOf(COMMON_EXCEPTION);
    }

    @Test
    void 원화로_로또들을_구매할수있다() {
        Lottos lottos = Lottos.by(new SequentialLottoNumberGenerator());
        lottos.buyFor(Won.of(3_000));
        List<LottoNumbers> purchased = lottos.getLottoNumbers();

        assertThatCode(() -> lottos.buyFor(Won.of(3_000)))
                .doesNotThrowAnyException();
        assertThat(purchased.size()).isEqualTo(3);
        assertThat(purchased.get(0)).isEqualTo(LottoNumbers.of(List.of(1, 2, 3, 4, 5, 6)));
        assertThat(purchased.get(1)).isEqualTo(LottoNumbers.of(List.of(7, 8, 9, 10, 11, 12)));
        assertThat(purchased.get(2)).isEqualTo(LottoNumbers.of(List.of(13, 14, 15, 16, 17, 18)));
    }

    @Test
    void 당첨로또를통해_구매한로또들의_당첨여부들을_알수있다() {
        Lottos lottos = Lottos.by(new SequentialLottoNumberGenerator());
        lottos.buyFor(Won.of(5_000));
        List<LottoNumbers> lottoNumbers = lottos.getLottoNumbers();
        WinningLotto winningLotto = new WinningLotto(LottoNumbers.of(List.of(1, 2, 3, 21, 31, 41)), new BonusNumber(7));

        WinningStatistics winningStatistics = lottos.calculateWinningStatistics(winningLotto);
        assertThat(winningStatistics.findWinningBy(5).getKey()).isEqualTo(FIFTH);
        assertThat(winningStatistics.findWinningBy(FIFTH.ranking).getKey()).isEqualTo(FIFTH);
        assertThat(winningStatistics.findWinningBy(FIFTH.ranking).getValue()).isEqualTo(1L);
        assertThat(winningStatistics.findWinningBy(FOURTH.ranking).getValue()).isEqualTo(0L);
        assertThat(winningStatistics.findWinningBy(THIRD.ranking).getValue()).isEqualTo(0L);
        assertThat(winningStatistics.findWinningBy(SECOND.ranking).getValue()).isEqualTo(0L);
        assertThat(winningStatistics.findWinningBy(FIRST.ranking).getValue()).isEqualTo(0L);

        assertThat(winningStatistics.getRateReturn()).isEqualTo(new BigDecimal("100.0"));
    }

}