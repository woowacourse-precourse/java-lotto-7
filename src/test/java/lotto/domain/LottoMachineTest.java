package lotto.domain;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

class LottoMachineTest {
    @Test
    void 입력_금액이_로또_가격보다_적으면_예외발생() {
        assertThatThrownBy(() -> new LottoMachine(999))
                .isInstanceOf(IllegalArgumentException.class);
    }
    @Test
    void 빵원이면_예외발생() {
        assertThatThrownBy(() -> new LottoMachine(0))
                .isInstanceOf(IllegalArgumentException.class);
    }
    @Test
    void 입력_금액이_1000원_단위로_안나눠지면_예외발생() {
        assertThatThrownBy(() -> new LottoMachine(1234))
                .isInstanceOf(IllegalArgumentException.class);
    }
}