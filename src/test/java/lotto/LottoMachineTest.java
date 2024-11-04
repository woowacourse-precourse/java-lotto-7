package lotto;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;


import java.util.List;
import org.junit.jupiter.api.Test;

class LottoMachineTest {

    @Test
    void 로또_구입_금액의_단위가_1000원이_아니면_예외가_발생한다() {
        LottoMachine lottoMachine = new LottoMachine();

        assertThatThrownBy(() -> lottoMachine.calculateLottoCount(1300))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(ExceptionMessage.INVALID_PURCHASE_AMOUNT.getErrorMessage());
    }

    @Test
    void 중복_없이_번호_6개_뽑는_테스트() {
        LottoMachine lottoMachine = new LottoMachine();
        List<Integer> lottoNumbers = lottoMachine.generateLottoNumbers();

        assertThat(lottoNumbers).hasSize(6);
        assertThat(lottoNumbers).allMatch(num -> num >= 1 && num <= 45);
        assertThat(lottoNumbers).doesNotHaveDuplicates();

    }

}