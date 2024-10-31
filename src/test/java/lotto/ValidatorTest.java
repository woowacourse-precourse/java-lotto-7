package lotto;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

import java.util.List;
import org.junit.jupiter.api.Test;

class ValidatorTest {

    Validator validator = new Validator();

    @Test
    void 올바른_구매_금액() {
        validator.purchaseAmountValidate("10000");
    }

    @Test
    void 올바른_당첨_로또_번호() {
        validator.winningNumberValidate(List.of("1", "2", "3", "4", "5", "6"));
    }

    @Test
    void 올바른_보너스_번호() {
        validator.bonusNumberValidate(List.of(1, 2, 3, 4, 5, 6), "7");
    }

    @Test
    void 보너스_번호가_당첨_번호와_중복() {
        assertThatThrownBy(() -> validator.bonusNumberValidate(List.of(1, 2, 3, 4, 5, 6), "1"))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void 당첨_번호_리스트_길이가_6개가_아니면_예외() {
        assertThatThrownBy(() -> validator.winningNumberValidate(List.of("1", "2", "3")))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void 구매_금액이_1000의_배수가_아니면_예외() {
        assertThatThrownBy(() -> validator.purchaseAmountValidate("121233"))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void 구매_금액이_숫자가_아님() {
        assertThatThrownBy(() -> validator.purchaseAmountValidate("preCourse"))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void 당첨_번호가_숫자가_아님() {
        assertThatThrownBy(() -> validator.lottoNumberValidate("preCourse"))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void 당첨_번호가_범위를_벗어남() {
        assertThatThrownBy(() -> validator.numberRangeValidate(99))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void 당첨_번호_리스트_내_중복된_원소_존재() {
        assertThatThrownBy(() -> validator.duplicateElementValidate(List.of("1", "2", "3", "4", "5", "5")))
                .isInstanceOf(IllegalArgumentException.class);
    }


}