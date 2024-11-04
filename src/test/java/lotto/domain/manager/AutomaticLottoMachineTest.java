package lotto.domain.manager;

import static lotto.domain.constant.LottoConstraintProperties.LOTTO_PRICE_UNIT;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

class AutomaticLottoMachineTest {
    private static final String ERROR_MESSAGE = "[ERROR]";

    @ParameterizedTest
    @ValueSource(ints = {1000, 2000, 5000, 7000, 10000})
    void 입력금액에_맞게_자동으로_로또들을을_발행해준다(int amount) {
        //given
        int expectedQuantity = amount / LOTTO_PRICE_UNIT;
        //when
        var automaticLottoMachine = new AutomaticLottoMachine(amount);
        //then
        Assertions.assertThat(automaticLottoMachine).isNotNull();
        Assertions.assertThat(automaticLottoMachine.getQuantity()).isEqualTo(expectedQuantity);
    }

    @ParameterizedTest
    @ValueSource(ints = {1, 999, 1001, 2001, 3001})
    void 입력금액이_천원단위가_아니면_예외가_발생한다(int invalidAmount) {
        //given
        //when
        //then
        Assertions.assertThatThrownBy(() -> new AutomaticLottoMachine(invalidAmount))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(ERROR_MESSAGE);
    }

    @ParameterizedTest
    @ValueSource(ints = {0, -1, -1000, -2000, -4000})
    void 입력금액이_0이거나_음수이면_예외가_발생한다(int invalidAmount) {
        //given
        //when
        //then
        Assertions.assertThatThrownBy(() -> new AutomaticLottoMachine(invalidAmount))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(ERROR_MESSAGE);
    }

    @ParameterizedTest
    @ValueSource(ints = {11000, 12000, 13000, 20000, 50000})
    void 발행갯수가_10개가_넘어가면_예외가_발생한다(int invalidAmount) {
        //given
        //when
        //then
        Assertions.assertThatThrownBy(() -> new AutomaticLottoMachine(invalidAmount))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(ERROR_MESSAGE);
    }


}