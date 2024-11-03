package lotto.service;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.ArrayList;
import java.util.List;
import lotto.domain.Amount;
import lotto.domain.Bonus;
import lotto.domain.Lotto;
import lotto.domain.Lottos;
import lotto.domain.Prize;
import lotto.domain.PrizeCount;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class LottoServiceTest {

    private final LottoService lottoService = new LottoService();

    @Test
    @DisplayName("로또를 발행한다.")
    void issueLotto() {
        //given
        Amount amount = Amount.of("10000");

        //when
        Lottos lottos = lottoService.issueLottos(amount);

        //then
        assertThat(lottos.getLottos()).hasSize(10);
        lottos.getLottos().forEach(lotto ->
                assertThat(lotto.getNumbers()).isSorted()
        );
    }

    @Test
    @DisplayName("당첨 통계를 구한다.")
    void getWinningCount() {
        //given
        List<Lotto> lottos = new ArrayList<>();
        lottos.add(Lotto.of("1, 2, 3, 4, 5, 6")); // 4개
        lottos.add(Lotto.of("1, 3, 5, 7, 9, 11")); // 2개
        lottos.add(Lotto.of("2, 4, 6, 8, 10, 12")); // 4개
        Lottos userLottos = new Lottos(lottos);

        Lotto winningLotto = Lotto.of("1, 2, 4, 6, 7, 8");
        Bonus bonus = Bonus.of("10", winningLotto);

        //when
        PrizeCount prizeCount = lottoService.getPrizeCount(userLottos, winningLotto, bonus);

        //then
        assertThat(prizeCount.getPrizeCount()).hasSize(5);
        assertThat(prizeCount.getPrizeCount().get(Prize.MATCHES_6)).isEqualTo(0);
        assertThat(prizeCount.getPrizeCount().get(Prize.MATCHES_5_BONUS_MATCH)).isEqualTo(0);
        assertThat(prizeCount.getPrizeCount().get(Prize.MATCHES_5)).isEqualTo(0);
        assertThat(prizeCount.getPrizeCount().get(Prize.MATCHES_4)).isEqualTo(2);
        assertThat(prizeCount.getPrizeCount().get(Prize.MATCHES_3)).isEqualTo(0);
    }
}