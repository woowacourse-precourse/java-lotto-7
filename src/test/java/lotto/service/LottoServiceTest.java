package lotto.service;

import static org.assertj.core.api.Assertions.*;
import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;
import lotto.domain.Lotto;
import lotto.domain.LottoNumber;
import lotto.domain.LottoNumberGenerator;
import lotto.domain.rank.LottoRank;
import lotto.domain.rank.LottoRanks;
import lotto.domain.money.Money;
import lotto.domain.WinningLotto;
import org.junit.jupiter.api.Test;

@SuppressWarnings("NonAsciiCharacters")
class LottoServiceTest {

    private final LottoService lottoService = new LottoService(new LottoNumberGenerator());

    @Test
    void 구매한_로또를_평가하여_순위를_확인할_수_있다() {
        // given
        Lotto winningNumbers = Lotto.of(List.of(1, 2, 3, 4, 5, 6));
        LottoNumber bonusNumber = new LottoNumber(7);
        List<Lotto> lottos = List.of(
                Lotto.of(List.of(1, 2, 3, 4, 5, 6)),
                Lotto.of(List.of(1, 2, 3, 4, 5, 7)),
                Lotto.of(List.of(1, 2, 3, 4, 5, 45)),
                Lotto.of(List.of(11, 12, 13, 14, 15, 16))
        );
        WinningLotto winningLotto = new WinningLotto(winningNumbers, bonusNumber);

        // when
        LottoRanks lottoRanks = lottoService.evaluateLottos(winningLotto, lottos);

        // then
        assertThat(lottoRanks.getRanks()).hasSize(3)
                .contains(
                        entry(LottoRank.FIRST, 1),
                        entry(LottoRank.SECOND, 1),
                        entry(LottoRank.THIRD, 1)
                );
    }

    @Test
    void 돈으로_로또를_구매할_수_있다() {
        // given
        Money money = new Money(3000);

        // when

        List<Lotto> lottos = lottoService.purchaseBy(money);

        // then
        assertThat(lottos).hasSize(3);
    }

}
