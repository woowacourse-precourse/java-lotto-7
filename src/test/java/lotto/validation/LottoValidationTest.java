package lotto.validation;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

class LottoValidationTest {

    private final LottoValidation lottoValidation = new LottoValidation();

    @Test
    void 입력_금액이_공백일_경우_예외가_발생한다() {
        assertThatThrownBy(() -> lottoValidation.validateBlank("  "))
                .isInstanceOf(IllegalArgumentException.class);
    }
}