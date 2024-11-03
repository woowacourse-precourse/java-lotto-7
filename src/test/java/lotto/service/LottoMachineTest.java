package lotto.service;

import static org.junit.jupiter.api.Assertions.*;

import java.util.List;
import lotto.model.Lotto;
import lotto.view.message.ErrorMessage;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

class LottoMachineTest {

    LottoMachine lottoMachine = new LottoMachine();

    @Test
    void 로또_생성_테스트() {
        Integer moneyAmount = 10000;
        List<Lotto> lotteries = lottoMachine.getLotteries();
        Assertions.assertThat(lotteries).isInstanceOf(Lotto.class);
    }

    @Test
    void 구입_금액_검증_테스트() {
        String moneyAmount = "10000";
        boolean result = lottoMachine.validateMoneyAmount(moneyAmount);
        Assertions.assertThat(result).isEqualTo(true);
    }

    @Test
    void 구입_금액_검증_예외_테스트() {
        String moneyAmount = "999";
        Assertions.assertThatThrownBy(() -> lottoMachine.validateMoneyAmount(moneyAmount))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(ErrorMessage.INVALID_MONEY_AMOUNT_ERROR);
    }

    @Test
    void generateLotto() {
        Lotto lotto = lottoMachine.generateLotto();
        Assertions.assertThat(lotto).isInstanceOf(Lotto.class);
    }
}