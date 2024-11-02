package lotto.domain;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import java.util.List;
import org.junit.jupiter.api.Test;

class LottoGameTest {
    @Test
    void 초기금액이_천원으로_나누어떨어지지않으면_예외가_발생한다() {
        assertThatThrownBy(() -> new LottoGame(1500))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void 초기금액이_자연수가_아니면_예외가_발생한다() {
        assertThatThrownBy(() -> new LottoGame(-1000))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void 로또구매수량을_통해_로또갯수를_도출한다() {
        LottoGame lottoGame = new LottoGame(2000);
        assertThat(lottoGame.getLottoCount()).isEqualTo(2);
    }

    @Test
    void 당첨번호와_보너스번호를_설정한다() {
        LottoGame lottoGame = new LottoGame(2000);
        Lotto winningLotto = new Lotto(List.of(1, 2, 3, 4, 5, 6));
        lottoGame.setWinningLotto(winningLotto);
        lottoGame.setBonusNumber(7);
        assertThat(lottoGame.getPurchasedLottos()).hasSize(2);
    }

    @Test
    void 수익률을_도출한다() {
        LottoGame lottoGame = new LottoGame(2000);
        Lotto winningLotto = new Lotto(List.of(1, 2, 3, 4, 5, 6));
        lottoGame.setWinningLotto(winningLotto);
        lottoGame.setBonusNumber(7);
        double profitRate = lottoGame.calculateProfitRate();
        assertThat(profitRate).isGreaterThanOrEqualTo(0);
    }

    @Test
    void 구매한로또를_가져올수있다() {
        LottoGame lottoGame = new LottoGame(2000);
        assertThat(lottoGame.getPurchasedLottos()).hasSize(2);
    }
}
