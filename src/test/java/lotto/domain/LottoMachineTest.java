package lotto.domain;

import lotto.domain.provider.RandomNumberProvider;
import lotto.domain.validator.DefaultRangeValidator;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.math.BigInteger;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class LottoMachineTest {

    private LottoMachine lottoMachine;

    @BeforeEach
    void setUp() {
        RandomNumberProvider numberProvider = new RandomNumberProvider();
        DefaultRangeValidator rangeValidator = new DefaultRangeValidator();
        this.lottoMachine = new LottoMachine(numberProvider, rangeValidator);
    }

    @DisplayName("구입 금액에 해당하는 만큼 로또를 생성한다.")
    @Test
    void purchaseLottosWithMoney() {
        Money money = new Money(BigInteger.valueOf(8000));

        Lottos lottos = lottoMachine.purchase(money);

        assertThat(lottos.getLottos()).hasSize(8);
    }

    @DisplayName("구입 금액이 1000으로 나누어 떨어지지 않으면 예외가 발생한다.")
    @Test
    void moneyShouldBeDividedBy1000() {
        Money money = new Money(BigInteger.valueOf(1100));

        assertThatThrownBy(() -> lottoMachine.purchase(money))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("로또 구입 금액은 1000원으로 나누어 떨어져야 합니다.");
    }

    @DisplayName("구입 금액이 0이면 예외가 발생한다.")
    @Test
    void moneyCannotBeZero() {
        Money money = new Money(BigInteger.ZERO);

        assertThatThrownBy(() -> lottoMachine.purchase(money))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("로또 구입 금액은 0일 수 없습니다.");
    }

}
