package lotto.model.lotto;

import lotto.config.AppConfig;
import lotto.dto.MatchResponse;
import lotto.dto.UserLotto;
import lotto.dto.WinNumberForm;
import lotto.model.generator.MockNumberGenerator;
import lotto.model.money.Money;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

class LottoServiceTest {
    private final LottoService lottoService = new AppConfig().lottoService();

    @Test
    void 로또_번호를_당첨_번호와_비교한_결과를_반환한다() {
        //given
        Money money = Money.from(2000);
        UserLotto userLotto = new UserLotto(Lottos.of(money, new MockNumberGenerator()), money);
        WinNumberForm winNumberForm = new WinNumberForm(Lotto.from(List.of(1, 2, 3, 4, 5, 6)), new Bonus(7));

        //when
        MatchResponse matchResponse = lottoService.matchLottos(userLotto, winNumberForm);

        //then
        assertThat(matchResponse.rateOfReturn()).isEqualTo(200000000);
    }

    @Test
    void 금액에_맞는_로또를_반환받는다() {
        UserLotto userLotto = lottoService.purchase(6000);
        assertThat(userLotto.lottos().getSize()).isEqualTo(6);
    }
}