package lotto.validation;

import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

class LottoValidationTest {

    private final LottoValidation lottoValidation = new LottoValidation();

    @Test
    void 입력_금액이_공백일_경우_예외가_발생한다() {
        assertThatThrownBy(() -> lottoValidation.validateBlank("  "))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void Integer로_변환이_불가능할_경우_예외가_발생한다() {
        assertThatThrownBy(() -> lottoValidation.validateParsing("일억"))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void 입력_금액이_양수가_아닐_경우_예외가_발생한다() {
        assertThatThrownBy(() -> lottoValidation.validatePositive(-5))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void 천원으로_나누어_떨어지지_않을_경우_예외가_발생한다() {
        assertThatThrownBy(() -> lottoValidation.validateDivisible(8500))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void Integer로_변환이_불가능한_당첨_번호가_있을_경우_예외가_발생한다() {
        List<String> input = List.of("1", "2", "", "4", "5", "6");
        assertThatThrownBy(() -> lottoValidation.validateParsing(input))
                .isInstanceOf(IllegalArgumentException.class);
    }
}