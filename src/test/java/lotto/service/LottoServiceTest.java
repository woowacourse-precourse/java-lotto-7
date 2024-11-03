package lotto.service;

import static org.assertj.core.api.Assertions.*;

import java.lang.reflect.Field;
import java.util.List;
import lotto.domain.BonusNumber;
import lotto.domain.Lotto;
import lotto.domain.Lottos;
import lotto.domain.Money;
import lotto.domain.Result;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class LottoServiceTest {
    private final LottoService lottoService = new LottoService();

    @Test
    @DisplayName("구입 금액에 따른 로또 개수 반환")
    void returnExactlyLottoCount(){
        Money money = new Money("5000");

        int ticketCount = lottoService.getTicketCount(money);

        assertThat(ticketCount).isEqualTo(5);
    }

    @Test
    @DisplayName("로또 당첨 금액 계산")
    void calculateLottoPrize() throws NoSuchFieldException, IllegalAccessException {
        Lottos lottos = new Lottos(2);

        Field lottosField = Lottos.class.getDeclaredField("lottos");
        lottosField.setAccessible(true);
        lottosField.set(lottos, List.of(
            new Lotto(List.of(1, 2, 3, 4, 5, 6)),
            new Lotto(List.of(1, 2, 3, 4, 7, 8))
        ));

        Lotto winningLotto = new Lotto(List.of(1, 2, 3, 5, 41, 42));
        BonusNumber bonusNumber = new BonusNumber("45", winningLotto);

        Result result = lottoService.getResult(lottos, winningLotto, bonusNumber);
        assertThat(result.getTotalPrize()).isEqualTo(55000);
    }

    @Test
    @DisplayName("수익률 계산")
    void calculateEarningRate() {
        long totalPrize = 10_000;
        Money money = new Money("10000");

        double earningRate = lottoService.calculateEarningRate(totalPrize, money);

        assertThat(earningRate).isEqualTo(100.0);
    }

}