package lotto.factory;

import lotto.model.Lotto;
import lotto.model.LottoTicket;
import lotto.model.Money;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class LottoMachineTest {

    @DisplayName("로또 티켓을 올바르게 생성한다.")
    @Test
    void 로또티켓을올바르게생성한다() {
        LottoMachine lottoMachine = new LottoMachine();

        LottoTicket lottoTicket = lottoMachine.generateLottoTicket();

        assertThat(lottoTicket).isNotNull();

        Lotto lotto = lottoTicket.lotto();

        assertThat(lotto.numbers()).hasSize(6);
        assertThat(lotto.numbers()).allMatch(number -> number >= 1 && number <= 45);

        Money price = lottoTicket.price();

        assertThat(price.amount()).isEqualTo(LottoMachine.PRICE_PER_ONE);
    }
}

