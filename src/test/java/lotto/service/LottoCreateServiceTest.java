package lotto.service;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;
import lotto.domain.Lotto;
import lotto.domain.Lottos;
import lotto.domain.WinningLotto;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

@DisplayName("LottoCreateService 테스트")
public class LottoCreateServiceTest {

    private LottoCreateService lottoCreateService;

    @BeforeEach
    void setUp() {
        lottoCreateService = new LottoCreateService();
    }

    @Test
    void 구입금액만큼_로또를_생성한다() {
        //given
        int money = 14000;

        //when
        Lottos lottos = lottoCreateService.createLottosWithMoney(money);

        //then
        assertThat(lottos.getLottos()).hasSize(14);
    }

    @Test
    void 당첨로또를_생성한다() {
        //given
        Lotto lotto = new Lotto(List.of(1, 2, 3, 4, 5, 6));
        int bonusNumber = 7;

        //when
        WinningLotto winningLotto = lottoCreateService.createWinningLotto(lotto, bonusNumber);

        //then
        assertThat(winningLotto.getWinningLottoNumbers()).containsExactly(1, 2, 3, 4, 5, 6);
        assertThat(winningLotto.getBonusNumber()).isEqualTo(7);
    }
}
