package lotto.domain;

import lotto.domain.provider.RandomNumberProvider;
import lotto.domain.validator.DefaultRangeValidator;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.math.BigInteger;

import static org.assertj.core.api.Assertions.assertThat;

class LottoMachineTest {

    @DisplayName("구입 금액에 해당하는 만큼 로또를 생성한다.")
    @Test
    void createLottosWithAmount() {
        Money money = new Money(BigInteger.valueOf(8000));
        RandomNumberProvider numberProvider = new RandomNumberProvider();
        DefaultRangeValidator rangeValidator = new DefaultRangeValidator();
        LottoMachine lottoMachine = new LottoMachine(money, numberProvider, rangeValidator);

        Lottos lottos = lottoMachine.create();

        assertThat(lottos.count()).isEqualTo(8);
    }

}
