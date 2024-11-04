package lotto;

import static org.assertj.core.api.Assertions.assertThatThrownBy;


import org.junit.jupiter.api.Test;

class LottoMachineTest {

    @Test
    void 로또_구입_금액의_단위가_1000원이_아니면_예외가_발생한다() {
        LottoMachine lottoMachine = new LottoMachine();

        assertThatThrownBy(() -> lottoMachine.calculateLottoCount(1300))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(ExceptionMessage.INVALID_PURCHASE_AMOUNT.getErrorMessage());
    }

}