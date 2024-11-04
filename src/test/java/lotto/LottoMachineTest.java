package lotto;

import lotto.data.Database;
import lotto.service.LottoMachine;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class LottoMachineTest {

    private LottoMachine lottoMachine = new LottoMachine();
    private Database database;

    @DisplayName("로또를 14000원으로 14개 구매한다.")
    @Test
    void buyLottoTest() {
        // given
        Long money = 14000L;
        // when
        lottoMachine.buyLotto(money);
        // then
        assertThat(lottoMachine.getPurchasedLotto().size()).isEqualTo(14);
    }
}
