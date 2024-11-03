package lotto.domain;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;
import lotto.constant.LottoRule;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class LottoStoreTest {

    private LottoGenerator lottoGenerator;

    @BeforeEach
    void setUp() {
        lottoGenerator = new LottoGenerator();
    }

    @DisplayName("구입 금액 만큼 로또를 구매한다.")
    @Test
    void getLottosByMoneyTest() {
        //given
        final int unit = LottoRule.MONEY_UNIT;
        final Money money = new Money(5000);
        final LottoStore lottoStore = new LottoStore(lottoGenerator);

        //when
        final List<Lotto> lottos = lottoStore.getLottosByMoney(money);
        final int quotient = money.calculateQuotient(unit);

        //then
        assertThat(lottos).hasSize(quotient);
    }
}
